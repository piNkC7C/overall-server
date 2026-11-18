-- 停用 CRM 日报汇总站内信；修正 crm_audit_remind 名称；清理错误汇总消息；
-- 并为当前运行中的 BPM 待办补发逐条「待审批提醒」（幂等可重复执行）

-- 1) 模板名：Pending approval remind（中文展示名 = 待审批提醒，见 glossary-zh）
UPDATE `system_notify_template`
SET `name` = 'Pending approval remind',
    `content` = 'New task: {processInstanceName}-{taskName}, requester: {startUserNickname}',
    `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_audit_remind' AND `deleted` = b'0';

-- 2) 停用旧日报模板
UPDATE `system_notify_template`
SET `status` = 1, `deleted` = b'1', `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_todo_daily_remind' AND `deleted` = b'0';

-- 3) 软删「共N项 / 今日待跟进…共」汇总文案（旧 9:00 Job）
UPDATE `system_notify_message`
SET `deleted` = b'1', `updater` = '1', `update_time` = NOW()
WHERE `deleted` = b'0'
  AND (
    `template_content` LIKE '%共%项%'
    OR `template_content` LIKE '%今日待跟进%'
    OR `template_content` LIKE '%即将入公海客户共%'
    OR `template_content` LIKE '%即将到期合同共%'
    OR (`template_code` = 'crm_audit_remind'
        AND JSON_UNQUOTE(JSON_EXTRACT(`template_params`, '$.processInstanceName')) = 'CRM审批待办')
  );

-- 4) 停用 XXL-JOB 旧/误开 handler（Overall 生产关 XXL；共享 xxl_job 里勿启本仓库 Job）
-- USE xxl_job;
-- UPDATE xxl_job_info SET trigger_status=0, update_time=NOW()
-- WHERE executor_handler IN ('crmTodoDailyRemindJob', 'crmEntityRemindJob');

-- 5) 为运行中的待办补发逐条审批站内信（已有同 processInstanceId 则跳过）
INSERT INTO `system_notify_message`
(`user_id`, `user_type`, `template_id`, `template_code`, `template_nickname`, `template_content`,
 `template_type`, `template_params`, `read_status`, `read_time`, `process_status`, `process_time`,
 `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT
  CAST(task.ASSIGNEE_ AS UNSIGNED),
  2,
  t.id,
  t.code,
  t.nickname,
  CONCAT(
    'New task: ', IFNULL(proc.NAME_, '流程'), '-', IFNULL(task.NAME_, '审批'),
    ', requester: ', IFNULL(u.nickname, 'System')
  ),
  t.type,
  JSON_OBJECT(
    'processInstanceName', IFNULL(proc.NAME_, '流程'),
    'taskName', IFNULL(task.NAME_, '审批'),
    'startUserNickname', IFNULL(u.nickname, 'System'),
    'processInstanceId', task.PROC_INST_ID_,
    'route', CONCAT('/bpm/process-instance/detail?id=', task.PROC_INST_ID_)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  IFNULL(task.CREATE_TIME_, NOW()),
  '1', NOW(), b'0',
  IFNULL(u.tenant_id, 1)
FROM ACT_RU_TASK task
LEFT JOIN ACT_HI_PROCINST proc ON proc.PROC_INST_ID_ = task.PROC_INST_ID_
LEFT JOIN system_users u ON u.id = CAST(proc.START_USER_ID_ AS UNSIGNED) AND u.deleted = b'0'
JOIN system_notify_template t
  ON t.code = 'crm_audit_remind' AND t.deleted = b'0' AND t.status = 0
WHERE task.ASSIGNEE_ REGEXP '^[0-9]+$'
  AND CAST(task.ASSIGNEE_ AS UNSIGNED) > 0
  AND NOT EXISTS (
    SELECT 1 FROM system_notify_message m
    WHERE m.deleted = b'0'
      AND m.template_code = 'crm_audit_remind'
      AND m.user_id = CAST(task.ASSIGNEE_ AS UNSIGNED)
      AND JSON_UNQUOTE(JSON_EXTRACT(m.template_params, '$.processInstanceId')) = task.PROC_INST_ID_
  );

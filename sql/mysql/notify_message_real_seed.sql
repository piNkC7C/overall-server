-- 清除站内信假数据，并按真实日程 / CRM 待办生成消息（幂等）
-- 说明：审批中心无运行中任务时跳过审批类消息

-- 1) 软删除当前未删除的站内信（含示例/demo）
UPDATE `system_notify_message`
SET `deleted` = b'1', `updater` = '1', `update_time` = NOW()
WHERE `deleted` = b'0';

-- 2) 真实日程提醒（仅已到提醒时刻的日程 → 创建人）
-- 提醒时刻 = start_time - remind_minutes；准时(0)即 start_time，不得用假的「提前 30 分钟」
INSERT INTO `system_notify_message`
(`user_id`, `user_type`, `template_id`, `template_code`, `template_nickname`, `template_content`,
 `template_type`, `template_params`, `read_status`, `read_time`, `process_status`, `process_time`,
 `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT
  CAST(s.creator AS UNSIGNED),
  2,
  t.id,
  t.code,
  t.nickname,
  CONCAT('Please handle schedule: ', s.title),
  t.type,
  JSON_OBJECT(
    'name', s.title,
    'scheduleId', s.id,
    'route', CONCAT('/bpm/my-schedule?scheduleId=', s.id)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  DATE_SUB(s.start_time, INTERVAL IFNULL(s.remind_minutes, 0) MINUTE),
  '1', NOW(), b'0', IFNULL(s.tenant_id, 1)
FROM `oa_schedule` s
JOIN `system_notify_template` t
  ON t.code = 'oa_schedule_reminder' AND t.deleted = b'0' AND t.status = 0
WHERE s.deleted = b'0'
  AND s.remind = b'1'
  AND s.creator REGEXP '^[0-9]+$'
  AND CAST(s.creator AS UNSIGNED) > 0
  -- 只种「提醒时刻已经到了」的消息，未来日程等定时任务到点再发
  AND DATE_SUB(s.start_time, INTERVAL IFNULL(s.remind_minutes, 0) MINUTE) <= NOW();

-- 3) 今日线索跟进（contact_next_time 落在今天）
INSERT INTO `system_notify_message`
(`user_id`, `user_type`, `template_id`, `template_code`, `template_nickname`, `template_content`,
 `template_type`, `template_params`, `read_status`, `read_time`, `process_status`, `process_time`,
 `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT
  c.owner_user_id,
  2,
  t.id,
  t.code,
  t.nickname,
  CONCAT('请你及时跟进线索：', c.name),
  t.type,
  JSON_OBJECT(
    'name', c.name,
    'id', c.id,
    'route', CONCAT('/crm/clue/detail/', c.id)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  c.contact_next_time,
  '1', NOW(), b'0', IFNULL(c.tenant_id, 1)
FROM `crm_clue` c
JOIN `system_notify_template` t
  ON t.code = 'crm_clue_follow_today' AND t.deleted = b'0' AND t.status = 0
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL
  AND c.contact_next_time IS NOT NULL
  AND DATE(c.contact_next_time) = CURDATE();

-- 4) 今日客户跟进
INSERT INTO `system_notify_message`
(`user_id`, `user_type`, `template_id`, `template_code`, `template_nickname`, `template_content`,
 `template_type`, `template_params`, `read_status`, `read_time`, `process_status`, `process_time`,
 `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT
  c.owner_user_id,
  2,
  t.id,
  t.code,
  t.nickname,
  CONCAT('请你及时跟进客户：', c.name),
  t.type,
  JSON_OBJECT(
    'name', c.name,
    'id', c.id,
    'route', CONCAT('/crm/customer/detail/', c.id)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  c.contact_next_time,
  '1', NOW(), b'0', IFNULL(c.tenant_id, 1)
FROM `crm_customer` c
JOIN `system_notify_template` t
  ON t.code = 'crm_customer_follow_today' AND t.deleted = b'0' AND t.status = 0
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL
  AND c.contact_next_time IS NOT NULL
  AND DATE(c.contact_next_time) = CURDATE();

-- 5) 今日商机跟进（有数据时）
INSERT INTO `system_notify_message`
(`user_id`, `user_type`, `template_id`, `template_code`, `template_nickname`, `template_content`,
 `template_type`, `template_params`, `read_status`, `read_time`, `process_status`, `process_time`,
 `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT
  b.owner_user_id,
  2,
  t.id,
  t.code,
  t.nickname,
  CONCAT('请你及时跟进商机：', b.name),
  t.type,
  JSON_OBJECT(
    'name', b.name,
    'id', b.id,
    'route', CONCAT('/crm/business/detail/', b.id)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  b.contact_next_time,
  '1', NOW(), b'0', IFNULL(b.tenant_id, 1)
FROM `crm_business` b
JOIN `system_notify_template` t
  ON t.code = 'crm_business_follow_today' AND t.deleted = b'0' AND t.status = 0
WHERE b.deleted = b'0'
  AND b.owner_user_id IS NOT NULL
  AND b.contact_next_time IS NOT NULL
  AND DATE(b.contact_next_time) = CURDATE();

-- 6) 合同即将到期（end_time 在 30 天内）
INSERT INTO `system_notify_message`
(`user_id`, `user_type`, `template_id`, `template_code`, `template_nickname`, `template_content`,
 `template_type`, `template_params`, `read_status`, `read_time`, `process_status`, `process_time`,
 `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT
  c.owner_user_id,
  2,
  t.id,
  t.code,
  t.nickname,
  CONCAT('请你及时跟进合同：', c.name),
  t.type,
  JSON_OBJECT(
    'name', c.name,
    'id', c.id,
    'route', CONCAT('/crm/contract/detail/', c.id)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  NOW(),
  '1', NOW(), b'0', IFNULL(c.tenant_id, 1)
FROM `crm_contract` c
JOIN `system_notify_template` t
  ON t.code = 'crm_contract_expiry' AND t.deleted = b'0' AND t.status = 0
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL
  AND c.end_time IS NOT NULL
  AND c.end_time BETWEEN NOW() AND DATE_ADD(NOW(), INTERVAL 30 DAY);

-- 7) 审批中心：运行中的待办任务（表存在且有数据时）
SET @has_task := (
  SELECT COUNT(*) FROM information_schema.TABLES
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'act_ru_task'
);

SET @sql := IF(@has_task > 0,
  'INSERT INTO `system_notify_message`
   (`user_id`, `user_type`, `template_id`, `template_code`, `template_nickname`, `template_content`,
    `template_type`, `template_params`, `read_status`, `read_time`, `process_status`, `process_time`,
    `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
   SELECT
     CAST(task.ASSIGNEE_ AS UNSIGNED),
     2,
     t.id,
     t.code,
     t.nickname,
     CONCAT(''New task: '', IFNULL(proc.NAME_, ''流程''), ''-'', IFNULL(task.NAME_, ''审批''), '', requester: '', IFNULL(u.nickname, ''System'')),
     t.type,
     JSON_OBJECT(
       ''processInstanceName'', IFNULL(proc.NAME_, ''流程''),
       ''taskName'', IFNULL(task.NAME_, ''审批''),
       ''startUserNickname'', IFNULL(u.nickname, ''System''),
       ''processInstanceId'', task.PROC_INST_ID_,
       ''route'', CONCAT(''/bpm/process-instance/detail?id='', task.PROC_INST_ID_)
     ),
     b''0'', NULL, b''0'', NULL,
     ''1'',
     IFNULL(task.CREATE_TIME_, NOW()),
     ''1'', NOW(), b''0'', IFNULL(u.tenant_id, 1)
   FROM ACT_RU_TASK task
   LEFT JOIN ACT_HI_PROCINST proc ON proc.PROC_INST_ID_ = task.PROC_INST_ID_
   LEFT JOIN system_users u ON u.id = CAST(proc.START_USER_ID_ AS UNSIGNED) AND u.deleted = b''0''
   JOIN system_notify_template t
     ON t.code = ''crm_audit_remind'' AND t.deleted = b''0'' AND t.status = 0
   WHERE task.ASSIGNEE_ REGEXP ''^[0-9]+$''
     AND CAST(task.ASSIGNEE_ AS UNSIGNED) > 0',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

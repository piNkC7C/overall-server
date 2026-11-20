-- 清除站内信，并按现有 CRM / BPM / OA 业务数据重生成（幂等可重复执行）
-- 规则对齐 message-notify：跟进窗 [fire, fire+1d)、OA 提醒时刻已到、BPM 运行中任务一任务一条
-- 模板正文用英文占位填充（前端 formatNotifyMessageContent + glossary-zh）

-- 1) 软删除当前未删除的站内信
UPDATE `system_notify_message`
SET `deleted` = b'1', `updater` = '1', `update_time` = NOW()
WHERE `deleted` = b'0';

-- 2) 重置即将补发实体的 reminded，避免与 Job 双发；未到窗的保持原样由 Job 到点发送
UPDATE `crm_clue` c
SET c.contact_reminded = b'0', c.updater = '1', c.update_time = NOW()
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY)
  AND IFNULL(c.transform_status, b'0') = b'0';

UPDATE `crm_customer` c
SET c.contact_reminded = b'0', c.updater = '1', c.update_time = NOW()
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

UPDATE `crm_business` b
SET b.contact_reminded = b'0', b.updater = '1', b.update_time = NOW()
WHERE b.deleted = b'0'
  AND b.owner_user_id IS NOT NULL AND b.owner_user_id > 0
  AND b.contact_next_time IS NOT NULL
  AND b.contact_next_time <= NOW()
  AND b.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

UPDATE `crm_contract` c
SET c.contact_reminded = b'0', c.updater = '1', c.update_time = NOW()
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

UPDATE `bpm_schedule` s
SET s.reminded = b'0', s.updater = '1', s.update_time = NOW()
WHERE s.deleted = b'0'
  AND s.remind = b'1'
  AND DATE_SUB(s.start_time, INTERVAL IFNULL(s.remind_minutes, 0) MINUTE) <= NOW();

-- 3) BPM 我的日程提醒（提醒时刻已到）
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
FROM `bpm_schedule` s
JOIN `system_notify_template` t
  ON t.code = 'bpm_schedule_reminder' AND t.deleted = b'0' AND t.status = 0
WHERE s.deleted = b'0'
  AND s.remind = b'1'
  AND s.creator REGEXP '^[0-9]+$'
  AND CAST(s.creator AS UNSIGNED) > 0
  AND DATE_SUB(s.start_time, INTERVAL IFNULL(s.remind_minutes, 0) MINUTE) <= NOW();

UPDATE `bpm_schedule` s
SET s.reminded = b'1', s.updater = '1', s.update_time = NOW()
WHERE s.deleted = b'0'
  AND s.remind = b'1'
  AND DATE_SUB(s.start_time, INTERVAL IFNULL(s.remind_minutes, 0) MINUTE) <= NOW();

-- 4) 线索跟进（窗 [contact_next_time, +1d)）
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
  CONCAT('Please follow up on lead: ', c.name),
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
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY)
  AND IFNULL(c.transform_status, b'0') = b'0';

UPDATE `crm_clue` c
SET c.contact_reminded = b'1', c.updater = '1', c.update_time = NOW()
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY)
  AND IFNULL(c.transform_status, b'0') = b'0';

-- 5) 客户跟进
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
  CONCAT('Please follow up on customer: ', c.name),
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
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

UPDATE `crm_customer` c
SET c.contact_reminded = b'1', c.updater = '1', c.update_time = NOW()
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

-- 6) 商机跟进
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
  CONCAT('Please follow up on opportunity: ', b.name),
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
  AND b.owner_user_id IS NOT NULL AND b.owner_user_id > 0
  AND b.contact_next_time IS NOT NULL
  AND b.contact_next_time <= NOW()
  AND b.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

UPDATE `crm_business` b
SET b.contact_reminded = b'1', b.updater = '1', b.update_time = NOW()
WHERE b.deleted = b'0'
  AND b.owner_user_id IS NOT NULL AND b.owner_user_id > 0
  AND b.contact_next_time IS NOT NULL
  AND b.contact_next_time <= NOW()
  AND b.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

-- 7) 合同跟进
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
  CONCAT('Please follow up on contract: ', c.name),
  t.type,
  JSON_OBJECT(
    'name', c.name,
    'id', c.id,
    'route', CONCAT('/crm/contract/detail/', c.id)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  c.contact_next_time,
  '1', NOW(), b'0', IFNULL(c.tenant_id, 1)
FROM `crm_contract` c
JOIN `system_notify_template` t
  ON t.code = 'crm_contract_follow_today' AND t.deleted = b'0' AND t.status = 0
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

UPDATE `crm_contract` c
SET c.contact_reminded = b'1', c.updater = '1', c.update_time = NOW()
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.contact_next_time IS NOT NULL
  AND c.contact_next_time <= NOW()
  AND c.contact_next_time > DATE_SUB(NOW(), INTERVAL 1 DAY);

-- 8) 公海提醒（对齐 CrmEntityRemindServiceImpl：fireAt <= now < poolAt）
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
  CONCAT('Please follow up on customer: ', c.name),
  t.type,
  JSON_OBJECT(
    'name', c.name,
    'id', c.id,
    'route', CONCAT('/crm/customer/detail/', c.id)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  LEAST(
    DATE_ADD(IFNULL(c.contact_last_time, c.owner_time), INTERVAL GREATEST(cfg.contact_expire_days - cfg.notify_days, 0) DAY),
    DATE_ADD(c.owner_time, INTERVAL GREATEST(cfg.deal_expire_days - cfg.notify_days, 0) DAY)
  ),
  '1', NOW(), b'0', IFNULL(c.tenant_id, 1)
FROM `crm_customer` c
JOIN `crm_customer_pool_config` cfg
  ON cfg.deleted = b'0' AND cfg.enabled = b'1' AND cfg.notify_enabled = b'1'
 AND cfg.notify_days IS NOT NULL AND cfg.contact_expire_days IS NOT NULL AND cfg.deal_expire_days IS NOT NULL
JOIN `system_notify_template` t
  ON t.code = 'crm_customer_pool_remind' AND t.deleted = b'0' AND t.status = 0
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND IFNULL(c.lock_status, b'0') = b'0'
  AND IFNULL(c.deal_status, b'0') = b'0'
  AND IFNULL(c.pool_reminded, b'0') = b'0'
  AND c.owner_time IS NOT NULL
  AND LEAST(
    DATE_ADD(IFNULL(c.contact_last_time, c.owner_time), INTERVAL GREATEST(cfg.contact_expire_days - cfg.notify_days, 0) DAY),
    DATE_ADD(c.owner_time, INTERVAL GREATEST(cfg.deal_expire_days - cfg.notify_days, 0) DAY)
  ) <= NOW()
  AND LEAST(
    DATE_ADD(IFNULL(c.contact_last_time, c.owner_time), INTERVAL cfg.contact_expire_days DAY),
    DATE_ADD(c.owner_time, INTERVAL cfg.deal_expire_days DAY)
  ) > NOW();

UPDATE `crm_customer` c
JOIN `crm_customer_pool_config` cfg
  ON cfg.deleted = b'0' AND cfg.enabled = b'1' AND cfg.notify_enabled = b'1'
 AND cfg.notify_days IS NOT NULL AND cfg.contact_expire_days IS NOT NULL AND cfg.deal_expire_days IS NOT NULL
SET c.pool_reminded = b'1', c.updater = '1', c.update_time = NOW()
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND IFNULL(c.lock_status, b'0') = b'0'
  AND IFNULL(c.deal_status, b'0') = b'0'
  AND c.owner_time IS NOT NULL
  AND LEAST(
    DATE_ADD(IFNULL(c.contact_last_time, c.owner_time), INTERVAL GREATEST(cfg.contact_expire_days - cfg.notify_days, 0) DAY),
    DATE_ADD(c.owner_time, INTERVAL GREATEST(cfg.deal_expire_days - cfg.notify_days, 0) DAY)
  ) <= NOW()
  AND LEAST(
    DATE_ADD(IFNULL(c.contact_last_time, c.owner_time), INTERVAL cfg.contact_expire_days DAY),
    DATE_ADD(c.owner_time, INTERVAL cfg.deal_expire_days DAY)
  ) > NOW();

-- 9) 合同即将到期（对齐合约配置 notify_days；仅已审批）
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
  CONCAT('Please follow up on contract: ', c.name),
  t.type,
  JSON_OBJECT(
    'name', c.name,
    'id', c.id,
    'route', CONCAT('/crm/contract/detail/', c.id)
  ),
  b'0', NULL, b'0', NULL,
  '1',
  DATE(DATE_SUB(c.end_time, INTERVAL cfg.notify_days DAY)),
  '1', NOW(), b'0', IFNULL(c.tenant_id, 1)
FROM `crm_contract` c
JOIN `crm_contract_config` cfg
  ON cfg.deleted = b'0' AND cfg.notify_enabled = b'1' AND cfg.notify_days IS NOT NULL
JOIN `system_notify_template` t
  ON t.code = 'crm_contract_expiry' AND t.deleted = b'0' AND t.status = 0
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.end_time IS NOT NULL
  AND c.audit_status = 20
  AND IFNULL(c.expiry_reminded, b'0') = b'0'
  AND NOW() >= DATE(DATE_SUB(c.end_time, INTERVAL cfg.notify_days DAY))
  AND NOW() < DATE_ADD(DATE(c.end_time), INTERVAL 1 DAY);

UPDATE `crm_contract` c
JOIN `crm_contract_config` cfg
  ON cfg.deleted = b'0' AND cfg.notify_enabled = b'1' AND cfg.notify_days IS NOT NULL
SET c.expiry_reminded = b'1', c.updater = '1', c.update_time = NOW()
WHERE c.deleted = b'0'
  AND c.owner_user_id IS NOT NULL AND c.owner_user_id > 0
  AND c.end_time IS NOT NULL
  AND c.audit_status = 20
  AND NOW() >= DATE(DATE_SUB(c.end_time, INTERVAL cfg.notify_days DAY))
  AND NOW() < DATE_ADD(DATE(c.end_time), INTERVAL 1 DAY);

-- 10) BPM 运行中待办 → crm_audit_remind（英文占位：Contract/Payment approval + Approver）
-- 业务机 lower_case_table_names=0，表名大小写敏感（ACT_RU_TASK）
SET @has_task := (
  SELECT COUNT(*) FROM information_schema.TABLES
  WHERE TABLE_SCHEMA = DATABASE() AND UPPER(TABLE_NAME) = 'ACT_RU_TASK'
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
     CONCAT(
       ''New task: '',
       CASE
         WHEN def.KEY_ = ''crm-contract-audit'' OR proc.NAME_ IN (''合同审批'', ''Contract approval'') THEN ''Contract approval''
         WHEN def.KEY_ = ''crm-receivable-audit'' OR proc.NAME_ IN (''回款审批'', ''Payment approval'') THEN ''Payment approval''
         ELSE IFNULL(proc.NAME_, ''Process'')
       END,
       ''-'',
       CASE
         WHEN task.NAME_ IN (''审批'', ''审批人'', ''Approver'') THEN ''Approver''
         ELSE IFNULL(task.NAME_, ''Approver'')
       END,
       '', requester: '', IFNULL(u.nickname, ''System'')
     ),
     t.type,
     JSON_OBJECT(
       ''processInstanceName'', CASE
         WHEN def.KEY_ = ''crm-contract-audit'' OR proc.NAME_ IN (''合同审批'', ''Contract approval'') THEN ''Contract approval''
         WHEN def.KEY_ = ''crm-receivable-audit'' OR proc.NAME_ IN (''回款审批'', ''Payment approval'') THEN ''Payment approval''
         ELSE IFNULL(proc.NAME_, ''Process'')
       END,
       ''taskName'', CASE
         WHEN task.NAME_ IN (''审批'', ''审批人'', ''Approver'') THEN ''Approver''
         ELSE IFNULL(task.NAME_, ''Approver'')
       END,
       ''startUserNickname'', IFNULL(u.nickname, ''System''),
       ''processInstanceId'', task.PROC_INST_ID_,
       ''processDefinitionKey'', IFNULL(def.KEY_, ''''),
       ''route'', CONCAT(''/bpm/process-instance/detail?id='', task.PROC_INST_ID_)
     ),
     b''0'', NULL, b''0'', NULL,
     ''1'',
     IFNULL(task.CREATE_TIME_, NOW()),
     ''1'', NOW(), b''0'', IFNULL(u.tenant_id, 1)
   FROM ACT_RU_TASK task
   LEFT JOIN ACT_HI_PROCINST proc ON proc.PROC_INST_ID_ = task.PROC_INST_ID_
   LEFT JOIN ACT_RE_PROCDEF def ON def.ID_ = task.PROC_DEF_ID_
   LEFT JOIN system_users u ON u.id = CAST(proc.START_USER_ID_ AS UNSIGNED) AND u.deleted = b''0''
   JOIN system_notify_template t
     ON t.code = ''crm_audit_remind'' AND t.deleted = b''0'' AND t.status = 0
   WHERE task.ASSIGNEE_ REGEXP ''^[0-9]+$''
     AND CAST(task.ASSIGNEE_ AS UNSIGNED) > 0',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- 11) 汇总
SELECT template_code, COUNT(*) AS cnt
FROM system_notify_message
WHERE deleted = b'0'
GROUP BY template_code
ORDER BY cnt DESC;

SELECT COUNT(*) AS notify_active FROM system_notify_message WHERE deleted = b'0';

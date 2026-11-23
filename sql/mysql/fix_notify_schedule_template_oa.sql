-- 日程 + 审批模板：code/发送人均为 OA；物理删除旧 crm_* / bpm_* 审批与日程别名
-- 幂等可重复执行

-- ========== 日程 ==========
UPDATE `system_notify_template`
SET `name` = 'Schedule reminder',
    `nickname` = 'OA',
    `content` = 'Please handle schedule: {name}',
    `params` = '["name","scheduleId"]',
    `route` = '/bpm/my-schedule?scheduleId={scheduleId}',
    `type` = 7,
    `status` = 0,
    `remark` = 'My Schedule',
    `updater` = '1',
    `update_time` = NOW()
WHERE `code` = 'oa_schedule_reminder' AND `deleted` = b'0';

INSERT INTO `system_notify_template` (
  `name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`,
  `creator`, `create_time`, `updater`, `update_time`, `deleted`
)
SELECT 'Schedule reminder', 'oa_schedule_reminder', 'OA',
       'Please handle schedule: {name}', '/bpm/my-schedule?scheduleId={scheduleId}',
       7, '["name","scheduleId"]', 0, 'My Schedule',
       '1', NOW(), '1', NOW(), b'0'
FROM DUAL
WHERE NOT EXISTS (
  SELECT 1 FROM `system_notify_template` WHERE `code` = 'oa_schedule_reminder' AND `deleted` = b'0'
);

DELETE FROM `system_notify_template` WHERE `code` = 'bpm_schedule_reminder';

-- ========== 审批（OA办公）==========
-- 先插入 oa_*（若不存在）；再删旧 crm_*；避免同表 UPDATE…NOT EXISTS 在 MySQL 报 1093

INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Pending approval remind', 'oa_audit_remind', 'OA',
       'New task: {processInstanceName}-{taskName}, requester: {startUserNickname}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","taskName","startUserNickname","processInstanceId"]', 0, 'Approval process details',
       '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='oa_audit_remind' AND deleted=b'0');

INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Contract approved', 'oa_contract_pass', 'OA',
       'Your process was approved: {processInstanceName}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","processInstanceId"]', 0, 'Approval process details',
       '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='oa_contract_pass' AND deleted=b'0');

INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Contract rejected', 'oa_contract_reject', 'OA',
       'Your process was rejected: {processInstanceName}. Reason: {reason}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","reason","processInstanceId"]', 0, 'Approval process details',
       '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='oa_contract_reject' AND deleted=b'0');

INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Payment approved', 'oa_receivable_pass', 'OA',
       'Your process was approved: {processInstanceName}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","processInstanceId"]', 0, 'Approval process details',
       '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='oa_receivable_pass' AND deleted=b'0');

INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Payment rejected', 'oa_receivable_reject', 'OA',
       'Your process was rejected: {processInstanceName}. Reason: {reason}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","reason","processInstanceId"]', 0, 'Approval process details',
       '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='oa_receivable_reject' AND deleted=b'0');

UPDATE `system_notify_template` SET
  `nickname` = 'OA', `status` = 0, `updater` = '1', `update_time` = NOW()
WHERE `code` IN (
  'oa_audit_remind', 'oa_contract_pass', 'oa_contract_reject',
  'oa_receivable_pass', 'oa_receivable_reject', 'oa_schedule_reminder'
) AND `deleted` = b'0';

DELETE FROM `system_notify_template` WHERE `code` IN (
  'crm_audit_remind', 'crm_contract_pass', 'crm_contract_reject',
  'crm_receivable_pass', 'crm_receivable_reject'
);

-- 历史消息 code 一并改名（无消息时无影响）
UPDATE `system_notify_message` SET `template_code` = 'oa_audit_remind', `updater` = '1', `update_time` = NOW()
WHERE `template_code` = 'crm_audit_remind';
UPDATE `system_notify_message` SET `template_code` = 'oa_contract_pass', `updater` = '1', `update_time` = NOW()
WHERE `template_code` = 'crm_contract_pass';
UPDATE `system_notify_message` SET `template_code` = 'oa_contract_reject', `updater` = '1', `update_time` = NOW()
WHERE `template_code` = 'crm_contract_reject';
UPDATE `system_notify_message` SET `template_code` = 'oa_receivable_pass', `updater` = '1', `update_time` = NOW()
WHERE `template_code` = 'crm_receivable_pass';
UPDATE `system_notify_message` SET `template_code` = 'oa_receivable_reject', `updater` = '1', `update_time` = NOW()
WHERE `template_code` = 'crm_receivable_reject';

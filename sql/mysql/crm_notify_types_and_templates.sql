-- 站内信类型 + 模板重构（幂等可重复执行）
-- 1) 扩展列  2) 清空站内信  3) 重建意向CRM对齐模板

-- ========== 列扩展 ==========
-- process_status（站内信已办）
SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'system_notify_message' AND COLUMN_NAME = 'process_status');
SET @sql := IF(@col = 0,
  'ALTER TABLE `system_notify_message` ADD COLUMN `process_status` bit(1) NOT NULL DEFAULT b''0'' COMMENT ''是否已办'' AFTER `read_time`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'system_notify_message' AND COLUMN_NAME = 'process_time');
SET @sql := IF(@col = 0,
  'ALTER TABLE `system_notify_message` ADD COLUMN `process_time` datetime NULL DEFAULT NULL COMMENT ''办理时间'' AFTER `process_status`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- 模板跳转地址
SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'system_notify_template' AND COLUMN_NAME = 'route');
SET @sql := IF(@col = 0,
  'ALTER TABLE `system_notify_template` ADD COLUMN `route` varchar(512) NULL DEFAULT NULL COMMENT ''跳转地址'' AFTER `content`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- 参数列加宽
ALTER TABLE `system_notify_message` MODIFY COLUMN `template_params` varchar(1024) NOT NULL DEFAULT '{}';

-- 日程已迁 BPM（bpm_schedule）；不再改 oa_schedule（表可能已 DROP）

-- ========== 字典：system_notify_template_type ==========
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1776, 3, 'CRM follow-up', '3', 'system_notify_template_type', 0, 'warning', '', 'CRM follow-up', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='3' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1777, 4, 'CRM approval', '4', 'system_notify_template_type', 0, 'danger', '', 'CRM approval', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='4' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1778, 5, 'Contract expiring', '5', 'system_notify_template_type', 0, 'warning', '', 'Contract expiring', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='5' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1779, 6, 'Payment reminder', '6', 'system_notify_template_type', 0, 'primary', '', 'Payment reminder', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='6' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1780, 7, 'Schedule reminder', '7', 'system_notify_template_type', 0, 'success', '', 'Schedule reminder', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='7' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1781, 8, 'Approval CC', '8', 'system_notify_template_type', 0, 'info', '', 'Approval CC', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='8' AND deleted=b'0');

UPDATE `system_dict_data` SET `label`='CRM follow-up', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='3' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='CRM approval', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='4' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='Contract expiring', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='5' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='Payment reminder', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='6' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='Schedule reminder', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='7' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='Approval CC', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='8' AND `deleted`=b'0';

-- ========== 清空全部站内信 ==========
UPDATE `system_notify_message` SET `deleted` = b'1', `updater` = '1', `update_time` = NOW() WHERE `deleted` = b'0';

-- ========== 关闭旧模板，重建目标模板 ==========
-- 关闭状态模板直接删除
DELETE FROM `system_notify_template` WHERE `status` = 1;

UPDATE `system_notify_template` SET `status` = 1, `updater` = '1', `update_time` = NOW()
WHERE `deleted` = b'0'
  AND `code` NOT IN (
    'crm_clue_follow_today','crm_customer_follow_today','crm_business_follow_today','crm_contract_follow_today',
    'crm_customer_pool_remind','crm_audit_remind','crm_contract_pass','crm_contract_reject',
    'crm_receivable_pass','crm_receivable_reject','crm_contract_expiry','oa_schedule_reminder','bpm_schedule_reminder'
  );

-- 辅助：插入或更新模板
-- 今日线索跟进提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Follow up on lead today', 'crm_clue_follow_today', 'CRM',
       'Please follow up on lead: {name}', '/crm/clue/detail/{id}',
       3, '["name","id"]', 0, 'Lead details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_clue_follow_today' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Follow up on lead today', `nickname`='CRM', `content`='Please follow up on lead: {name}',
  `route`='/crm/clue/detail/{id}', `type`=3, `params`='["name","id"]', `status`=0,
  `remark`='Lead details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_clue_follow_today' AND `deleted`=b'0';

-- 今日客户跟进提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Follow up on customer today', 'crm_customer_follow_today', 'CRM',
       'Please follow up on customer: {name}', '/crm/customer/detail/{id}',
       3, '["name","id"]', 0, 'Customer details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_customer_follow_today' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Follow up on customer today', `nickname`='CRM', `content`='Please follow up on customer: {name}',
  `route`='/crm/customer/detail/{id}', `type`=3, `params`='["name","id"]', `status`=0,
  `remark`='Customer details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_customer_follow_today' AND `deleted`=b'0';

-- 今日商机跟进提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Follow up on opportunity today', 'crm_business_follow_today', 'CRM',
       'Please follow up on opportunity: {name}', '/crm/business/detail/{id}',
       3, '["name","id"]', 0, 'Opportunity details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_business_follow_today' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Follow up on opportunity today', `nickname`='CRM', `content`='Please follow up on opportunity: {name}',
  `route`='/crm/business/detail/{id}', `type`=3, `params`='["name","id"]', `status`=0,
  `remark`='Opportunity details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_business_follow_today' AND `deleted`=b'0';

-- 今日合同跟进提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Follow up on contract today', 'crm_contract_follow_today', 'CRM',
       'Please follow up on contract: {name}', '/crm/contract/detail/{id}',
       5, '["name","id"]', 0, 'Contract details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_contract_follow_today' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Follow up on contract today', `nickname`='CRM', `content`='Please follow up on contract: {name}',
  `route`='/crm/contract/detail/{id}', `type`=5, `params`='["name","id"]', `status`=0,
  `remark`='Contract details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_contract_follow_today' AND `deleted`=b'0';

-- 即将退回公海提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Customer moving to the pool', 'crm_customer_pool_remind', 'CRM',
       'Please follow up on customer: {name}', '/crm/customer/detail/{id}',
       3, '["name","id"]', 0, 'Customer details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_customer_pool_remind' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Customer moving to the pool', `nickname`='CRM', `content`='Please follow up on customer: {name}',
  `route`='/crm/customer/detail/{id}', `type`=3, `params`='["name","id"]', `status`=0,
  `remark`='Customer details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_customer_pool_remind' AND `deleted`=b'0';

-- 待审批提醒（审批人；BPM 任务分配时逐条发送，禁止日报汇总）
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Pending approval remind', 'crm_audit_remind', 'BPM',
       'New task: {processInstanceName}-{taskName}, requester: {startUserNickname}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","taskName","startUserNickname","processInstanceId"]', 0, 'Approval process details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_audit_remind' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Pending approval remind', `nickname`='BPM',
  `content`='New task: {processInstanceName}-{taskName}, requester: {startUserNickname}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","taskName","startUserNickname","processInstanceId"]', `status`=0,
  `remark`='Approval process details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_audit_remind' AND `deleted`=b'0';

-- 合同审批通过
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Contract approved', 'crm_contract_pass', 'BPM',
       'Your process was approved: {processInstanceName}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","processInstanceId"]', 0, 'Approval process details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_contract_pass' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Contract approved', `nickname`='BPM',
  `content`='Your process was approved: {processInstanceName}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","processInstanceId"]', `status`=0,
  `remark`='Approval process details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_contract_pass' AND `deleted`=b'0';

-- 合同审批不通过
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Contract rejected', 'crm_contract_reject', 'BPM',
       'Your process was rejected: {processInstanceName}. Reason: {reason}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","reason","processInstanceId"]', 0, 'Approval process details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_contract_reject' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Contract rejected', `nickname`='BPM',
  `content`='Your process was rejected: {processInstanceName}. Reason: {reason}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","reason","processInstanceId"]', `status`=0,
  `remark`='Approval process details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_contract_reject' AND `deleted`=b'0';

-- 回款审批通过
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Payment approved', 'crm_receivable_pass', 'BPM',
       'Your process was approved: {processInstanceName}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","processInstanceId"]', 0, 'Approval process details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_receivable_pass' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Payment approved', `nickname`='BPM',
  `content`='Your process was approved: {processInstanceName}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","processInstanceId"]', `status`=0,
  `remark`='Approval process details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_receivable_pass' AND `deleted`=b'0';

-- 回款审批不通过
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Payment rejected', 'crm_receivable_reject', 'BPM',
       'Your process was rejected: {processInstanceName}. Reason: {reason}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","reason","processInstanceId"]', 0, 'Approval process details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_receivable_reject' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Payment rejected', `nickname`='BPM',
  `content`='Your process was rejected: {processInstanceName}. Reason: {reason}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","reason","processInstanceId"]', `status`=0,
  `remark`='Approval process details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_receivable_reject' AND `deleted`=b'0';

-- 合同即将到期提醒（跳转合同详情；文案按用户给定）
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Contract expiring soon', 'crm_contract_expiry', 'CRM',
       'Please follow up on contract: {name}', '/crm/contract/detail/{id}',
       5, '["name","id"]', 0, 'Contract details', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_contract_expiry' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Contract expiring soon', `nickname`='CRM', `content`='Please follow up on contract: {name}',
  `route`='/crm/contract/detail/{id}', `type`=5, `params`='["name","id"]', `status`=0,
  `remark`='Contract details', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_contract_expiry' AND `deleted`=b'0';

-- 待处理日程（产品 code = bpm_schedule_reminder；旧 oa_* 仅保留停用别名）
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'Schedule reminder', 'bpm_schedule_reminder', 'System',
       'Please handle schedule: {name}', '/bpm/my-schedule?scheduleId={scheduleId}',
       7, '["name","scheduleId"]', 0, 'My Schedule', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='bpm_schedule_reminder' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='Schedule reminder', `nickname`='System', `content`='Please handle schedule: {name}',
  `route`='/bpm/my-schedule?scheduleId={scheduleId}', `type`=7,
  `params`='["name","scheduleId"]', `status`=0,
  `remark`='My Schedule', `updater`='1', `update_time`=NOW()
WHERE `code`='bpm_schedule_reminder' AND `deleted`=b'0';

UPDATE `system_notify_template` SET
  `status`=1, `route`='/bpm/my-schedule?scheduleId={scheduleId}',
  `updater`='1', `update_time`=NOW()
WHERE `code`='oa_schedule_reminder' AND `deleted`=b'0';

-- ========== 菜单：我的日程（挂 BPM 目录 148；产品展示名定制为 OA）==========
UPDATE `system_menu` SET `name` = 'OA', `updater` = '1', `update_time` = NOW()
WHERE `id` = 148 AND `deleted` = b'0';

-- 我的日程已迁 BPM（勿再写回 oa:schedule / oa/schedule 组件）
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 5088, 'My Schedule', 'bpm:schedule:query', 2, 5, 148, 'my-schedule', 'ep:calendar', 'bpm/schedule/calendar/index', 'BpmMySchedule', 0, b'1', b'1', b'0', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_menu WHERE id = 5088 AND deleted = b'0');

UPDATE `system_menu` SET
  `parent_id` = 148, `path` = 'my-schedule', `name` = 'My Schedule', `icon` = 'ep:calendar',
  `component` = 'bpm/schedule/calendar/index', `component_name` = 'BpmMySchedule',
  `permission` = 'bpm:schedule:query', `sort` = 5, `visible` = b'1', `status` = 0,
  `updater` = '1', `update_time` = NOW()
WHERE `id` = 5088 AND `deleted` = b'0';

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 5089, 'Schedule Create', 'bpm:schedule:create', 3, 1, 5088, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_menu WHERE id = 5089 AND deleted = b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 5090, 'Schedule Update', 'bpm:schedule:update', 3, 2, 5088, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_menu WHERE id = 5090 AND deleted = b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 5091, 'Schedule Delete', 'bpm:schedule:delete', 3, 3, 5088, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_menu WHERE id = 5091 AND deleted = b'0');

-- 给已有「我的日程」权限的角色补上 BPM create/update/delete
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT r.role_id, m.id, '1', NOW(), '1', NOW(), b'0', r.tenant_id
FROM (
  SELECT DISTINCT `role_id`, `tenant_id` FROM `system_role_menu`
  WHERE `menu_id` = 5088 AND `deleted` = b'0'
) r
CROSS JOIN `system_menu` m
WHERE m.id IN (5089, 5090, 5091) AND m.deleted = b'0'
AND NOT EXISTS (
  SELECT 1 FROM `system_role_menu` x
  WHERE x.role_id = r.role_id AND x.menu_id = m.id AND x.deleted = b'0' AND x.tenant_id = r.tenant_id
);

-- 站内信请用真实业务数据生成，见 notify_message_real_seed.sql（勿再插入示例假数据）

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

-- 日程已处理
SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'oa_schedule' AND COLUMN_NAME = 'process_status');
SET @sql := IF(@col = 0,
  'ALTER TABLE `oa_schedule` ADD COLUMN `process_status` tinyint NOT NULL DEFAULT 0 COMMENT ''日程状态：0未执行 1执行中 2已结束 3已取消'' AFTER `reminded`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'oa_schedule' AND COLUMN_NAME = 'process_time');
SET @sql := IF(@col = 0,
  'ALTER TABLE `oa_schedule` ADD COLUMN `process_time` datetime NULL DEFAULT NULL COMMENT ''处理时间'' AFTER `process_status`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- ========== 字典：system_notify_template_type ==========
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1776, 3, 'CRM跟进', '3', 'system_notify_template_type', 0, 'warning', '', 'CRM follow-up', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='3' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1777, 4, 'CRM审批', '4', 'system_notify_template_type', 0, 'danger', '', 'CRM audit', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='4' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1778, 5, '合同到期', '5', 'system_notify_template_type', 0, 'warning', '', 'Contract expiring', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='5' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1779, 6, '回款提醒', '6', 'system_notify_template_type', 0, 'primary', '', 'Receivable', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='6' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1780, 7, '日程提醒', '7', 'system_notify_template_type', 0, 'success', '', 'OA schedule', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='7' AND deleted=b'0');

INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 1781, 8, '审批抄送', '8', 'system_notify_template_type', 0, 'info', '', 'BPM CC', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_data WHERE dict_type='system_notify_template_type' AND value='8' AND deleted=b'0');

UPDATE `system_dict_data` SET `label`='CRM跟进', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='3' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='CRM审批', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='4' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='合同到期', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='5' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='回款提醒', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='6' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='日程提醒', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='7' AND `deleted`=b'0';
UPDATE `system_dict_data` SET `label`='审批抄送', `updater`='1', `update_time`=NOW() WHERE `dict_type`='system_notify_template_type' AND `value`='8' AND `deleted`=b'0';

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
    'crm_receivable_pass','crm_receivable_reject','crm_contract_expiry','oa_schedule_reminder'
  );

-- 辅助：插入或更新模板
-- 今日线索跟进提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '今日线索跟进提醒', 'crm_clue_follow_today', 'CRM',
       '请你及时跟进线索：{name}', '/crm/clue/detail/{id}',
       3, '["name","id"]', 0, '线索详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_clue_follow_today' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='今日线索跟进提醒', `nickname`='CRM', `content`='请你及时跟进线索：{name}',
  `route`='/crm/clue/detail/{id}', `type`=3, `params`='["name","id"]', `status`=0,
  `remark`='线索详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_clue_follow_today' AND `deleted`=b'0';

-- 今日客户跟进提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '今日客户跟进提醒', 'crm_customer_follow_today', 'CRM',
       '请你及时跟进客户：{name}', '/crm/customer/detail/{id}',
       3, '["name","id"]', 0, '客户详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_customer_follow_today' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='今日客户跟进提醒', `nickname`='CRM', `content`='请你及时跟进客户：{name}',
  `route`='/crm/customer/detail/{id}', `type`=3, `params`='["name","id"]', `status`=0,
  `remark`='客户详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_customer_follow_today' AND `deleted`=b'0';

-- 今日商机跟进提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '今日商机跟进提醒', 'crm_business_follow_today', 'CRM',
       '请你及时跟进商机：{name}', '/crm/business/detail/{id}',
       3, '["name","id"]', 0, '商机详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_business_follow_today' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='今日商机跟进提醒', `nickname`='CRM', `content`='请你及时跟进商机：{name}',
  `route`='/crm/business/detail/{id}', `type`=3, `params`='["name","id"]', `status`=0,
  `remark`='商机详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_business_follow_today' AND `deleted`=b'0';

-- 今日合同跟进提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '今日合同跟进提醒', 'crm_contract_follow_today', 'CRM',
       '请你及时跟进合同：{name}', '/crm/contract/detail/{id}',
       5, '["name","id"]', 0, '合同详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_contract_follow_today' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='今日合同跟进提醒', `nickname`='CRM', `content`='请你及时跟进合同：{name}',
  `route`='/crm/contract/detail/{id}', `type`=5, `params`='["name","id"]', `status`=0,
  `remark`='合同详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_contract_follow_today' AND `deleted`=b'0';

-- 即将退回公海提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '即将退回公海提醒', 'crm_customer_pool_remind', 'CRM',
       '请你及时跟进客户：{name}', '/crm/customer/detail/{id}',
       3, '["name","id"]', 0, '客户详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_customer_pool_remind' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='即将退回公海提醒', `nickname`='CRM', `content`='请你及时跟进客户：{name}',
  `route`='/crm/customer/detail/{id}', `type`=3, `params`='["name","id"]', `status`=0,
  `remark`='客户详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_customer_pool_remind' AND `deleted`=b'0';

-- 待审批提醒
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '待审批提醒', 'crm_audit_remind', 'BPM',
       '您收到了一条新的待办任务：{processInstanceName}-{taskName}，申请人：{startUserNickname}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","taskName","startUserNickname","processInstanceId"]', 0, '审批流程详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_audit_remind' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='待审批提醒', `nickname`='BPM',
  `content`='您收到了一条新的待办任务：{processInstanceName}-{taskName}，申请人：{startUserNickname}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","taskName","startUserNickname","processInstanceId"]', `status`=0,
  `remark`='审批流程详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_audit_remind' AND `deleted`=b'0';

-- 合同审批通过
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '合同审批通过提醒', 'crm_contract_pass', 'BPM',
       '您的流程被审批通过：{processInstanceName}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","processInstanceId"]', 0, '审批流程详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_contract_pass' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='合同审批通过提醒', `nickname`='BPM',
  `content`='您的流程被审批通过：{processInstanceName}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","processInstanceId"]', `status`=0,
  `remark`='审批流程详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_contract_pass' AND `deleted`=b'0';

-- 合同审批不通过
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '合同审批不通过提醒', 'crm_contract_reject', 'BPM',
       '您的流程被审批不通过：{processInstanceName}，原因：{reason}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","reason","processInstanceId"]', 0, '审批流程详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_contract_reject' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='合同审批不通过提醒', `nickname`='BPM',
  `content`='您的流程被审批不通过：{processInstanceName}，原因：{reason}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","reason","processInstanceId"]', `status`=0,
  `remark`='审批流程详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_contract_reject' AND `deleted`=b'0';

-- 回款审批通过
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '回款审批通过提醒', 'crm_receivable_pass', 'BPM',
       '您的流程被审批通过：{processInstanceName}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","processInstanceId"]', 0, '审批流程详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_receivable_pass' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='回款审批通过提醒', `nickname`='BPM',
  `content`='您的流程被审批通过：{processInstanceName}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","processInstanceId"]', `status`=0,
  `remark`='审批流程详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_receivable_pass' AND `deleted`=b'0';

-- 回款审批不通过
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '回款审批不通过提醒', 'crm_receivable_reject', 'BPM',
       '您的流程被审批不通过：{processInstanceName}，原因：{reason}',
       '/bpm/process-instance/detail?id={processInstanceId}',
       4, '["processInstanceName","reason","processInstanceId"]', 0, '审批流程详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_receivable_reject' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='回款审批不通过提醒', `nickname`='BPM',
  `content`='您的流程被审批不通过：{processInstanceName}，原因：{reason}',
  `route`='/bpm/process-instance/detail?id={processInstanceId}', `type`=4,
  `params`='["processInstanceName","reason","processInstanceId"]', `status`=0,
  `remark`='审批流程详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_receivable_reject' AND `deleted`=b'0';

-- 合同即将到期提醒（跳转合同详情；文案按用户给定）
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '合同即将到期提醒', 'crm_contract_expiry', 'CRM',
       '请你及时跟进合同：{name}', '/crm/contract/detail/{id}',
       5, '["name","id"]', 0, '合同详情', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='crm_contract_expiry' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='合同即将到期提醒', `nickname`='CRM', `content`='请你及时跟进合同：{name}',
  `route`='/crm/contract/detail/{id}', `type`=5, `params`='["name","id"]', `status`=0,
  `remark`='合同详情', `updater`='1', `update_time`=NOW()
WHERE `code`='crm_contract_expiry' AND `deleted`=b'0';

-- 待处理日程（跳转仅带 scheduleId）
INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT '待处理日程', 'oa_schedule_reminder', 'OA',
       '请你及时处理日程：{name}', '/bpm/my-schedule?scheduleId={scheduleId}',
       7, '["name","scheduleId"]', 0, '我的日程', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_notify_template WHERE code='oa_schedule_reminder' AND deleted=b'0');
UPDATE `system_notify_template` SET
  `name`='待处理日程', `nickname`='OA', `content`='请你及时处理日程：{name}',
  `route`='/bpm/my-schedule?scheduleId={scheduleId}', `type`=7,
  `params`='["name","scheduleId"]', `status`=0,
  `remark`='我的日程', `updater`='1', `update_time`=NOW()
WHERE `code`='oa_schedule_reminder' AND `deleted`=b'0';

-- ========== 菜单：我的日程 ==========
UPDATE `system_menu` SET `name` = 'OA办公', `updater` = '1', `update_time` = NOW()
WHERE `id` = 148 AND `deleted` = b'0';

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 5088, '我的日程', 'oa:schedule:query', 2, 5, 148, 'my-schedule', 'ep:calendar', 'oa/schedule/calendar/index', 'OaMySchedule', 0, b'1', b'1', b'0', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_menu WHERE id = 5088 AND deleted = b'0');

UPDATE `system_menu` SET
  `parent_id` = 148, `path` = 'my-schedule', `name` = '我的日程', `icon` = 'ep:calendar',
  `component` = 'oa/schedule/calendar/index', `component_name` = 'OaMySchedule',
  `permission` = 'oa:schedule:query', `sort` = 5, `visible` = b'1',
  `updater` = '1', `update_time` = NOW()
WHERE `id` = 5088 AND `deleted` = b'0';

UPDATE `system_menu` SET `visible` = b'0', `updater` = '1', `update_time` = NOW()
WHERE `id` = 8216 AND `deleted` = b'0';

-- 给已有「我的日程」权限的角色补上 create/update/delete
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT r.role_id, m.id, '1', NOW(), '1', NOW(), b'0', r.tenant_id
FROM (
  SELECT DISTINCT `role_id`, `tenant_id` FROM `system_role_menu`
  WHERE `menu_id` IN (5088, 8215, 8216) AND `deleted` = b'0'
) r
CROSS JOIN `system_menu` m
WHERE m.id IN (8211, 8212, 8213) AND m.deleted = b'0'
AND NOT EXISTS (
  SELECT 1 FROM `system_role_menu` x
  WHERE x.role_id = r.role_id AND x.menu_id = m.id AND x.deleted = b'0' AND x.tenant_id = r.tenant_id
);

-- 站内信请用真实业务数据生成，见 notify_message_real_seed.sql（勿再插入示例假数据）

-- Fix Chinese-only seeds: menus / notify dict types / notify templates / OA priority → English (idempotent)
-- Chinese UI uses menu-source-zh / dict-source-zh / glossary-zh.

-- ========== OA priority / schedule type ==========
UPDATE `system_dict_data` SET `label` = 'Normal', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'oa_priority' AND `value` = '1' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'Important', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'oa_priority' AND `value` = '2' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'Urgent', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'oa_priority' AND `value` = '3' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'Important and urgent', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'oa_priority' AND `value` = '4' AND `deleted` = b'0';
INSERT INTO `system_dict_data` (`sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 4, 'Important and urgent', '4', 'oa_priority', 0, 'danger', '', '', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM `system_dict_data` WHERE `dict_type` = 'oa_priority' AND `value` = '4' AND `deleted` = b'0'
);
UPDATE `system_dict_data` SET `label` = 'Schedule reminder', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'oa_schedule_type' AND `value` = '1' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'Holiday', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'oa_schedule_type' AND `value` = '2' AND `deleted` = b'0';

-- ========== Menus ==========
UPDATE `system_menu` SET `name` = 'OA', `updater` = '1', `update_time` = NOW()
WHERE `id` = 148 AND `deleted` = b'0';

UPDATE `system_menu` SET `name` = 'My Schedule', `updater` = '1', `update_time` = NOW()
WHERE `id` = 5088 AND `deleted` = b'0';

-- ========== Dict: system_notify_template_type ==========
UPDATE `system_dict_data` SET `label` = 'Announcements', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'system_notify_template_type' AND `value` = '1' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'System message', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'system_notify_template_type' AND `value` = '2' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'CRM follow-up', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'system_notify_template_type' AND `value` = '3' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'CRM approval', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'system_notify_template_type' AND `value` = '4' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'Contract expiring', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'system_notify_template_type' AND `value` = '5' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'Payment reminder', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'system_notify_template_type' AND `value` = '6' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'Schedule reminder', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'system_notify_template_type' AND `value` = '7' AND `deleted` = b'0';
UPDATE `system_dict_data` SET `label` = 'Approval CC', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'system_notify_template_type' AND `value` = '8' AND `deleted` = b'0';

-- ========== Notify templates (name / content / remark) ==========
UPDATE `system_notify_template` SET
  `name` = 'Follow up on lead today',
  `content` = 'Please follow up on lead: {name}',
  `remark` = 'Lead details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_clue_follow_today' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Follow up on customer today',
  `content` = 'Please follow up on customer: {name}',
  `remark` = 'Customer details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_customer_follow_today' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Follow up on opportunity today',
  `content` = 'Please follow up on opportunity: {name}',
  `remark` = 'Opportunity details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_business_follow_today' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Follow up on contract today',
  `content` = 'Please follow up on contract: {name}',
  `remark` = 'Contract details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_contract_follow_today' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Customer moving to the pool',
  `content` = 'Please follow up on customer: {name}',
  `remark` = 'Customer details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_customer_pool_remind' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Pending approval remind',
  `content` = 'New task: {processInstanceName}-{taskName}, requester: {startUserNickname}',
  `remark` = 'Approval process details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_audit_remind' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Contract approved',
  `content` = 'Your process was approved: {processInstanceName}',
  `remark` = 'Approval process details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_contract_pass' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Contract rejected',
  `content` = 'Your process was rejected: {processInstanceName}. Reason: {reason}',
  `remark` = 'Approval process details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_contract_reject' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Payment approved',
  `content` = 'Your process was approved: {processInstanceName}',
  `remark` = 'Approval process details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_receivable_pass' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Payment rejected',
  `content` = 'Your process was rejected: {processInstanceName}. Reason: {reason}',
  `remark` = 'Approval process details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_receivable_reject' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Contract expiring soon',
  `content` = 'Please follow up on contract: {name}',
  `remark` = 'Contract details',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_contract_expiry' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `name` = 'Schedule due',
  `content` = 'Please handle schedule: {name}',
  `remark` = 'My Schedule',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_schedule_reminder' AND `deleted` = b'0';

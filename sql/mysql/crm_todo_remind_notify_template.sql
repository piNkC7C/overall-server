-- CRM 待办每日提醒站内信模板（每天 9:00 推送）
-- 模板编码须与 CrmTodoRemindServiceImpl.NOTIFY_TEMPLATE_CODE 一致

INSERT INTO `system_notify_template` (`name`, `code`, `nickname`, `content`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 'CRM Daily Todo Remind', 'crm_todo_daily_remind', 'CRM',
       '您有 CRM 待办共 {totalCount} 项：今日联系 {todayCount}，待跟进客户 {followCustomerCount}，待跟进线索 {followClueCount}，即将入公海 {poolCount}，合同审批 {contractAuditCount}，合同到期 {contractRemindCount}，回款审批 {receivableAuditCount}，回款计划 {receivablePlanCount}。请打开消息中心处理。',
       2, '["totalCount","todayCount","followCustomerCount","followClueCount","poolCount","contractAuditCount","contractRemindCount","receivableAuditCount","receivablePlanCount"]',
       0, 'Daily CRM backlog remind at 09:00', '1', NOW(), '1', NOW(), b'0'
FROM DUAL
WHERE NOT EXISTS (
    SELECT 1 FROM `system_notify_template` WHERE `code` = 'crm_todo_daily_remind' AND `deleted` = b'0'
);

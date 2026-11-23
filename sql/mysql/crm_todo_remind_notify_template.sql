-- 已废弃：CRM 每日 9:00 汇总站内信（crm_todo_daily_remind）不再使用。
-- 跟进 → CrmEntityRemind* 实体到点；审批待办 → BPM 任务分配 oa_audit_remind。
-- 本脚本幂等：停用并软删旧模板。

UPDATE `system_notify_template`
SET `status` = 1, `deleted` = b'1', `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_todo_daily_remind' AND `deleted` = b'0';

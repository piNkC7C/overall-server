-- 客户级别标签颜色拉开区分度（幂等）
-- A 重点=danger，B 普通=warning，C 非优先=info（原 primary/info/default 过近）
UPDATE `system_dict_data`
SET `color_type` = 'danger', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'crm_customer_level' AND `value` = '1' AND `deleted` = b'0';

UPDATE `system_dict_data`
SET `color_type` = 'warning', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'crm_customer_level' AND `value` = '2' AND `deleted` = b'0';

UPDATE `system_dict_data`
SET `color_type` = 'info', `updater` = '1', `update_time` = NOW()
WHERE `dict_type` = 'crm_customer_level' AND `value` = '3' AND `deleted` = b'0';

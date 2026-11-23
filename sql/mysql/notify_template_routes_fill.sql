-- 按前端真实路由修正已开启模板的跳转地址（幂等）
-- CRM 详情：/crm/{module}/detail/{id}
-- BPM 流程：/bpm/process-instance/detail?id={processInstanceId}
-- 我的日程：/bpm/my-schedule?scheduleId={scheduleId}

UPDATE `system_notify_template` SET
  `route` = '/crm/clue/detail/{id}', `params` = '["name","id"]', `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_clue_follow_today' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/crm/customer/detail/{id}', `params` = '["name","id"]', `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_customer_follow_today' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/crm/business/detail/{id}', `params` = '["name","id"]', `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_business_follow_today' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/crm/contract/detail/{id}', `params` = '["name","id"]', `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_contract_follow_today' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/crm/customer/detail/{id}', `params` = '["name","id"]', `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_customer_pool_remind' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/bpm/process-instance/detail?id={processInstanceId}',
  `params` = '["processInstanceName","taskName","startUserNickname","processInstanceId"]',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_audit_remind' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/bpm/process-instance/detail?id={processInstanceId}',
  `params` = '["processInstanceName","processInstanceId"]',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_contract_pass' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/bpm/process-instance/detail?id={processInstanceId}',
  `params` = '["processInstanceName","reason","processInstanceId"]',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_contract_reject' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/bpm/process-instance/detail?id={processInstanceId}',
  `params` = '["processInstanceName","processInstanceId"]',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_receivable_pass' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/bpm/process-instance/detail?id={processInstanceId}',
  `params` = '["processInstanceName","reason","processInstanceId"]',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_receivable_reject' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/crm/contract/detail/{id}', `params` = '["name","id"]', `updater` = '1', `update_time` = NOW()
WHERE `code` = 'crm_contract_expiry' AND `deleted` = b'0';

UPDATE `system_notify_template` SET
  `route` = '/bpm/my-schedule?scheduleId={scheduleId}',
  `params` = '["name","scheduleId"]',
  `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_schedule_reminder' AND `deleted` = b'0';

-- 已有站内信 params.route 同步修正（query 风格 → path 风格）
UPDATE `system_notify_message`
SET `template_params` = REPLACE(
  REPLACE(
    REPLACE(
      REPLACE(`template_params`,
        '/crm/customer/detail?id=', '/crm/customer/detail/'),
      '/crm/clue/detail?id=', '/crm/clue/detail/'),
    '/crm/business/detail?id=', '/crm/business/detail/'),
  '/crm/contract/detail?id=', '/crm/contract/detail/'),
  `updater` = '1', `update_time` = NOW()
WHERE `deleted` = b'0'
  AND (
    `template_params` LIKE '%/crm/customer/detail?id=%'
    OR `template_params` LIKE '%/crm/clue/detail?id=%'
    OR `template_params` LIKE '%/crm/business/detail?id=%'
    OR `template_params` LIKE '%/crm/contract/detail?id=%'
  );

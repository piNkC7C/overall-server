-- Overall 独立 XXL 执行器 overall-admin（共享 xxl_job 库；勿挂到 yudao-server）
-- 负责人：zsj
-- 幂等可重复执行

USE xxl_job;

-- 1) 执行器组
INSERT INTO xxl_job_group (app_name, title, address_type, address_list, update_time)
SELECT 'overall-admin', 'Overall', 0, NULL, NOW()
FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM xxl_job_group WHERE app_name = 'overall-admin');

SET @overall_group_id := (SELECT id FROM xxl_job_group WHERE app_name = 'overall-admin' LIMIT 1);

-- 2) 旧任务 27：从 yudao-server 挪到 overall-admin 并启用
UPDATE xxl_job_info
SET job_group = @overall_group_id,
    author = 'zsj',
    trigger_status = 1,
    update_time = NOW()
WHERE id = 27 AND executor_handler = 'crmEntityRemindJob';

-- 3) 其余周期任务（不存在则插入）
INSERT INTO xxl_job_info (
  job_group, job_desc, add_time, update_time, author, alarm_email,
  schedule_type, schedule_conf, misfire_strategy, executor_route_strategy,
  executor_handler, executor_param, executor_block_strategy, executor_timeout,
  executor_fail_retry_count, glue_type, glue_source, glue_remark, glue_updatetime,
  child_jobid, trigger_status, trigger_last_time, trigger_next_time
)
SELECT @overall_group_id, 'CRM客户自动掉公海', NOW(), NOW(), 'zsj', '',
       'CRON', '0 0 1 * * ?', 'DO_NOTHING', 'FIRST',
       'customerAutoPutPoolJob', '', 'SERIAL_EXECUTION', 0,
       0, 'BEAN', '', 'GLUE代码初始化', NOW(),
       '', 1, 0, 0
FROM DUAL
WHERE NOT EXISTS (
  SELECT 1 FROM xxl_job_info
  WHERE job_group = @overall_group_id AND executor_handler = 'customerAutoPutPoolJob'
);

INSERT INTO xxl_job_info (
  job_group, job_desc, add_time, update_time, author, alarm_email,
  schedule_type, schedule_conf, misfire_strategy, executor_route_strategy,
  executor_handler, executor_param, executor_block_strategy, executor_timeout,
  executor_fail_retry_count, glue_type, glue_source, glue_remark, glue_updatetime,
  child_jobid, trigger_status, trigger_last_time, trigger_next_time
)
SELECT @overall_group_id, 'OA日程提醒', NOW(), NOW(), 'zsj', '',
       'CRON', '0 * * * * ?', 'DO_NOTHING', 'FIRST',
       'oaScheduleReminderJob', '', 'SERIAL_EXECUTION', 0,
       0, 'BEAN', '', 'GLUE代码初始化', NOW(),
       '', 1, 0, 0
FROM DUAL
WHERE NOT EXISTS (
  SELECT 1 FROM xxl_job_info
  WHERE job_group = @overall_group_id AND executor_handler = 'oaScheduleReminderJob'
);

INSERT INTO xxl_job_info (
  job_group, job_desc, add_time, update_time, author, alarm_email,
  schedule_type, schedule_conf, misfire_strategy, executor_route_strategy,
  executor_handler, executor_param, executor_block_strategy, executor_timeout,
  executor_fail_retry_count, glue_type, glue_source, glue_remark, glue_updatetime,
  child_jobid, trigger_status, trigger_last_time, trigger_next_time
)
SELECT @overall_group_id, 'OA会议室提醒与过期取消', NOW(), NOW(), 'zsj', '',
       'CRON', '0 * * * * ?', 'DO_NOTHING', 'FIRST',
       'oaMeetingRoomBookingReminderJob', '', 'SERIAL_EXECUTION', 0,
       0, 'BEAN', '', 'GLUE代码初始化', NOW(),
       '', 1, 0, 0
FROM DUAL
WHERE NOT EXISTS (
  SELECT 1 FROM xxl_job_info
  WHERE job_group = @overall_group_id AND executor_handler = 'oaMeetingRoomBookingReminderJob'
);

INSERT INTO xxl_job_info (
  job_group, job_desc, add_time, update_time, author, alarm_email,
  schedule_type, schedule_conf, misfire_strategy, executor_route_strategy,
  executor_handler, executor_param, executor_block_strategy, executor_timeout,
  executor_fail_retry_count, glue_type, glue_source, glue_remark, glue_updatetime,
  child_jobid, trigger_status, trigger_last_time, trigger_next_time
)
SELECT @overall_group_id, '清理过期OAuth2令牌', NOW(), NOW(), 'zsj', '',
       'CRON', '0 15 3 * * ?', 'DO_NOTHING', 'FIRST',
       'tokenCleanJob', '', 'SERIAL_EXECUTION', 0,
       0, 'BEAN', '', 'GLUE代码初始化', NOW(),
       '', 1, 0, 0
FROM DUAL
WHERE NOT EXISTS (
  SELECT 1 FROM xxl_job_info
  WHERE job_group = @overall_group_id AND executor_handler = 'tokenCleanJob'
);

INSERT INTO xxl_job_info (
  job_group, job_desc, add_time, update_time, author, alarm_email,
  schedule_type, schedule_conf, misfire_strategy, executor_route_strategy,
  executor_handler, executor_param, executor_block_strategy, executor_timeout,
  executor_fail_retry_count, glue_type, glue_source, glue_remark, glue_updatetime,
  child_jobid, trigger_status, trigger_last_time, trigger_next_time
)
SELECT @overall_group_id, '清理访问日志', NOW(), NOW(), 'zsj', '',
       'CRON', '0 30 3 * * ?', 'DO_NOTHING', 'FIRST',
       'accessLogCleanJob', '', 'SERIAL_EXECUTION', 0,
       0, 'BEAN', '', 'GLUE代码初始化', NOW(),
       '', 1, 0, 0
FROM DUAL
WHERE NOT EXISTS (
  SELECT 1 FROM xxl_job_info
  WHERE job_group = @overall_group_id AND executor_handler = 'accessLogCleanJob'
);

INSERT INTO xxl_job_info (
  job_group, job_desc, add_time, update_time, author, alarm_email,
  schedule_type, schedule_conf, misfire_strategy, executor_route_strategy,
  executor_handler, executor_param, executor_block_strategy, executor_timeout,
  executor_fail_retry_count, glue_type, glue_source, glue_remark, glue_updatetime,
  child_jobid, trigger_status, trigger_last_time, trigger_next_time
)
SELECT @overall_group_id, '清理错误日志', NOW(), NOW(), 'zsj', '',
       'CRON', '0 45 3 * * ?', 'DO_NOTHING', 'FIRST',
       'errorLogCleanJob', '', 'SERIAL_EXECUTION', 0,
       0, 'BEAN', '', 'GLUE代码初始化', NOW(),
       '', 1, 0, 0
FROM DUAL
WHERE NOT EXISTS (
  SELECT 1 FROM xxl_job_info
  WHERE job_group = @overall_group_id AND executor_handler = 'errorLogCleanJob'
);

-- 4) 确保 overall-admin 组内上述 handler 负责人均为 zsj、状态为运行
UPDATE xxl_job_info
SET author = 'zsj', trigger_status = 1, update_time = NOW()
WHERE job_group = @overall_group_id
  AND executor_handler IN (
    'crmEntityRemindJob',
    'customerAutoPutPoolJob',
    'oaScheduleReminderJob',
    'oaMeetingRoomBookingReminderJob',
    'tokenCleanJob',
    'accessLogCleanJob',
    'errorLogCleanJob'
  );

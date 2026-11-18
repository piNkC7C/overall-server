-- CRM 事件驱动站内信：跟进 / 公海 / 合同到期已提醒标记（幂等可重复执行）

-- 客户：下次跟进提醒 + 公海提醒
SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'crm_customer' AND COLUMN_NAME = 'contact_reminded');
SET @sql := IF(@col = 0,
  'ALTER TABLE `crm_customer` ADD COLUMN `contact_reminded` bit(1) NOT NULL DEFAULT b''0'' COMMENT ''下次跟进站内信是否已提醒'' AFTER `contact_next_time`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'crm_customer' AND COLUMN_NAME = 'pool_reminded');
SET @sql := IF(@col = 0,
  'ALTER TABLE `crm_customer` ADD COLUMN `pool_reminded` bit(1) NOT NULL DEFAULT b''0'' COMMENT ''公海站内信是否已提醒'' AFTER `owner_time`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- 线索：下次跟进提醒
SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'crm_clue' AND COLUMN_NAME = 'contact_reminded');
SET @sql := IF(@col = 0,
  'ALTER TABLE `crm_clue` ADD COLUMN `contact_reminded` bit(1) NOT NULL DEFAULT b''0'' COMMENT ''下次跟进站内信是否已提醒'' AFTER `contact_next_time`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- 商机：下次跟进提醒
SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'crm_business' AND COLUMN_NAME = 'contact_reminded');
SET @sql := IF(@col = 0,
  'ALTER TABLE `crm_business` ADD COLUMN `contact_reminded` bit(1) NOT NULL DEFAULT b''0'' COMMENT ''下次跟进站内信是否已提醒'' AFTER `contact_next_time`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- 合同：下次跟进提醒 + 到期提醒
SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'crm_contract' AND COLUMN_NAME = 'contact_reminded');
SET @sql := IF(@col = 0,
  'ALTER TABLE `crm_contract` ADD COLUMN `contact_reminded` bit(1) NOT NULL DEFAULT b''0'' COMMENT ''下次跟进站内信是否已提醒'' AFTER `contact_next_time`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

SET @col := (SELECT COUNT(*) FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'crm_contract' AND COLUMN_NAME = 'expiry_reminded');
SET @sql := IF(@col = 0,
  'ALTER TABLE `crm_contract` ADD COLUMN `expiry_reminded` bit(1) NOT NULL DEFAULT b''0'' COMMENT ''合同到期站内信是否已提醒'' AFTER `end_time`',
  'SELECT 1');
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- ========== 定时 ==========
-- 生产可开 XXL：执行器 appname=overall-admin（勿挂 yudao-server），种子见 xxl_job_overall_admin.sql（负责人 zsj）。
-- 关 XXL 时靠 CrmEntityRemindScheduler 等 @Scheduled 兜底（@ConditionalOnXxlJobDisabled）。
-- 另见 crm_notify_stop_daily_digest.sql

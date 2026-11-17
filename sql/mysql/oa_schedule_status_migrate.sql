-- 日程 process_status：bit(是否已处理) -> tinyint(0未执行/1执行中/2已结束/3已取消)
-- 幂等：可重复执行

SET @col_type := (
  SELECT DATA_TYPE FROM information_schema.COLUMNS
  WHERE TABLE_SCHEMA = DATABASE() AND TABLE_NAME = 'oa_schedule' AND COLUMN_NAME = 'process_status'
);
SET @sql := IF(
  @col_type = 'bit',
  'ALTER TABLE `oa_schedule` MODIFY COLUMN `process_status` tinyint NOT NULL DEFAULT 0 COMMENT ''日程状态：0未执行 1执行中 2已结束 3已取消''',
  'SELECT 1'
);
PREPARE stmt FROM @sql; EXECUTE stmt; DEALLOCATE PREPARE stmt;

-- 旧 true(已处理) -> 2已结束
UPDATE `oa_schedule` SET `process_status` = 2 WHERE `process_status` = 1;

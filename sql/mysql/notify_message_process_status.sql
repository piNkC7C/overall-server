-- 站内信增加「已办」状态（与已读分离：已读看详情自动；已办用户手动）
-- 若列已存在会报错，可忽略后继续

ALTER TABLE `system_notify_message`
  ADD COLUMN `process_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已办' AFTER `read_time`;

ALTER TABLE `system_notify_message`
  ADD COLUMN `process_time` datetime NULL DEFAULT NULL COMMENT '办理时间' AFTER `process_status`;

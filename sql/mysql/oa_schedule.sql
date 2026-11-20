-- [历史/源码参考] OA 日程表 — 产品「我的日程」已迁 BPM（见 bpm_schedule.sql）。
-- 勿在业务库 overall 再执行本文件灌产品数据；未启用 OA 模块时不应建这些表。
-- 幂等：可重复执行（仅作源码参考）

CREATE TABLE IF NOT EXISTS `oa_schedule` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '日程编号',
  `type` tinyint NOT NULL COMMENT '日程类型',
  `priority` tinyint NOT NULL COMMENT '优先级',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `remind` bit NOT NULL DEFAULT b'0' COMMENT '是否提醒',
  `remind_minutes` int NOT NULL DEFAULT 0 COMMENT '提醒提前分钟数，0=准时',
  `reminded` bit NOT NULL DEFAULT b'0' COMMENT '是否已提醒',
  `process_status` tinyint NOT NULL DEFAULT 0 COMMENT '日程状态：0未执行 1执行中 2已结束 3已取消',
  `process_time` datetime DEFAULT NULL COMMENT '状态变更时间',
  `creator` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='OA 日程';

CREATE TABLE IF NOT EXISTS `oa_schedule_participant` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `schedule_id` bigint NOT NULL COMMENT '日程编号',
  `user_id` bigint NOT NULL COMMENT '参与人用户编号',
  `read_status` bit NOT NULL DEFAULT b'0' COMMENT '是否已读',
  `read_time` datetime DEFAULT NULL COMMENT '阅读时间',
  `creator` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT '租户编号',
  PRIMARY KEY (`id`),
  KEY `idx_schedule_id_user_id` (`schedule_id`, `user_id`, `deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='OA 日程参与人';

-- 示例日程：多优先级色块 + remind 用于站内信
INSERT INTO `oa_schedule`
(`type`, `priority`, `title`, `description`, `start_time`, `end_time`, `remind`, `reminded`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT 1, 1, '团队周会', '示例：普通绿',
       CONCAT(CURDATE(), ' 10:00:00'), CONCAT(CURDATE(), ' 11:00:00'),
       b'0', b'0', '1', NOW(), '1', NOW(), b'0', 1
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM `oa_schedule` WHERE `title` = '团队周会' AND `creator` = '1' AND `deleted` = b'0' AND `tenant_id` = 1
);

INSERT INTO `oa_schedule`
(`type`, `priority`, `title`, `description`, `start_time`, `end_time`, `remind`, `reminded`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT 1, 2, '客户拜访', '示例：重要蓝',
       CONCAT(CURDATE(), ' 15:00:00'), CONCAT(CURDATE(), ' 16:00:00'),
       b'1', b'0', '1', NOW(), '1', NOW(), b'0', 1
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM `oa_schedule` WHERE `title` = '客户拜访' AND `creator` = '1' AND `deleted` = b'0' AND `tenant_id` = 1
);

INSERT INTO `oa_schedule`
(`type`, `priority`, `title`, `description`, `start_time`, `end_time`, `remind`, `reminded`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT 1, 3, '合同评审会', '示例：紧急橙，开启提醒',
       DATE_ADD(NOW(), INTERVAL 2 HOUR), DATE_ADD(NOW(), INTERVAL 3 HOUR),
       b'1', b'0', '1', NOW(), '1', NOW(), b'0', 1
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM `oa_schedule` WHERE `title` = '合同评审会' AND `creator` = '1' AND `deleted` = b'0' AND `tenant_id` = 1
);

INSERT INTO `oa_schedule`
(`type`, `priority`, `title`, `description`, `start_time`, `end_time`, `remind`, `reminded`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT 1, 4, '重要且紧急：报价截止', '示例：紫块',
       CONCAT(CURDATE(), ' 14:00:00'), CONCAT(CURDATE(), ' 14:30:00'),
       b'1', b'0', '1', NOW(), '1', NOW(), b'0', 1
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM `oa_schedule` WHERE `title` = '重要且紧急：报价截止' AND `creator` = '1' AND `deleted` = b'0' AND `tenant_id` = 1
);

INSERT INTO `oa_schedule`
(`type`, `priority`, `title`, `description`, `start_time`, `end_time`, `remind`, `reminded`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT 1, 2, '下午客户电话', '示例：重要蓝',
       CONCAT(CURDATE(), ' 16:30:00'), CONCAT(CURDATE(), ' 17:00:00'),
       b'1', b'0', '1', NOW(), '1', NOW(), b'0', 1
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM `oa_schedule` WHERE `title` = '下午客户电话' AND `creator` = '1' AND `deleted` = b'0' AND `tenant_id` = 1
);

INSERT INTO `oa_schedule`
(`type`, `priority`, `title`, `description`, `start_time`, `end_time`, `remind`, `reminded`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT 1, 2, '明日客户回访', '示例：明日 + 提醒窗口',
       CONCAT(DATE_ADD(CURDATE(), INTERVAL 1 DAY), ' 09:30:00'),
       CONCAT(DATE_ADD(CURDATE(), INTERVAL 1 DAY), ' 10:30:00'),
       b'1', b'0', '1', NOW(), '1', NOW(), b'0', 1
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM `oa_schedule` WHERE `title` = '明日客户回访' AND `creator` = '1' AND `deleted` = b'0' AND `tenant_id` = 1
);

INSERT INTO `oa_schedule`
(`type`, `priority`, `title`, `description`, `start_time`, `end_time`, `remind`, `reminded`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT 1, 1, '站内信联调提醒', '约 30 分钟后开始，Job 可推送站内信',
       DATE_ADD(NOW(), INTERVAL 30 MINUTE), DATE_ADD(NOW(), INTERVAL 90 MINUTE),
       b'1', b'0', '1', NOW(), '1', NOW(), b'0', 1
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM `oa_schedule` WHERE `title` = '站内信联调提醒' AND `creator` = '1' AND `deleted` = b'0' AND `tenant_id` = 1
);

-- 模板：跳转仅带 scheduleId
UPDATE `system_notify_template`
SET `params` = '["name","scheduleId"]',
    `route` = '/bpm/my-schedule?scheduleId={scheduleId}',
    `type` = 7, `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_schedule_reminder' AND `deleted` = b'0';

-- 站内信由真实业务生成，见 notify_message_real_seed.sql

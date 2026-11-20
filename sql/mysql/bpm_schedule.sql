-- BPM 我的日程：建表 + 从 oa_schedule 迁移 + 菜单/模板/XXL
-- 幂等：可重复执行

CREATE TABLE IF NOT EXISTS `bpm_schedule` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='BPM 我的日程';

-- 迁移：保留原 id，便于站内信 scheduleId 深链（oa_schedule 已 DROP 时可跳过）
SET @oa_schedule_exists := (
  SELECT COUNT(*) FROM information_schema.tables
  WHERE table_schema = DATABASE() AND table_name = 'oa_schedule'
);
SET @sql_migrate := IF(@oa_schedule_exists > 0,
  'INSERT INTO `bpm_schedule` (
     `id`, `type`, `priority`, `title`, `description`, `start_time`, `end_time`,
     `remind`, `remind_minutes`, `reminded`, `process_status`, `process_time`,
     `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`
   )
   SELECT
     `id`, `type`, `priority`, `title`, `description`, `start_time`, `end_time`,
     `remind`, IFNULL(`remind_minutes`, 0), `reminded`, IFNULL(`process_status`, 0), `process_time`,
     `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`
   FROM `oa_schedule`
   WHERE NOT EXISTS (SELECT 1 FROM `bpm_schedule` b WHERE b.id = `oa_schedule`.id)',
  'SELECT 1');
PREPARE stmt_migrate FROM @sql_migrate;
EXECUTE stmt_migrate;
DEALLOCATE PREPARE stmt_migrate;

-- 菜单：我的日程 + 按钮权限（挂在 5088 下）
UPDATE `system_menu` SET
  `name` = 'My Schedule',
  `permission` = 'bpm:schedule:query',
  `component` = 'bpm/schedule/calendar/index',
  `component_name` = 'BpmMySchedule',
  `parent_id` = 148,
  `path` = 'my-schedule',
  `icon` = 'ep:calendar',
  `visible` = b'1',
  `status` = 0,
  `updater` = '1',
  `update_time` = NOW()
WHERE `id` = 5088 AND `deleted` = b'0';

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 5089, 'Schedule Create', 'bpm:schedule:create', 3, 1, 5088, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_menu WHERE id = 5089 AND deleted = b'0');

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 5090, 'Schedule Update', 'bpm:schedule:update', 3, 2, 5088, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_menu WHERE id = 5090 AND deleted = b'0');

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT 5091, 'Schedule Delete', 'bpm:schedule:delete', 3, 3, 5088, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_menu WHERE id = 5091 AND deleted = b'0');

-- 已有「我的日程」的角色补上 create/update/delete
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT r.role_id, m.id, '1', NOW(), '1', NOW(), b'0', r.tenant_id
FROM (
  SELECT DISTINCT `role_id`, `tenant_id` FROM `system_role_menu`
  WHERE `menu_id` IN (5088, 8211, 8212, 8213, 8215, 8216) AND `deleted` = b'0'
) r
CROSS JOIN `system_menu` m
WHERE m.id IN (5088, 5089, 5090, 5091) AND m.deleted = b'0'
AND NOT EXISTS (
  SELECT 1 FROM `system_role_menu` x
  WHERE x.role_id = r.role_id AND x.menu_id = m.id AND x.deleted = b'0' AND x.tenant_id = r.tenant_id
);

-- 站内信模板：改挂 BPM code（保留旧 code 别名行也可；产品用新 code）
INSERT INTO `system_notify_template` (
  `name`, `code`, `nickname`, `content`, `route`, `type`, `params`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`
)
SELECT 'Schedule reminder', 'bpm_schedule_reminder', 'System',
       'Reminder: your schedule 「{name}」 is due soon.',
       '/bpm/my-schedule?scheduleId={scheduleId}',
       7, '["name","scheduleId"]', 0, 'My Schedule',
       '1', NOW(), '1', NOW(), b'0'
FROM DUAL WHERE NOT EXISTS (
  SELECT 1 FROM system_notify_template WHERE code = 'bpm_schedule_reminder' AND deleted = b'0'
);

-- 产品只用 BPM 模板；旧 OA code 停用（历史消息深链仍可识别）
UPDATE `system_notify_template`
SET `name` = 'Schedule reminder',
    `params` = '["name","scheduleId"]',
    `route` = '/bpm/my-schedule?scheduleId={scheduleId}',
    `type` = 7,
    `status` = 0,
    `updater` = '1',
    `update_time` = NOW()
WHERE `code` = 'bpm_schedule_reminder' AND `deleted` = b'0';

UPDATE `system_notify_template`
SET `status` = 1, `updater` = '1', `update_time` = NOW()
WHERE `code` = 'oa_schedule_reminder' AND `deleted` = b'0';

-- 产品字典（不删源码 oa_priority / oa_schedule_type）
INSERT INTO `system_dict_type` (`name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`)
SELECT 'Schedule Priority', 'bpm_schedule_priority', 0, 'My Schedule (BPM)', '1', NOW(), '1', NOW(), b'0', NULL
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_type WHERE type = 'bpm_schedule_priority' AND deleted = b'0');

INSERT INTO `system_dict_type` (`name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`)
SELECT 'Schedule Type', 'bpm_schedule_type', 0, 'My Schedule (BPM)', '1', NOW(), '1', NOW(), b'0', NULL
FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM system_dict_type WHERE type = 'bpm_schedule_type' AND deleted = b'0');

INSERT INTO `system_dict_data` (`sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT d.sort, d.label, d.value, 'bpm_schedule_priority', d.status, d.color_type, d.css_class, d.remark, '1', NOW(), '1', NOW(), b'0'
FROM system_dict_data d
WHERE d.dict_type = 'oa_priority' AND d.deleted = b'0'
  AND NOT EXISTS (
    SELECT 1 FROM system_dict_data x
    WHERE x.dict_type = 'bpm_schedule_priority' AND x.value = d.value AND x.deleted = b'0'
  );

INSERT INTO `system_dict_data` (`sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
SELECT d.sort, d.label, d.value, 'bpm_schedule_type', d.status, d.color_type, d.css_class, d.remark, '1', NOW(), '1', NOW(), b'0'
FROM system_dict_data d
WHERE d.dict_type = 'oa_schedule_type' AND d.deleted = b'0'
  AND NOT EXISTS (
    SELECT 1 FROM system_dict_data x
    WHERE x.dict_type = 'bpm_schedule_type' AND x.value = d.value AND x.deleted = b'0'
  );

-- 仅软删「OA 日程」子树；禁止动 8200 Office 根（否则子菜单会顶到顶层）
UPDATE `system_menu`
SET `deleted` = b'1', `status` = 1, `visible` = b'0', `updater` = '1', `update_time` = NOW()
WHERE `id` IN (8210, 8211, 8212, 8213, 8215, 8216) AND `deleted` = b'0';

-- Office 根保持存在（可禁用），供菜单树挂载其它 OA 源码菜单；模块未接线时侧栏靠 status/角色控制
UPDATE `system_menu`
SET `deleted` = b'0', `status` = 1, `visible` = b'1', `updater` = '1', `update_time` = NOW()
WHERE `id` = 8200;

-- ========== 卸掉未启用 OA：删除业务库 oa_* 表（迁移完成后再执行）==========
DROP TABLE IF EXISTS `oa_schedule_participant`;
DROP TABLE IF EXISTS `oa_schedule`;

-- CRM 枚举配置菜单（跟进类型 / 线索来源）
SET NAMES utf8mb4;

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
VALUES (12950, 'Enums', '', 2, 6, 564, 'dict-config', 'ep:collection', 'crm/config/dict/index', 'CrmDictConfig', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0')
ON DUPLICATE KEY UPDATE
  `name` = VALUES(`name`),
  `path` = VALUES(`path`),
  `component` = VALUES(`component`),
  `component_name` = VALUES(`component_name`),
  `parent_id` = VALUES(`parent_id`),
  `updater` = VALUES(`updater`),
  `update_time` = VALUES(`update_time`);

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
VALUES
(12951, 'Enum Query', 'crm:dict-config:query', 3, 1, 12950, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'),
(12952, 'Enum Create', 'crm:dict-config:create', 3, 2, 12950, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'),
(12953, 'Enum Update', 'crm:dict-config:update', 3, 3, 12950, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'),
(12954, 'Enum Delete', 'crm:dict-config:delete', 3, 4, 12950, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0')
ON DUPLICATE KEY UPDATE
  `permission` = VALUES(`permission`),
  `parent_id` = VALUES(`parent_id`),
  `updater` = VALUES(`updater`),
  `update_time` = VALUES(`update_time`);

-- 授权给已有 CRM 配置权限的角色
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT r.role_id, m.menu_id, '1', NOW(), '1', NOW(), b'0', 1
FROM (
  SELECT 2 AS role_id UNION ALL SELECT 169
) r
CROSS JOIN (
  SELECT 12950 AS menu_id UNION ALL SELECT 12951 UNION ALL SELECT 12952 UNION ALL SELECT 12953 UNION ALL SELECT 12954
) m
WHERE NOT EXISTS (
  SELECT 1 FROM `system_role_menu` srm
  WHERE srm.role_id = r.role_id AND srm.menu_id = m.menu_id AND srm.deleted = b'0' AND srm.tenant_id = 1
);

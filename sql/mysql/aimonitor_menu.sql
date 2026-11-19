-- AI Monitoring button permissions (runtime system_menu). Parent menu id 12940 already exists.
SET NAMES utf8mb4;

INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`)
VALUES
(12960, 'AI Monitoring Query', 'aimonitor:project:query', 3, 1, 12940, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'),
(12961, 'AI Monitoring Create', 'aimonitor:project:create', 3, 2, 12940, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'),
(12962, 'AI Monitoring Update', 'aimonitor:project:update', 3, 3, 12940, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0'),
(12963, 'AI Monitoring Delete', 'aimonitor:project:delete', 3, 4, 12940, '', '', '', '', 0, b'1', b'1', b'1', '1', NOW(), '1', NOW(), b'0')
ON DUPLICATE KEY UPDATE
  `name` = VALUES(`name`),
  `permission` = VALUES(`permission`),
  `parent_id` = VALUES(`parent_id`),
  `updater` = VALUES(`updater`),
  `update_time` = VALUES(`update_time`);

-- Grant to roles that already have AI Monitoring (12940)
INSERT INTO `system_role_menu` (`role_id`, `menu_id`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`)
SELECT srm.role_id, m.menu_id, '1', NOW(), '1', NOW(), b'0', srm.tenant_id
FROM `system_role_menu` srm
CROSS JOIN (
  SELECT 12960 AS menu_id UNION ALL SELECT 12961 UNION ALL SELECT 12962 UNION ALL SELECT 12963
) m
WHERE srm.menu_id = 12940 AND srm.deleted = b'0'
  AND NOT EXISTS (
    SELECT 1 FROM `system_role_menu` x
    WHERE x.role_id = srm.role_id AND x.menu_id = m.menu_id AND x.deleted = b'0' AND x.tenant_id = srm.tenant_id
  );

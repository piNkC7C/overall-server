-- CRM tables generated from yudao-module-crm data objects.
-- Tenant rows are required because multi-tenant SQL injection is on for every table.

-- ----------------------------
-- Table structure for crm_clue
-- ----------------------------
DROP TABLE IF EXISTS `crm_clue`;
CREATE TABLE `crm_clue`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Lead name',
  `follow_up_status` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Follow-up status',
  `contact_last_time` datetime NULL DEFAULT NULL COMMENT 'Last contact time',
  `contact_last_content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Last contact notes',
  `contact_next_time` datetime NULL DEFAULT NULL COMMENT 'Next contact time',
  `owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner user ID',
  `transform_status` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Converted to a customer',
  `customer_id` bigint NULL DEFAULT NULL COMMENT 'Customer ID',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Mobile number',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Phone',
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'WeChat',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Email',
  `area_id` int NULL DEFAULT NULL COMMENT 'Area ID',
  `detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Street address',
  `industry_id` int NULL DEFAULT NULL COMMENT 'Industry',
  `level` int NULL DEFAULT NULL COMMENT 'Customer level',
  `source` int NULL DEFAULT NULL COMMENT 'Lead source',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_owner_user_id`(`owner_user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM lead';

-- ----------------------------
-- Table structure for crm_customer
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer`;
CREATE TABLE `crm_customer`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Customer name',
  `follow_up_status` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Follow-up status',
  `contact_last_time` datetime NULL DEFAULT NULL COMMENT 'Last contact time',
  `contact_last_content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Last contact notes',
  `contact_next_time` datetime NULL DEFAULT NULL COMMENT 'Next contact time',
  `owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner user ID',
  `owner_time` datetime NULL DEFAULT NULL COMMENT 'Owner assigned time',
  `lock_status` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Locked',
  `deal_status` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Won',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Mobile number',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Phone',
  `qq` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'WeChat',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Email',
  `area_id` int NULL DEFAULT NULL COMMENT 'Area ID',
  `detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Street address',
  `industry_id` int NULL DEFAULT NULL COMMENT 'Industry',
  `level` int NULL DEFAULT NULL COMMENT 'Customer level',
  `source` int NULL DEFAULT NULL COMMENT 'Customer source',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_owner_user_id`(`owner_user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM customer';

-- ----------------------------
-- Table structure for crm_customer_limit_config
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer_limit_config`;
CREATE TABLE `crm_customer_limit_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` int NOT NULL COMMENT 'Rule type',
  `user_ids` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'User IDs',
  `dept_ids` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Department IDs',
  `max_count` int NOT NULL COMMENT 'Ownership cap',
  `deal_count_enabled` bit(1) NULL DEFAULT NULL COMMENT 'Won customers count toward the cap',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM customer ownership limit';

-- ----------------------------
-- Table structure for crm_customer_pool_config
-- ----------------------------
DROP TABLE IF EXISTS `crm_customer_pool_config`;
CREATE TABLE `crm_customer_pool_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `enabled` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Public pool enabled',
  `contact_expire_days` int NULL DEFAULT NULL COMMENT 'Days without contact before release',
  `deal_expire_days` int NULL DEFAULT NULL COMMENT 'Days without a win before release',
  `notify_enabled` bit(1) NULL DEFAULT NULL COMMENT 'Release reminder enabled',
  `notify_days` int NULL DEFAULT NULL COMMENT 'Days before release to remind',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM public pool settings';

-- ----------------------------
-- Table structure for crm_contact
-- ----------------------------
DROP TABLE IF EXISTS `crm_contact`;
CREATE TABLE `crm_contact`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Contact name',
  `customer_id` bigint NOT NULL COMMENT 'Customer ID',
  `contact_last_time` datetime NULL DEFAULT NULL COMMENT 'Last contact time',
  `contact_last_content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Last contact notes',
  `contact_next_time` datetime NULL DEFAULT NULL COMMENT 'Next contact time',
  `owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner user ID',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Mobile number',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Phone',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Email',
  `qq` bigint NULL DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'WeChat',
  `area_id` int NULL DEFAULT NULL COMMENT 'Area ID',
  `detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Street address',
  `sex` int NULL DEFAULT NULL COMMENT 'Gender',
  `master` bit(1) NULL DEFAULT b'0' COMMENT 'Primary decision maker',
  `post` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Job title',
  `parent_id` bigint NULL DEFAULT NULL COMMENT 'Manager contact ID',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_customer_id`(`customer_id` ASC) USING BTREE,
  INDEX `idx_owner_user_id`(`owner_user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM contact';

-- ----------------------------
-- Table structure for crm_contact_business
-- ----------------------------
DROP TABLE IF EXISTS `crm_contact_business`;
CREATE TABLE `crm_contact_business`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `contact_id` bigint NOT NULL COMMENT 'Contact ID',
  `business_id` bigint NOT NULL COMMENT 'Opportunity ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_contact_id`(`contact_id` ASC) USING BTREE,
  INDEX `idx_business_id`(`business_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM contact opportunity link';

-- ----------------------------
-- Table structure for crm_business_status_type
-- ----------------------------
DROP TABLE IF EXISTS `crm_business_status_type`;
CREATE TABLE `crm_business_status_type`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Pipeline name',
  `dept_ids` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Department IDs',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM opportunity pipeline';

-- ----------------------------
-- Table structure for crm_business_status
-- ----------------------------
DROP TABLE IF EXISTS `crm_business_status`;
CREATE TABLE `crm_business_status`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type_id` bigint NOT NULL COMMENT 'Pipeline ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Stage name',
  `percent` int NOT NULL COMMENT 'Win probability',
  `sort` int NOT NULL DEFAULT 0 COMMENT 'Sort',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_type_id`(`type_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM opportunity stage';

-- ----------------------------
-- Table structure for crm_business
-- ----------------------------
DROP TABLE IF EXISTS `crm_business`;
CREATE TABLE `crm_business`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Opportunity name',
  `customer_id` bigint NOT NULL COMMENT 'Customer ID',
  `follow_up_status` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Follow-up status',
  `contact_last_time` datetime NULL DEFAULT NULL COMMENT 'Last contact time',
  `contact_next_time` datetime NULL DEFAULT NULL COMMENT 'Next contact time',
  `owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner user ID',
  `status_type_id` bigint NULL DEFAULT NULL COMMENT 'Pipeline ID',
  `status_id` bigint NULL DEFAULT NULL COMMENT 'Stage ID',
  `end_status` int NULL DEFAULT NULL COMMENT 'Closed status',
  `end_remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Close notes',
  `deal_time` datetime NULL DEFAULT NULL COMMENT 'Expected close date',
  `total_product_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'Product total',
  `discount_percent` decimal(24, 6) NULL DEFAULT NULL COMMENT 'Discount percent',
  `total_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'Amount',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_customer_id`(`customer_id` ASC) USING BTREE,
  INDEX `idx_owner_user_id`(`owner_user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM opportunity';

-- ----------------------------
-- Table structure for crm_business_product
-- ----------------------------
DROP TABLE IF EXISTS `crm_business_product`;
CREATE TABLE `crm_business_product`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `business_id` bigint NOT NULL COMMENT 'Opportunity ID',
  `product_id` bigint NOT NULL COMMENT 'Product ID',
  `product_price` decimal(24, 6) NOT NULL COMMENT 'List price',
  `business_price` decimal(24, 6) NOT NULL COMMENT 'Selling price',
  `count` decimal(24, 6) NOT NULL COMMENT 'Quantity',
  `total_price` decimal(24, 6) NOT NULL COMMENT 'Line total',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_business_id`(`business_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM opportunity product';

-- ----------------------------
-- Table structure for crm_contract_config
-- ----------------------------
DROP TABLE IF EXISTS `crm_contract_config`;
CREATE TABLE `crm_contract_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `notify_enabled` bit(1) NULL DEFAULT NULL COMMENT 'Expiration reminder enabled',
  `notify_days` int NULL DEFAULT NULL COMMENT 'Days before expiration to remind',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM contract settings';

-- ----------------------------
-- Table structure for crm_contract
-- ----------------------------
DROP TABLE IF EXISTS `crm_contract`;
CREATE TABLE `crm_contract`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Contract name',
  `no` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Contract number',
  `customer_id` bigint NOT NULL COMMENT 'Customer ID',
  `business_id` bigint NULL DEFAULT NULL COMMENT 'Opportunity ID',
  `contact_last_time` datetime NULL DEFAULT NULL COMMENT 'Last contact time',
  `owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner user ID',
  `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Workflow instance ID',
  `audit_status` int NOT NULL DEFAULT 0 COMMENT 'Approval status',
  `order_date` datetime NULL DEFAULT NULL COMMENT 'Order date',
  `start_time` datetime NULL DEFAULT NULL COMMENT 'Start date',
  `end_time` datetime NULL DEFAULT NULL COMMENT 'End date',
  `total_product_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'Product total',
  `discount_percent` decimal(24, 6) NULL DEFAULT NULL COMMENT 'Discount percent',
  `total_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'Contract amount',
  `sign_contact_id` bigint NULL DEFAULT NULL COMMENT 'Customer signer contact ID',
  `sign_user_id` bigint NULL DEFAULT NULL COMMENT 'Company signer user ID',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_no`(`no` ASC) USING BTREE,
  INDEX `idx_customer_id`(`customer_id` ASC) USING BTREE,
  INDEX `idx_owner_user_id`(`owner_user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM contract';

-- ----------------------------
-- Table structure for crm_contract_product
-- ----------------------------
DROP TABLE IF EXISTS `crm_contract_product`;
CREATE TABLE `crm_contract_product`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `contract_id` bigint NOT NULL COMMENT 'Contract ID',
  `product_id` bigint NOT NULL COMMENT 'Product ID',
  `product_price` decimal(24, 6) NOT NULL COMMENT 'List price',
  `contract_price` decimal(24, 6) NOT NULL COMMENT 'Contract price',
  `count` decimal(24, 6) NOT NULL COMMENT 'Quantity',
  `total_price` decimal(24, 6) NOT NULL COMMENT 'Line total',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_contract_id`(`contract_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM contract product';

-- ----------------------------
-- Table structure for crm_receivable_plan
-- ----------------------------
DROP TABLE IF EXISTS `crm_receivable_plan`;
CREATE TABLE `crm_receivable_plan`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `period` int NOT NULL COMMENT 'Installment number',
  `customer_id` bigint NOT NULL COMMENT 'Customer ID',
  `contract_id` bigint NOT NULL COMMENT 'Contract ID',
  `owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner user ID',
  `return_time` datetime NULL DEFAULT NULL COMMENT 'Planned collection date',
  `return_type` int NULL DEFAULT NULL COMMENT 'Collection method',
  `price` decimal(24, 6) NOT NULL COMMENT 'Planned amount',
  `receivable_id` bigint NULL DEFAULT NULL COMMENT 'Payment ID',
  `remind_days` int NULL DEFAULT NULL COMMENT 'Reminder lead days',
  `remind_time` datetime NULL DEFAULT NULL COMMENT 'Reminder time',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_contract_id`(`contract_id` ASC) USING BTREE,
  INDEX `idx_customer_id`(`customer_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM payment plan';

-- ----------------------------
-- Table structure for crm_receivable
-- ----------------------------
DROP TABLE IF EXISTS `crm_receivable`;
CREATE TABLE `crm_receivable`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `no` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Payment number',
  `plan_id` bigint NULL DEFAULT NULL COMMENT 'Payment plan ID',
  `customer_id` bigint NOT NULL COMMENT 'Customer ID',
  `contract_id` bigint NOT NULL COMMENT 'Contract ID',
  `owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner user ID',
  `return_time` datetime NULL DEFAULT NULL COMMENT 'Collection date',
  `return_type` int NULL DEFAULT NULL COMMENT 'Collection method',
  `price` decimal(24, 6) NOT NULL COMMENT 'Amount',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Workflow instance ID',
  `audit_status` int NOT NULL DEFAULT 0 COMMENT 'Approval status',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_no`(`no` ASC) USING BTREE,
  INDEX `idx_contract_id`(`contract_id` ASC) USING BTREE,
  INDEX `idx_customer_id`(`customer_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM payment';

-- ----------------------------
-- Table structure for crm_product_category
-- ----------------------------
DROP TABLE IF EXISTS `crm_product_category`;
CREATE TABLE `crm_product_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Category name',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT 'Parent category ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM product category';

-- ----------------------------
-- Table structure for crm_product
-- ----------------------------
DROP TABLE IF EXISTS `crm_product`;
CREATE TABLE `crm_product`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Product name',
  `no` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Product code',
  `unit` int NOT NULL DEFAULT 0 COMMENT 'Unit',
  `price` decimal(24, 6) NULL DEFAULT 0 COMMENT 'Price',
  `status` int NOT NULL COMMENT 'Status',
  `category_id` bigint NOT NULL COMMENT 'Category ID',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Description',
  `owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner user ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_no`(`no` ASC) USING BTREE,
  INDEX `idx_category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM product';

-- ----------------------------
-- Table structure for crm_permission
-- ----------------------------
DROP TABLE IF EXISTS `crm_permission`;
CREATE TABLE `crm_permission`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `biz_type` int NOT NULL COMMENT 'Record type',
  `biz_id` bigint NOT NULL COMMENT 'Record ID',
  `user_id` bigint NOT NULL COMMENT 'User ID',
  `level` int NOT NULL COMMENT 'Access level',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_biz`(`biz_type` ASC, `biz_id` ASC) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM record access';

-- ----------------------------
-- Table structure for crm_owner_record
-- ----------------------------
DROP TABLE IF EXISTS `crm_owner_record`;
CREATE TABLE `crm_owner_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `biz_type` int NOT NULL COMMENT 'Record type',
  `biz_id` bigint NOT NULL COMMENT 'Record ID',
  `pre_owner_user_id` bigint NULL DEFAULT NULL COMMENT 'Previous owner user ID',
  `post_owner_user_id` bigint NULL DEFAULT NULL COMMENT 'New owner user ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_biz`(`biz_type` ASC, `biz_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM owner change';

-- ----------------------------
-- Table structure for crm_follow_up_record
-- ----------------------------
DROP TABLE IF EXISTS `crm_follow_up_record`;
CREATE TABLE `crm_follow_up_record`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `biz_type` int NOT NULL COMMENT 'Record type',
  `biz_id` bigint NOT NULL COMMENT 'Record ID',
  `type` int NULL DEFAULT NULL COMMENT 'Follow-up method',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'Notes',
  `next_time` datetime NULL DEFAULT NULL COMMENT 'Next contact time',
  `pic_urls` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Image URLs',
  `file_urls` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'File URLs',
  `business_ids` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Opportunity IDs',
  `contact_ids` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Contact IDs',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_biz`(`biz_type` ASC, `biz_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM follow-up';

-- ----------------------------
-- Table structure for crm_performance_config
-- ----------------------------
DROP TABLE IF EXISTS `crm_performance_config`;
CREATE TABLE `crm_performance_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `biz_type` int NOT NULL COMMENT 'Target type',
  `object_id` bigint NOT NULL COMMENT 'Target object ID',
  `object_type` int NOT NULL COMMENT 'Target object type',
  `year` int NOT NULL COMMENT 'Year',
  `year_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'Year target',
  `january_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'January target',
  `february_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'February target',
  `march_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'March target',
  `april_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'April target',
  `may_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'May target',
  `june_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'June target',
  `july_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'July target',
  `august_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'August target',
  `september_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'September target',
  `october_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'October target',
  `november_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'November target',
  `december_target_price` decimal(24, 6) NULL DEFAULT NULL COMMENT 'December target',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_object_year`(`biz_type` ASC, `object_type` ASC, `object_id` ASC, `year` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'CRM sales target';

/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1 MySQL
 Source Server Type    : MySQL
 Source Server Version : 80200 (8.2.0)
 Source Host           : 127.0.0.1:3306
 Source Schema         : overall

 Target Server Type    : MySQL
 Target Server Version : 80200 (8.2.0)
 File Encoding         : 65001

 Date: 27/09/2026 00:04:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for infra_api_access_log
-- ----------------------------
DROP TABLE IF EXISTS `infra_api_access_log`;
CREATE TABLE `infra_api_access_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Log ID',
  `trace_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Trace ID',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT 'User ID',
  `user_type` tinyint NOT NULL DEFAULT 0 COMMENT 'User type',
  `application_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'App name',
  `request_method` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Request method',
  `request_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Request URL',
  `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'Request params',
  `response_body` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'Response body',
  `user_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'User IP',
  `user_agent` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'User agent',
  `operate_module` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Module',
  `operate_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Action name',
  `operate_type` tinyint NULL DEFAULT 0 COMMENT 'Action type',
  `begin_time` datetime NOT NULL COMMENT 'Request start time',
  `end_time` datetime NOT NULL COMMENT 'Request end time',
  `duration` int NOT NULL COMMENT 'Duration',
  `result_code` int NOT NULL DEFAULT 0 COMMENT 'Result code',
  `result_msg` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Result message',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41072 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'API access log';

-- ----------------------------
-- Records of infra_api_access_log
-- ----------------------------

-- ----------------------------
-- Table structure for infra_api_error_log
-- ----------------------------
DROP TABLE IF EXISTS `infra_api_error_log`;
CREATE TABLE `infra_api_error_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `trace_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Trace ID',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT 'User ID',
  `user_type` tinyint NOT NULL DEFAULT 0 COMMENT 'User type',
  `application_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'App name',
  `request_method` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Request method',
  `request_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Request URL',
  `request_params` varchar(8000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Request params',
  `user_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'User IP',
  `user_agent` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'User agent',
  `exception_time` datetime NOT NULL COMMENT 'Exception time',
  `exception_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Exception name',
  `exception_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Exception message',
  `exception_root_cause_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Root cause message',
  `exception_stack_trace` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Exception stack trace',
  `exception_class_name` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Exception class name',
  `exception_file_name` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Exception class file',
  `exception_method_name` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Exception method',
  `exception_line_number` int NOT NULL COMMENT 'Exception line number',
  `process_status` tinyint NOT NULL COMMENT 'Process status',
  `process_time` datetime NULL DEFAULT NULL COMMENT 'Process time',
  `process_user_id` int NULL DEFAULT 0 COMMENT 'Process user ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26630 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'API error log';

-- ----------------------------
-- Records of infra_api_error_log
-- ----------------------------

-- ----------------------------
-- Table structure for infra_codegen_column
-- ----------------------------
DROP TABLE IF EXISTS `infra_codegen_column`;
CREATE TABLE `infra_codegen_column`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `table_id` bigint NOT NULL COMMENT 'Table ID',
  `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Field name',
  `data_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Field type',
  `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'FieldDescription',
  `nullable` bit(1) NOT NULL COMMENT 'Is not allow is empty',
  `primary_key` bit(1) NOT NULL COMMENT 'Is not primary key',
  `ordinal_position` int NOT NULL COMMENT 'Sort',
  `java_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Java attribute type',
  `java_field` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Java field name',
  `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Dictionary type',
  `example` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Data sample',
  `create_operation` bit(1) NOT NULL COMMENT 'Is not is Create createaction field',
  `update_operation` bit(1) NOT NULL COMMENT 'Is not is Update updateaction field',
  `list_operation` bit(1) NOT NULL COMMENT 'Is not is List searchaction field',
  `list_operation_condition` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '=' COMMENT 'List searchaction condition type',
  `list_operation_result` bit(1) NOT NULL COMMENT 'Returned by list query',
  `html_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Show type',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_table_id`(`table_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2880 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Codegen table column';

-- ----------------------------
-- Records of infra_codegen_column
-- ----------------------------

-- ----------------------------
-- Table structure for infra_codegen_table
-- ----------------------------
DROP TABLE IF EXISTS `infra_codegen_table`;
CREATE TABLE `infra_codegen_table`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `data_source_config_id` bigint NOT NULL COMMENT 'Data sourcesetting code',
  `scene` tinyint NOT NULL DEFAULT 1 COMMENT 'Generate scene',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Table name',
  `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Table comment',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `module_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Module name',
  `business_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Business name',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Class name',
  `class_comment` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Class Description',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Author',
  `template_type` tinyint NOT NULL DEFAULT 1 COMMENT 'Template type',
  `front_type` tinyint NOT NULL COMMENT 'Frontend type',
  `parent_menu_id` bigint NULL DEFAULT NULL COMMENT 'Parent menu code',
  `master_table_id` bigint NULL DEFAULT NULL COMMENT 'Master table ID',
  `sub_join_column_id` bigint NULL DEFAULT NULL COMMENT 'Join column ID',
  `sub_join_many` bit(1) NULL DEFAULT NULL COMMENT 'One-to-many with master',
  `tree_parent_column_id` bigint NULL DEFAULT NULL COMMENT 'Tree parent column ID',
  `tree_name_column_id` bigint NULL DEFAULT NULL COMMENT 'Tree name column ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 210 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Codegen table';

-- ----------------------------
-- Records of infra_codegen_table
-- ----------------------------

-- ----------------------------
-- Table structure for infra_config
-- ----------------------------
DROP TABLE IF EXISTS `infra_config`;
CREATE TABLE `infra_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Parameter primary key',
  `category` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Parameter group',
  `type` tinyint NOT NULL COMMENT 'Parameter type',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Parameter name',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Config key',
  `value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Config value',
  `visible` bit(1) NOT NULL COMMENT 'Visible',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_config_key`(`config_key` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Config';

-- ----------------------------
-- Records of infra_config
-- ----------------------------
BEGIN;
INSERT INTO `infra_config` (`id`, `category`, `type`, `name`, `config_key`, `value`, `visible`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2, 'biz', 1, 'Initial user password', 'system.user.init-password', '123456', b'0', 'Password assigned to newly created users', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0');
INSERT INTO `infra_config` (`id`, `category`, `type`, `name`, `config_key`, `value`, `visible`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (7, 'url', 2, 'MySQL monitor URL', 'url.druid', '', b'1', '', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0');
INSERT INTO `infra_config` (`id`, `category`, `type`, `name`, `config_key`, `value`, `visible`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (8, 'url', 2, 'SkyWalking URL', 'url.skywalking', '', b'1', '', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0');
INSERT INTO `infra_config` (`id`, `category`, `type`, `name`, `config_key`, `value`, `visible`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (9, 'url', 2, 'Spring Boot Admin URL', 'url.spring-boot-admin', '', b'1', '', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0');
INSERT INTO `infra_config` (`id`, `category`, `type`, `name`, `config_key`, `value`, `visible`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (10, 'url', 2, 'API docs URL', 'url.swagger', '', b'1', '', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0');
INSERT INTO `infra_config` (`id`, `category`, `type`, `name`, `config_key`, `value`, `visible`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (13, 'biz', 2, 'Allow self-registration', 'system.user.register-enabled', 'true', b'0', 'Turn off to disable public account creation', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0');
COMMIT;

-- ----------------------------
-- Table structure for infra_data_source_config
-- ----------------------------
DROP TABLE IF EXISTS `infra_data_source_config`;
CREATE TABLE `infra_data_source_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key code',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Parameter name',
  `url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Data source connect',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Username',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Password',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Data source';

-- ----------------------------
-- Records of infra_data_source_config
-- ----------------------------

-- ----------------------------
-- Table structure for infra_file
-- ----------------------------
DROP TABLE IF EXISTS `infra_file`;
CREATE TABLE `infra_file`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'File code',
  `config_id` bigint NULL DEFAULT NULL COMMENT 'Setting code',
  `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'File name',
  `path` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'File path',
  `url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'File URL',
  `type` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'File type',
  `size` int NOT NULL COMMENT 'File size',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2330 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'File';

-- ----------------------------
-- Records of infra_file
-- ----------------------------

-- ----------------------------
-- Table structure for infra_file_config
-- ----------------------------
DROP TABLE IF EXISTS `infra_file_config`;
CREATE TABLE `infra_file_config`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Config name',
  `storage` tinyint NOT NULL COMMENT 'Storage',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `master` bit(1) NOT NULL COMMENT 'Primary config',
  `config` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Storage setting',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'File config';

-- ----------------------------
-- Records of infra_file_config
-- ----------------------------
BEGIN;
INSERT INTO `infra_file_config` (`id`, `name`, `storage`, `remark`, `master`, `config`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (4, 'Database', 1, 'Local database storage', b'1', '{\"@class\":\"cn.iocoder.yudao.module.infra.framework.file.core.client.db.DBFileClientConfig\",\"domain\":\"http://127.0.0.1:48080\"}', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0');
COMMIT;

-- ----------------------------
-- Table structure for infra_file_content
-- ----------------------------
DROP TABLE IF EXISTS `infra_file_content`;
CREATE TABLE `infra_file_content`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `config_id` bigint NOT NULL COMMENT 'Setting code',
  `path` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'File path',
  `content` mediumblob NOT NULL COMMENT 'File content',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_config_id_path`(`config_id` ASC, `path` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 303 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'File';

-- ----------------------------
-- Records of infra_file_content
-- ----------------------------

-- ----------------------------
-- Table structure for infra_job
-- ----------------------------
DROP TABLE IF EXISTS `infra_job`;
CREATE TABLE `infra_job`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Task code',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Task name',
  `status` tinyint NOT NULL COMMENT 'Task status',
  `handler_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Handler name',
  `handler_param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Handler params',
  `cron_expression` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'CRON expression',
  `retry_count` int NOT NULL DEFAULT 0 COMMENT 'Retry count',
  `retry_interval` int NOT NULL DEFAULT 0 COMMENT 'Retry gap',
  `monitor_timeout` int NOT NULL DEFAULT 0 COMMENT 'Monitor timeout',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12914 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Scheduled job';

-- ----------------------------
-- Records of infra_job
-- ----------------------------

-- ----------------------------
-- Table structure for infra_job_log
-- ----------------------------
DROP TABLE IF EXISTS `infra_job_log`;
CREATE TABLE `infra_job_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Log ID',
  `job_id` bigint NOT NULL COMMENT 'Task code',
  `handler_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Handler name',
  `handler_param` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Handler params',
  `execute_index` tinyint NOT NULL DEFAULT 1 COMMENT 'Execution index',
  `begin_time` datetime NOT NULL COMMENT 'Start execute time',
  `end_time` datetime NULL DEFAULT NULL COMMENT 'End execute time',
  `duration` int NULL DEFAULT NULL COMMENT 'Duration',
  `status` tinyint NOT NULL COMMENT 'Task status',
  `result` varchar(4000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Result data',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_job_id`(`job_id` ASC) USING BTREE,
  INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44955 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Scheduled job log';

-- ----------------------------
-- Records of infra_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for system_dept
-- ----------------------------
DROP TABLE IF EXISTS `system_dept`;
CREATE TABLE `system_dept`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Departmentid',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Department name',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT 'Parent departmentid',
  `sort` int NOT NULL DEFAULT 0 COMMENT 'Sort',
  `leader_user_id` bigint NULL DEFAULT NULL COMMENT 'Owner person',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Phone',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Email',
  `status` tinyint NOT NULL COMMENT 'Department status (0Normal 1 disable )',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 122 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Department';

-- ----------------------------
-- Records of system_dept
-- ----------------------------
BEGIN;
INSERT INTO `system_dept` (`id`, `name`, `parent_id`, `sort`, `leader_user_id`, `phone`, `email`, `status`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`) VALUES (100, 'Overall', 0, 0, 1, '', '', 0, 'admin', '2021-01-05 17:03:47', 'admin', '2021-01-05 17:03:47', b'0', 1);
COMMIT;

-- ----------------------------
-- Table structure for system_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `system_dict_data`;
CREATE TABLE `system_dict_data`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Dictionary code',
  `sort` int NOT NULL DEFAULT 0 COMMENT 'Dictionary sort',
  `label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Dictionarytag',
  `value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Dict value',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Dictionary type',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT 'Status (0Normal 1 disable )',
  `color_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Color type',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'CSS class',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1834 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Dict data';

-- ----------------------------
-- Records of system_dict_data
-- ----------------------------
BEGIN;
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1, 1, 'Male', '1', 'system_user_sex', 0, 'primary', 'A', 'Male', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2, 2, 'Female', '2', 'system_user_sex', 0, 'success', '', 'Female', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (3, 1, 'Active', '1', 'infra_job_status', 0, 'success', '', 'Active', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (4, 2, 'Paused', '2', 'infra_job_status', 0, 'danger', '', 'Inactive', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (5, 1, 'Built-in', '1', 'infra_config_type', 0, 'danger', '', 'Built-in setting', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (6, 2, 'Custom', '2', 'infra_config_type', 0, 'primary', '', 'Custom setting', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (7, 1, 'Notice', '1', 'system_notice_type', 0, 'success', '', 'Notice', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (8, 2, 'Announcement', '2', 'system_notice_type', 0, 'info', '', 'Announcement', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (9, 0, 'Other', '0', 'infra_operate_type', 0, 'default', '', 'Other', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (10, 1, 'Query', '1', 'infra_operate_type', 0, 'info', '', 'Query', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (11, 2, 'Create', '2', 'infra_operate_type', 0, 'primary', '', 'Create', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (12, 3, 'Update', '3', 'infra_operate_type', 0, 'warning', '', 'Update', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (13, 4, 'Delete', '4', 'infra_operate_type', 0, 'danger', '', 'Delete', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (14, 5, 'Export', '5', 'infra_operate_type', 0, 'default', '', 'Export', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (15, 6, 'Import', '6', 'infra_operate_type', 0, 'default', '', 'Import', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (16, 1, 'Enabled', '0', 'common_status', 0, 'primary', '', 'Enabled', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (17, 2, 'Disabled', '1', 'common_status', 0, 'info', '', 'Disabled', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (21, 1, 'Built-in', '1', 'system_role_type', 0, 'danger', '', 'Built-in', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (22, 2, 'Custom', '2', 'system_role_type', 0, 'primary', '', 'Custom', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (28, 0, 'Success', '0', 'system_login_result', 0, 'success', '', 'Signed in', '', '2021-01-18 06:17:36', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (29, 10, 'Incorrect username or password', '10', 'system_login_result', 0, 'primary', '', 'Incorrect username or password', '', '2021-01-18 06:17:54', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (30, 20, 'Account disabled', '20', 'system_login_result', 0, 'warning', '', 'Account disabled', '', '2021-01-18 06:17:54', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (31, 30, 'Verification code not found', '30', 'system_login_result', 0, 'info', '', 'Verification code not found', '', '2021-01-18 06:17:54', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (32, 31, 'Incorrect verification code', '31', 'system_login_result', 0, 'info', '', 'Incorrect verification code', '', '2021-01-18 06:17:54', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (33, 100, 'Unknown error', '100', 'system_login_result', 0, 'danger', '', 'Unknown error', '', '2021-01-18 06:17:54', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (34, 1, 'Yes', 'true', 'infra_boolean_string', 0, 'danger', '', 'Yes', '', '2021-01-19 03:20:55', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (35, 1, 'No', 'false', 'infra_boolean_string', 0, 'info', '', 'No', '', '2021-01-19 03:20:55', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (36, 1, 'Single table (CRUD)', '1', 'infra_codegen_template_type', 0, '', '', NULL, '', '2021-02-05 07:09:06', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (37, 2, 'Tree table (CRUD)', '2', 'infra_codegen_template_type', 0, '', '', NULL, '', '2021-02-05 07:14:46', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (38, 0, 'Initializing', '0', 'infra_job_status', 0, 'primary', '', NULL, '', '2021-02-07 07:46:49', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (39, 0, 'Running', '0', 'infra_job_log_status', 0, 'primary', '', 'RUNNING', '', '2021-02-08 10:04:24', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (40, 1, 'Success', '1', 'infra_job_log_status', 0, 'success', '', NULL, '', '2021-02-08 10:06:57', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (41, 2, 'Failed', '2', 'infra_job_log_status', 0, 'warning', '', 'Failed', '', '2021-02-08 10:07:38', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (42, 1, 'Member', '1', 'user_type', 0, 'primary', '', NULL, '', '2021-02-26 00:16:27', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (43, 2, 'Admin', '2', 'user_type', 0, 'success', '', NULL, '', '2021-02-26 00:16:34', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (44, 0, 'Open', '0', 'infra_api_error_log_process_status', 0, 'primary', '', NULL, '', '2021-02-26 07:07:19', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (45, 1, 'Resolved', '1', 'infra_api_error_log_process_status', 0, 'success', '', NULL, '', '2021-02-26 07:07:26', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (46, 2, 'Ignored', '2', 'infra_api_error_log_process_status', 0, 'danger', '', NULL, '', '2021-02-26 07:07:34', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (47, 1, 'Alibaba Cloud', 'ALIYUN', 'system_sms_channel_code', 0, 'primary', '', NULL, '1', '2021-04-05 01:05:26', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (48, 1, 'Verification code', '1', 'system_sms_template_type', 0, 'warning', '', NULL, '1', '2021-04-05 21:50:57', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (49, 2, 'Notice', '2', 'system_sms_template_type', 0, 'primary', '', NULL, '1', '2021-04-05 21:51:08', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (50, 0, 'Marketing', '3', 'system_sms_template_type', 0, 'danger', '', NULL, '1', '2021-04-05 21:51:15', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (51, 0, 'Init', '0', 'system_sms_send_status', 0, 'primary', '', NULL, '1', '2021-04-11 20:18:33', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (52, 1, 'Sent', '10', 'system_sms_send_status', 0, 'success', '', NULL, '1', '2021-04-11 20:18:43', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (53, 2, 'Failed', '20', 'system_sms_send_status', 0, 'danger', '', NULL, '1', '2021-04-11 20:18:49', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (54, 3, 'Skipped', '30', 'system_sms_send_status', 0, 'info', '', NULL, '1', '2021-04-11 20:19:44', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (55, 0, 'Waiting', '0', 'system_sms_receive_status', 0, 'primary', '', NULL, '1', '2021-04-11 20:27:43', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (56, 1, 'Received', '10', 'system_sms_receive_status', 0, 'success', '', NULL, '1', '2021-04-11 20:29:25', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (57, 2, 'Receive failed', '20', 'system_sms_receive_status', 0, 'danger', '', NULL, '1', '2021-04-11 20:29:31', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (58, 0, 'Debug (DingTalk)', 'DEBUG_DING_TALK', 'system_sms_channel_code', 0, 'info', '', NULL, '1', '2021-04-13 00:20:37', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (59, 100, 'Password', '100', 'system_login_type', 0, 'primary', '', 'Password', '1', '2021-10-06 00:52:02', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (60, 101, 'Social', '101', 'system_login_type', 0, 'info', '', 'Social', '1', '2021-10-06 00:52:17', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (61, 200, 'Signed out', '200', 'system_login_type', 0, 'primary', '', 'Signed out', '1', '2021-10-06 00:52:58', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (62, 202, 'Forced sign-out', '202', 'system_login_type', 0, 'danger', '', 'Forced sign-out', '1', '2021-10-06 00:53:41', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (103, 1, 'Admin', '1', 'infra_codegen_scene', 0, '', '', 'Admin', '1', '2022-02-02 13:15:06', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (104, 2, 'App', '2', 'infra_codegen_scene', 0, '', '', 'App', '1', '2022-02-02 13:15:19', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (105, 1, 'Database', '1', 'infra_file_storage', 0, 'default', '', NULL, '1', '2022-03-15 00:25:28', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (106, 10, 'Local disk', '10', 'infra_file_storage', 0, 'default', '', NULL, '1', '2022-03-15 00:25:41', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (107, 11, 'FTP', '11', 'infra_file_storage', 0, 'default', '', NULL, '1', '2022-03-15 00:26:06', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (108, 12, 'SFTP', '12', 'infra_file_storage', 0, 'default', '', NULL, '1', '2022-03-15 00:26:22', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (109, 20, 'S3', '20', 'infra_file_storage', 0, 'default', '', NULL, '1', '2022-03-15 00:26:31', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (110, 103, 'SMS', '103', 'system_login_type', 0, 'default', '', NULL, '1', '2022-05-09 23:57:58', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (111, 1, 'password', 'password', 'system_oauth2_grant_type', 0, 'default', '', 'Password', '1', '2022-05-12 00:22:05', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (112, 2, 'authorization_code', 'authorization_code', 'system_oauth2_grant_type', 0, 'primary', '', 'Authorization code', '1', '2022-05-12 00:22:59', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (113, 3, 'implicit', 'implicit', 'system_oauth2_grant_type', 0, 'success', '', 'Implicit', '1', '2022-05-12 00:23:40', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (114, 4, 'client_credentials', 'client_credentials', 'system_oauth2_grant_type', 0, 'default', '', 'Client credentials', '1', '2022-05-12 00:23:51', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (115, 5, 'refresh_token', 'refresh_token', 'system_oauth2_grant_type', 0, 'info', '', 'Refresh token', '1', '2022-05-12 00:24:02', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (177, 0, 'Init', '0', 'system_mail_send_status', 0, 'primary', '', 'Initializing', '1', '2023-01-26 09:53:49', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (178, 10, 'Sent', '10', 'system_mail_send_status', 0, 'success', '', 'Sent', '1', '2023-01-26 09:54:28', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (179, 20, 'Failed', '20', 'system_mail_send_status', 0, 'danger', '', 'Failed', '1', '2023-01-26 09:54:50', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (180, 30, 'Skipped', '30', 'system_mail_send_status', 0, 'info', '', 'Skipped', '1', '2023-01-26 09:55:06', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (181, 1, 'Announcements', '1', 'system_notify_template_type', 0, 'primary', '', 'Announcement', '1', '2023-01-28 10:35:59', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (182, 2, 'System', '2', 'system_notify_template_type', 0, 'success', '', 'System', '1', '2023-01-28 10:36:20', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (184, 10, 'Vue 2 Element UI', '10', 'infra_codegen_front_type', 0, '', '', '', '1', '2023-04-13 00:03:55', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (185, 20, 'Vue 3 Element Plus', '20', 'infra_codegen_front_type', 0, '', '', '', '1', '2023-04-13 00:04:08', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (186, 30, 'Vben 2.0 Ant Design Schema', '30', 'infra_codegen_front_type', 1, '', '', '', '1', '2023-04-13 00:04:26', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (274, 10, 'Gitee', '10', 'system_social_type', 0, '', '', '', '1', '2023-11-04 13:04:42', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (275, 20, 'DingTalk', '20', 'system_social_type', 0, '', '', '', '1', '2023-11-04 13:04:54', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (276, 30, 'WeCom', '30', 'system_social_type', 0, '', '', '', '1', '2023-11-04 13:05:09', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (277, 31, 'WeChat Official Account', '31', 'system_social_type', 0, '', '', '', '1', '2023-11-04 13:05:18', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (278, 32, 'WeChat Open Platform', '32', 'system_social_type', 0, '', '', '', '1', '2023-11-04 13:05:30', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (279, 34, 'WeChat Mini Program', '34', 'system_social_type', 0, '', '', '', '1', '2023-11-04 13:05:38', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (282, 15, 'Child table', '15', 'infra_codegen_template_type', 0, 'default', '', '', '1', '2023-11-13 23:06:16', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (283, 10, 'Primary table (standard)', '10', 'infra_codegen_template_type', 0, 'default', '', '', '1', '2023-11-14 12:32:49', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (284, 11, 'Primary table (ERP)', '11', 'infra_codegen_template_type', 0, 'default', '', '', '1', '2023-11-14 12:33:05', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (285, 12, 'Primary table (embedded)', '12', 'infra_codegen_template_type', 0, '', '', '', '1', '2023-11-14 12:33:31', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (407, 2, 'Tencent Cloud', 'TENCENT', 'system_sms_channel_code', 0, '', '', '', '1', '2024-07-22 22:23:16', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (408, 3, 'Huawei Cloud', 'HUAWEI', 'system_sms_channel_code', 0, '', '', '', '1', '2024-07-22 22:23:46', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (412, 4, 'Qiniu', 'QINIU', 'system_sms_channel_code', 0, '', '', '', '1', '2024-08-31 08:45:03', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (596, 40, 'Vben 5.0 Ant Design Schema', '40', 'infra_codegen_front_type', 0, '', '', NULL, '1', '2025-04-23 21:47:47', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (622, 41, 'Vben 5.0 Ant Design', '41', 'infra_codegen_front_type', 0, '', '', '', '1', '2025-09-04 23:26:07', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (623, 50, 'Vben 5.0 Element Plus Schema', '50', 'infra_codegen_front_type', 0, '', '', '', '1', '2025-09-04 23:26:38', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (624, 51, 'Vben 5.0 Element Plus', '51', 'infra_codegen_front_type', 0, '', '', '', '1', '2025-09-04 23:26:49', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (626, 40, 'Alipay Mini Program', '40', 'system_social_type', 0, '', '', '', '1', '2023-11-04 13:05:38', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (627, 60, 'Admin UniApp', '60', 'infra_codegen_front_type', 0, '', '', NULL, '1', '2025-12-16 19:25:51', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (628, 42, 'Vben 5.0 Antdv Next Schema', '42', 'infra_codegen_front_type', 0, '', '', '', '1', '2026-05-23 13:52:25', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_dict_data` (`id`, `sort`, `label`, `value`, `dict_type`, `status`, `color_type`, `css_class`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (629, 43, 'Vben 5.0 Antdv Next', '43', 'infra_codegen_front_type', 0, '', '', '', '1', '2026-05-23 13:52:25', '1', '2026-08-14 01:49:42', b'0');
COMMIT;

-- ----------------------------
-- Table structure for system_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `system_dict_type`;
CREATE TABLE `system_dict_type`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Dictionary primary key',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Dictionary name',
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Dictionary type',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT 'Status (0Normal 1 disable )',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `deleted_time` datetime NULL DEFAULT NULL COMMENT 'Delete time',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 398 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Dict type';

-- ----------------------------
-- Records of system_dict_type
-- ----------------------------
BEGIN;
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (1, 'User Sex', 'system_user_sex', 0, NULL, 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (2, 'Setting Type', 'infra_config_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (3, 'Announcement Type', 'system_notice_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (4, 'Action Type', 'infra_operate_type', 0, NULL, 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (5, 'Status', 'common_status', 0, NULL, 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (6, 'Yes / No', 'infra_boolean_string', 0, 'Boolean as yes or no', '', '2021-01-19 03:20:08', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (7, 'Sign-in Result', 'system_login_result', 0, 'Sign-in Result', '', '2021-01-18 06:17:11', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (8, 'Code Generator Template', 'infra_codegen_template_type', 0, NULL, '', '2021-02-05 07:08:06', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (9, 'Scheduled Job Status', 'infra_job_status', 0, NULL, '', '2021-02-07 07:44:16', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (10, 'Scheduled Job Log Status', 'infra_job_log_status', 0, NULL, '', '2021-02-08 10:03:51', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (11, 'User Type', 'user_type', 0, NULL, '', '2021-02-26 00:15:51', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (12, 'API Error Log Status', 'infra_api_error_log_process_status', 0, NULL, '', '2021-02-26 07:07:01', '', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (13, 'SMS Channel', 'system_sms_channel_code', 0, NULL, '1', '2021-04-05 01:04:50', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (14, 'SMS Template Type', 'system_sms_template_type', 0, NULL, '1', '2021-04-05 21:50:43', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (15, 'SMS Send Status', 'system_sms_send_status', 0, NULL, '1', '2021-04-11 20:18:03', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (16, 'SMS Receive Status', 'system_sms_receive_status', 0, NULL, '1', '2021-04-11 20:27:14', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (17, 'Sign-in Log Type', 'system_login_type', 0, 'Sign-in Log Type', '1', '2021-10-06 00:50:46', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (27, 'Code Generator Scene', 'infra_codegen_scene', 0, 'Code Generator Scene', '1', '2022-02-02 13:14:45', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (28, 'Role Type', 'system_role_type', 0, 'Role Type', '1', '2022-02-16 13:01:46', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (29, 'File Storage', 'infra_file_storage', 0, 'File Storage', '1', '2022-03-15 00:24:38', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (30, 'OAuth 2.0 Grant Type', 'system_oauth2_grant_type', 0, 'OAuth 2.0 Grant Type', '1', '2022-05-12 00:20:52', '1', '2026-08-14 01:49:42', b'0', NULL);
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (48, 'Email Send Status', 'system_mail_send_status', 0, 'Email Send Status', '1', '2023-01-26 09:53:13', '1', '2026-08-14 01:49:42', b'0', '1970-01-01 00:00:00');
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (49, 'Inbox Template Type', 'system_notify_template_type', 0, 'Inbox Template Type', '1', '2023-01-28 10:35:10', '1', '2026-08-14 01:49:42', b'0', '1970-01-01 00:00:00');
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (50, 'Code Generator Frontend', 'infra_codegen_front_type', 0, '', '1', '2023-04-12 23:57:52', '1', '2026-08-14 01:49:42', b'0', '1970-01-01 00:00:00');
INSERT INTO `system_dict_type` (`id`, `name`, `type`, `status`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `deleted_time`) VALUES (70, 'Social Client Type', 'system_social_type', 0, '', '1', '2023-11-04 13:03:54', '1', '2026-08-14 01:49:42', b'0', '1970-01-01 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for system_login_log
-- ----------------------------
DROP TABLE IF EXISTS `system_login_log`;
CREATE TABLE `system_login_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Access ID',
  `log_type` bigint NOT NULL COMMENT 'Log type',
  `trace_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Trace ID',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT 'User ID',
  `user_type` tinyint NOT NULL DEFAULT 0 COMMENT 'User type',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Username',
  `result` tinyint NOT NULL COMMENT 'Sign-in result',
  `user_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'User IP',
  `user_agent` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'User agent',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_username`(`username` ASC) USING BTREE,
  INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7941 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Sign-in log';

-- ----------------------------
-- Records of system_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for system_mail_account
-- ----------------------------
DROP TABLE IF EXISTS `system_mail_account`;
CREATE TABLE `system_mail_account`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Email',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Username',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Password',
  `host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMTP host',
  `port` int NOT NULL COMMENT 'SMTP port',
  `ssl_enable` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Is not enable SSL',
  `starttls_enable` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Is not enable STARTTLS',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Email account';

-- ----------------------------
-- Records of system_mail_account
-- ----------------------------

-- ----------------------------
-- Table structure for system_mail_log
-- ----------------------------
DROP TABLE IF EXISTS `system_mail_log`;
CREATE TABLE `system_mail_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `user_id` bigint NULL DEFAULT NULL COMMENT 'User ID',
  `user_type` tinyint NULL DEFAULT NULL COMMENT 'User type',
  `to_mails` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ReceiveemailAddress',
  `cc_mails` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Cc',
  `bcc_mails` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Bcc',
  `account_id` bigint NOT NULL COMMENT 'Email account code',
  `from_mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Send emailAddress',
  `template_id` bigint NOT NULL COMMENT 'Template code',
  `template_code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template code',
  `template_nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Template send person name',
  `template_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Email title',
  `template_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Email content',
  `template_params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Email parameter',
  `send_status` tinyint NOT NULL DEFAULT 0 COMMENT 'Send status',
  `send_time` datetime NULL DEFAULT NULL COMMENT 'Send time',
  `send_message_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Provider message ID',
  `send_exception` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Send error',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 368 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Email log';

-- ----------------------------
-- Records of system_mail_log
-- ----------------------------

-- ----------------------------
-- Table structure for system_mail_template
-- ----------------------------
DROP TABLE IF EXISTS `system_mail_template`;
CREATE TABLE `system_mail_template`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template name',
  `code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template code',
  `account_id` bigint NOT NULL COMMENT 'Send email account code',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Send person name',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template title',
  `content` varchar(10240) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template content',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template params',
  `status` tinyint NOT NULL COMMENT 'Enable status',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Email template';

-- ----------------------------
-- Records of system_mail_template
-- ----------------------------

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'MenuID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Menu name',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Permission key',
  `type` tinyint NOT NULL COMMENT 'Menu type',
  `sort` int NOT NULL DEFAULT 0 COMMENT 'Sort',
  `parent_id` bigint NOT NULL DEFAULT 0 COMMENT 'Parent menuID',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Route path',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '#' COMMENT 'Menu icon',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Component path',
  `component_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Component name',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT 'Menu status',
  `visible` bit(1) NOT NULL DEFAULT b'1' COMMENT 'Visible',
  `keep_alive` bit(1) NOT NULL DEFAULT b'1' COMMENT 'Keep-alive',
  `always_show` bit(1) NOT NULL DEFAULT b'1' COMMENT 'Always show',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13478 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Menu';

-- ----------------------------
-- Records of system_menu
-- ----------------------------
BEGIN;
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1, 'System', '', 1, 10, 0, '/system', 'ep:tools', NULL, NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-09-02 18:42:01', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (2, 'Infrastructure', '', 1, 20, 0, '/infra', 'ep:monitor', NULL, NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-09-02 18:42:01', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (4, 'Users', 'system:user:list', 2, 1, 1, 'user', 'ep:avatar', 'system/user/index', 'SystemUser', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (5, 'Roles', '', 2, 2, 1, 'role', 'ep:user', 'system/role/index', 'SystemRole', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (6, 'Menus', '', 2, 3, 1, 'menu', 'ep:menu', 'system/menu/index', 'SystemMenu', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (7, 'Departments', '', 2, 4, 1, 'dept', 'fa:address-card', 'system/dept/index', 'SystemDept', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (8, 'Job Titles', '', 2, 5, 1, 'post', 'fa:address-book-o', 'system/post/index', 'SystemPost', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (9, 'Dictionaries', '', 2, 6, 1, 'dict', 'ep:collection', 'system/dict/index', 'SystemDictType', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (10, 'Settings', '', 2, 8, 2, 'config', 'fa:connectdevelop', 'infra/config/index', 'InfraConfig', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (11, 'Announcements', '', 2, 4, 772, 'notice', 'ep:takeaway-box', 'system/notice/index', 'SystemNotice', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (12, 'Audit Logs', '', 1, 9, 1, 'log', 'ep:document-copy', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (13, 'Tokens', '', 2, 2, 201, 'token', 'fa:key', 'system/oauth2/token/index', 'SystemTokenClient', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (14, 'Scheduled Jobs', '', 2, 7, 2, 'job', 'fa-solid:tasks', 'infra/job/index', 'InfraJob', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (15, 'MySQL Monitor', '', 2, 1, 773, 'druid', 'fa-solid:box', 'infra/druid/index', 'InfraDruid', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (16, 'Java Monitor', '', 2, 3, 773, 'admin-server', 'ep:coffee-cup', 'infra/server/index', 'InfraAdminServer', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (17, 'Redis Monitor', '', 2, 2, 773, 'redis', 'fa:reddit-square', 'infra/redis/index', 'InfraRedis', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (18, 'Form Builder', 'infra:build:list', 2, 2, 2, 'build', 'fa:wpforms', 'infra/build/index', 'InfraBuild', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (19, 'Code Generator', 'infra:codegen:query', 2, 1, 2, 'codegen', 'ep:document-copy', 'infra/codegen/index', 'InfraCodegen', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (20, 'API Explorer', 'infra:swagger:list', 2, 3, 2, 'swagger', 'fa:fighter-jet', 'infra/swagger/index', 'InfraSwagger', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (21, 'Activity Log', '', 2, 1, 12, 'operate-log', 'ep:position', 'system/operatelog/index', 'SystemOperateLog', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (22, 'Sign-in Log', '', 2, 2, 12, 'login-log', 'ep:promotion', 'system/loginlog/index', 'SystemLoginLog', 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (23, 'Users Query', 'system:user:query', 3, 1, 4, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (24, 'Users Create', 'system:user:create', 3, 2, 4, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (25, 'Users Update', 'system:user:update', 3, 3, 4, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (26, 'Users Delete', 'system:user:delete', 3, 4, 4, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (27, 'Users Export', 'system:user:export', 3, 5, 4, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (28, 'Users Import', 'system:user:import', 3, 6, 4, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (29, 'Reset Password', 'system:user:update-password', 3, 7, 4, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (30, 'Roles Query', 'system:role:query', 3, 1, 5, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (31, 'Roles Create', 'system:role:create', 3, 2, 5, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (32, 'Roles Update', 'system:role:update', 3, 3, 5, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (33, 'Roles Delete', 'system:role:delete', 3, 4, 5, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (34, 'Roles Export', 'system:role:export', 3, 5, 5, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (35, 'Menu Query', 'system:menu:query', 3, 1, 6, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (36, 'Menu Create', 'system:menu:create', 3, 2, 6, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (37, 'Menu Update', 'system:menu:update', 3, 3, 6, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (38, 'Menu Delete', 'system:menu:delete', 3, 4, 6, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (39, 'Departments Query', 'system:dept:query', 3, 1, 7, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (40, 'Departments Create', 'system:dept:create', 3, 2, 7, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (41, 'Departments Update', 'system:dept:update', 3, 3, 7, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (42, 'Departments Delete', 'system:dept:delete', 3, 4, 7, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (43, 'Job Titles Query', 'system:post:query', 3, 1, 8, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (44, 'Job Titles Create', 'system:post:create', 3, 2, 8, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (45, 'Job Titles Update', 'system:post:update', 3, 3, 8, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (46, 'Job Titles Delete', 'system:post:delete', 3, 4, 8, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (47, 'Job Titles Export', 'system:post:export', 3, 5, 8, '', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (48, 'Dictionaries Query', 'system:dict:query', 3, 1, 9, '#', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (49, 'Dictionaries Create', 'system:dict:create', 3, 2, 9, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (50, 'Dictionaries Update', 'system:dict:update', 3, 3, 9, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (51, 'Dictionaries Delete', 'system:dict:delete', 3, 4, 9, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (52, 'Dictionaries Export', 'system:dict:export', 3, 5, 9, '#', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (53, 'Settings Query', 'infra:config:query', 3, 1, 10, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (54, 'Settings Create', 'infra:config:create', 3, 2, 10, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (55, 'Settings Update', 'infra:config:update', 3, 3, 10, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (56, 'Settings Delete', 'infra:config:delete', 3, 4, 10, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (57, 'Settings Export', 'infra:config:export', 3, 5, 10, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (58, 'Announcements Query', 'system:notice:query', 3, 1, 11, '#', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (59, 'Announcements Create', 'system:notice:create', 3, 2, 11, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (60, 'Announcements Update', 'system:notice:update', 3, 3, 11, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (61, 'Announcements Delete', 'system:notice:delete', 3, 4, 11, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (62, 'Query Actions', 'system:operate-log:query', 3, 1, 21, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (63, 'Logs Export', 'system:operate-log:export', 3, 2, 21, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (64, 'Query Sign-in Logs', 'system:login-log:query', 3, 1, 22, '#', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (65, 'Logs Export', 'system:login-log:export', 3, 3, 22, '#', '#', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (66, 'Tokens List', 'system:oauth2-token:page', 3, 1, 13, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (67, 'Tokens Delete', 'system:oauth2-token:delete', 3, 2, 13, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (68, 'Jobs Create', 'infra:job:create', 3, 2, 14, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (69, 'Jobs Update', 'infra:job:update', 3, 3, 14, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (70, 'Jobs Delete', 'infra:job:delete', 3, 4, 14, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (71, 'Status Update', 'infra:job:update', 3, 5, 14, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (72, 'Jobs Export', 'infra:job:export', 3, 7, 14, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (73, 'Update Generated Code', 'infra:codegen:update', 3, 2, 19, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (74, 'Delete Generated Code', 'infra:codegen:delete', 3, 3, 19, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (75, 'Import Tables', 'infra:codegen:create', 3, 2, 19, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (76, 'Preview Code', 'infra:codegen:preview', 3, 4, 19, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (77, 'Generate Code', 'infra:codegen:download', 3, 5, 19, '', '', '', NULL, 0, b'1', b'1', b'1', 'admin', '2021-01-05 17:03:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (78, 'Assign Role Menus', 'system:permission:assign-role-menu', 3, 6, 5, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-01-06 17:53:44', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (79, 'Assign Role Data Scope', 'system:permission:assign-role-data-scope', 3, 7, 5, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-01-06 17:56:31', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (80, 'Assign User Roles', 'system:permission:assign-user-role', 3, 8, 5, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-01-07 10:23:28', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (81, 'Get Redis Monitor Info', 'infra:redis:get-monitor-info', 3, 1, 17, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-01-26 01:02:31', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (82, 'Get Redis Key List', 'infra:redis:get-key-list', 3, 2, 17, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-01-26 01:02:52', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (84, 'Run Job', 'infra:job:trigger', 3, 8, 14, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-02-07 13:03:10', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (85, 'Trace', '', 2, 4, 773, 'skywalking', 'fa:eye', 'infra/skywalking/index', 'InfraSkyWalking', 0, b'1', b'1', b'1', '', '2021-02-08 20:41:31', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (86, 'Access Log', '', 2, 1, 88, 'api-access-log', 'ep:place', 'infra/apiAccessLog/index', 'InfraApiAccessLog', 0, b'1', b'1', b'1', '', '2021-02-26 01:32:59', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (87, 'Logs Export', 'infra:api-access-log:export', 3, 2, 86, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-02-26 01:32:59', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (88, 'API Logs', '', 2, 4, 2, 'log', 'fa:tasks', NULL, NULL, 0, b'1', b'1', b'1', '', '2021-02-26 02:18:24', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (89, 'Error Log', 'infra:api-error-log:query', 2, 2, 88, 'api-error-log', 'ep:warning-filled', 'infra/apiErrorLog/index', 'InfraApiErrorLog', 0, b'1', b'1', b'1', '', '2021-02-26 07:53:20', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (90, 'Process Log', 'infra:api-error-log:update-status', 3, 2, 89, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-02-26 07:53:20', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (91, 'Logs Export', 'infra:api-error-log:export', 3, 3, 89, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-02-26 07:53:20', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (92, 'Jobs Query', 'infra:job:query', 3, 1, 14, '', '', '', NULL, 0, b'1', b'1', b'1', '1', '2021-03-10 01:26:19', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (93, 'Logs Query', 'infra:api-access-log:query', 3, 1, 86, '', '', '', NULL, 0, b'1', b'1', b'1', '1', '2021-03-10 01:28:04', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (94, 'Logs Query', 'infra:api-error-log:query', 3, 1, 89, '', '', '', NULL, 0, b'1', b'1', b'1', '1', '2021-03-10 01:29:09', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (95, 'Files List', '', 2, 5, 193, 'file', 'ep:upload-filled', 'infra/file/index', 'InfraFile', 0, b'1', b'1', b'1', '', '2021-03-12 20:16:20', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (96, 'Files Query', 'infra:file:query', 3, 1, 95, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-03-12 20:16:20', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (97, 'Files Delete', 'infra:file:delete', 3, 4, 95, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-03-12 20:16:20', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (98, 'SMS', '', 1, 1, 772, 'sms', 'ep:message', NULL, NULL, 0, b'1', b'1', b'1', '1', '2021-04-05 01:10:16', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (99, 'SMS Channels', '', 2, 0, 98, 'sms-channel', 'fa:stack-exchange', 'system/sms/channel/index', 'SystemSmsChannel', 0, b'1', b'1', b'1', '', '2021-04-01 11:07:15', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (100, 'SMS Channels Query', 'system:sms-channel:query', 3, 1, 99, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 11:07:15', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (101, 'SMS Channels Create', 'system:sms-channel:create', 3, 2, 99, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 11:07:15', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (102, 'SMS Channels Update', 'system:sms-channel:update', 3, 3, 99, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 11:07:15', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (103, 'SMS Channels Delete', 'system:sms-channel:delete', 3, 4, 99, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 11:07:15', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (104, 'SMS Templates', '', 2, 1, 98, 'sms-template', 'ep:connection', 'system/sms/template/index', 'SystemSmsTemplate', 0, b'1', b'1', b'1', '', '2021-04-01 17:35:17', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (105, 'SMS Templates Query', 'system:sms-template:query', 3, 1, 104, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 17:35:17', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (106, 'SMS Templates Create', 'system:sms-template:create', 3, 2, 104, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 17:35:17', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (107, 'SMS Templates Update', 'system:sms-template:update', 3, 3, 104, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 17:35:17', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (108, 'SMS Templates Delete', 'system:sms-template:delete', 3, 4, 104, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 17:35:17', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (109, 'SMS Templates Export', 'system:sms-template:export', 3, 5, 104, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-01 17:35:17', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (110, 'Send Test SMS', 'system:sms-template:send-sms', 3, 6, 104, '', '', '', NULL, 0, b'1', b'1', b'1', '1', '2021-04-11 00:26:40', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (111, 'SMS Logs', '', 2, 2, 98, 'sms-log', 'fa:edit', 'system/sms/log/index', 'SystemSmsLog', 0, b'1', b'1', b'1', '', '2021-04-11 08:37:05', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (112, 'SMS Logs Query', 'system:sms-log:query', 3, 1, 111, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-11 08:37:05', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (113, 'SMS Logs Export', 'system:sms-log:export', 3, 5, 111, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-04-11 08:37:05', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (129, 'Tenants', '', 2, 0, 181, 'list', 'ep:house', 'system/tenant/index', 'SystemTenant', 0, b'1', b'1', b'1', '', '2021-12-14 12:31:43', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (130, 'Tenants Query', 'system:tenant:query', 3, 1, 129, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-12-14 12:31:44', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (131, 'Tenants Create', 'system:tenant:create', 3, 2, 129, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-12-14 12:31:44', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (132, 'Tenants Update', 'system:tenant:update', 3, 3, 129, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-12-14 12:31:44', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (133, 'Tenants Delete', 'system:tenant:delete', 3, 4, 129, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-12-14 12:31:44', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (134, 'Tenants Export', 'system:tenant:export', 3, 5, 129, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2021-12-14 12:31:44', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (181, 'Tenants', '', 2, 0, 1, 'tenant', 'fa-solid:house-user', NULL, NULL, 0, b'1', b'1', b'1', '1', '2022-02-20 01:41:13', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (182, 'Tenant Plans', '', 2, 0, 181, 'package', 'fa:bars', 'system/tenantPackage/index', 'SystemTenantPackage', 0, b'1', b'1', b'1', '', '2022-02-19 17:44:06', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (183, 'Tenant Plans Query', 'system:tenant-package:query', 3, 1, 182, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-02-19 17:44:06', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (184, 'Tenant Plans Create', 'system:tenant-package:create', 3, 2, 182, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-02-19 17:44:06', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (185, 'Tenant Plans Update', 'system:tenant-package:update', 3, 3, 182, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-02-19 17:44:06', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (186, 'Tenant Plans Delete', 'system:tenant-package:delete', 3, 4, 182, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-02-19 17:44:06', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (187, 'File Settings', '', 2, 0, 193, 'file-config', 'fa-solid:file-signature', 'infra/fileConfig/index', 'InfraFileConfig', 0, b'1', b'1', b'1', '', '2022-03-15 14:35:28', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (188, 'File Settings Query', 'infra:file-config:query', 3, 1, 187, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-03-15 14:35:28', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (189, 'File Settings Create', 'infra:file-config:create', 3, 2, 187, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-03-15 14:35:28', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (190, 'File Settings Update', 'infra:file-config:update', 3, 3, 187, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-03-15 14:35:28', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (191, 'File Settings Delete', 'infra:file-config:delete', 3, 4, 187, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-03-15 14:35:28', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (192, 'File Settings Export', 'infra:file-config:export', 3, 5, 187, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-03-15 14:35:28', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (193, 'Files', '', 2, 6, 2, 'file', 'ep:files', NULL, '', 0, b'1', b'1', b'1', '1', '2022-03-16 23:47:40', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (195, 'Data Sources', '', 2, 1, 2, 'data-source-config', 'ep:data-analysis', 'infra/dataSourceConfig/index', 'InfraDataSourceConfig', 0, b'1', b'1', b'1', '', '2022-04-27 14:37:32', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (196, 'Data Sources Query', 'infra:data-source-config:query', 3, 1, 195, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-04-27 14:37:32', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (197, 'Data Sources Create', 'infra:data-source-config:create', 3, 2, 195, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-04-27 14:37:32', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (198, 'Data Sources Update', 'infra:data-source-config:update', 3, 3, 195, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-04-27 14:37:32', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (199, 'Data Sources Delete', 'infra:data-source-config:delete', 3, 4, 195, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-04-27 14:37:32', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (200, 'Data Sources Export', 'infra:data-source-config:export', 3, 5, 195, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-04-27 14:37:32', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (201, 'OAuth 2.0', '', 2, 10, 1, 'oauth2', 'fa:dashcube', NULL, NULL, 0, b'1', b'1', b'1', '1', '2022-05-09 23:38:17', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (202, 'Applications', '', 2, 0, 201, 'oauth2/application', 'fa:hdd-o', 'system/oauth2/client/index', 'SystemOAuth2Client', 0, b'1', b'1', b'1', '', '2022-05-10 16:26:33', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (203, 'Clients Query', 'system:oauth2-client:query', 3, 1, 202, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-05-10 16:26:33', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (204, 'Clients Create', 'system:oauth2-client:create', 3, 2, 202, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-05-10 16:26:33', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (205, 'Clients Update', 'system:oauth2-client:update', 3, 3, 202, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-05-10 16:26:33', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (206, 'Clients Delete', 'system:oauth2-client:delete', 3, 4, 202, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2022-05-10 16:26:33', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (271, 'Regions', '', 2, 14, 1, 'area', 'fa:map-marker', 'system/area/index', 'SystemArea', 0, b'1', b'1', b'1', '1', '2022-12-23 17:35:05', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (318, 'Email', '', 2, 2, 772, 'mail', 'fa-solid:mail-bulk', NULL, NULL, 0, b'1', b'1', b'1', '1', '2023-01-25 17:27:44', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (319, 'Email Accounts', '', 2, 0, 318, 'mail-account', 'fa:universal-access', 'system/mail/account/index', 'SystemMailAccount', 0, b'1', b'1', b'1', '', '2023-01-25 09:33:48', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (320, 'Accounts Query', 'system:mail-account:query', 3, 1, 319, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-25 09:33:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (321, 'Accounts Create', 'system:mail-account:create', 3, 2, 319, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-25 09:33:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (322, 'Accounts Update', 'system:mail-account:update', 3, 3, 319, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-25 09:33:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (323, 'Accounts Delete', 'system:mail-account:delete', 3, 4, 319, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-25 09:33:48', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (324, 'Email Templates', '', 2, 0, 318, 'mail-template', 'fa:tag', 'system/mail/template/index', 'SystemMailTemplate', 0, b'1', b'1', b'1', '', '2023-01-25 12:05:31', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (325, 'Templates Query', 'system:mail-template:query', 3, 1, 324, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-25 12:05:31', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (326, 'Templates Create', 'system:mail-template:create', 3, 2, 324, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-25 12:05:31', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (327, 'Templates Update', 'system:mail-template:update', 3, 3, 324, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-25 12:05:31', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (328, 'Templates Delete', 'system:mail-template:delete', 3, 4, 324, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-25 12:05:31', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (329, 'Email Logs', '', 2, 0, 318, 'mail-log', 'fa:edit', 'system/mail/log/index', 'SystemMailLog', 0, b'1', b'1', b'1', '', '2023-01-26 02:16:50', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (330, 'Logs Query', 'system:mail-log:query', 3, 1, 329, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-26 02:16:50', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (331, 'Send Test Email', 'system:mail-template:send-mail', 3, 5, 324, '', '', '', NULL, 0, b'1', b'1', b'1', '1', '2023-01-26 23:29:15', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (332, 'Inbox', '', 1, 3, 772, 'notify', 'ep:message-box', NULL, NULL, 0, b'1', b'1', b'1', '1', '2023-01-28 10:25:18', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (333, 'Templates Admin', '', 2, 0, 332, 'notify-template', 'fa:archive', 'system/notify/template/index', 'SystemNotifyTemplate', 0, b'1', b'1', b'1', '', '2023-01-28 02:26:42', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (334, 'Inbox Templates Query', 'system:notify-template:query', 3, 1, 333, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-28 02:26:42', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (335, 'Inbox Templates Create', 'system:notify-template:create', 3, 2, 333, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-28 02:26:42', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (336, 'Inbox Templates Update', 'system:notify-template:update', 3, 3, 333, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-28 02:26:42', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (337, 'Inbox Templates Delete', 'system:notify-template:delete', 3, 4, 333, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-28 02:26:42', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (338, 'Send Test Inbox Message', 'system:notify-template:send-notify', 3, 5, 333, '', '', '', NULL, 0, b'1', b'1', b'1', '1', '2023-01-28 10:54:43', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (339, 'Messages Logs', '', 2, 0, 332, 'notify-message', 'fa:edit', 'system/notify/message/index', 'SystemNotifyMessage', 0, b'1', b'1', b'1', '', '2023-01-28 04:28:22', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (340, 'Inbox Messages Query', 'system:notify-message:query', 3, 1, 339, '', '', '', NULL, 0, b'1', b'1', b'1', '', '2023-01-28 04:28:22', '', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (529, 'Social Sign-in', '', 1, 10, 1, 'social', 'fa:rocket', '', '', 0, b'1', b'1', b'1', '1', '2023-11-04 12:12:01', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (530, 'Social Apps', '', 2, 1, 529, 'client', 'ep:set-up', 'system/social/client/index.vue', 'SocialClient', 0, b'1', b'1', b'1', '1', '2023-11-04 12:17:19', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (531, 'Query Social Apps', 'system:social-client:query', 3, 1, 530, '', '', '', '', 0, b'1', b'1', b'1', '1', '2023-11-04 12:43:12', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (532, 'Create Social App', 'system:social-client:create', 3, 2, 530, '', '', '', '', 0, b'1', b'1', b'1', '1', '2023-11-04 12:43:58', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (533, 'Update Social App', 'system:social-client:update', 3, 3, 530, '', '', '', '', 0, b'1', b'1', b'1', '1', '2023-11-04 12:44:27', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (534, 'Delete Social App', 'system:social-client:delete', 3, 4, 530, '', '', '', '', 0, b'1', b'1', b'1', '1', '2023-11-04 12:44:43', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (535, 'Social Users', 'system:social-user:query', 2, 2, 529, 'user', 'ep:avatar', 'system/social/user/index.vue', 'SocialUser', 0, b'1', b'1', b'1', '1', '2023-11-04 14:01:05', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (565, 'WebSocket', '', 2, 5, 2, 'websocket', 'ep:connection', 'infra/webSocket/index', 'InfraWebSocket', 0, b'1', b'1', b'1', '1', '2023-11-23 19:41:55', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (772, 'Messages', '', 1, 7, 1, 'messages', 'ep:chat-dot-round', '', '', 0, b'1', b'1', b'1', '1', '2024-04-22 23:54:30', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (773, 'Monitoring', '', 1, 10, 2, 'monitors', 'ep:monitor', '', '', 0, b'1', b'1', b'1', '1', '2024-04-23 00:04:44', '1', '2026-08-14 01:49:42', b'0');
INSERT INTO `system_menu` (`id`, `name`, `permission`, `type`, `sort`, `parent_id`, `path`, `icon`, `component`, `component_name`, `status`, `visible`, `keep_alive`, `always_show`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (920, 'Switch Tenant', 'system:tenant:visit', 3, 999, 129, '', '', '', '', 0, b'1', b'1', b'1', '1', '2025-05-05 15:25:32', '1', '2026-08-14 01:49:42', b'0');
COMMIT;

-- ----------------------------
-- Table structure for system_notice
-- ----------------------------
DROP TABLE IF EXISTS `system_notice`;
CREATE TABLE `system_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'AnnouncementID',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Announcement title',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Announcement content',
  `type` tinyint NOT NULL COMMENT 'Announcement type (1notification 2announcement)',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT 'Announcement status (0Normal 1 disable )',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Notice';

-- ----------------------------
-- Records of system_notice
-- ----------------------------

-- ----------------------------
-- Table structure for system_notify_message
-- ----------------------------
DROP TABLE IF EXISTS `system_notify_message`;
CREATE TABLE `system_notify_message`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'UserID',
  `user_id` bigint NOT NULL COMMENT 'Userid',
  `user_type` tinyint NOT NULL COMMENT 'User type',
  `template_id` bigint NOT NULL COMMENT 'Template code',
  `template_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template code',
  `template_nickname` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template send person name',
  `template_content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template content',
  `template_type` int NOT NULL COMMENT 'Template type',
  `template_params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template parameter',
  `read_status` bit(1) NOT NULL COMMENT 'Is not Read',
  `read_time` datetime NULL DEFAULT NULL COMMENT 'Read time',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id_user_type_read_status`(`user_id` ASC, `user_type` ASC, `read_status` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Inbox message';

-- ----------------------------
-- Records of system_notify_message
-- ----------------------------

-- ----------------------------
-- Table structure for system_notify_template
-- ----------------------------
DROP TABLE IF EXISTS `system_notify_template`;
CREATE TABLE `system_notify_template`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template name',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template code',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Send person name',
  `content` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template content',
  `type` tinyint NOT NULL COMMENT 'Type',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Template params',
  `status` tinyint NOT NULL COMMENT 'Status',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1062148 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Inbox template';

-- ----------------------------
-- Records of system_notify_template
-- ----------------------------

-- ----------------------------
-- Table structure for system_oauth2_access_token
-- ----------------------------
DROP TABLE IF EXISTS `system_oauth2_access_token`;
CREATE TABLE `system_oauth2_access_token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `user_id` bigint NOT NULL COMMENT 'User ID',
  `user_type` tinyint NOT NULL COMMENT 'User type',
  `user_info` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'User info',
  `access_token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Access token',
  `refresh_token` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Refresh token',
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Client code',
  `scopes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Scopes',
  `expires_time` datetime NOT NULL COMMENT 'Expires at',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_access_token`(`access_token` ASC) USING BTREE,
  INDEX `idx_refresh_token`(`refresh_token` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128754 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'OAuth2 access token';

-- ----------------------------
-- Records of system_oauth2_access_token
-- ----------------------------

-- ----------------------------
-- Table structure for system_oauth2_approve
-- ----------------------------
DROP TABLE IF EXISTS `system_oauth2_approve`;
CREATE TABLE `system_oauth2_approve`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `user_id` bigint NOT NULL COMMENT 'User ID',
  `user_type` tinyint NOT NULL COMMENT 'User type',
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Client code',
  `scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Scopes',
  `approved` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Approved',
  `expires_time` datetime NOT NULL COMMENT 'Expires at',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id_user_type_client_id`(`user_id` ASC, `user_type` ASC, `client_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 84 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'OAuth2 approval';

-- ----------------------------
-- Records of system_oauth2_approve
-- ----------------------------

-- ----------------------------
-- Table structure for system_oauth2_client
-- ----------------------------
DROP TABLE IF EXISTS `system_oauth2_client`;
CREATE TABLE `system_oauth2_client`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Client code',
  `secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Client secret',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'App name',
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'App icon',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'AppDescription',
  `status` tinyint NOT NULL COMMENT 'Status',
  `access_token_validity_seconds` int NOT NULL COMMENT 'Access token expiration date',
  `refresh_token_validity_seconds` int NOT NULL COMMENT 'Refresh token expiration date',
  `redirect_uris` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Redirect URIs',
  `authorized_grant_types` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Grant types',
  `scopes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Scopes',
  `auto_approve_scopes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Auto-approve scopes',
  `authorities` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Permission',
  `resource_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Resource',
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Extra info',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_client_id`(`client_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'OAuth2 client';

-- ----------------------------
-- Records of system_oauth2_client
-- ----------------------------
BEGIN;
INSERT INTO `system_oauth2_client` (`id`, `client_id`, `secret`, `name`, `logo`, `description`, `status`, `access_token_validity_seconds`, `refresh_token_validity_seconds`, `redirect_uris`, `authorized_grant_types`, `scopes`, `auto_approve_scopes`, `authorities`, `resource_ids`, `additional_information`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1, 'default', 'admin123', 'Overall', '', 'Admin console', 0, 1800, 2592000, '["http://127.0.0.1:80","http://localhost:80"]', '["password","authorization_code","implicit","refresh_token","client_credentials"]', '["user.read","user.write"]', '[]', '["user.read","user.write"]', '[]', '{}', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0');
COMMIT;

-- ----------------------------
-- Table structure for system_oauth2_code
-- ----------------------------
DROP TABLE IF EXISTS `system_oauth2_code`;
CREATE TABLE `system_oauth2_code`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `user_id` bigint NOT NULL COMMENT 'User ID',
  `user_type` tinyint NOT NULL COMMENT 'User type',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Authorization code',
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Client code',
  `scopes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Scopes',
  `expires_time` datetime NOT NULL COMMENT 'Expires at',
  `redirect_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Redirect URIs',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Status',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_code`(`code` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 155 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'OAuth2 authorization code';

-- ----------------------------
-- Records of system_oauth2_code
-- ----------------------------

-- ----------------------------
-- Table structure for system_oauth2_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `system_oauth2_refresh_token`;
CREATE TABLE `system_oauth2_refresh_token`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `user_id` bigint NOT NULL COMMENT 'User ID',
  `refresh_token` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Refresh token',
  `user_type` tinyint NOT NULL COMMENT 'User type',
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Client code',
  `scopes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Scopes',
  `expires_time` datetime NOT NULL COMMENT 'Expires at',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_refresh_token`(`refresh_token` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5896 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'OAuth2 refresh token';

-- ----------------------------
-- Records of system_oauth2_refresh_token
-- ----------------------------

-- ----------------------------
-- Table structure for system_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `system_operate_log`;
CREATE TABLE `system_operate_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Log ID',
  `trace_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Trace ID',
  `user_id` bigint NOT NULL COMMENT 'User ID',
  `user_type` tinyint NOT NULL DEFAULT 0 COMMENT 'User type',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Module type',
  `sub_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Action name',
  `biz_id` bigint NOT NULL COMMENT 'Biz ID',
  `action` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Action content',
  `success` bit(1) NOT NULL DEFAULT b'1' COMMENT 'Action result',
  `extra` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Extra JSON',
  `request_method` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Request method',
  `request_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Request URL',
  `user_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'User IP',
  `user_agent` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'User agent',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
  INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10022 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Activity Logrecord V2 version';

-- ----------------------------
-- Records of system_operate_log
-- ----------------------------

-- ----------------------------
-- Table structure for system_post
-- ----------------------------
DROP TABLE IF EXISTS `system_post`;
CREATE TABLE `system_post`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Post ID',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Post code',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Post name',
  `sort` int NOT NULL COMMENT 'Sort',
  `status` tinyint NOT NULL COMMENT 'Status (0Normal 1 disable )',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Post';

-- ----------------------------
-- Records of system_post
-- ----------------------------

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'RoleID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Role name',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Role code',
  `sort` int NOT NULL COMMENT 'Sort',
  `data_scope` tinyint NOT NULL DEFAULT 1 COMMENT 'Data scope (1 all, 2 custom, 3 dept, 4 dept and below)',
  `data_scope_dept_ids` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Custom dept IDs',
  `status` tinyint NOT NULL COMMENT 'Role status (0Normal 1 disable )',
  `type` tinyint NOT NULL COMMENT 'Role type',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Role';

-- ----------------------------
-- Records of system_role
-- ----------------------------
BEGIN;
INSERT INTO `system_role` (`id`, `name`, `code`, `sort`, `data_scope`, `data_scope_dept_ids`, `status`, `type`, `remark`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`) VALUES (1, 'Super Admin', 'super_admin', 1, 1, '', 0, 1, 'Built-in super admin', 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0', 1);
COMMIT;

-- ----------------------------
-- Table structure for system_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_role_menu`;
CREATE TABLE `system_role_menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Auto ID',
  `role_id` bigint NOT NULL COMMENT 'RoleID',
  `menu_id` bigint NOT NULL COMMENT 'MenuID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9127 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Role menu';

-- ----------------------------
-- Records of system_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for system_sms_channel
-- ----------------------------
DROP TABLE IF EXISTS `system_sms_channel`;
CREATE TABLE `system_sms_channel`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `signature` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMS signature',
  `code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Channel code',
  `status` tinyint NOT NULL COMMENT 'Enable status',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `api_key` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMS API account',
  `api_secret` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'SMS API secret',
  `callback_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'SMS callback URL',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'SMS Channels';

-- ----------------------------
-- Records of system_sms_channel
-- ----------------------------

-- ----------------------------
-- Table structure for system_sms_code
-- ----------------------------
DROP TABLE IF EXISTS `system_sms_code`;
CREATE TABLE `system_sms_code`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Phone number',
  `code` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Verification code',
  `create_ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Create IP',
  `scene` tinyint NOT NULL COMMENT 'Send scene',
  `today_index` tinyint NOT NULL COMMENT 'Today send index',
  `used` tinyint NOT NULL COMMENT 'Is not used',
  `used_time` datetime NULL DEFAULT NULL COMMENT 'Used time',
  `used_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Used IP',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_mobile`(`mobile` ASC) USING BTREE COMMENT 'Phone number'
) ENGINE = InnoDB AUTO_INCREMENT = 694 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'SMS code';

-- ----------------------------
-- Records of system_sms_code
-- ----------------------------

-- ----------------------------
-- Table structure for system_sms_log
-- ----------------------------
DROP TABLE IF EXISTS `system_sms_log`;
CREATE TABLE `system_sms_log`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `channel_id` bigint NOT NULL COMMENT 'SMS channel code',
  `channel_code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMS channel code',
  `template_id` bigint NOT NULL COMMENT 'Template code',
  `template_code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template code',
  `template_type` tinyint NOT NULL COMMENT 'SMS type',
  `template_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMS content',
  `template_params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMS parameter',
  `api_template_id` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMS API template code',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Phone number',
  `user_id` bigint NULL DEFAULT NULL COMMENT 'User ID',
  `user_type` tinyint NULL DEFAULT NULL COMMENT 'User type',
  `send_status` tinyint NOT NULL DEFAULT 0 COMMENT 'Send status',
  `send_time` datetime NULL DEFAULT NULL COMMENT 'Send time',
  `api_send_code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'SMS API send result code',
  `api_send_msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'SMS API send failed Tip',
  `api_request_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'SMS API request ID',
  `api_serial_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'SMS API serial',
  `receive_status` tinyint NOT NULL DEFAULT 0 COMMENT 'Receive status',
  `receive_time` datetime NULL DEFAULT NULL COMMENT 'Receive time',
  `api_receive_code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'API Receive result code',
  `api_receive_msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'API Receive result Notes',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1638 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'SMS Logs';

-- ----------------------------
-- Records of system_sms_log
-- ----------------------------

-- ----------------------------
-- Table structure for system_sms_template
-- ----------------------------
DROP TABLE IF EXISTS `system_sms_template`;
CREATE TABLE `system_sms_template`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `type` tinyint NOT NULL COMMENT 'Template type',
  `status` tinyint NOT NULL COMMENT 'Enable status',
  `code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template code',
  `name` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template name',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template content',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Template params',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `api_template_id` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMS API template code',
  `channel_id` bigint NOT NULL COMMENT 'SMS channel code',
  `channel_code` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'SMS channel code',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'SMS Templates';

-- ----------------------------
-- Records of system_sms_template
-- ----------------------------

-- ----------------------------
-- Table structure for system_social_client
-- ----------------------------
DROP TABLE IF EXISTS `system_social_client`;
CREATE TABLE `system_social_client`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'App name',
  `social_type` tinyint NOT NULL COMMENT 'Social type',
  `user_type` tinyint NOT NULL COMMENT 'User type',
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Client code',
  `client_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Client secret',
  `agent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Agent ID',
  `public_key` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Public key',
  `status` tinyint NOT NULL COMMENT 'Status',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Social client';

-- ----------------------------
-- Records of system_social_client
-- ----------------------------

-- ----------------------------
-- Table structure for system_social_user
-- ----------------------------
DROP TABLE IF EXISTS `system_social_user`;
CREATE TABLE `system_social_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `type` tinyint NOT NULL COMMENT 'Social type',
  `openid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Social openid',
  `token` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Social token',
  `raw_token_info` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Raw token JSON',
  `nickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Nickname',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'User avatar',
  `raw_user_info` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Raw user JSON',
  `code` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Last auth code',
  `state` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Last auth state',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_type_openid`(`type` ASC, `openid` ASC) USING BTREE,
  INDEX `idx_type_code_state`(`type` ASC, `code` ASC, `state` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Social user';

-- ----------------------------
-- Records of system_social_user
-- ----------------------------

-- ----------------------------
-- Table structure for system_social_user_bind
-- ----------------------------
DROP TABLE IF EXISTS `system_social_user_bind`;
CREATE TABLE `system_social_user_bind`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'Primary key',
  `user_id` bigint NOT NULL COMMENT 'User ID',
  `user_type` tinyint NOT NULL COMMENT 'User type',
  `social_type` tinyint NOT NULL COMMENT 'Social type',
  `social_user_id` bigint NOT NULL COMMENT 'Social user code',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_type_social_user_id`(`user_type` ASC, `social_user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 165 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Social user bind';

-- ----------------------------
-- Records of system_social_user_bind
-- ----------------------------

-- ----------------------------
-- Table structure for system_tenant
-- ----------------------------
DROP TABLE IF EXISTS `system_tenant`;
CREATE TABLE `system_tenant`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Tenant ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Tenant name',
  `contact_user_id` bigint NULL DEFAULT NULL COMMENT 'Contact user ID',
  `contact_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Contact',
  `contact_mobile` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Contact mobile',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT 'Tenant status',
  `websites` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Bound websites',
  `package_id` bigint NOT NULL COMMENT 'Tenant plan code',
  `expire_time` datetime NOT NULL COMMENT 'Expires at',
  `account_count` int NOT NULL COMMENT 'Account quantity',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 162 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Tenant';

-- ----------------------------
-- Records of system_tenant
-- ----------------------------
BEGIN;
INSERT INTO `system_tenant` (`id`, `name`, `contact_user_id`, `contact_name`, `contact_mobile`, `status`, `websites`, `package_id`, `expire_time`, `account_count`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1, 'Overall', 1, 'Admin', '', 0, '127.0.0.1,localhost,127.0.0.1:80,localhost:80', 0, '2099-12-31 23:59:59', 9999, 'admin', '2021-01-05 17:03:47', 'admin', '2021-01-05 17:03:47', b'0');
COMMIT;

-- ----------------------------
-- Table structure for system_tenant_package
-- ----------------------------
DROP TABLE IF EXISTS `system_tenant_package`;
CREATE TABLE `system_tenant_package`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Plan ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Plan name',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT 'Tenant status (0Normal 1 disable )',
  `remark` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Notes',
  `menu_ids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Relation menu code',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Tenant plan';

-- ----------------------------
-- Records of system_tenant_package
-- ----------------------------

-- ----------------------------
-- Table structure for system_user_post
-- ----------------------------
DROP TABLE IF EXISTS `system_user_post`;
CREATE TABLE `system_user_post`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL DEFAULT 0 COMMENT 'UserID',
  `post_id` bigint NOT NULL DEFAULT 0 COMMENT 'Post ID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'User post';

-- ----------------------------
-- Records of system_user_post
-- ----------------------------

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Auto ID',
  `user_id` bigint NOT NULL COMMENT 'UserID',
  `role_id` bigint NOT NULL COMMENT 'RoleID',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'User role';

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
BEGIN;
INSERT INTO `system_user_role` (`id`, `user_id`, `role_id`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`) VALUES (1, 1, 1, 'admin', '2021-01-05 17:03:48', 'admin', '2021-01-05 17:03:48', b'0', 1);
COMMIT;

-- ----------------------------
-- Table structure for system_users
-- ----------------------------
DROP TABLE IF EXISTS `system_users`;
CREATE TABLE `system_users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'UserID',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Username',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Password',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Nickname',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Notes',
  `dept_id` bigint NULL DEFAULT NULL COMMENT 'DepartmentID',
  `post_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Post ID list',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'User email',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Mobile Number',
  `sex` tinyint NULL DEFAULT 0 COMMENT 'User gender',
  `avatar` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'AvatarAddress',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT 'Account status (0 enabled, 1 disabled)',
  `login_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Last sign-in IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT 'Last sign-in time',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_username`(`username` ASC) USING BTREE,
  INDEX `idx_mobile`(`mobile` ASC) USING BTREE,
  INDEX `idx_email`(`email` ASC) USING BTREE,
  INDEX `idx_dept_id`(`dept_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 249 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'User';

-- ----------------------------
-- Records of system_users
-- ----------------------------
BEGIN;
INSERT INTO `system_users` (`id`, `username`, `password`, `nickname`, `remark`, `dept_id`, `post_ids`, `email`, `mobile`, `sex`, `avatar`, `status`, `login_ip`, `login_date`, `creator`, `create_time`, `updater`, `update_time`, `deleted`, `tenant_id`) VALUES (1, 'admin', '$2a$04$.vd8nPeLwxt6hnSzmAoAyul8BOLX7Cib6QhcxRe30rfvrIPQHH1OG', 'Admin', 'Super Admin', 100, NULL, '', '', 1, '', 0, '', NULL, 'admin', '2021-01-05 17:03:47', 'admin', '2021-01-05 17:03:47', b'0', 1);
COMMIT;

-- ----------------------------
-- Table structure for yudao_demo01_contact
-- ----------------------------
DROP TABLE IF EXISTS `yudao_demo01_contact`;
CREATE TABLE `yudao_demo01_contact`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Name',
  `sex` tinyint(1) NOT NULL COMMENT 'Gender',
  `birthday` datetime NOT NULL COMMENT 'Birth year',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Bio',
  `avatar` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'Avatar',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Demo contact';

-- ----------------------------
-- Records of yudao_demo01_contact
-- ----------------------------

-- ----------------------------
-- Table structure for yudao_demo02_category
-- ----------------------------
DROP TABLE IF EXISTS `yudao_demo02_category`;
CREATE TABLE `yudao_demo02_category`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Name',
  `parent_id` bigint NOT NULL COMMENT 'Parent code',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Demo category';

-- ----------------------------
-- Records of yudao_demo02_category
-- ----------------------------

-- ----------------------------
-- Table structure for yudao_demo03_course
-- ----------------------------
DROP TABLE IF EXISTS `yudao_demo03_course`;
CREATE TABLE `yudao_demo03_course`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `student_id` bigint NOT NULL COMMENT 'Student ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Name',
  `score` tinyint NOT NULL COMMENT 'Score',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Demo student course';

-- ----------------------------
-- Records of yudao_demo03_course
-- ----------------------------

-- ----------------------------
-- Table structure for yudao_demo03_grade
-- ----------------------------
DROP TABLE IF EXISTS `yudao_demo03_grade`;
CREATE TABLE `yudao_demo03_grade`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `student_id` bigint NOT NULL COMMENT 'Student ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Name',
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Homeroom teacher',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Demo student class';

-- ----------------------------
-- Records of yudao_demo03_grade
-- ----------------------------

-- ----------------------------
-- Table structure for yudao_demo03_student
-- ----------------------------
DROP TABLE IF EXISTS `yudao_demo03_student`;
CREATE TABLE `yudao_demo03_student`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Code',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'Name',
  `sex` tinyint NOT NULL COMMENT 'Gender',
  `birthday` datetime NOT NULL COMMENT 'Date of birth',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Bio',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Creator',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'Updater',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Update time',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT 'Deleted',
  `tenant_id` bigint NOT NULL DEFAULT 0 COMMENT 'Tenant ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Demo student';

-- ----------------------------
-- Records of yudao_demo03_student
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

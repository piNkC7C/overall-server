package cn.iocoder.yudao.module.iot.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * iot 错误码枚举类
 * <p>
 * iot 系统，使用 1-050-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 产品相关 1-050-001-000 ============
    ErrorCode PRODUCT_NOT_EXISTS = new ErrorCode(1_050_001_000, "Product was not found.");
    ErrorCode PRODUCT_KEY_EXISTS = new ErrorCode(1_050_001_001, "Product key already exists.");
    ErrorCode PRODUCT_STATUS_NOT_DELETE = new ErrorCode(1_050_001_002, "Product status is published, is not alloweddelete.");
    ErrorCode PRODUCT_STATUS_NOT_ALLOW_THING_MODEL = new ErrorCode(1_050_001_003, "Product status is published, is not allowedaction thing model.");
    ErrorCode PRODUCT_DELETE_FAIL_HAS_DEVICE = new ErrorCode(1_050_001_004, "Product still has device, is not alloweddelete.");

    // ========== product thing model 1-050-002-000 ============
    ErrorCode THING_MODEL_NOT_EXISTS = new ErrorCode(1_050_002_000, "Product thing model was not found.");
    ErrorCode THING_MODEL_EXISTS_BY_PRODUCT_KEY = new ErrorCode(1_050_002_001, "ProductKey a matching product thing model already exists.");
    ErrorCode THING_MODEL_IDENTIFIER_EXISTS = new ErrorCode(1_050_002_002, "Exists is duplicated feature identifier.");
    ErrorCode THING_MODEL_NAME_EXISTS = new ErrorCode(1_050_002_003, "Exists is duplicated feature name.");
    ErrorCode THING_MODEL_IDENTIFIER_INVALID = new ErrorCode(1_050_002_003, "Product thing model key invalid.");

    // ========== device 1-050-003-000 ============
    ErrorCode DEVICE_NOT_EXISTS = new ErrorCode(1_050_003_000, "Device was not found.");
    ErrorCode DEVICE_NAME_EXISTS = new ErrorCode(1_050_003_001, "Device name in the same product must unique.");
    ErrorCode DEVICE_GATEWAY_HAS_SUB = new ErrorCode(1_050_003_002, "Gateway device exists already bind child device, is not alloweddelete.");
    ErrorCode DEVICE_KEY_EXISTS = new ErrorCode(1_050_003_003, "Device key already exists.");
    ErrorCode DEVICE_GATEWAY_NOT_EXISTS = new ErrorCode(1_050_003_004, "Gateway device was not found.");
    ErrorCode DEVICE_NOT_GATEWAY = new ErrorCode(1_050_003_005, "Device is not gateway device.");
    ErrorCode DEVICE_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_050_003_006, "Importdevice data is required!");
    ErrorCode DEVICE_DOWNSTREAM_FAILED_SERVER_ID_NULL = new ErrorCode(1_050_003_007, "Downlink devicemessage failed, : device not connect gateway.");
    ErrorCode DEVICE_SERIAL_NUMBER_EXISTS = new ErrorCode(1_050_003_008, "Device serial number already exists, serial number must globally unique.");
    ErrorCode DEVICE_NOT_GATEWAY_SUB = new ErrorCode(1_050_003_009, "Device[{}/{}] is not gateway child device type, cannot bind to gateway.");
    ErrorCode DEVICE_GATEWAY_BINDTO_EXISTS = new ErrorCode(1_050_003_010, "Device[{}/{}] already bind to its other gateway, first unbind.");
    // 拓扑管理相关错误码 1-050-003-100
    ErrorCode DEVICE_TOPO_PARAMS_INVALID = new ErrorCode(1_050_003_100, "Topology admin parameter invalid.");
    ErrorCode DEVICE_TOPO_SUB_DEVICE_USERNAME_INVALID = new ErrorCode(1_050_003_101, "Child device username format invalid.");
    ErrorCode DEVICE_TOPO_SUB_DEVICE_AUTH_FAILED = new ErrorCode(1_050_003_102, "Child device auth failed.");
    ErrorCode DEVICE_TOPO_SUB_NOT_BINDTO_GATEWAY = new ErrorCode(1_050_003_103, "Child device [{}/{}] not bind to this gateway.");
    // 设备注册相关错误码 1-050-003-200
    ErrorCode DEVICE_SUB_REGISTER_PARAMS_INVALID = new ErrorCode(1_050_003_200, "Child device register parameter invalid.");
    ErrorCode DEVICE_SUB_REGISTER_PRODUCT_NOT_GATEWAY_SUB = new ErrorCode(1_050_003_201, "Product[{}] is not gateway child device type.");
    ErrorCode DEVICE_REGISTER_DISABLED = new ErrorCode(1_050_003_210, "This product not enable dynamic registration feature.");
    ErrorCode DEVICE_REGISTER_SECRET_INVALID = new ErrorCode(1_050_003_211, "Product secret verify failed.");
    ErrorCode DEVICE_REGISTER_ALREADY_EXISTS = new ErrorCode(1_050_003_212, "Device already exists, is not allowed is duplicated register.");
    // 设备属性存储相关错误码 1-050-003-300
    ErrorCode DEVICE_PROPERTY_HISTORY_TIMES_INVALID = new ErrorCode(1_050_003_300, "Device property history time range, must include start 、 end two time.");
    ErrorCode DEVICE_PROPERTY_FIELD_NAME_INVALID = new ErrorCode(1_050_003_301, "Property identifier ({}) is invalid, cannot as storage field.");
    ErrorCode DEVICE_PROPERTY_FIELD_NAME_RESERVED = new ErrorCode(1_050_003_302, "Property identifier ({}) and storage reserved field({}) conflict.");
    ErrorCode DEVICE_PROPERTY_FIELD_NAME_DUPLICATE = new ErrorCode(1_050_003_303, "Property identifier ({}) and ({}) storage field({}) is duplicated.");

    // ========== product category 1-050-004-000 ==========
    ErrorCode PRODUCT_CATEGORY_NOT_EXISTS = new ErrorCode(1_050_004_000, "Product category was not found.");

    // ========== device group 1-050-005-000 ==========
    ErrorCode DEVICE_GROUP_NOT_EXISTS = new ErrorCode(1_050_005_000, "Device group was not found.");
    ErrorCode DEVICE_GROUP_DELETE_FAIL_DEVICE_EXISTS = new ErrorCode(1_050_005_001, "Device group still has device, is not alloweddelete.");

    // ========== device Modbus setting 1-050-006-000 ==========
    ErrorCode DEVICE_MODBUS_CONFIG_NOT_EXISTS = new ErrorCode(1_050_006_000, "Device Modbus connect setting was not found.");
    ErrorCode DEVICE_MODBUS_CONFIG_EXISTS = new ErrorCode(1_050_006_001, "Device Modbus connect setting already exists.");

    // ========== device Modbus point 1-050-007-000 ==========
    ErrorCode DEVICE_MODBUS_POINT_NOT_EXISTS = new ErrorCode(1_050_007_000, "Device Modbus point setting was not found.");
    ErrorCode DEVICE_MODBUS_POINT_EXISTS = new ErrorCode(1_050_007_001, "Device Modbus point setting already exists.");

    // ========== OTA 固件相关 1-050-008-000 ==========

    ErrorCode OTA_FIRMWARE_NOT_EXISTS = new ErrorCode(1_050_008_000, "Firmware info was not found.");
    ErrorCode OTA_FIRMWARE_PRODUCT_VERSION_DUPLICATE = new ErrorCode(1_050_008_001, "Product version is duplicated.");
    ErrorCode OTA_FIRMWARE_DELETE_FAIL_TASK_IN_PROGRESS = new ErrorCode(1_050_008_002,
            "Delete OTA firmware failed, : exists in progress upgrade job.");

    // ========== OTA 升级任务相关 1-050-008-100 ==========

    ErrorCode OTA_TASK_NOT_EXISTS = new ErrorCode(1_050_008_100, "Upgrade job was not found.");
    ErrorCode OTA_TASK_CREATE_FAIL_NAME_DUPLICATE = new ErrorCode(1_050_008_101, "Create OTA task failed, : task name is already used.");
    ErrorCode OTA_TASK_CREATE_FAIL_DEVICE_FIRMWARE_EXISTS = new ErrorCode(1_050_008_102,
            "Create OTA task failed, : device({}) already is this firmware version.");
    ErrorCode OTA_TASK_CREATE_FAIL_DEVICE_OTA_IN_PROCESS = new ErrorCode(1_050_008_102,
            "Create OTA task failed, : device({}) already in upgrade...");
    ErrorCode OTA_TASK_CREATE_FAIL_DEVICE_EMPTY = new ErrorCode(1_050_008_103, "Create OTA task failed, : has no can upgrade device.");
    ErrorCode OTA_TASK_CANCEL_FAIL_STATUS_END = new ErrorCode(1_050_008_104, "Cancel OTA task failed, : task status is not in progress.");

    // ========== OTA 升级任务记录相关 1-050-008-200 ==========

    ErrorCode OTA_TASK_RECORD_NOT_EXISTS = new ErrorCode(1_050_008_200, "Upgrade record was not found.");
    ErrorCode OTA_TASK_RECORD_CANCEL_FAIL_STATUS_ERROR = new ErrorCode(1_050_008_201, "Cancel OTA upgrade record failed, : record status is not in progress.");
    ErrorCode OTA_TASK_RECORD_UPDATE_PROGRESS_FAIL_NO_EXISTS = new ErrorCode(1_050_008_202, "Update OTA upgrade record progress failed, : this device has no in progress upgrade record.");

    // ========== IoT data flow rule 1-050-010-000 ==========
    ErrorCode DATA_RULE_NOT_EXISTS = new ErrorCode(1_050_010_000, "Data flow rule was not found.");
    ErrorCode DATA_RULE_NAME_EXISTS = new ErrorCode(1_050_010_001, "Data flow rule name already exists.");

    // ========== IoT data flow destination 1-050-011-000 ==========
    ErrorCode DATA_SINK_NOT_EXISTS = new ErrorCode(1_050_011_000, "Data bridge was not found.");
    ErrorCode DATA_SINK_DELETE_FAIL_USED_BY_RULE = new ErrorCode(1_050_011_001, "Data flow destination is currently by data flow rule used, cannot delete.");
    ErrorCode DATA_SINK_NAME_EXISTS = new ErrorCode(1_050_011_002, "Data flow destination name already exists.");

    // ========== IoT scene automation 1-050-012-000 ==========
    ErrorCode RULE_SCENE_NOT_EXISTS = new ErrorCode(1_050_012_000, "Scene automation was not found.");

    // ========== IoT alert setting 1-050-013-000 ==========
    ErrorCode ALERT_CONFIG_NOT_EXISTS = new ErrorCode(1_050_013_000, "IoT alert setting was not found.");
    ErrorCode ALERT_CONFIG_SMS_TEMPLATE_REQUIRED = new ErrorCode(1_050_013_001, "Already select SMS receive method, SMS template is required.");
    ErrorCode ALERT_CONFIG_MAIL_TEMPLATE_REQUIRED = new ErrorCode(1_050_013_002, "Already select email receive method, email template is required.");
    ErrorCode ALERT_CONFIG_NOTIFY_TEMPLATE_REQUIRED = new ErrorCode(1_050_013_003, "Already select inbox message receive method, inbox template is required.");

    // ========== IoT alert record 1-050-014-000 ==========
    ErrorCode ALERT_RECORD_NOT_EXISTS = new ErrorCode(1_050_014_000, "IoT alert record was not found.");

}

package cn.iocoder.yudao.module.mes.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * MES 错误码枚举类
 * <p>
 * mes 系统，使用 1-040-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== MES 基础数据-物料分类（1-040-100-000） ==========
    ErrorCode MD_ITEM_TYPE_NOT_EXISTS = new ErrorCode(1_040_100_000, "Materialcategory was not found.");
    ErrorCode MD_ITEM_TYPE_EXITS_CHILDREN = new ErrorCode(1_040_100_001, "Exists child category, cannot delete.");
    ErrorCode MD_ITEM_TYPE_PARENT_NOT_EXITS = new ErrorCode(1_040_100_002, "Parent category was not found.");
    ErrorCode MD_ITEM_TYPE_PARENT_ERROR = new ErrorCode(1_040_100_003, "Cannot set itself as parent category.");
    ErrorCode MD_ITEM_TYPE_NAME_DUPLICATE = new ErrorCode(1_040_100_004, "The same parent category already exists this name category.");
    ErrorCode MD_ITEM_TYPE_CODE_DUPLICATE = new ErrorCode(1_040_100_005, "The same parent category already exists this code category.");
    ErrorCode MD_ITEM_TYPE_PARENT_IS_CHILD = new ErrorCode(1_040_100_006, "Cannot set its own child category is parent category.");
    ErrorCode MD_ITEM_TYPE_EXITS_ITEM = new ErrorCode(1_040_100_007, "This category still has material, cannot delete.");
    ErrorCode MD_ITEM_TYPE_NOT_LEAF = new ErrorCode(1_040_100_008, "Can only material attach to leaf category ( this category still has child category).");

    // ========== MES 基础数据-计量单位（1-040-101-000） ==========
    ErrorCode MD_UNIT_MEASURE_NOT_EXISTS = new ErrorCode(1_040_101_000, "Unit of measure was not found.");
    ErrorCode MD_UNIT_MEASURE_CODE_DUPLICATE = new ErrorCode(1_040_101_001, "Unit of measure code already exists.");
    ErrorCode MD_UNIT_MEASURE_HAS_ITEM = new ErrorCode(1_040_101_002, "This unit of measure still has material, cannot delete.");
    ErrorCode MD_UNIT_MEASURE_HAS_SECONDARY = new ErrorCode(1_040_101_003, "This primary unit still has secondary unit, cannot delete.");
    ErrorCode MD_UNIT_MEASURE_HAS_TASK_ISSUE = new ErrorCode(1_040_101_004, "This unit of measure is already used by production material input referenced, cannot delete.");
    ErrorCode MD_UNIT_MEASURE_HAS_QC_TEMPLATE_INDICATOR = new ErrorCode(1_040_101_005, "This unit of measure is already used by quality inspection plan metric item referenced, cannot delete.");
    ErrorCode MD_UNIT_MEASURE_HAS_QC_LINE = new ErrorCode(1_040_101_006, "This unit of measure is already used by quality inspection document line referenced, cannot delete.");

    // ========== MES 基础数据-物料（1-040-102-000） ==========
    ErrorCode MD_ITEM_NOT_EXISTS = new ErrorCode(1_040_102_000, "Material was not found.");
    ErrorCode MD_ITEM_CODE_DUPLICATE = new ErrorCode(1_040_102_001, "Material code already exists.");
    ErrorCode MD_ITEM_NAME_DUPLICATE = new ErrorCode(1_040_102_002, "Material name already exists.");
    ErrorCode MD_ITEM_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_040_102_003, "Importmaterial data is required.");
    ErrorCode MD_ITEM_BATCH_REQUIRED = new ErrorCode(1_040_102_004, "Current material enable lot control, select lot.");
    ErrorCode MD_ITEM_IS_DISABLE = new ErrorCode(1_040_102_005, "Material is disabled.");

    // ========== MES 基础数据-物料批次属性配置（1-040-102-100） ==========
    ErrorCode MD_ITEM_BATCH_CONFIG_NOT_EXISTS = new ErrorCode(1_040_102_100, "Materiallot property setting was not found.");
    ErrorCode MD_ITEM_BATCH_CONFIG_AT_LEAST_ONE_FLAG = new ErrorCode(1_040_102_101, "Lot control already enable, at least need to need setting one lot attribute.");
    ErrorCode MD_ITEM_PRODUCT_BOM_REQUIRED = new ErrorCode(1_040_102_102, "Product class material before enabling, must setting at least one BOM component.");

    // ========== MES warehouse admin - lot control (1-040-717-000) ==========
    ErrorCode WM_BATCH_PRODUCE_DATE_REQUIRED = new ErrorCode(1_040_717_000, "Lotsetting require production date is required.");
    ErrorCode WM_BATCH_RECEIPT_DATE_REQUIRED = new ErrorCode(1_040_717_001, "Lotsetting require inbound date is required.");
    ErrorCode WM_BATCH_EXPIRE_DATE_REQUIRED = new ErrorCode(1_040_717_002, "Lotsetting require expiration date is required.");
    ErrorCode WM_BATCH_VENDOR_REQUIRED = new ErrorCode(1_040_717_003, "Lotsetting require supplier is required.");
    ErrorCode WM_BATCH_CLIENT_REQUIRED = new ErrorCode(1_040_717_004, "Lotsetting require customer is required.");
    ErrorCode WM_BATCH_PURCHASE_ORDER_CODE_REQUIRED = new ErrorCode(1_040_717_005, "Lotsetting require purchase order code is required.");
    ErrorCode WM_BATCH_CUSTOMER_ORDER_CODE_REQUIRED = new ErrorCode(1_040_717_006, "Lotsetting require sales order code is required.");
    ErrorCode WM_BATCH_WORK_ORDER_REQUIRED = new ErrorCode(1_040_717_007, "Lotsetting require production work order is required.");
    ErrorCode WM_BATCH_TASK_REQUIRED = new ErrorCode(1_040_717_008, "Lotsetting require production task is required.");
    ErrorCode WM_BATCH_WORKSTATION_REQUIRED = new ErrorCode(1_040_717_009, "Lotsetting require workstation is required.");
    ErrorCode WM_BATCH_TOOL_REQUIRED = new ErrorCode(1_040_717_010, "Lotsetting require tool is required.");
    ErrorCode WM_BATCH_MOLD_REQUIRED = new ErrorCode(1_040_717_011, "Lotsetting require mold is required.");
    ErrorCode WM_BATCH_LOT_NUMBER_REQUIRED = new ErrorCode(1_040_717_012, "Lotsetting require production lot is required.");
    ErrorCode WM_BATCH_QUALITY_STATUS_REQUIRED = new ErrorCode(1_040_717_013, "Lotsetting require quality status is required.");
    ErrorCode WM_BATCH_NOT_EXISTS = new ErrorCode(1_040_717_014, "Lot was not found.");
    ErrorCode WM_BATCH_ITEM_MISMATCH = new ErrorCode(1_040_717_015, "Lot does not belong to current material.");
    ErrorCode WM_BATCH_CLIENT_MISMATCH = new ErrorCode(1_040_717_016, "Lot does not belong to current customer.");
    ErrorCode WM_BATCH_VENDOR_MISMATCH = new ErrorCode(1_040_717_017, "Lot does not belong to current supplier.");

    // ========== MES 基础数据-客户（1-040-103-000） ==========
    ErrorCode MD_CLIENT_NOT_EXISTS = new ErrorCode(1_040_103_000, "Customer was not found.");
    ErrorCode MD_CLIENT_CODE_DUPLICATE = new ErrorCode(1_040_103_001, "Customer code already exists.");
    ErrorCode MD_CLIENT_NAME_DUPLICATE = new ErrorCode(1_040_103_002, "Customer name already exists.");
    ErrorCode MD_CLIENT_NICKNAME_DUPLICATE = new ErrorCode(1_040_103_003, "Customer short name already exists.");
    ErrorCode MD_CLIENT_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_040_103_004, "Importcustomer data is required.");
    ErrorCode MD_CLIENT_IS_DISABLE = new ErrorCode(1_040_103_005, "Customer is disabled.");

    // ========== MES 基础数据-供应商（1-040-104-000） ==========
    ErrorCode MD_VENDOR_NOT_EXISTS = new ErrorCode(1_040_104_000, "Supplier was not found.");
    ErrorCode MD_VENDOR_CODE_DUPLICATE = new ErrorCode(1_040_104_001, "Supplier code already exists.");
    ErrorCode MD_VENDOR_NAME_DUPLICATE = new ErrorCode(1_040_104_002, "Supplier name already exists.");
    ErrorCode MD_VENDOR_NICKNAME_DUPLICATE = new ErrorCode(1_040_104_003, "Supplier short name already exists.");
    ErrorCode MD_VENDOR_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_040_104_004, "Importsupplier data is required.");
    ErrorCode MD_VENDOR_HAS_REFERENCE = new ErrorCode(1_040_104_005, "This supplier is already used by its other business referenced, cannot delete.");
    ErrorCode MD_VENDOR_IS_DISABLE = new ErrorCode(1_040_104_006, "Supplier is disabled.");

    // ========== MES 基础数据-车间（1-040-105-000） ==========
    ErrorCode MD_WORKSHOP_NOT_EXISTS = new ErrorCode(1_040_105_000, "Workshop was not found.");
    ErrorCode MD_WORKSHOP_CODE_DUPLICATE = new ErrorCode(1_040_105_001, "Workshop code already exists.");
    ErrorCode MD_WORKSHOP_NAME_DUPLICATE = new ErrorCode(1_040_105_002, "Workshop name already exists.");
    ErrorCode MD_WORKSHOP_HAS_WORKSTATION = new ErrorCode(1_040_105_003, "Workshop still has workstation, cannot delete.");

    // ========== MES 基础数据-工作站（1-040-106-000） ==========
    ErrorCode MD_WORKSTATION_NOT_EXISTS = new ErrorCode(1_040_106_000, "Workstation was not found.");
    ErrorCode MD_WORKSTATION_CODE_DUPLICATE = new ErrorCode(1_040_106_001, "Workstation code already exists.");
    ErrorCode MD_WORKSTATION_NAME_DUPLICATE = new ErrorCode(1_040_106_002, "Workstation name already exists.");
    ErrorCode MD_WORKSTATION_IS_DISABLE = new ErrorCode(1_040_106_003, "Workstation is disabled.");
    // ========== MES 基础数据-设备资源（1-040-106-100） ==========
    ErrorCode MD_WORKSTATION_MACHINE_NOT_EXISTS = new ErrorCode(1_040_106_100, "Device resource record was not found.");
    ErrorCode MD_WORKSTATION_MACHINE_EXISTS = new ErrorCode(1_040_106_101, "This device already assigned to workstation：{}.");
    // ========== MES 基础数据-工装夹具资源（1-040-106-200） ==========
    ErrorCode MD_WORKSTATION_TOOL_NOT_EXISTS = new ErrorCode(1_040_106_200, "Fixture resource record was not found.");
    ErrorCode MD_WORKSTATION_TOOL_TYPE_EXISTS = new ErrorCode(1_040_106_201, "This tool type already in this workstation exists.");
    // ========== MES 基础数据-人力资源（1-040-106-300） ==========
    ErrorCode MD_WORKSTATION_WORKER_NOT_EXISTS = new ErrorCode(1_040_106_300, "Labor resource record was not found.");
    ErrorCode MD_WORKSTATION_WORKER_POST_EXISTS = new ErrorCode(1_040_106_301, "This job title already in this workstation exists.");

    // ========== MES 基础数据-产品BOM（1-040-107-000） ==========
    ErrorCode MD_PRODUCT_BOM_NOT_EXISTS = new ErrorCode(1_040_107_000, "ProductBOM was not found.");
    ErrorCode MD_PRODUCT_BOM_SELF_REFERENCE = new ErrorCode(1_040_107_001, "Product cannot as itself BOM material.");
    ErrorCode MD_PRODUCT_BOM_CIRCULAR = new ErrorCode(1_040_107_002, "BOM materials form a cycle and cannot be added.");
    ErrorCode MD_PRODUCT_BOM_ITEM_INVALID = new ErrorCode(1_040_107_003, "Select BOM material does not belong to current product.");

    // ========== MES 基础数据-产品SOP（1-040-108-000） ==========
    ErrorCode MD_PRODUCT_SOP_NOT_EXISTS = new ErrorCode(1_040_108_000, "ProductSOP was not found.");
    ErrorCode MD_PRODUCT_SOP_SORT_DUPLICATE = new ErrorCode(1_040_108_001, "This display order already exists.");

    // ========== MES 基础数据-产品SIP（1-040-109-000） ==========
    ErrorCode MD_PRODUCT_SIP_NOT_EXISTS = new ErrorCode(1_040_109_000, "ProductSIP was not found.");
    ErrorCode MD_PRODUCT_SIP_SORT_DUPLICATE = new ErrorCode(1_040_109_001, "This display order already exists.");

    // ========== MES 基础数据-编码规则（1-040-110-000） ==========
    ErrorCode AUTO_CODE_RULE_NOT_EXISTS = new ErrorCode(1_040_110_000, "Coderule was not found.");
    ErrorCode AUTO_CODE_RULE_CODE_DUPLICATE = new ErrorCode(1_040_110_001, "Rule code already exists.");
    ErrorCode AUTO_CODE_PART_NOT_EXISTS = new ErrorCode(1_040_110_002, "Rule component was not found.");
    ErrorCode AUTO_CODE_REDIS_ERROR = new ErrorCode(1_040_110_003, "Codecreate service unavailable, please later retry.");
    ErrorCode AUTO_CODE_GENERATE_FAILED = new ErrorCode(1_040_110_004, "Codecreate failed.");
    ErrorCode AUTO_CODE_PART_SERIAL_NUMBER_DUPLICATE = new ErrorCode(1_040_110_005, "Sequence number segment can only exists one.");
    ErrorCode AUTO_CODE_PART_FIXED_CHAR_DUPLICATE = new ErrorCode(1_040_110_006, "Fixed text and its other coding rule the same, change fixed text.");

    // ========== MES 日历排班-计划班次（1-040-200-000） ==========
    ErrorCode CAL_PLAN_SHIFT_NOT_EXISTS = new ErrorCode(1_040_200_000, "Plan shift was not found.");
    ErrorCode CAL_PLAN_SHIFT_COUNT_EXCEED = new ErrorCode(1_040_200_001, "Shift quantity already reached rotation method limit.");

    // ========== MES 日历排班-班组（1-040-201-000） ==========
    ErrorCode CAL_TEAM_NOT_EXISTS = new ErrorCode(1_040_201_000, "Team was not found.");
    ErrorCode CAL_TEAM_CODE_DUPLICATE = new ErrorCode(1_040_201_001, "Team code already exists.");
    // ========== MES 日历排班-班组成员（1-040-201-100） ==========
    ErrorCode CAL_TEAM_MEMBER_NOT_EXISTS = new ErrorCode(1_040_201_100, "Team member was not found.");
    ErrorCode CAL_TEAM_MEMBER_USER_DUPLICATE = new ErrorCode(1_040_201_101, "This user already assign to its other team.");
    ErrorCode CAL_TEAM_MEMBER_USER_NOT_EXISTS = new ErrorCode(1_040_201_102, "User was not found.");
    // ========== MES 日历排班-班组排班（1-040-201-200） ==========
    ErrorCode CAL_TEAM_SHIFT_NOT_EXISTS = new ErrorCode(1_040_201_200, "Team schedule record was not found.");
    ErrorCode CAL_TEAM_SHIFT_GENERATE_TEAM_NOT_ENOUGH = new ErrorCode(1_040_201_201, "Team quantity not meet rotation method require.");
    ErrorCode CAL_TEAM_SHIFT_GENERATE_SHIFT_NOT_ENOUGH = new ErrorCode(1_040_201_202, "Shift quantity not meet rotation method require.");
    ErrorCode CAL_TEAM_SHIFT_GENERATE_SHIFT_COUNT_INVALID = new ErrorCode(1_040_201_203, "Day-based rotation requires a valid rotation-day count.");
    ErrorCode CAL_TEAM_SHIFT_GENERATE_SHIFT_METHOD_INVALID = new ErrorCode(1_040_201_204, "Not support shift rotation method ：{}.");
    ErrorCode CAL_TEAM_SHIFT_GENERATE_SHIFT_TIME_INVALID = new ErrorCode(1_040_201_205, "Shift [{}] start or end time format is invalid, should be HH:mm, end time can be 24:00.");
    ErrorCode CAL_TEAM_SHIFT_GENERATE_REST_INVALID = new ErrorCode(1_040_201_206,
            "Team [{}]{} {} and {} {} work time overlap or are contiguous, has no rest gap, please adjust shift time or shift rotation method.");

    // ========== MES 日历排班-排班计划（1-040-202-000） ==========
    ErrorCode CAL_PLAN_NOT_EXISTS = new ErrorCode(1_040_202_000, "Schedule plan was not found.");
    ErrorCode CAL_PLAN_CODE_DUPLICATE = new ErrorCode(1_040_202_001, "Schedule plan code already exists.");
    ErrorCode CAL_PLAN_NOT_PREPARE = new ErrorCode(1_040_202_002, "Schedule plan already confirm, is not allowed edit or delete.");
    ErrorCode CAL_PLAN_TEAM_COUNT_NOT_MATCH = new ErrorCode(1_040_202_003, "Confirm schedule plan time, assign team quantity and rotation method does not match.");
    // ========== MES 日历排班-计划班组关联（1-040-202-100） ==========
    ErrorCode CAL_PLAN_TEAM_NOT_EXISTS = new ErrorCode(1_040_202_100, "Plan team relation was not found.");
    ErrorCode CAL_PLAN_TEAM_DUPLICATE = new ErrorCode(1_040_202_101, "This team already assign to this plan.");

    // ========== MES 日历排班-假期设置（1-040-203-000） ==========
    ErrorCode CAL_HOLIDAY_NOT_EXISTS = new ErrorCode(1_040_203_000, "Holiday set was not found.");
    ErrorCode CAL_HOLIDAY_PLAN_CONFIRMED = new ErrorCode(1_040_203_001,
            "{} in already confirm schedule plan[{}] in the range of, edit is not holiday will and already created by schedule do not match, is not allowed edit.");

    // ========== MES device admin -device type (1-040-300-000) ==========
    ErrorCode DV_MACHINERY_TYPE_NOT_EXISTS = new ErrorCode(1_040_300_000, "Device type was not found.");
    ErrorCode DV_MACHINERY_TYPE_EXITS_CHILDREN = new ErrorCode(1_040_300_001, "Exists child type, cannot delete.");
    ErrorCode DV_MACHINERY_TYPE_PARENT_NOT_EXITS = new ErrorCode(1_040_300_002, "Parent type was not found.");
    ErrorCode DV_MACHINERY_TYPE_PARENT_ERROR = new ErrorCode(1_040_300_003, "Cannot set itself as parent type.");
    ErrorCode DV_MACHINERY_TYPE_NAME_DUPLICATE = new ErrorCode(1_040_300_004, "The same parent type already exists this name.");
    ErrorCode DV_MACHINERY_TYPE_CODE_DUPLICATE = new ErrorCode(1_040_300_005, "Device type code already exists.");
    ErrorCode DV_MACHINERY_TYPE_PARENT_IS_CHILD = new ErrorCode(1_040_300_006, "Cannot set its own child type is parent type.");
    ErrorCode DV_MACHINERY_TYPE_HAS_MACHINERY = new ErrorCode(1_040_300_007, "This type still has device, cannot delete.");

    // ========== MES 设备管理-设备台账（1-040-301-000） ==========
    ErrorCode DV_MACHINERY_NOT_EXISTS = new ErrorCode(1_040_301_000, "Device was not found.");
    ErrorCode DV_MACHINERY_CODE_DUPLICATE = new ErrorCode(1_040_301_001, "Device code already exists.");
    ErrorCode DV_MACHINERY_IS_DISABLE = new ErrorCode(1_040_301_007, "Device is disabled.");
    ErrorCode DV_MACHINERY_IMPORT_LIST_IS_EMPTY = new ErrorCode(1_040_301_002, "Importdevice data is required.");
    ErrorCode DV_MACHINERY_HAS_CHECK_PLAN = new ErrorCode(1_040_301_003, "Device already relation inspection plan, cannot delete.");
    ErrorCode DV_MACHINERY_HAS_CHECK_RECORD = new ErrorCode(1_040_301_004, "Device already relation inspection record, cannot delete.");
    ErrorCode DV_MACHINERY_HAS_MAINTEN_RECORD = new ErrorCode(1_040_301_005, "Device already relation maintenance record, cannot delete.");
    ErrorCode DV_MACHINERY_HAS_REPAIR = new ErrorCode(1_040_301_006, "Device already related maintenancework order, cannot delete.");

    // ========== MES device admin - inspection and maintenance item (1-040-304-000) ==========
    ErrorCode DV_SUBJECT_NOT_EXISTS = new ErrorCode(1_040_304_000, "Inspection and maintenance project was not found.");
    ErrorCode DV_SUBJECT_CODE_DUPLICATE = new ErrorCode(1_040_304_001, "Project code already exists.");
    ErrorCode DV_SUBJECT_USED_BY_CHECK_PLAN = new ErrorCode(1_040_304_002, "Inspection and maintenance project is already used by inspection and maintenance plan used, cannot delete.");
    ErrorCode DV_SUBJECT_IS_DISABLE = new ErrorCode(1_040_304_003, "Inspection and maintenance project is disabled.");

    // ========== MES device admin - inspection plan (1-040-302-000) ==========
    ErrorCode DV_CHECK_PLAN_NOT_EXISTS = new ErrorCode(1_040_302_000, "Inspection plan was not found.");
    ErrorCode DV_CHECK_PLAN_CODE_DUPLICATE = new ErrorCode(1_040_302_001, "Inspection and maintenance plan code already exists.");
    ErrorCode DV_CHECK_PLAN_NOT_PREPARE = new ErrorCode(1_040_302_002, "Inspection and maintenance plan already enable, is not allowed edit or delete.");
    ErrorCode DV_CHECK_PLAN_NO_MACHINERY = new ErrorCode(1_040_302_003, "Enable plan time, at least need to need relation one device.");
    ErrorCode DV_CHECK_PLAN_NO_SUBJECT = new ErrorCode(1_040_302_004, "Enable plan time, at least need to need relation one inspection and maintenance item.");
    ErrorCode DV_CHECK_PLAN_NOT_ENABLED = new ErrorCode(1_040_302_005, "Inspection and maintenance plan is not enabled, is not allowed disable.");
    ErrorCode DV_CHECK_PLAN_TYPE_MISMATCH = new ErrorCode(1_040_302_006, "Inspection and maintenance plan type and current business does not match.");
    ErrorCode DV_CHECK_PLAN_NOT_ENABLED_FOR_RECORD = new ErrorCode(1_040_302_007, "Inspection and maintenance plan is not enabled, is not allowedcreaterecord.");
    // ========== MES device admin - inspection plan device (1-040-302-100) ==========
    ErrorCode DV_CHECK_PLAN_MACHINERY_NOT_EXISTS = new ErrorCode(1_040_302_100, "Inspection and maintenance plandevice was not found.");
    ErrorCode DV_CHECK_PLAN_MACHINERY_DUPLICATE = new ErrorCode(1_040_302_101, "This device already related to current plan, please do not is duplicated add.");
    ErrorCode DV_CHECK_PLAN_MACHINERY_EXISTS_IN_SAME_TYPE = new ErrorCode(1_040_302_102, "This equipment is already in another enabled or draft plan of the same type.");
    // ========== MES device admin - inspection plan item (1-040-302-200) ==========
    ErrorCode DV_CHECK_PLAN_SUBJECT_NOT_EXISTS = new ErrorCode(1_040_302_200, "Inspection and maintenance planproject was not found.");
    ErrorCode DV_CHECK_PLAN_SUBJECT_DUPLICATE = new ErrorCode(1_040_302_201, "This project already related to current plan, please do not is duplicated add.");

    // ========== MES device admin - repair work order (1-040-303-000) ==========
    ErrorCode DV_REPAIR_NOT_EXISTS = new ErrorCode(1_040_303_000, "Maintenancework order was not found.");
    ErrorCode DV_REPAIR_NOT_PREPARE = new ErrorCode(1_040_303_001, "Maintenancework order is not draft status, is not allowed edit or delete.");
    ErrorCode DV_REPAIR_CODE_DUPLICATE = new ErrorCode(1_040_303_002, "Maintenancework order code already exists.");
    ErrorCode DV_REPAIR_NOT_CONFIRMED = new ErrorCode(1_040_303_003, "Only maintenance status maintenancework order can completemaintenance.");
    ErrorCode DV_REPAIR_NOT_APPROVING = new ErrorCode(1_040_303_004, "Only pending acceptance status repair work order can accept.");
    // ========== MES device admin - repair work order line (1-040-303-100) ==========
    ErrorCode DV_REPAIR_LINE_NOT_EXISTS = new ErrorCode(1_040_303_100, "Maintenancework order line was not found.");

    // ========== MES device admin - maintenance record (1-040-305-000) ==========
    ErrorCode MAINTEN_RECORD_NOT_EXISTS = new ErrorCode(1_040_305_000, "Device maintenance record was not found.");
    ErrorCode MAINTEN_RECORD_NOT_DRAFT = new ErrorCode(1_040_305_001, "Device maintenance record already submit, is not allowed edit or delete.");
    ErrorCode MAINTEN_RECORD_NO_LINE = new ErrorCode(1_040_305_002, "Submit maintenance record time, at least need to need one item maintenance item.");
    // ========== MES device admin - maintenance recorddetail (1-040-305-100) ==========
    ErrorCode MAINTEN_RECORD_LINE_NOT_EXISTS = new ErrorCode(1_040_305_100, "Device maintenance recorddetail was not found.");

    // ========== MES device admin - inspection record (1-040-306-000) ==========
    ErrorCode DV_CHECK_RECORD_NOT_EXISTS = new ErrorCode(1_040_306_000, "Device inspection record was not found.");
    ErrorCode DV_CHECK_RECORD_NOT_DRAFT = new ErrorCode(1_040_306_001, "Device inspection recordcompleted, is not allowed edit or delete.");
    ErrorCode DV_CHECK_RECORD_NO_LINE = new ErrorCode(1_040_306_002, "Submit inspection record time, at least need to need one item inspection item.");
    // ========== MES device admin - inspection recorddetail (1-040-306-100) ==========
    ErrorCode DV_CHECK_RECORD_LINE_NOT_EXISTS = new ErrorCode(1_040_306_100, "Device inspection recorddetail was not found.");

    // ========== MES tool admin -tool type (1-040-400-000) ==========
    ErrorCode TM_TOOL_TYPE_NOT_EXISTS = new ErrorCode(1_040_400_000, "Tool type was not found.");
    ErrorCode TM_TOOL_TYPE_CODE_DUPLICATE = new ErrorCode(1_040_400_001, "Tool type code already exists.");
    ErrorCode TM_TOOL_TYPE_NAME_DUPLICATE = new ErrorCode(1_040_400_002, "Tool type name already exists.");
    ErrorCode TM_TOOL_TYPE_HAS_TOOL = new ErrorCode(1_040_400_003, "This tool type still has tool, cannot delete.");
    ErrorCode TM_TOOL_TYPE_HAS_WORKSTATION_TOOL = new ErrorCode(1_040_400_004, "This tool type is used by workstation tooling and cannot be deleted.");

    // ========== MES 工具管理-工具台账（1-040-401-000） ==========
    ErrorCode TM_TOOL_NOT_EXISTS = new ErrorCode(1_040_401_000, "Tool was not found.");
    ErrorCode TM_TOOL_CODE_DUPLICATE = new ErrorCode(1_040_401_001, "Tool code already exists.");
    ErrorCode TM_TOOL_HAS_BATCH = new ErrorCode(1_040_401_002, "This tool is already used by lot referenced, cannot delete.");

    // ========== MES production admin -operation (1-040-500-000) ==========
    ErrorCode PRO_PROCESS_NOT_EXISTS = new ErrorCode(1_040_500_000, "Operation was not found.");
    ErrorCode PRO_PROCESS_CODE_EXISTS = new ErrorCode(1_040_500_001, "Operation code already exists.");
    ErrorCode PRO_PROCESS_NAME_EXISTS = new ErrorCode(1_040_500_002, "Operation name already exists.");
    ErrorCode PRO_PROCESS_USED_BY_ROUTE = new ErrorCode(1_040_500_003, "Operation is already used by routing path referenced, cannot delete.");
    ErrorCode PRO_PROCESS_IS_DISABLE = new ErrorCode(1_040_500_004, "Operation is disabled.");
    // ========== MES production admin -operation content (1-040-500-100) ==========
    ErrorCode PRO_PROCESS_CONTENT_NOT_EXISTS = new ErrorCode(1_040_500_100, "Operation content was not found.");

    // ========== MES production admin -routing path (1-040-501-000) ==========
    ErrorCode PRO_ROUTE_NOT_EXISTS = new ErrorCode(1_040_501_000, "Routing path was not found.");
    ErrorCode PRO_ROUTE_CODE_DUPLICATE = new ErrorCode(1_040_501_001, "Routing path code already exists.");
    ErrorCode PRO_ROUTE_ENABLE_NO_PROCESS = new ErrorCode(1_040_501_002, "First add component operation.");
    ErrorCode PRO_ROUTE_ENABLE_NO_KEY_PROCESS = new ErrorCode(1_040_501_003, "The routing must include a key operation.");
    ErrorCode PRO_ROUTE_ENABLE_PRODUCT_NO_BOM = new ErrorCode(1_040_501_004, "Product {} has no BOM consumption configured for the operation.");
    ErrorCode PRO_ROUTE_IS_ENABLE = new ErrorCode(1_040_501_005, "Routing path already enable, is not allowedaction.");
    // ========== MES production admin -routing pathoperation (1-040-501-100) ==========
    ErrorCode PRO_ROUTE_PROCESS_NOT_EXISTS = new ErrorCode(1_040_501_100, "Routing pathoperation was not found.");
    ErrorCode PRO_ROUTE_PROCESS_SORT_DUPLICATE = new ErrorCode(1_040_501_101, "The sequence number already exists.");
    ErrorCode PRO_ROUTE_PROCESS_DUPLICATE = new ErrorCode(1_040_501_102, "Cannot is duplicated add operation.");
    ErrorCode PRO_ROUTE_PROCESS_KEY_DUPLICATE = new ErrorCode(1_040_501_103, "This routing already has a key operation.");
    // ========== MES production admin -routing pathproduct (1-040-501-200) ==========
    ErrorCode PRO_ROUTE_PRODUCT_NOT_EXISTS = new ErrorCode(1_040_501_200, "Routing pathproduct was not found.");
    ErrorCode PRO_ROUTE_PRODUCT_ITEM_DUPLICATE = new ErrorCode(1_040_501_201, "This product already setting routing path.");
    // ========== MES production admin -routing pathproductBOM (1-040-501-300) ==========
    ErrorCode PRO_ROUTE_PRODUCT_BOM_NOT_EXISTS = new ErrorCode(1_040_501_300, "Routing pathproduct BOM was not found.");
    ErrorCode PRO_ROUTE_PRODUCT_BOM_DUPLICATE = new ErrorCode(1_040_501_301, "This BOM material is already configured on the operation.");

    // ========== MES production admin -production work order (1-040-502-000) ==========
    ErrorCode PRO_WORK_ORDER_NOT_EXISTS = new ErrorCode(1_040_502_000, "Production work order was not found.");
    ErrorCode PRO_WORK_ORDER_CODE_DUPLICATE = new ErrorCode(1_040_502_001, "Production work order code already exists.");
    ErrorCode PRO_WORK_ORDER_NOT_PREPARE = new ErrorCode(1_040_502_002, "Only draft status work order can execute this action.");
    ErrorCode PRO_WORK_ORDER_NOT_CONFIRMED = new ErrorCode(1_040_502_003, "Only already confirm status work order can execute this action.");
    ErrorCode PRO_WORK_ORDER_HAS_CHILDREN = new ErrorCode(1_040_502_004, "Exists child work order, cannot delete.");
    ErrorCode PRO_WORK_ORDER_PRODUCT_MISMATCH = new ErrorCode(1_040_502_005, "Current productmaterial and production work orderproduct do not match.");
    ErrorCode PRO_WORK_ORDER_BOM_NOT_EXISTS = new ErrorCode(1_040_502_100, "Production work orderBOM was not found.");

    // ========== MES production admin - production task (1-040-503-000) ==========
    ErrorCode PRO_TASK_NOT_EXISTS = new ErrorCode(1_040_503_000, "Production task was not found.");
    ErrorCode PRO_TASK_ALREADY_FINISHED = new ErrorCode(1_040_503_001, "The production task is completed or canceled and cannot be changed.");
    ErrorCode PRO_TASK_WORK_ORDER_MISMATCH = new ErrorCode(1_040_503_002, "Production task does not belong to current production work order.");
    ErrorCode PRO_TASK_WORKSTATION_MISMATCH = new ErrorCode(1_040_503_003, "Production task does not belong to current workstation.");
    ErrorCode PRO_TASK_ROUTE_PROCESS_MISMATCH = new ErrorCode(1_040_503_004, "Production task and current routing path or operation do not match.");
    ErrorCode PRO_TASK_ITEM_MISMATCH = new ErrorCode(1_040_503_005, "Production taskproduct and current productmaterial do not match.");
    ErrorCode PRO_WORKSTATION_PROCESS_MISMATCH = new ErrorCode(1_040_503_006, "Workstation belonging operation and current operation do not match.");
    // ========== MES production admin - production task material input (1-040-503-100) ==========
    ErrorCode PRO_TASK_ISSUE_NOT_EXISTS = new ErrorCode(1_040_503_100, "Production task material input record was not found.");

    // ========== MES 生产管理-安灯呼叫配置（1-040-504-000） ==========
    ErrorCode PRO_ANDON_CONFIG_NOT_EXISTS = new ErrorCode(1_040_504_000, "Andon call setting not found.");

    // ========== MES 生产管理-安灯呼叫记录（1-040-505-000） ==========
    ErrorCode PRO_ANDON_RECORD_NOT_EXISTS = new ErrorCode(1_040_505_000, "Andon call record not found.");
    ErrorCode PRO_ANDON_RECORD_ALREADY_HANDLED = new ErrorCode(1_040_505_001, "This Andon record is already handled.");
    ErrorCode PRO_ANDON_RECORD_HANDLE_TIME_REQUIRED = new ErrorCode(1_040_505_002, "Handled time is required when marking as handled.");
    ErrorCode PRO_ANDON_RECORD_HANDLER_USER_REQUIRED = new ErrorCode(1_040_505_003, "Handler is required when marking as handled.");

    // ========== MES production admin - production work report (1-040-506-000) ==========
    ErrorCode PRO_FEEDBACK_NOT_EXISTS = new ErrorCode(1_040_506_000, "Production work report was not found.");
    ErrorCode PRO_FEEDBACK_NOT_PREPARE = new ErrorCode(1_040_506_001, "Can only edit or deletedraft status report work order.");
    ErrorCode PRO_FEEDBACK_NOT_APPROVING = new ErrorCode(1_040_506_002, "Only approval status report work order can execute this action.");
    ErrorCode PRO_FEEDBACK_NOT_UNCHECK = new ErrorCode(1_040_506_003, "Only pending inspection status report work order can complete inspection.");
    ErrorCode PRO_FEEDBACK_QUANTITY_EXCEED = new ErrorCode(1_040_506_004, "Reported quantity cannot exceed the scheduled quantity.");
    ErrorCode PRO_FEEDBACK_STATUS_ERROR = new ErrorCode(1_040_506_005, "Report work order status is invalid, cannot execute this action.");
    ErrorCode PRO_FEEDBACK_WORK_ORDER_NOT_CONFIRMED = new ErrorCode(1_040_506_006, "Relation work order not confirm, cannot create work report.");
    ErrorCode PRO_FEEDBACK_QUALIFIED_UNQUALIFIED_MISMATCH = new ErrorCode(1_040_506_007, "Good quantity plus defect quantity must equal the reported quantity.");
    ErrorCode PRO_FEEDBACK_ROUTE_PROCESS_INVALID = new ErrorCode(1_040_506_008, "Not find to a matching routingoperationsetting, please check routing path and operation.");
    ErrorCode PRO_FEEDBACK_TASK_OR_ORDER_FINISHED = new ErrorCode(1_040_506_009, "The production task or work order is complete, so reporting is not allowed.");
    ErrorCode PRO_FEEDBACK_QUANTITY_MUST_POSITIVE = new ErrorCode(1_040_506_010, "Work report quantity must large at 0.");
    ErrorCode PRO_FEEDBACK_QUALIFIED_UNQUALIFIED_REQUIRED = new ErrorCode(1_040_506_011, "Enter good and defect quantities. The total must be greater than 0.");
    ErrorCode PRO_FEEDBACK_UNCHECK_QUANTITY_EXISTS = new ErrorCode(1_040_506_012, "This work report still has pending inspection quantity: {}.");

    // ========== MES production admin - production routing card (1-040-507-000) ==========
    ErrorCode PRO_CARD_NOT_EXISTS = new ErrorCode(1_040_507_000, "Production routing card was not found.");
    ErrorCode PRO_CARD_CODE_DUPLICATE = new ErrorCode(1_040_507_001, "Routing card code already exists.");
    ErrorCode PRO_CARD_STATUS_ERROR = new ErrorCode(1_040_507_002, "Routing card status is invalid.");
    ErrorCode PRO_CARD_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_507_003, "Completed or canceled routing card cannot be canceled.");
    ErrorCode PRO_CARD_NOT_PREPARE = new ErrorCode(1_040_507_004, "Routing card is not draft status, is not allowed edit or delete.");
    // ========== MES production admin - routing card operation (1-040-507-100) ==========
    ErrorCode PRO_CARD_PROCESS_NOT_EXISTS = new ErrorCode(1_040_507_100, "Routing card operationrecord was not found.");

    // ========== MES 生产管理-工作记录（1-040-508-000） ==========
    ErrorCode WORK_RECORD_NOT_CLOCK_IN = new ErrorCode(1_040_508_001, "Current user not work, cannot work.");
    ErrorCode WORK_RECORD_ALREADY_CLOCK_IN = new ErrorCode(1_040_508_002, "Current user already work, first work again action.");

    // ========== MES quality admin - quality inspection plan (1-040-600-000) ==========
    ErrorCode QC_TEMPLATE_NOT_EXISTS = new ErrorCode(1_040_600_000, "Quality inspection plan was not found.");
    ErrorCode QC_TEMPLATE_CODE_DUPLICATE = new ErrorCode(1_040_600_001, "Quality inspection plan code already exists.");
    // ========== MES quality admin - quality inspection plan inspect metric item (1-040-600-100) ==========
    ErrorCode QC_TEMPLATE_INDICATOR_NOT_EXISTS = new ErrorCode(1_040_600_100, "Quality inspection plan inspect metric item was not found.");
    // ========== MES quality admin - quality inspection plan product relation (1-040-600-200) ==========
    ErrorCode QC_TEMPLATE_ITEM_NOT_EXISTS = new ErrorCode(1_040_600_200, "Quality inspection plan product related was not found.");
    ErrorCode QC_TEMPLATE_ITEM_DUPLICATE = new ErrorCode(1_040_600_201, "This product already related this quality inspection plan.");

    // ========== MES quality admin - quality inspection metric (1-040-601-000) ==========
    ErrorCode QC_INDICATOR_NOT_EXISTS = new ErrorCode(1_040_601_000, "Quality inspection metric was not found.");
    ErrorCode QC_INDICATOR_CODE_DUPLICATE = new ErrorCode(1_040_601_001, "Quality inspection metric code already exists.");
    ErrorCode QC_INDICATOR_NAME_DUPLICATE = new ErrorCode(1_040_601_002, "Quality inspection metric name already exists.");
    ErrorCode QC_INDICATOR_RESULT_SPECIFICATION_REQUIRED = new ErrorCode(1_040_601_003, "Result value attribute is required.");

    // ========== MES quality admin - defect type (1-040-602-000) ==========
    ErrorCode QC_DEFECT_NOT_EXISTS = new ErrorCode(1_040_602_000, "Defect type was not found.");
    ErrorCode QC_DEFECT_CODE_DUPLICATE = new ErrorCode(1_040_602_001, "Defect type code already exists.");
    ErrorCode QC_DEFECT_NAME_DUPLICATE = new ErrorCode(1_040_602_002, "Defect type name already exists.");

    // ========== MES 质量管理-来料检验 IQC（1-040-603-000） ==========
    ErrorCode QC_IQC_NOT_EXISTS = new ErrorCode(1_040_603_000, "Incoming inspection not found.");
    ErrorCode QC_IQC_CODE_DUPLICATE = new ErrorCode(1_040_603_001, "Incoming inspection number already exists.");
    ErrorCode QC_IQC_NOT_PREPARE = new ErrorCode(1_040_603_002, "Only draft status inspection only then can action.");
    ErrorCode QC_IQC_QUANTITY_MISMATCH = new ErrorCode(1_040_603_004, "Passed quantity and failed quantity quantity must equal inspected quantity.");
    ErrorCode QC_NO_TEMPLATE = new ErrorCode(1_040_603_005, "Current product is not configured inspect template.");
    ErrorCode QC_IQC_SOURCE_DOC_PARAMS_MISSING = new ErrorCode(1_040_603_006, "Source document ID and line ID are required when source type is set.");
    ErrorCode QC_IQC_CHECK_RESULT_EMPTY = new ErrorCode(1_040_603_007, "Before completing the inspection,, inspection result must enter.");
    // ========== MES 质量管理-来料检验行（1-040-603-100） ==========
    ErrorCode QC_IQC_LINE_NOT_EXISTS = new ErrorCode(1_040_603_100, "Incoming inspection line not found.");

    // ========== MES 质量管理-过程检验 IPQC（1-040-604-000） ==========
    ErrorCode QC_IPQC_NOT_EXISTS = new ErrorCode(1_040_604_000, "In-process inspection not found.");
    ErrorCode QC_IPQC_CODE_DUPLICATE = new ErrorCode(1_040_604_001, "In-process inspection number already exists.");
    ErrorCode QC_IPQC_NOT_PREPARE = new ErrorCode(1_040_604_002, "Only draft status inspection only then can action.");
    ErrorCode QC_IPQC_QUANTITY_MISMATCH = new ErrorCode(1_040_604_004, "Passed quantity and failed quantity quantity must equal inspected quantity.");
    ErrorCode QC_IPQC_NO_TEMPLATE = new ErrorCode(1_040_604_005, "Current product is not configured IPQC inspect template.");
    ErrorCode QC_IPQC_CHECK_RESULT_EMPTY = new ErrorCode(1_040_604_006, "Before completing the inspection,, inspection result must enter.");
    ErrorCode QC_IPQC_SOURCE_DOC_TYPE_UNKNOWN = new ErrorCode(1_040_604_007, "Not IPQC source document type.");
    ErrorCode QC_IPQC_SOURCE_DOC_NO_PENDING_LINE = new ErrorCode(1_040_604_008, "The source work report has no pending-inspection output line for IPQC.");
    ErrorCode QC_IPQC_SOURCE_LINE_NOT_BELONG = new ErrorCode(1_040_604_009, "Source document line does not belong to this report work order.");
    ErrorCode QC_IPQC_SOURCE_LINE_REQUIRED = new ErrorCode(1_040_604_010, "Source output line ID is required when the source type is a work report.");
    ErrorCode QC_IPQC_SOURCE_LINE_NOT_PENDING = new ErrorCode(1_040_604_011, "The source output line is not pending inspection.");
    // ========== MES 质量管理-过程检验行（1-040-604-100） ==========
    ErrorCode QC_IPQC_LINE_NOT_EXISTS = new ErrorCode(1_040_604_100, "In-process inspection line not found.");

    // ========== MES 质量管理-质检缺陷记录（通用）（1-040-605-000） ==========
    ErrorCode QC_DEFECT_RECORD_NOT_EXISTS = new ErrorCode(1_040_605_000, "Defect record was not found.");
    ErrorCode QC_DEFECT_RECORD_LEVEL_UNKNOWN = new ErrorCode(1_040_605_001, "Not defect level.");
    ErrorCode QC_DEFECT_RECORD_QC_TYPE_UNSUPPORTED = new ErrorCode(1_040_605_002, "Not support inspection type.");

    // ========== MES quality admin - inspection result (1-040-606-000) ==========
    ErrorCode QC_RESULT_NOT_EXISTS = new ErrorCode(1_040_606_000, "Inspection result was not found.");
    ErrorCode QC_RESULT_VALUE_FORMAT_INVALID = new ErrorCode(1_040_606_001, "Inspect value format is invalid：{}.");
    ErrorCode QC_FINISH_INDICATOR_RESULT_REQUIRED = new ErrorCode(1_040_606_002, "Enter at least one inspection result before completing the inspection.");

    // ========== MES 质量管理-出货检验（1-040-607-000） ==========
    ErrorCode QC_OQC_NOT_EXISTS = new ErrorCode(1_040_607_000, "Outgoing inspection not found.");
    ErrorCode QC_OQC_CODE_DUPLICATE = new ErrorCode(1_040_607_001, "Outgoing inspection number already exists.");
    ErrorCode QC_OQC_NOT_PREPARE = new ErrorCode(1_040_607_002, "Only draft status inspection only then can action.");
    ErrorCode QC_OQC_QUANTITY_MISMATCH = new ErrorCode(1_040_607_004, "Passed quantity and failed quantity quantity must equal inspected quantity.");
    ErrorCode QC_OQC_NO_TEMPLATE = new ErrorCode(1_040_607_005, "Current product is not configured OQC inspect template.");
    ErrorCode QC_OQC_CHECK_RESULT_EMPTY = new ErrorCode(1_040_607_006, "Before completing the inspection,, inspection result must enter.");
    ErrorCode QC_OQC_SOURCE_DOC_TYPE_UNKNOWN = new ErrorCode(1_040_607_007, "Not OQC source document type.");

    // ========== MES 质量管理-出货检验行（1-040-607-100） ==========
    ErrorCode QC_OQC_LINE_NOT_EXISTS = new ErrorCode(1_040_607_100, "Outgoing inspection line not found.");

    // ========== MES quality admin - return inspection RQC (1-040-608-000) ==========
    ErrorCode QC_RQC_NOT_EXISTS = new ErrorCode(1_040_608_000, "Return inspection was not found.");
    ErrorCode QC_RQC_CODE_DUPLICATE = new ErrorCode(1_040_608_001, "Return inspection code already exists.");
    ErrorCode QC_RQC_NOT_PREPARE = new ErrorCode(1_040_608_002, "Only draft status inspection only then can action.");
    ErrorCode QC_RQC_QUANTITY_MISMATCH = new ErrorCode(1_040_608_004, "Passed quantity and failed quantity quantity must equal inspected quantity.");
    ErrorCode QC_RQC_NO_TEMPLATE = new ErrorCode(1_040_608_005, "Current product is not configured RQC inspect template.");
    ErrorCode QC_RQC_CHECK_RESULT_EMPTY = new ErrorCode(1_040_608_006, "Before completing the inspection,, inspection result must enter.");
    // ========== MES quality admin - return inspection line (1-040-608-100) ==========
    ErrorCode QC_RQC_LINE_NOT_EXISTS = new ErrorCode(1_040_608_100, "Return inspection line was not found.");

    // ========== MES warehouse admin -warehouse (1-040-700-000) ==========
    ErrorCode WM_WAREHOUSE_NOT_EXISTS = new ErrorCode(1_040_700_000, "Warehouse was not found.");
    ErrorCode WM_WAREHOUSE_CODE_DUPLICATE = new ErrorCode(1_040_700_001, "Warehouse code already exists.");
    ErrorCode WM_WAREHOUSE_NAME_DUPLICATE = new ErrorCode(1_040_700_002, "Warehouse name already exists.");
    ErrorCode WM_WAREHOUSE_HAS_LOCATION = new ErrorCode(1_040_700_003, "Warehouse still has zone, cannot delete.");
    ErrorCode WM_WAREHOUSE_HAS_WORKSTATION = new ErrorCode(1_040_700_004, "Warehouse is already used by workstation referenced, cannot delete.");
    ErrorCode WM_WAREHOUSE_HAS_MATERIAL_STOCK = new ErrorCode(1_040_700_005, "Warehouse has inventoryrecord, cannot delete.");
    ErrorCode WM_WAREHOUSE_IS_VIRTUAL = new ErrorCode(1_040_700_006, "Virtual warehouses cannot be used for this action.");

    // ========== MES warehouse admin - zone (1-040-701-000) ==========
    ErrorCode WM_WAREHOUSE_LOCATION_NOT_EXISTS = new ErrorCode(1_040_701_000, "Zone was not found.");
    ErrorCode WM_WAREHOUSE_LOCATION_CODE_DUPLICATE = new ErrorCode(1_040_701_001, "The same warehouse zone code already exists.");
    ErrorCode WM_WAREHOUSE_LOCATION_NAME_DUPLICATE = new ErrorCode(1_040_701_002, "The same warehouse zone name already exists.");
    ErrorCode WM_WAREHOUSE_LOCATION_HAS_AREA = new ErrorCode(1_040_701_003, "Zone still has bin, cannot delete.");
    ErrorCode WM_WAREHOUSE_LOCATION_HAS_WORKSTATION = new ErrorCode(1_040_701_004, "Zone is already used by workstation referenced, cannot delete.");
    ErrorCode WM_WAREHOUSE_REQUIRED = new ErrorCode(1_040_701_005, "Select zone time, warehouse is required.");
    ErrorCode WM_WAREHOUSE_LOCATION_RELATION_INVALID = new ErrorCode(1_040_701_006, "Zone does not belong to selected warehouse.");
    ErrorCode WM_WAREHOUSE_LOCATION_HAS_MATERIAL_STOCK = new ErrorCode(1_040_701_007, "Zone has inventoryrecord, cannot delete.");
    ErrorCode WM_WAREHOUSE_LOCATION_IS_VIRTUAL = new ErrorCode(1_040_701_008, "Virtual zones cannot be used for this action.");

    // ========== MES warehouse admin -bin (1-040-702-000) ==========
    ErrorCode WM_WAREHOUSE_AREA_NOT_EXISTS = new ErrorCode(1_040_702_000, "Bin was not found.");
    ErrorCode WM_WAREHOUSE_AREA_CODE_DUPLICATE = new ErrorCode(1_040_702_001, "The same zone bin code already exists.");
    ErrorCode WM_WAREHOUSE_AREA_NAME_DUPLICATE = new ErrorCode(1_040_702_002, "The same zone bin name already exists.");
    ErrorCode WM_WAREHOUSE_AREA_HAS_WORKSTATION = new ErrorCode(1_040_702_003, "Bin is already used by workstation referenced, cannot delete.");
    ErrorCode WM_WAREHOUSE_LOCATION_REQUIRED = new ErrorCode(1_040_702_004, "Select bin time, zone is required.");
    ErrorCode WM_WAREHOUSE_AREA_RELATION_INVALID = new ErrorCode(1_040_702_005, "Bin does not belong to selected zone.");
    ErrorCode WM_WAREHOUSE_AREA_HAS_MATERIAL_STOCK = new ErrorCode(1_040_702_006, "Bin has inventoryrecord, cannot delete.");
    ErrorCode WM_WAREHOUSE_AREA_WAREHOUSE_MISMATCH = new ErrorCode(1_040_702_007, "Bin does not belong to selected warehouse.");
    ErrorCode WM_WAREHOUSE_AREA_IS_VIRTUAL = new ErrorCode(1_040_702_008, "Virtual bins cannot be used for this action.");

    // ========== MES warehouse admin -inventory (1-040-703-000) ==========
    ErrorCode WM_MATERIAL_STOCK_NOT_EXISTS = new ErrorCode(1_040_703_000, "Inventoryrecord was not found.");
    ErrorCode WM_MATERIAL_STOCK_INSUFFICIENT = new ErrorCode(1_040_703_001, "Inventory quantity is insufficient.");
    ErrorCode WM_TRANSACTION_TYPE_NOT_EXISTS = new ErrorCode(1_040_703_002, "Inventory transaction type not found.");
    ErrorCode WM_TRANSACTION_WAREHOUSE_FROZEN = new ErrorCode(1_040_703_003, "Warehouse({}) is already used by freeze.");
    ErrorCode WM_TRANSACTION_LOCATION_FROZEN = new ErrorCode(1_040_703_004, "Zone ({}) is already used by freeze.");
    ErrorCode WM_TRANSACTION_AREA_FROZEN = new ErrorCode(1_040_703_005, "Bin({}) is already used by freeze.");
    ErrorCode WM_TRANSACTION_STOCK_FROZEN = new ErrorCode(1_040_703_006, "Material stored at ({}/{}/{}) is frozen.");
    ErrorCode WM_TRANSACTION_BATCH_REQUIRED = new ErrorCode(1_040_703_007, "Current material enable lot control, lot no. is required.");
    ErrorCode WM_MATERIAL_STOCK_AREA_ITEM_MIXING_NOT_ALLOWED = new ErrorCode(1_040_703_008, "Bin ({}) does not allow mixed materials. Choose another bin.");
    ErrorCode WM_MATERIAL_STOCK_AREA_BATCH_MIXING_NOT_ALLOWED = new ErrorCode(1_040_703_009, "Bin ({}) does not allow mixed lots. Choose another bin.");
    ErrorCode WM_TRANSACTION_RELATED_NOT_EXISTS = new ErrorCode(1_040_703_010, "Related inventory transaction not found.");
    ErrorCode WM_TRANSACTION_LIST_EMPTY = new ErrorCode(1_040_703_011, "Inventory transaction list cannot be empty.");
    ErrorCode WM_TRANSACTION_BATCH_NOT_EXISTS = new ErrorCode(1_040_703_012, "Lotrecord was not found.");
    ErrorCode WM_MATERIAL_STOCK_REQUIRED = new ErrorCode(1_040_703_013, "Inventoryrecord is required.");
    ErrorCode WM_MATERIAL_STOCK_SELECTION_MISMATCH = new ErrorCode(1_040_703_014, "Inventoryrecord and submit material 、lot or bin info do not match.");

    // ========== MES warehouse admin - receiving notification order (1-040-704-000) ==========
    ErrorCode WM_ARRIVAL_NOTICE_NOT_EXISTS = new ErrorCode(1_040_704_000, "Receiving notification order was not found.");
    ErrorCode WM_ARRIVAL_NOTICE_CODE_DUPLICATE = new ErrorCode(1_040_704_001, "Receiving notification order code already exists.");
    ErrorCode WM_ARRIVAL_NOTICE_STATUS_NOT_PREPARE = new ErrorCode(1_040_704_002, "Only draft status is allowed for this action.");
    ErrorCode WM_ARRIVAL_NOTICE_STATUS_NOT_PENDING_QC = new ErrorCode(1_040_704_003, "Only pending quality inspection status only then allow approval.");
    ErrorCode WM_ARRIVAL_NOTICE_STATUS_NOT_PENDING_RECEIPT = new ErrorCode(1_040_704_004, "Only pending inbound status only then allow complete.");
    ErrorCode WM_ARRIVAL_NOTICE_IQC_PENDING = new ErrorCode(1_040_704_005, "Exists pending inspection line, cannot approved.");
    ErrorCode WM_ARRIVAL_NOTICE_NO_LINE = new ErrorCode(1_040_704_006, "Add at least one line item.");
    ErrorCode WM_ARRIVAL_NOTICE_VENDOR_MISMATCH = new ErrorCode(1_040_704_007, "Receiving notification order supplier and current document do not match.");
    ErrorCode WM_ARRIVAL_NOTICE_LINE_NOT_EXISTS = new ErrorCode(1_040_704_100, "Receiving notification order line was not found.");
    ErrorCode WM_ARRIVAL_NOTICE_LINE_NOT_MATCH = new ErrorCode(1_040_704_101, "Receiving notification order line does not belong to specified receiving notification order.");

    // ========== MES warehouse admin -purchase receipt (1-040-705-000) ==========
    ErrorCode WM_ITEM_RECEIPT_NOT_EXISTS = new ErrorCode(1_040_705_000, "Purchase receipt was not found.");
    ErrorCode WM_ITEM_RECEIPT_CODE_DUPLICATE = new ErrorCode(1_040_705_001, "Purchase receipt code already exists.");
    ErrorCode WM_ITEM_RECEIPT_STATUS_NOT_PREPARE = new ErrorCode(1_040_705_002, "Only draft or waiting to put away status is allowed for this action.");
    ErrorCode WM_ITEM_RECEIPT_NO_LINE = new ErrorCode(1_040_705_003, "Add at least one line item.");
    ErrorCode WM_ITEM_RECEIPT_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_705_004, "Detailput away total and inbound quantity does not match.");
    ErrorCode WM_ITEM_RECEIPT_STATUS_ERROR = new ErrorCode(1_040_705_005, "Inbound order status is invalid.");
    ErrorCode WM_ITEM_RECEIPT_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_705_006, "Completed or canceled inbound order cannot be canceled.");
    ErrorCode WM_ITEM_RECEIPT_LINE_NOT_EXISTS = new ErrorCode(1_040_705_100, "Purchase receipt line was not found.");
    ErrorCode WM_ITEM_RECEIPT_LINE_ARRIVAL_NOTICE_LINE_REQUIRED = new ErrorCode(1_040_705_101,
            "Inbound order relation receiving notification order, must select receiving notification order line.");
    ErrorCode WM_ITEM_RECEIPT_LINE_ARRIVAL_NOTICE_LINE_NOT_ALLOWED = new ErrorCode(1_040_705_102,
            "Inbound order not related receiving notification order, cannot select receiving notification order line.");
    ErrorCode WM_ITEM_RECEIPT_DETAIL_NOT_EXISTS = new ErrorCode(1_040_705_200, "Purchase inbound detail was not found.");
    ErrorCode WM_ITEM_RECEIPT_DETAIL_LINE_MISMATCH = new ErrorCode(1_040_705_201, "Inbound order line and put awaydetail document or material do not match.");
    ErrorCode WM_ITEM_RECEIPT_DETAIL_QUANTITY_EXCEED = new ErrorCode(1_040_705_202, "Put awaydetail total quantity cannot exceeds inbound quantity.");

    // ========== MES warehouse admin - material issue apply please order (1-040-706-000) ==========
    ErrorCode WM_MATERIAL_REQUEST_NOT_EXISTS = new ErrorCode(1_040_706_000, "Material issue apply please order was not found.");
    ErrorCode WM_MATERIAL_REQUEST_STATUS_INVALID = new ErrorCode(1_040_706_001, "Material issue apply please order status is invalid, cannot execute this action.");
    ErrorCode WM_MATERIAL_REQUEST_LINE_NOT_EXISTS = new ErrorCode(1_040_706_100, "Material issue apply please order line was not found.");

    // ========== MES warehouse admin - subcontract issue order (1-040-707-000) ==========
    ErrorCode WM_OUTSOURCE_ISSUE_NOT_EXISTS = new ErrorCode(1_040_707_000, "Subcontract issue order was not found.");
    ErrorCode WM_OUTSOURCE_ISSUE_CODE_DUPLICATE = new ErrorCode(1_040_707_001, "Subcontract issue order code already exists.");
    ErrorCode WM_OUTSOURCE_ISSUE_STATUS_NOT_PREPARE = new ErrorCode(1_040_707_002, "Only draft status is allowed for this action.");
    ErrorCode WM_OUTSOURCE_ISSUE_NO_LINE = new ErrorCode(1_040_707_003, "At least need to need one item issue materials line.");
    ErrorCode WM_OUTSOURCE_ISSUE_QUANTITY_MISMATCH = new ErrorCode(1_040_707_004, "Issue materials order line quantity and detail quantity do not match.");
    ErrorCode WM_OUTSOURCE_ISSUE_STATUS_NOT_APPROVING = new ErrorCode(1_040_707_005, "Only pending picking status is allowed for this action.");
    ErrorCode WM_OUTSOURCE_ISSUE_STATUS_NOT_APPROVED = new ErrorCode(1_040_707_006, "Only pending execute outbound status is allowed for this action.");
    ErrorCode WM_OUTSOURCE_ISSUE_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_707_007, "Completed or canceled issue materials order cannot be canceled.");
    ErrorCode WM_OUTSOURCE_ISSUE_LINE_NOT_EXISTS = new ErrorCode(1_040_707_100, "Subcontract issue order line was not found.");
    ErrorCode WM_OUTSOURCE_ISSUE_LINE_ITEM_NOT_IN_BOM = new ErrorCode(1_040_707_101, "Issue materials order line a matching material is not in current work order BOM list.");
    ErrorCode WM_OUTSOURCE_ISSUE_DETAIL_NOT_EXISTS = new ErrorCode(1_040_707_200, "Subcontract issue order detail was not found.");
    ErrorCode WM_OUTSOURCE_ISSUE_DETAIL_LINE_NOT_MATCH = new ErrorCode(1_040_707_201, "Picking detail does not belong to specified subcontract issue order.");
    ErrorCode WM_OUTSOURCE_ISSUE_DETAIL_ITEM_MISMATCH = new ErrorCode(1_040_707_202, "Picking detail material and subcontract issue order line material do not match.");
    ErrorCode WM_OUTSOURCE_ISSUE_WORK_ORDER_TYPE_INVALID = new ErrorCode(1_040_707_008, "The work order is not a subcontract type.");

    // ========== MES warehouse admin - production material issue outbound order (1-040-708-000) ==========
    ErrorCode WM_PRODUCT_ISSUE_NOT_EXISTS = new ErrorCode(1_040_708_000, "Production material issue outbound order was not found.");
    ErrorCode WM_PRODUCT_ISSUE_STATUS_INVALID = new ErrorCode(1_040_708_001, "Production material issue outbound order status is invalid, cannot execute this action.");
    ErrorCode WM_PRODUCT_ISSUE_NO_LINE = new ErrorCode(1_040_708_002, "Production material issue outbound order at least need to need one item line data.");
    ErrorCode WM_PRODUCT_ISSUE_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_708_003, "Material issue outbound order line quantity and detail quantity do not match.");
    ErrorCode WM_PRODUCT_ISSUE_WORKORDER_NOT_EXISTS = new ErrorCode(1_040_708_004, "Production work order was not found.");
    ErrorCode WM_PRODUCT_ISSUE_WORKSTATION_NOT_EXISTS = new ErrorCode(1_040_708_005, "Workstation was not found.");
    ErrorCode WM_PRODUCT_ISSUE_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_708_006, "Production material issue outbound ordercompleted or canceled, cannot cancel.");
    ErrorCode WM_PRODUCT_ISSUE_LINE_NOT_EXISTS = new ErrorCode(1_040_708_100, "Production material issue outbound order line was not found.");
    ErrorCode WM_PRODUCT_ISSUE_LINE_ITEM_NOT_IN_BOM = new ErrorCode(1_040_708_101, "This material is not on the production work order BOM.");
    ErrorCode WM_PRODUCT_ISSUE_CODE_DUPLICATE = new ErrorCode(1_040_708_102, "Material issue outbound order code already exists.");
    ErrorCode WM_PRODUCT_ISSUE_DETAIL_NOT_EXISTS = new ErrorCode(1_040_708_200, "Production material issue outbound orderdetail was not found.");
    ErrorCode WM_PRODUCT_ISSUE_DETAIL_ITEM_MISMATCH = new ErrorCode(1_040_708_201, "Picking detail material and material issue order line material do not match.");
    ErrorCode WM_PRODUCT_ISSUE_DETAIL_LINE_NOT_MATCH = new ErrorCode(1_040_708_202, "Picking detail does not belong to specified material issue outbound order.");
    ErrorCode WM_PRODUCT_ISSUE_NO_DETAIL = new ErrorCode(1_040_708_203, "The material issue has no pick lines and cannot be issued.");

    // ========== MES warehouse admin - production inbound order (1-040-709-000) ==========
    ErrorCode WM_PRODUCT_PRODUCE_NOT_EXISTS = new ErrorCode(1_040_709_000, "Production inbound order was not found.");
    ErrorCode WM_PRODUCT_PRODUCE_STATUS_INVALID = new ErrorCode(1_040_709_001, "Production inbound order status is invalid, cannot execute this action.");
    ErrorCode WM_PRODUCT_PRODUCE_NO_LINE = new ErrorCode(1_040_709_002, "Production inbound order at least need to need one item line data.");
    ErrorCode WM_PRODUCT_PRODUCE_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_709_003, "Production inbound order line quantity and detail quantity do not match.");
    ErrorCode WM_PRODUCT_PRODUCE_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_709_004, "Production inbound ordercompleted or canceled, cannot cancel.");
    ErrorCode WM_PRODUCT_PRODUCE_LINE_NOT_EXISTS = new ErrorCode(1_040_709_100, "Production inbound order line was not found.");
    ErrorCode WM_PRODUCT_PRODUCE_DETAIL_NOT_EXISTS = new ErrorCode(1_040_709_200, "Production inbound orderdetail was not found.");

    // ========== MES warehouse admin - transfer transfer (1-040-710-000) ==========
    ErrorCode WM_TRANSFER_NOT_EXISTS = new ErrorCode(1_040_710_000, "Transfer order was not found.");
    ErrorCode WM_TRANSFER_NOT_EDITABLE = new ErrorCode(1_040_710_001, "Current transfer order status is not allowed edit.");
    ErrorCode WM_TRANSFER_CODE_DUPLICATE = new ErrorCode(1_040_710_002, "Transfer order code already exists.");
    ErrorCode WM_TRANSFER_NOT_DRAFT = new ErrorCode(1_040_710_003, "Only draft status transfer order only then can action.");
    ErrorCode WM_TRANSFER_NOT_CONFIRMED = new ErrorCode(1_040_710_004, "Only pending confirm status transfer order only then can execute confirm.");
    ErrorCode WM_TRANSFER_NOT_APPROVING = new ErrorCode(1_040_710_005, "Only waiting to put away status transfer order only then can execute put away.");
    ErrorCode WM_TRANSFER_NOT_APPROVED = new ErrorCode(1_040_710_006, "Only pending execute status transfer order only then can complete.");
    ErrorCode WM_TRANSFER_ALREADY_FINISHED = new ErrorCode(1_040_710_007, "The transfer is completed or canceled and cannot be changed.");
    ErrorCode WM_TRANSFER_NO_LINE = new ErrorCode(1_040_710_008, "Transfer order at least need to need one item line data.");
    ErrorCode WM_TRANSFER_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_710_009, "Transfer order line quantity and detail quantity do not match.");
    ErrorCode WM_TRANSFER_LINE_NOT_EXISTS = new ErrorCode(1_040_710_100, "Transfer order line was not found.");
    ErrorCode WM_TRANSFER_LINE_QUANTITY_EXCEED_STOCK = new ErrorCode(1_040_710_101, "Transfer quantity cannot exceeds inventory quantity.");
    ErrorCode WM_TRANSFER_DETAIL_NOT_EXISTS = new ErrorCode(1_040_710_200, "Transfer detail was not found.");
    ErrorCode WM_TRANSFER_DETAIL_QUANTITY_EXCEED = new ErrorCode(1_040_710_201, "Transfer detail total quantity cannot exceeds transfer order line quantity.");
    ErrorCode WM_TRANSFER_DETAIL_MIXED_GOODS = new ErrorCode(1_040_710_202, "The target location already has another material and cannot be mixed.");

    // ========== MES warehouse admin - production material return order (1-040-711-000) ==========
    ErrorCode WM_RETURN_ISSUE_NOT_EXISTS = new ErrorCode(1_040_710_000, "Production material return order was not found.");
    ErrorCode WM_RETURN_ISSUE_STATUS_INVALID = new ErrorCode(1_040_710_001, "Production material return order status is invalid, cannot execute this action.");
    ErrorCode WM_RETURN_ISSUE_NOT_PREPARE = new ErrorCode(1_040_710_002, "Only draft status material return order only then can action.");
    ErrorCode WM_RETURN_ISSUE_NOT_CONFIRMED = new ErrorCode(1_040_710_003, "Only pending inspection status material return order only then can submit.");
    ErrorCode WM_RETURN_ISSUE_NOT_APPROVING = new ErrorCode(1_040_710_004, "Only waiting to put away status material return order only then can inbound put away.");
    ErrorCode WM_RETURN_ISSUE_NOT_APPROVED = new ErrorCode(1_040_710_005, "Only pending execute material return status material return order only then can complete.");
    ErrorCode WM_RETURN_ISSUE_NO_LINE = new ErrorCode(1_040_710_006, "Production material return order at least need to need one item line data.");
    ErrorCode WM_RETURN_ISSUE_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_710_007, "Material return order line quantity and detail quantity do not match.");
    ErrorCode WM_RETURN_ISSUE_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_710_008, "Production material return order completed or canceled, cannot cancel.");
    ErrorCode WM_RETURN_ISSUE_LINE_NOT_EXISTS = new ErrorCode(1_040_710_100, "Production material return order line was not found.");
    ErrorCode WM_RETURN_ISSUE_DETAIL_NOT_EXISTS = new ErrorCode(1_040_710_200, "Production material return order detail was not found.");
    ErrorCode WM_RETURN_ISSUE_DETAIL_QUANTITY_INVALID = new ErrorCode(1_040_710_201, "Material return detail quantity must large at 0.");
    ErrorCode WM_RETURN_ISSUE_DETAIL_QUANTITY_EXCEED = new ErrorCode(1_040_710_202, "Material return detail total quantity cannot exceeds material return order line quantity.");
    ErrorCode WM_RETURN_ISSUE_CODE_DUPLICATE = new ErrorCode(1_040_710_203, "Material return order code already exists.");
    ErrorCode WM_RETURN_ISSUE_DETAIL_LINE_NOT_MATCH = new ErrorCode(1_040_710_204, "Material return detail does not belong to specified material return order.");
    ErrorCode WM_RETURN_ISSUE_DETAIL_ITEM_MISMATCH = new ErrorCode(1_040_710_205, "Material return detail material and material return order line material do not match.");

    // ========== MES warehouse admin -supplierreturn order (1-040-711-000) ==========
    ErrorCode WM_RETURN_VENDOR_NOT_EXISTS = new ErrorCode(1_040_711_000, "Supplierreturn order was not found.");
    ErrorCode WM_RETURN_VENDOR_STATUS_INVALID = new ErrorCode(1_040_711_001, "Supplierreturn order status is invalid, cannot execute this action.");
    ErrorCode WM_RETURN_VENDOR_NO_LINE = new ErrorCode(1_040_711_002, "Supplierreturn order at least need to need one item line data.");
    ErrorCode WM_RETURN_VENDOR_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_711_003, "Supplierreturn order line quantity and detail quantity do not match.");
    ErrorCode WM_RETURN_VENDOR_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_711_004, "Supplierreturn ordercompleted or canceled, cannot cancel.");
    ErrorCode WM_RETURN_VENDOR_CODE_DUPLICATE = new ErrorCode(1_040_711_005, "Supplierreturn order code already exists.");
    ErrorCode WM_RETURN_VENDOR_NO_DETAIL = new ErrorCode(1_040_711_006, "Supplierreturn order has no picking detail, cannot execute return.");
    ErrorCode WM_RETURN_VENDOR_DETAIL_ITEM_MISMATCH = new ErrorCode(1_040_711_007, "Picking detail material and return order line material do not match.");
    ErrorCode WM_RETURN_VENDOR_LINE_NOT_EXISTS = new ErrorCode(1_040_711_100, "Supplierreturn order line was not found.");
    ErrorCode WM_RETURN_VENDOR_DETAIL_NOT_EXISTS = new ErrorCode(1_040_711_200, "Supplierreturn orderdetail was not found.");
    ErrorCode WM_RETURN_VENDOR_DETAIL_QUANTITY_INVALID = new ErrorCode(1_040_711_201, "Return detail quantity must large at 0.");
    ErrorCode WM_RETURN_VENDOR_DETAIL_LINE_NOT_MATCH = new ErrorCode(1_040_711_202, "Picking detail does not belong to specified supplierreturn order.");

    // ========== MES warehouse admin -product receiving order (1-040-712-000) ==========
    ErrorCode WM_PRODUCT_RECPT_NOT_EXISTS = new ErrorCode(1_040_712_000, "Product receiving order was not found.");
    ErrorCode WM_PRODUCT_RECPT_CODE_DUPLICATE = new ErrorCode(1_040_712_001, "Product receiving order code already exists.");
    ErrorCode WM_PRODUCT_RECPT_STATUS_NOT_PREPARE = new ErrorCode(1_040_712_002, "Only draft or waiting to put away status is allowed for this action.");
    ErrorCode WM_PRODUCT_RECPT_NO_LINE = new ErrorCode(1_040_712_003, "Add at least one line item.");
    ErrorCode WM_PRODUCT_RECPT_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_712_004, "Detailput away total and line receiving quantity does not match.");
    ErrorCode WM_PRODUCT_RECPT_STATUS_ERROR = new ErrorCode(1_040_712_005, "Receiving order status is invalid.");
    ErrorCode WM_PRODUCT_RECPT_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_712_006, "Completed or canceled receiving order cannot be canceled.");
    ErrorCode WM_PRODUCT_RECPT_NO_DETAIL = new ErrorCode(1_040_712_007, "Receiving order has no put awaydetail, cannot execute inbound.");
    ErrorCode WM_PRODUCT_RECPT_LINE_NOT_EXISTS = new ErrorCode(1_040_712_100, "Product receiving order line was not found.");
    ErrorCode WM_PRODUCT_RECPT_DETAIL_NOT_EXISTS = new ErrorCode(1_040_712_200, "Product receiving detail was not found.");

    // ========== MES warehouse admin - subcontract inbound order (1-040-713-000) ==========
    ErrorCode WM_OUTSOURCE_RECEIPT_NOT_EXISTS = new ErrorCode(1_040_713_000, "Subcontract inbound order was not found.");
    ErrorCode WM_OUTSOURCE_RECEIPT_CODE_DUPLICATE = new ErrorCode(1_040_713_001, "Subcontract inbound order code already exists.");
    ErrorCode WM_OUTSOURCE_RECEIPT_STATUS_NOT_PREPARE = new ErrorCode(1_040_713_002, "Only draft status is allowed for this action.");
    ErrorCode WM_OUTSOURCE_RECEIPT_NO_LINE = new ErrorCode(1_040_713_003, "Add at least one line item.");
    ErrorCode WM_OUTSOURCE_RECEIPT_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_713_004, "Detailput away total and inbound quantity does not match.");
    ErrorCode WM_OUTSOURCE_RECEIPT_STATUS_ERROR = new ErrorCode(1_040_713_005, "Inbound order status is invalid.");
    ErrorCode WM_OUTSOURCE_RECEIPT_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_713_006, "Completed or canceled inbound order cannot be canceled.");
    ErrorCode WM_OUTSOURCE_RECEIPT_LINE_NOT_EXISTS = new ErrorCode(1_040_713_100, "Subcontract inbound order line was not found.");
    ErrorCode WM_OUTSOURCE_RECEIPT_DETAIL_NOT_EXISTS = new ErrorCode(1_040_713_200, "Subcontract inbound detail was not found.");

    // ========== MES warehouse admin -sales return (1-040-713-000) ==========
    ErrorCode WM_RETURN_SALES_NOT_EXISTS = new ErrorCode(1_040_713_000, "Sales return was not found.");
    ErrorCode WM_RETURN_SALES_CODE_DUPLICATE = new ErrorCode(1_040_713_001, "Sales return code already exists.");
    ErrorCode WM_RETURN_SALES_STATUS_NOT_PREPARE = new ErrorCode(1_040_713_002, "Only draft status is allowed for this action.");
    ErrorCode WM_RETURN_SALES_STATUS_NOT_APPROVING = new ErrorCode(1_040_713_003, "Only pending execute status only then allow execute return.");
    ErrorCode WM_RETURN_SALES_STATUS_NOT_APPROVED = new ErrorCode(1_040_713_004, "Only waiting to put away status only then allow execute put away.");
    ErrorCode WM_RETURN_SALES_NO_LINE = new ErrorCode(1_040_713_005, "Sales return at least need to need one item line data.");
    ErrorCode WM_RETURN_SALES_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_713_006, "Sales return line quantity and detail quantity do not match.");
    ErrorCode WM_RETURN_SALES_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_713_007, "Sales returncompleted or canceled, cannot cancel.");
    ErrorCode WM_RETURN_SALES_LINE_NOT_EXISTS = new ErrorCode(1_040_713_100, "Sales return line was not found.");
    ErrorCode WM_RETURN_SALES_DETAIL_NOT_EXISTS = new ErrorCode(1_040_713_200, "Sales returndetail was not found.");
    ErrorCode WM_RETURN_SALES_DETAIL_QUANTITY_EXCEED = new ErrorCode(1_040_713_201, "Put awaydetail total quantity cannot exceeds return line quantity.");

    // ========== MES warehouse admin - stocktake plan /task/ result (1-040-714-100) ==========
    ErrorCode WM_STOCK_TAKING_PLAN_NOT_EXISTS = new ErrorCode(1_040_714_100, "Stocktake plan was not found.");
    ErrorCode WM_STOCK_TAKING_PLAN_CODE_DUPLICATE = new ErrorCode(1_040_714_101, "Stocktake plan code already exists.");
    ErrorCode WM_STOCK_TAKING_PLAN_NOT_DISABLED = new ErrorCode(1_040_714_102, "Only disabled count plans can be edited, deleted, or maintained.");
    ErrorCode WM_STOCK_TAKING_PLAN_NOT_ENABLED = new ErrorCode(1_040_714_103, "Only enable status stocktake plan only then allow createtask.");
    ErrorCode WM_STOCK_TAKING_PLAN_PARAM_NOT_EXISTS = new ErrorCode(1_040_714_104, "Stocktake plan parameter was not found.");
    ErrorCode WM_STOCK_TAKING_PLAN_PARAM_EMPTY = new ErrorCode(1_040_714_105, "Stocktake plan parameter is required, first setting stocktake parameter.");
    ErrorCode WM_STOCK_TAKING_PLAN_DYNAMIC_TIME_INVALID = new ErrorCode(1_040_714_106, "Dynamic count plans require a start and end time, and the end must be later.");
    ErrorCode WM_STOCK_TAKING_TASK_NOT_EXISTS = new ErrorCode(1_040_714_110, "Stocktake task was not found.");
    ErrorCode WM_STOCK_TAKING_TASK_CODE_DUPLICATE = new ErrorCode(1_040_714_111, "Stocktake task code already exists.");
    ErrorCode WM_STOCK_TAKING_TASK_NOT_PREPARE = new ErrorCode(1_040_714_112, "Only draft status stocktake task is allowed for this action.");
    ErrorCode WM_STOCK_TAKING_TASK_NOT_APPROVING = new ErrorCode(1_040_714_113, "Only stocktake status task is allowed for this action.");
    ErrorCode WM_STOCK_TAKING_TASK_CANNOT_CANCEL = new ErrorCode(1_040_714_114, "Completed or canceled stocktake task cannot be canceled.");
    ErrorCode WM_STOCK_TAKING_TASK_NO_STOCK = new ErrorCode(1_040_714_115, "No matching inventory was found.");
    ErrorCode WM_STOCK_TAKING_TASK_NO_LINE = new ErrorCode(1_040_714_116, "Stocktake task at least need to need one item task line.");
    ErrorCode WM_STOCK_TAKING_TASK_LINE_NOT_EXISTS = new ErrorCode(1_040_714_117, "Stocktake task line was not found.");
    ErrorCode WM_STOCK_TAKING_TASK_DYNAMIC_TIME_REQUIRED = new ErrorCode(1_040_714_118, "Dynamic counts require a start and end time.");
    ErrorCode WM_STOCK_TAKING_TASK_RESULT_NOT_EXISTS = new ErrorCode(1_040_714_119, "Stocktake result was not found.");
    ErrorCode WM_STOCK_TAKING_TASK_LINE_ALREADY_TAKEN = new ErrorCode(1_040_714_120, "This count line already has a count record.");

    // ========== MES warehouse admin -sales shipment (1-040-714-000) ==========
    ErrorCode WM_PRODUCT_SALES_NOT_EXISTS = new ErrorCode(1_040_714_000, "Sales shipment was not found.");
    ErrorCode WM_PRODUCT_SALES_CODE_DUPLICATE = new ErrorCode(1_040_714_001, "Sales shipment no. already exists.");
    ErrorCode WM_PRODUCT_SALES_NOT_PREPARE = new ErrorCode(1_040_714_002, "Only draft status only then can action.");
    ErrorCode WM_PRODUCT_SALES_LINES_EMPTY = new ErrorCode(1_040_714_003, "Sales shipment line is required.");
    ErrorCode WM_PRODUCT_SALES_CANNOT_SUBMIT = new ErrorCode(1_040_714_004, "Current status is not allowedsubmit.");
    ErrorCode WM_PRODUCT_SALES_CANNOT_PICK = new ErrorCode(1_040_714_005, "Current status is not allowed picking.");
    ErrorCode WM_PRODUCT_SALES_CANNOT_SHIPPING = new ErrorCode(1_040_714_006, "The current status does not allow a tracking number.");
    ErrorCode WM_PRODUCT_SALES_CANNOT_FINISH = new ErrorCode(1_040_714_007, "Current status is not allowed execute outbound.");
    ErrorCode WM_PRODUCT_SALES_CANNOT_CANCEL = new ErrorCode(1_040_714_008, "Current status cannot be canceled.");
    ErrorCode WM_PRODUCT_SALES_CANNOT_CONFIRM = new ErrorCode(1_040_714_009, "Current status is not allowed confirm inspection via.");
    ErrorCode WM_PRODUCT_SALES_DETAILS_EMPTY = new ErrorCode(1_040_714_020, "Picking detail is required.");
    ErrorCode WM_PRODUCT_SALES_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_714_010, "Picking quantity and outbound quantity does not match.");
    ErrorCode WM_PRODUCT_SALES_LINE_NOT_EXISTS = new ErrorCode(1_040_714_011, "Sales shipment line was not found.");
    ErrorCode WM_PRODUCT_SALES_DETAIL_NOT_EXISTS = new ErrorCode(1_040_714_012, "Sales outbound detail was not found.");
    ErrorCode WM_PRODUCT_SALES_STOCK_INSUFFICIENT = new ErrorCode(1_040_714_013, "Inventory is insufficient, cannot picking.");
    ErrorCode WM_PRODUCT_SALES_LINE_QUANTITY_INVALID = new ErrorCode(1_040_714_014, "Outbound quantity must large at 0.");
    ErrorCode WM_PRODUCT_SALES_DETAIL_LINE_NOT_MATCH = new ErrorCode(1_040_714_015, "Picking detail does not belong to specified sales shipment.");
    ErrorCode WM_PRODUCT_SALES_DETAIL_ITEM_MISMATCH = new ErrorCode(1_040_714_016, "Picking detail material and sales shipment line material do not match.");
    ErrorCode WM_PRODUCT_SALES_LINE_SALES_NOTICE_LINE_REQUIRED = new ErrorCode(1_040_714_017,
            "Outbound order relation shipping notification order, must select shipping notification order line.");
    ErrorCode WM_PRODUCT_SALES_LINE_SALES_NOTICE_LINE_NOT_ALLOWED = new ErrorCode(1_040_714_018,
            "Outbound order not related shipping notification order, cannot select shipping notification order line.");
    ErrorCode WM_PRODUCT_SALES_LINE_NOTICE_LINE_ITEM_MISMATCH = new ErrorCode(1_040_714_030,
            "Outbound line material and shipping notification order line material do not match.");
    ErrorCode WM_PRODUCT_SALES_LINE_NOTICE_LINE_QUANTITY_MISMATCH = new ErrorCode(1_040_714_031,
            "Outbound line quantity and shipping notification order line quantity do not match.");
    ErrorCode WM_PRODUCT_SALES_LINE_NOTICE_LINE_BATCH_MISMATCH = new ErrorCode(1_040_714_032,
            "Outbound line lot no. and shipping notification order line lot no. do not match.");
    ErrorCode WM_PRODUCT_SALES_LINE_NOTICE_LINE_OQC_MISMATCH = new ErrorCode(1_040_714_033,
            "Outbound line OQC inspection key and shipping notification order line do not match.");

    // ========== MES warehouse admin - miscellaneous outbound order (1-040-715-000) ==========
    ErrorCode WM_MISC_ISSUE_NOT_EXISTS = new ErrorCode(1_040_715_000, "Miscellaneous outbound order was not found.");
    ErrorCode WM_MISC_ISSUE_CODE_DUPLICATE = new ErrorCode(1_040_715_001, "Miscellaneous outbound order code already exists.");
    ErrorCode WM_MISC_ISSUE_STATUS_INVALID = new ErrorCode(1_040_715_002, "Miscellaneous outbound order status is invalid, cannot execute this action.");
    ErrorCode WM_MISC_ISSUE_NO_LINE = new ErrorCode(1_040_715_003, "Miscellaneous outbound order at least need to need one item line data.");
    ErrorCode WM_MISC_ISSUE_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_715_004, "Miscellaneous outbound ordercompleted or canceled, cannot cancel.");
    ErrorCode WM_MISC_ISSUE_DETAIL_QUANTITY_MISMATCH = new ErrorCode(1_040_715_005, "Miscellaneous outbound order line quantity and detail quantity do not match.");
    ErrorCode WM_MISC_ISSUE_LINE_NOT_EXISTS = new ErrorCode(1_040_715_100, "Miscellaneous outbound order line was not found.");
    ErrorCode WM_MISC_ISSUE_DETAIL_NOT_EXISTS = new ErrorCode(1_040_715_200, "Miscellaneous outbound orderdetail was not found.");

    // ========== MES warehouse admin - miscellaneous inbound order (1-040-716-000) ==========
    ErrorCode WM_MISC_RECEIPT_NOT_EXISTS = new ErrorCode(1_040_716_000, "Miscellaneous inbound order was not found.");
    ErrorCode WM_MISC_RECEIPT_CODE_DUPLICATE = new ErrorCode(1_040_716_001, "Miscellaneous inbound order code already exists.");
    ErrorCode WM_MISC_RECEIPT_STATUS_NOT_PREPARE = new ErrorCode(1_040_716_002, "Only draft status is allowed for this action.");
    ErrorCode WM_MISC_RECEIPT_STATUS_NOT_APPROVED = new ErrorCode(1_040_716_003, "Only already approval status only then allow execute inbound.");
    ErrorCode WM_MISC_RECEIPT_NO_LINE = new ErrorCode(1_040_716_004, "Add at least one line item.");
    ErrorCode WM_MISC_RECEIPT_CANCEL_NOT_ALLOWED = new ErrorCode(1_040_716_005, "Completed or canceled inbound order cannot be canceled.");
    ErrorCode WM_MISC_RECEIPT_LINE_NOT_EXISTS = new ErrorCode(1_040_716_100, "Miscellaneous inbound order line was not found.");
    ErrorCode WM_MISC_RECEIPT_WAREHOUSE_REQUIRED = new ErrorCode(1_040_716_101, "Warehouse is required.");
    ErrorCode WM_MISC_RECEIPT_QUANTITY_INVALID = new ErrorCode(1_040_716_102, "Inbound quantity must large at 0.");
    ErrorCode WM_MISC_RECEIPT_DETAIL_NOT_EXISTS = new ErrorCode(1_040_716_200, "Miscellaneous inbound orderdetail was not found.");

    // ========== MES warehouse admin - shipping notification order (1-040-720-000) ==========
    ErrorCode WM_SALES_NOTICE_NOT_EXISTS = new ErrorCode(1_040_720_000, "Shipping notification order was not found.");
    ErrorCode WM_SALES_NOTICE_CODE_DUPLICATE = new ErrorCode(1_040_720_001, "Notification order code is already used.");
    ErrorCode WM_SALES_NOTICE_STATUS_NOT_ALLOW_DELETE = new ErrorCode(1_040_720_002, "Document status is not alloweddelete.");
    ErrorCode WM_SALES_NOTICE_STATUS_NOT_ALLOW_UPDATE = new ErrorCode(1_040_720_003, "Document status is not allowed edit.");
    ErrorCode WM_SALES_NOTICE_STATUS_NOT_APPROVED = new ErrorCode(1_040_720_004, "Shipping notification order is not pending outbound status.");
    ErrorCode WM_SALES_NOTICE_CLIENT_MISMATCH = new ErrorCode(1_040_720_005, "Shipping notification order customer and current document do not match.");
    ErrorCode WM_SALES_NOTICE_LINE_NOT_EXISTS = new ErrorCode(1_040_720_010, "Shipping notification order line was not found.");
    ErrorCode WM_SALES_NOTICE_LINE_EMPTY = new ErrorCode(1_040_720_011, "Shipping notification order line is empty, cannot submit.");
    ErrorCode WM_SALES_NOTICE_LINE_NOT_MATCH = new ErrorCode(1_040_720_012, "Shipping notification order line does not belong to specified shipping notification order.");

    // ========== MES warehouse admin -barcode setting (1-040-730-000) ==========
    ErrorCode WM_BARCODE_CONFIG_NOT_EXISTS = new ErrorCode(1_040_730_000, "Barcode setting was not found.");
    ErrorCode WM_BARCODE_CONFIG_BIZ_TYPE_DUPLICATE = new ErrorCode(1_040_730_001, "This business type barcode setting already exists.");
    ErrorCode WM_BARCODE_CONFIG_HAS_BARCODE = new ErrorCode(1_040_730_002, "This barcode setting is already used by barcoderecord related, cannot delete.");

    // ========== MES 仓库管理-条码清单（1-040-731-000） ==========
    ErrorCode WM_BARCODE_NOT_EXISTS = new ErrorCode(1_040_731_000, "Barcode was not found.");
    ErrorCode WM_BARCODE_ALREADY_EXISTS = new ErrorCode(1_040_731_001, "This business object barcode already exists.");
    ErrorCode WM_BARCODE_CONTENT_DUPLICATE = new ErrorCode(1_040_731_002, "Barcode content already exists.");
    ErrorCode BARCODE_BIZ_TYPE_NOT_EXISTS = new ErrorCode(1_040_731_003, "Business type is required.");
    ErrorCode BARCODE_BIZ_CODE_NOT_EXISTS = new ErrorCode(1_040_731_004, "Business code is required.");
    ErrorCode BARCODE_CONFIG_NOT_EXISTS = new ErrorCode(1_040_731_005, "Barcode setting was not found.");

    // ========== MES warehouse admin - packing order (1-040-740-000) ==========
    ErrorCode WM_PACKAGE_NOT_EXISTS = new ErrorCode(1_040_740_000, "Packing order was not found.");
    ErrorCode WM_PACKAGE_CODE_DUPLICATE = new ErrorCode(1_040_740_001, "Packing order code already exists.");
    ErrorCode WM_PACKAGE_STATUS_NOT_PREPARE = new ErrorCode(1_040_740_002, "Only draft status is allowed for this action.");
    ErrorCode WM_PACKAGE_PARENT_NOT_EXISTS = new ErrorCode(1_040_740_003, "Parent box was not found.");
    ErrorCode WM_PACKAGE_PARENT_SELF = new ErrorCode(1_040_740_004, "Cannot select your own as parent box.");
    ErrorCode WM_PACKAGE_CHILD_HAS_PARENT = new ErrorCode(1_040_740_005, "This packing order already has parent box, cannot is duplicated add.");
    ErrorCode WM_PACKAGE_PARENT_IS_CHILD = new ErrorCode(1_040_740_006, "A child box cannot become its own parent.");
    ErrorCode WM_PACKAGE_CHILD_NOT_FINISHED = new ErrorCode(1_040_740_007, "Child box must be completed status can add.");
    ErrorCode WM_PACKAGE_HAS_CHILDREN = new ErrorCode(1_040_740_008, "Exists child box, is not alloweddelete.");
    ErrorCode WM_PACKAGE_LINE_NOT_EXISTS = new ErrorCode(1_040_740_100, "Packing detail was not found.");

}

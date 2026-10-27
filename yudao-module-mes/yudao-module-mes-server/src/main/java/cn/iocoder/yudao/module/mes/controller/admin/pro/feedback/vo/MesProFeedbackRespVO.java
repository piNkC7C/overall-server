package cn.iocoder.yudao.module.mes.controller.admin.pro.feedback.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production work report response.")
@Data
@ExcelIgnoreUnannotated
public class MesProFeedbackRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Work-report number.", example = "FB202503160001")
    @ExcelProperty("Work Report No")
    private String code;

    @Schema(description = "Work report type.", example = "1")
    @ExcelProperty(value = "Report Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_FEEDBACK_TYPE)
    private Integer type;

    @Schema(description = "Report channel.", example = "PC")
    @ExcelProperty("Report Channel")
    private String channel;

    @Schema(description = "Work report time.")
    @ExcelProperty("Report Time")
    private LocalDateTime feedbackTime;

    @Schema(description = "Workstation code.", example = "1")
    private Long workstationId;

    @Schema(description = "Workstation code.", example = "WS-001")
    @ExcelProperty("Workstation Code")
    private String workstationCode;

    @Schema(description = "Workstation name.", example = "Injection workstation")
    @ExcelProperty("Workstation Name")
    private String workstationName;

    @Schema(description = "Routing path code.", example = "1")
    private Long routeId;

    @Schema(description = "Routing path code.", example = "RT-001")
    private String routeCode;

    @Schema(description = "Operation code.", example = "1")
    private Long processId;

    @Schema(description = "Operation code.", example = "PR-001")
    @ExcelProperty("Operation Code")
    private String processCode;

    @Schema(description = "Operation name.", example = "Injection")
    @ExcelProperty("Operation Name")
    private String processName;

    @Schema(description = "Is not need to need inspection.")
    private Boolean checkFlag;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Work order code.", example = "MO202503120008")
    @ExcelProperty("Work Order Code")
    private String workOrderCode;

    @Schema(description = "Work order name.", example = "Bosch screwdriver")
    @ExcelProperty("Work Order Name")
    private String workOrderName;

    @Schema(description = "Production task code.", example = "1")
    private Long taskId;

    @Schema(description = "Task code.", example = "PT202503150001")
    private String taskCode;

    @Schema(description = "Product material code.", example = "75")
    private Long itemId;

    @Schema(description = "Material code.", example = "I-075")
    @ExcelProperty("Material Code")
    private String itemCode;

    @Schema(description = "Material name.", example = "Bosch screwdriver")
    @ExcelProperty("Material Name")
    private String itemName;

    @Schema(description = "Spec / Model", example = "Flat-head")
    @ExcelProperty("Spec / Model")
    private String itemSpecification;

    @Schema(description = "Order characters code.", example = "202")
    private Long unitMeasureId;

    @Schema(description = "Order characters name.", example = "")
    @ExcelProperty("Unit")
    private String unitMeasureName;

    @Schema(description = "Expiration date.")
    private LocalDateTime expireDate;

    @Schema(description = "Production lot.", example = "LOT20260321")
    private String lotNumber;

    @Schema(description = "Scheduled Qty", example = "5000.00")
    @ExcelProperty("Scheduled Quantity")
    private BigDecimal scheduledQuantity;

    @Schema(description = "This Times work report quantity.", example = "500.00")
    @ExcelProperty("Reported Quantity")
    private BigDecimal feedbackQuantity;

    @Schema(description = "Passed quantity quantity.", example = "490.00")
    @ExcelProperty("Passed Quantity")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "Defect quantity.", example = "10.00")
    @ExcelProperty("Defect Quantity")
    private BigDecimal unqualifiedQuantity;

    @Schema(description = "Pending inspection quantity.", example = "0")
    @ExcelProperty("Pending Inspection Quantity")
    private BigDecimal uncheckQuantity;

    @Schema(description = "Process scrap quantity.", example = "6.00")
    private BigDecimal laborScrapQuantity;

    @Schema(description = "Material scrap quantity.", example = "4.00")
    private BigDecimal materialScrapQuantity;

    @Schema(description = "Other scrap quantity.", example = "0")
    private BigDecimal otherScrapQuantity;

    @Schema(description = "Work report user ID.", example = "1")
    private Long feedbackUserId;

    @Schema(description = "Work report person Nickname.", example = "John.")
    @ExcelProperty("Reporter")
    private String feedbackUserNickname;

    @Schema(description = "Approval user ID.", example = "1")
    private Long approveUserId;

    @Schema(description = "Approval person Nickname.", example = "Jane.")
    @ExcelProperty("Approver")
    private String approveUserNickname;

    @Schema(description = "Status.", example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_PRO_FEEDBACK_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

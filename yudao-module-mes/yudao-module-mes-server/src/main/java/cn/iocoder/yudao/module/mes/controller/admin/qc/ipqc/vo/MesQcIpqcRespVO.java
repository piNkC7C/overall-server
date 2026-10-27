package cn.iocoder.yudao.module.mes.controller.admin.qc.ipqc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "MES in-process inspection response VO.")
@Data
@ExcelIgnoreUnannotated
public class MesQcIpqcRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Inspection code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "IPQC20250101001")
    @ExcelProperty("Inspection No")
    private String code;

    @Schema(description = "Inspection name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "XX work-order in-process inspection")
    @ExcelProperty("Inspection Name")
    private String name;

    @Schema(description = "IPQC inspection type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Inspection Type")
    private Integer type;

    @Schema(description = "Inspection template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long templateId;

    // ========== source document ==========

    @Schema(description = "Source document type.", example = "304")
    private Integer sourceDocType;

    @Schema(description = "Source document ID.", example = "200")
    private Long sourceDocId;

    @Schema(description = "Source document line ID.", example = "300")
    private Long sourceLineId;

    @Schema(description = "Source document code.", example = "FB20250101001")
    private String sourceDocCode;

    // ========== production relation ==========

    @Schema(description = "Production work order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long workOrderId;

    @Schema(description = "Work order code.", example = "WO20250101001")
    @ExcelProperty("Work Order No")
    private String workOrderCode;

    @Schema(description = "Work order name.", example = "Production work orderA.")
    private String workOrderName;

    @Schema(description = "Production task ID.", example = "20")
    private Long taskId;

    @Schema(description = "Workstation ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    private Long workstationId;

    @Schema(description = "Workstationname.", example = "WorkstationA")
    @ExcelProperty("Station Name")
    private String workstationName;

    @Schema(description = "Operation ID.", example = "40")
    private Long processId;

    @Schema(description = "Operation name.", example = "Assembly")
    @ExcelProperty("Operation Name")
    private String processName;

    // ========== material ==========

    @Schema(description = "Product material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Long itemId;

    @Schema(description = "Product material code.", example = "ITEM001")
    @ExcelProperty("Product Material Code")
    private String itemCode;

    @Schema(description = "Product material name.", example = "Material A.")
    @ExcelProperty("Product Material Name")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100mm*50mm")
    private String itemSpecification;

    @Schema(description = "Order characters name.", example = "")
    private String unitName;

    // ========== quantity ==========

    @Schema(description = "Inspected quantity.", example = "100")
    @ExcelProperty("Inspected Quantity")
    private BigDecimal checkQuantity;

    @Schema(description = "Passed quantity quantity.", example = "95")
    @ExcelProperty("Passed Quantity")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "Failed quantity quantity.", example = "5")
    @ExcelProperty("Failed Quantity")
    private BigDecimal unqualifiedQuantity;

    @Schema(description = "Process scrap quantity.", example = "2")
    @ExcelProperty("Process Scrap Quantity")
    private BigDecimal laborScrapQuantity;

    @Schema(description = "Material scrap quantity.", example = "2")
    @ExcelProperty("Material Scrap Quantity")
    private BigDecimal materialScrapQuantity;

    @Schema(description = "Other scrap quantity.", example = "1")
    @ExcelProperty("Other Scrap Quantity")
    private BigDecimal otherScrapQuantity;

    // ========== defect Stats ==========

    @Schema(description = "Critical Defect Rate (%).", example = "0.00")
    private BigDecimal criticalRate;

    @Schema(description = "Major Defect Rate (%).", example = "0.00")
    private BigDecimal majorRate;

    @Schema(description = "Minor Defect Rate (%).", example = "10.00")
    private BigDecimal minorRate;

    @Schema(description = "Critical defect count", example = "0")
    private Integer criticalQuantity;

    @Schema(description = "Major defect count", example = "0")
    private Integer majorQuantity;

    @Schema(description = "Minor defect count", example = "1")
    private Integer minorQuantity;

    // ========== inspection ==========

    @Schema(description = "Inspection result.", example = "1")
    @ExcelProperty("Inspection Result")
    private Integer checkResult;

    @Schema(description = "Inspection Date")
    @ExcelProperty("Inspection Date")
    private LocalDateTime inspectDate;

    @Schema(description = "Inspectoruser ID.", example = "1")
    private Long inspectorUserId;

    @Schema(description = "InspectorNickname.", example = "John.")
    @ExcelProperty("Inspector")
    private String inspectorNickname;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

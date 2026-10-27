package cn.iocoder.yudao.module.mes.controller.admin.qc.rqc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES return inspection response.")
@Data
@ExcelIgnoreUnannotated
public class MesQcRqcRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Inspection code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "RQC20250101001")
    @ExcelProperty("Inspection No")
    private String code;

    @Schema(description = "Inspection name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material A return inspection.")
    @ExcelProperty("Inspection Name")
    private String name;

    @Schema(description = "Inspection template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long templateId;

    // ========== source document ==========

    @Schema(description = "Source document type.", example = "116")
    private Integer sourceDocType;

    @Schema(description = "Source document ID.", example = "200")
    private Long sourceDocId;

    @Schema(description = "Source document line ID.", example = "300")
    private Long sourceLineId;

    @Schema(description = "Source document code.", example = "RT20250101001")
    private String sourceDocCode;

    // ========== inspection type ==========

    @Schema(description = "Inspection type.", example = "1")
    @ExcelProperty("Inspection Type")
    private Integer type;

    // ========== material ==========

    @Schema(description = "Product material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
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

    @Schema(description = "Lot no.", example = "BATCH001")
    @ExcelProperty("Lot No")
    private String batchCode;

    // ========== quantity ==========

    @Schema(description = "Inspected quantity.", example = "100")
    @ExcelProperty("Inspected Quantity")
    private BigDecimal checkQuantity;

    @Schema(description = "Passed quantity quantity.", example = "90")
    @ExcelProperty("Passed Quantity")
    private BigDecimal qualifiedQuantity;

    @Schema(description = "Failed quantity.", example = "10")
    @ExcelProperty("Failed Quantity")
    private BigDecimal unqualifiedQuantity;

    // ========== defect Stats ==========

    @Schema(description = "Critical Defect Rate (%).", example = "5.00")
    private BigDecimal criticalRate;

    @Schema(description = "Major Defect Rate (%).", example = "10.00")
    private BigDecimal majorRate;

    @Schema(description = "Minor Defect Rate (%).", example = "15.00")
    private BigDecimal minorRate;

    @Schema(description = "Critical defect count", example = "5")
    private Integer criticalQuantity;

    @Schema(description = "Major defect count", example = "10")
    private Integer majorQuantity;

    @Schema(description = "Minor defect count", example = "15")
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

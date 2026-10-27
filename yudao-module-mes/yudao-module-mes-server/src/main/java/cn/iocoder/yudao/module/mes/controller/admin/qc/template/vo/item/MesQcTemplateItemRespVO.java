package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES quality inspection plan -product relation response.")
@Data
@ExcelIgnoreUnannotated
public class MesQcTemplateItemRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Quality inspection plan ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long templateId;

    @Schema(description = "Product material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Minimum inspection count.", example = "5")
    @ExcelProperty("Min Inspection Count")
    private Integer quantityCheck;

    @Schema(description = "Maximum failed count.", example = "0")
    @ExcelProperty("Max Fail Count")
    private Integer quantityUnqualified;

    @Schema(description = "MaximumCritical Defect Rate (%).", example = "0")
    @ExcelProperty("Critical Defect Rate %")
    private BigDecimal criticalRate;

    @Schema(description = "MaximumMajor Defect Rate (%).", example = "0")
    @ExcelProperty("Major Defect Rate %")
    private BigDecimal majorRate;

    @Schema(description = "MaximumMinor Defect Rate (%).", example = "100")
    @ExcelProperty("Minor Defect Rate %")
    private BigDecimal minorRate;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    // ========== JOIN mes_md_item ==========

    @Schema(description = "Material code.", example = "ITEM001")
    @ExcelProperty("Material Code")
    private String itemCode;

    @Schema(description = "Material name.", example = "Screw")
    @ExcelProperty("Material Name")
    private String itemName;

    @Schema(description = "Spec / Model", example = "M3x10")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "")
    @ExcelProperty("Unit Of Measure")
    private String unitMeasureName;

}

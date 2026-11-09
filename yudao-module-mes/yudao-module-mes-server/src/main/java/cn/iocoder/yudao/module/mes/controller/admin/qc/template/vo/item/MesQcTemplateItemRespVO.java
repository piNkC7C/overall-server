package cn.iocoder.yudao.module.mes.controller.admin.qc.template.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 质检方案-产品关联 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesQcTemplateItemRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "质检方案ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long templateId;

    @Schema(description = "产品物料ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "最低检测数", example = "5")
    @ExcelProperty("Min Inspection Count")
    private Integer quantityCheck;

    @Schema(description = "最大不合格数", example = "0")
    @ExcelProperty("Max Fail Count")
    private Integer quantityUnqualified;

    @Schema(description = "最大致命缺陷率（%）", example = "0")
    @ExcelProperty("Critical Defect Rate %")
    private BigDecimal criticalRate;

    @Schema(description = "最大严重缺陷率（%）", example = "0")
    @ExcelProperty("Major Defect Rate %")
    private BigDecimal majorRate;

    @Schema(description = "最大轻微缺陷率（%）", example = "100")
    @ExcelProperty("Minor Defect Rate %")
    private BigDecimal minorRate;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    // ========== JOIN mes_md_item ==========

    @Schema(description = "物料编码", example = "ITEM001")
    @ExcelProperty("Material Code")
    private String itemCode;

    @Schema(description = "物料名称", example = "Screw")
    @ExcelProperty("Material Name")
    private String itemName;

    @Schema(description = "规格型号", example = "M3x10")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "计量单位名称", example = "")
    @ExcelProperty("Unit Of Measure")
    private String unitMeasureName;

}

package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo.bom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 生产工单 BOM Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesProWorkOrderBomRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "生产工单编号", example = "100")
    private Long workOrderId;

    @Schema(description = "BOM 物料编号", example = "200")
    private Long itemId;

    @Schema(description = "物料名称", example = "Resistor R1")
    @ExcelProperty("Material Name")
    private String itemName;

    @Schema(description = "物料编码", example = "M-001")
    @ExcelProperty("Material Code")
    private String itemCode;

    @Schema(description = "规格型号", example = "10K 0603")
    @ExcelProperty("Spec / Model")
    private String itemSpecification;

    @Schema(description = "单位编号", example = "300")
    private Long unitMeasureId;

    @Schema(description = "单位名称", example = "")
    @ExcelProperty("Unit")
    private String unitMeasureName;

    @Schema(description = "预计使用量", example = "10.00")
    @ExcelProperty("Estimated Usage")
    private BigDecimal quantity;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "物料产品标识", example = "PRODUCT")
    private String itemOrProduct;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

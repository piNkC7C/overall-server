package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo.bom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production work order BOM response.")
@Data
@ExcelIgnoreUnannotated
public class MesProWorkOrderBomRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Production work order code.", example = "100")
    private Long workOrderId;

    @Schema(description = "BOM material code.", example = "200")
    private Long itemId;

    @Schema(description = "Material name.", example = "Resistor R1")
    @ExcelProperty("Material Name")
    private String itemName;

    @Schema(description = "Material code.", example = "M-001")
    @ExcelProperty("Material Code")
    private String itemCode;

    @Schema(description = "Spec / Model", example = "10K 0603")
    @ExcelProperty("Spec / Model")
    private String itemSpecification;

    @Schema(description = "Order characters code.", example = "300")
    private Long unitMeasureId;

    @Schema(description = "Order characters name.", example = "")
    @ExcelProperty("Unit")
    private String unitMeasureName;

    @Schema(description = "Expected usage.", example = "10.00")
    @ExcelProperty("Estimated Usage")
    private BigDecimal quantity;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Material product key.", example = "PRODUCT")
    private String itemOrProduct;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

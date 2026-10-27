package cn.iocoder.yudao.module.mes.controller.admin.pro.card.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production routing card response.")
@Data
@ExcelIgnoreUnannotated
public class MesProCardRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Routing card code.", example = "CARD-001")
    @ExcelProperty("Traveler Card Code")
    private String code;

    @Schema(description = "Production work order code.", example = "100")
    private Long workOrderId;

    @Schema(description = "Work order code.", example = "WO-001")
    @ExcelProperty("Work Order Code")
    private String workOrderCode;

    @Schema(description = "Work order name.", example = "Production work order-A.")
    @ExcelProperty("Work Order Name")
    private String workOrderName;

    @Schema(description = "Product material code.", example = "200")
    private Long itemId;

    @Schema(description = "Lot no.", example = "BATCH-001")
    @ExcelProperty("Lot No")
    private String batchCode;

    @Schema(description = "Product code.", example = "P-001")
    @ExcelProperty("Product Code")
    private String itemCode;

    @Schema(description = "Product name.", example = "PCB A")
    @ExcelProperty("Product Name")
    private String itemName;

    @Schema(description = "Spec / Model", example = "100x200mm")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "Order characters code.", example = "300")
    private Long unitMeasureId;

    @Schema(description = "Order characters name.", example = "")
    @ExcelProperty("Unit")
    private String unitMeasureName;

    @Schema(description = "Transfer Qty", example = "100.00")
    @ExcelProperty("Transfer Quantity")
    private BigDecimal transferedQuantity;

    @Schema(description = "Status.", example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

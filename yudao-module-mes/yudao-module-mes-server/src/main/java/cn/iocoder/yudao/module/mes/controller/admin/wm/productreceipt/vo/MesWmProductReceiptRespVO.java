package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES product receiving order response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmProductReceiptRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Receiving order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PR202603010001")
    @ExcelProperty("Receipt Code")
    private String code;

    @Schema(description = "Receiving order name.", example = "Product receiving order -work order001.")
    @ExcelProperty("Receipt Name")
    private String name;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Production work order code.", example = "WO202603010001")
    @ExcelProperty("Production Work Order")
    private String workOrderCode;

    @Schema(description = "Product material code.", example = "1")
    private Long itemId;

    @Schema(description = "Product material code.", example = "P001")
    @ExcelProperty("Product Material Code")
    private String itemCode;

    @Schema(description = "Product material name.", example = "Finished A")
    @ExcelProperty("Product Material Name")
    private String itemName;

    @Schema(description = "Spec / Model", example = "Standard")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Pcs.")
    @ExcelProperty("Unit Of Measure")
    private String unitMeasureName;

    @Schema(description = "Receiving Date.")
    @ExcelProperty("Receipt Date")
    private LocalDateTime receiptDate;

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

package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 产品收货单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmProductReceiptRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "收货单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "PR202603010001")
    @ExcelProperty("Receipt Code")
    private String code;

    @Schema(description = "收货单名称", example = "Product receiving order -work order001.")
    @ExcelProperty("Receipt Name")
    private String name;

    @Schema(description = "生产工单编号", example = "1")
    private Long workOrderId;

    @Schema(description = "生产工单编码", example = "WO202603010001")
    @ExcelProperty("Production Work Order")
    private String workOrderCode;

    @Schema(description = "产品物料编号", example = "1")
    private Long itemId;

    @Schema(description = "产品物料编码", example = "P001")
    @ExcelProperty("Product Material Code")
    private String itemCode;

    @Schema(description = "产品物料名称", example = "Finished A")
    @ExcelProperty("Product Material Name")
    private String itemName;

    @Schema(description = "规格型号", example = "Standard")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "计量单位名称", example = "Pcs.")
    @ExcelProperty("Unit Of Measure")
    private String unitMeasureName;

    @Schema(description = "收货日期")
    @ExcelProperty("Receipt Date")
    private LocalDateTime receiptDate;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

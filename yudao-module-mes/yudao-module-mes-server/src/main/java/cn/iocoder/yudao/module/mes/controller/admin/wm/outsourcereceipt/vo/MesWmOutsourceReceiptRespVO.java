package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourcereceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES subcontract inbound order response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmOutsourceReceiptRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "OR2026030001")
    @ExcelProperty("Inbound Order Code")
    private String code;

    @Schema(description = "Inbound order name.", example = "Subcontract inbound")
    @ExcelProperty("Inbound Order Name")
    private String name;

    @Schema(description = "Subcontract work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Subcontract work order code.", example = "WO20260301")
    @ExcelProperty("Subcontract Work Order")
    private String workOrderCode;

    @Schema(description = "Supplier code.", example = "1")
    private Long vendorId;

    @Schema(description = "Supplier name.", example = "A supplier.")
    @ExcelProperty("Supplier")
    private String vendorName;

    @Schema(description = "Inbound date.")
    @ExcelProperty("Inbound Date")
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

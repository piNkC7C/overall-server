package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES purchase receipt response.")
@Data
@ExcelIgnoreUnannotated
public class MesWmItemReceiptRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "IR2026020001")
    @ExcelProperty("Inbound Order Code")
    private String code;

    @Schema(description = "Inbound order name.", example = "Steel plateinbound order.")
    @ExcelProperty("Inbound Order Name")
    private String name;

    @Schema(description = "Incoming inspection number.", example = "1")
    private Long iqcId;

    @Schema(description = "Incoming inspectioncode.", example = "IQC20260201")
    @ExcelProperty("Incoming Inspection")
    private String iqcCode;

    @Schema(description = "Receiving notification order code.", example = "1")
    private Long noticeId;

    @Schema(description = "Receiving notification order code.", example = "AN2026020001")
    @ExcelProperty("ASN")
    private String noticeCode;

    @Schema(description = "Purchase order no.", example = "PO20260201")
    @ExcelProperty("Purchase Order No")
    private String purchaseOrderCode;

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

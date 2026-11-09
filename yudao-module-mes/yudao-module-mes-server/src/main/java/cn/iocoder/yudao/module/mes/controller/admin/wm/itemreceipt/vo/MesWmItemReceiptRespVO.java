package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 采购入库单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesWmItemReceiptRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "入库单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "IR2026020001")
    @ExcelProperty("Inbound Order Code")
    private String code;

    @Schema(description = "入库单名称", example = "Steel plateinbound order.")
    @ExcelProperty("Inbound Order Name")
    private String name;

    @Schema(description = "来料检验单编号", example = "1")
    private Long iqcId;

    @Schema(description = "来料检验单编码", example = "IQC20260201")
    @ExcelProperty("Incoming Inspection")
    private String iqcCode;

    @Schema(description = "到货通知单编号", example = "1")
    private Long noticeId;

    @Schema(description = "到货通知单编码", example = "AN2026020001")
    @ExcelProperty("ASN")
    private String noticeCode;

    @Schema(description = "采购订单号", example = "PO20260201")
    @ExcelProperty("Purchase Order No")
    private String purchaseOrderCode;

    @Schema(description = "供应商编号", example = "1")
    private Long vendorId;

    @Schema(description = "供应商名称", example = "A supplier.")
    @ExcelProperty("Supplier")
    private String vendorName;

    @Schema(description = "入库日期")
    @ExcelProperty("Inbound Date")
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

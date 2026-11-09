package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 采购入库单新增/修改 Request VO")
@Data
public class MesWmItemReceiptSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "入库单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "IR2026020001")
    @NotEmpty(message = "Inbound order code is required.")
    private String code;

    @Schema(description = "入库单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Steel plateinbound order.")
    @NotEmpty(message = "Inbound order name is required.")
    private String name;

    @Schema(description = "来料检验单编号", example = "1")
    private Long iqcId;

    @Schema(description = "到货通知单编号", example = "1")
    private Long noticeId;

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Supplier is required.")
    private Long vendorId;

    @Schema(description = "入库日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inbound date is required.")
    private LocalDateTime receiptDate;

    @Schema(description = "采购订单号", example = "PO20260201")
    private String purchaseOrderCode;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

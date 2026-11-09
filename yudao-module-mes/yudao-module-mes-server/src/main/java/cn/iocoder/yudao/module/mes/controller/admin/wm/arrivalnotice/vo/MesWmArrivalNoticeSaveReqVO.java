package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 到货通知单新增/修改 Request VO")
@Data
public class MesWmArrivalNoticeSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "通知单编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "AN2026020001")
    @NotEmpty(message = "Notification order code is required.")
    private String code;

    @Schema(description = "通知单名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "2 Monthsteel plate receiving.")
    @NotEmpty(message = "Notification order name is required.")
    private String name;

    @Schema(description = "采购订单编号", example = "PO20260101")
    private String purchaseOrderCode;

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Supplier code is required.")
    private Long vendorId;

    @Schema(description = "到货日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Receiving Date is required.")
    private LocalDateTime arrivalDate;

    @Schema(description = "联系人", example = "John.")
    private String contactName;

    @Schema(description = "联系电话", example = "13800138000")
    private String contactTelephone;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }

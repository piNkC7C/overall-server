package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES receiving notification order create / edit request.")
@Data
public class MesWmArrivalNoticeSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Notification order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "AN2026020001")
    @NotEmpty(message = "Notification order code is required.")
    private String code;

    @Schema(description = "Notification order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2 Monthsteel plate receiving.")
    @NotEmpty(message = "Notification order name is required.")
    private String name;

    @Schema(description = "Purchase order code.", example = "PO20260101")
    private String purchaseOrderCode;

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Supplier code is required.")
    private Long vendorId;

    @Schema(description = "Receiving Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Receiving Date is required.")
    private LocalDateTime arrivalDate;

    @Schema(description = "Contact.", example = "John.")
    private String contactName;

    @Schema(description = "Phone", example = "13800138000")
    private String contactTelephone;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }

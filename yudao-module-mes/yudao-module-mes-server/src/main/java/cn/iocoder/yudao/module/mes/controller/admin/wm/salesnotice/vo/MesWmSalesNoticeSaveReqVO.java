package cn.iocoder.yudao.module.mes.controller.admin.wm.salesnotice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES shipping notification order create / edit request.")
@Data
public class MesWmSalesNoticeSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Notification order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SN202603010001")
    @NotEmpty(message = "Notification order code is required.")
    private String code;

    @Schema(description = "Notification order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test shipment notice")
    @NotEmpty(message = "Notification order name is required.")
    private String name;

    @Schema(description = "Sales order code.", example = "SO202603010001")
    private String salesOrderCode;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Customer code is required.")
    private Long clientId;

    @Schema(description = "Shipping Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Shipping Date is required.")
    private LocalDateTime salesDate;

    @Schema(description = "Receiving person.", example = "John.")
    private String recipientName;

    @Schema(description = "Contact", example = "13800138000")
    private String recipientTelephone;

    @Schema(description = "Receiving Address.", example = "District xxx, Seattle")
    private String recipientAddress;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

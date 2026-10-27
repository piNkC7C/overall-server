package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Admin - MES transfer order Save request.")
@Data
public class MesWmTransferSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Transfer order code.", requiredMode = REQUIRED, example = "TR2026020001")
    @NotBlank(message = "Transfer order code is required.")
    private String code;

    @Schema(description = "Transfer order name.", requiredMode = REQUIRED, example = "Steel plate transfer order.")
    @NotBlank(message = "Transfer order name is required.")
    private String name;

    @Schema(description = "Transfer order type.", requiredMode = REQUIRED, example = "1")
    @NotNull(message = "Transfer order type is required.")
    private Integer type;

    @Schema(description = "Deliver.", requiredMode = REQUIRED, example = "true")
    @NotNull(message = "Deliver cannot be empty.")
    private Boolean deliveryFlag;

    @Schema(description = "Receiving person.", example = "John.")
    private String recipientName;

    @Schema(description = "Contact", example = "13800138000")
    private String recipientTelephone;

    @Schema(description = "Destination.", example = "Pudong, Shanghai")
    private String destinationAddress;

    @Schema(description = "Carrier", example = "SF Express")
    private String carrier;

    @Schema(description = "Tracking No.", example = "SF123456789")
    private String shippingNumber;

    @Schema(description = "Transfer Date.", requiredMode = REQUIRED)
    @NotNull(message = "Transfer Date is required.")
    private LocalDateTime transferDate;

    @Schema(description = "Notes.", example = "Notes info.")
    private String remark;

}

package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES transfer order response.")
@Data
public class MesWmTransferRespVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Transfer order code.", example = "TR2026020001")
    private String code;

    @Schema(description = "Transfer order name.", example = "Steel plate transfer order.")
    private String name;

    @Schema(description = "Transfer order type.", example = "1")
    private Integer type;

    @Schema(description = "Deliver.", example = "true")
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

    @Schema(description = "Is not already confirm.", example = "false")
    private Boolean confirmFlag;

    @Schema(description = "Transfer Date.")
    private LocalDateTime transferDate;

    @Schema(description = "Document status.", example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes info.")
    private String remark;

}

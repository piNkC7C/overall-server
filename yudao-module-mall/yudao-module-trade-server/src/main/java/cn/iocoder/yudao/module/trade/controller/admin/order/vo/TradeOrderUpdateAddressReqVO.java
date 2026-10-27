package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - order edit Address request.")
@Data
public class TradeOrderUpdateAddressReqVO {

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Order code is required.")
    private Long id;

    @Schema(description = "Recipient name", requiredMode = Schema.RequiredMode.REQUIRED, example = "ZJohn.")
    @NotEmpty(message = "Recipient name is required.")
    private String receiverName;

    @Schema(description = "Recipient mobile.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19988188888")
    @NotEmpty(message = "Recipient mobile cannot be empty.")
    private String receiverMobile;

    @Schema(description = "Recipient region ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7310")
    @NotNull(message = "Recipient region ID cannot be empty.")
    private Integer receiverAreaId;

    @Schema(description = "Recipient street address.", requiredMode = Schema.RequiredMode.REQUIRED, example = "xxx Community, District, City")
    @NotEmpty(message = "Recipient street address cannot be empty.")
    private String receiverDetailAddress;

}

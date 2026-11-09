package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - 订单修改地址 Request VO")
@Data
public class TradeOrderUpdateAddressReqVO {

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Order code is required.")
    private Long id;

    @Schema(description = "收件人名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "ZJohn.")
    @NotEmpty(message = "Recipient name is required.")
    private String receiverName;

    @Schema(description = "收件人手机", requiredMode = Schema.RequiredMode.REQUIRED, example = "19988188888")
    @NotEmpty(message = "Recipient mobile cannot be empty.")
    private String receiverMobile;

    @Schema(description = "收件人地区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "7310")
    @NotNull(message = "Recipient region ID cannot be empty.")
    private Integer receiverAreaId;

    @Schema(description = "收件人详细地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "xxx Community, District, City")
    @NotEmpty(message = "Recipient street address cannot be empty.")
    private String receiverDetailAddress;

}

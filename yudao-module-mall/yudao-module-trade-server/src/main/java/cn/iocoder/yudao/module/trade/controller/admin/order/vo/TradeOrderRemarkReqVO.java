package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - 订单备注 Request VO")
@Data
public class TradeOrderRemarkReqVO {

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Order code is required.")
    private Long id;

    @Schema(description = "商家备注", example = "Take a guess")
    @NotEmpty(message = "Order notes is required.")
    private String remark;

}

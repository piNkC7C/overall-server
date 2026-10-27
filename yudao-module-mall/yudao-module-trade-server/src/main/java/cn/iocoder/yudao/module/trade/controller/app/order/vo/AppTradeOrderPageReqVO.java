package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.trade.enums.order.TradeOrderStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Trade order page request.")
@Data
public class AppTradeOrderPageReqVO extends PageParam {

    @Schema(description = "Order status.", example = "1")
    @InEnum(value = TradeOrderStatusEnum.class, message = "Order status must be {value}.")
    private Integer status;

    @Schema(description = "Is not review.", example = "true")
    private Boolean commentStatus;

}

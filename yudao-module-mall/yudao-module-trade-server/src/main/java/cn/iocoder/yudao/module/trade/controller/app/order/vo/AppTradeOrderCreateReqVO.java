package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

@Schema(description = "用户 App - 交易订单创建 Request VO")
@Data
public class AppTradeOrderCreateReqVO extends AppTradeOrderSettlementReqVO {

    @Schema(description = "备注", example = "This is my order")
    private String remark;

    @AssertTrue(message = "Delivery Method is required.")
    @JsonIgnore
    public boolean isDeliveryTypeNotNull() {
        return getDeliveryType() != null;
    }

}

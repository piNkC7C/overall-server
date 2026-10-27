package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

@Schema(description = "User App - trade ordercreate request.")
@Data
public class AppTradeOrderCreateReqVO extends AppTradeOrderSettlementReqVO {

    @Schema(description = "Notes.", example = "This is my order")
    private String remark;

    @AssertTrue(message = "Delivery Method is required.")
    @JsonIgnore
    public boolean isDeliveryTypeNotNull() {
        return getDeliveryType() != null;
    }

}

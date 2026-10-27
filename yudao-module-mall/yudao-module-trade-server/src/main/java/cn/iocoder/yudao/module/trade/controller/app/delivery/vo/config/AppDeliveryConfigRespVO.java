package cn.iocoder.yudao.module.trade.controller.app.delivery.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

// TODO 芋艿：后续要实现下，配送配置；后续融合到 AppTradeConfigRespVO 中
@Schema(description = "Delivery setting response VO.")
@Data
public class AppDeliveryConfigRespVO {

    @Schema(description = "Tencent Map key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    private String tencentLbsKey;

    @Schema(description = "Is not enable pickup.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean pickUpEnable;

}

package cn.iocoder.yudao.module.trade.controller.app.delivery.vo.express;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "App - Courier response.")
@Data
public class AppDeliveryExpressRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Store Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "SF Express")
    private String name;

}

package cn.iocoder.yudao.module.trade.controller.admin.config.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Trade center setting response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradeConfigRespVO extends TradeConfigBaseVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Tencent Map key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123456")
    private String tencentLbsKey;

}

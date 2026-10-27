package cn.iocoder.yudao.module.fms.controller.admin.config.vo.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * FMS 币别 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "FMS currency response VO.")
@Data
public class FmsCurrencyRespVO {

    @Schema(description = "Currency ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountSetId;

    @Schema(description = "Currency code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "USD")
    private String code;

    @Schema(description = "Currency name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "USD")
    private String name;

    @Schema(description = "Exchange rate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7.120000")
    private BigDecimal exchangeRate;

    @Schema(description = "WhetherBase currency.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean standard;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

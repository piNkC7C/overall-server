package cn.iocoder.yudao.module.pay.controller.admin.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Schema(description = "Payment app info page search response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayAppPageItemRespVO extends PayAppBaseVO {

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Already setting payment channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[alipay_pc, alipay_wap]")
    private Set<String> channelCodes;

}

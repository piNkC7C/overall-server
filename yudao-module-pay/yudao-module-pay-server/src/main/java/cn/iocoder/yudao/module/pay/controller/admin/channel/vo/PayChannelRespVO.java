package cn.iocoder.yudao.module.pay.controller.admin.channel.vo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Schema(description = "Admin - payment channel response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayChannelRespVO extends PayChannelBaseVO {

    @Schema(description = "Merchant number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private LocalDateTime createTime;

    @Schema(description = "Channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "alipay_pc")
    private String code;

    @Schema(description = "Setting.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String config;

}

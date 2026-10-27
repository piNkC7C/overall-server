package cn.iocoder.yudao.module.pay.controller.admin.channel.vo;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;

/**
* 支付渠道 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PayChannelBaseVO {

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enable status is required.")
    @InEnum(CommonStatusEnum.class)
    private Integer status;

    @Schema(description = "Notes.", example = "I am a short note")
    private String remark;

    @Schema(description = "Channel fee rate in percent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Channel fee rate, as a percentage cannot be empty.")
    private Double feeRate;

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "App code is required.")
    private Long appId;

}

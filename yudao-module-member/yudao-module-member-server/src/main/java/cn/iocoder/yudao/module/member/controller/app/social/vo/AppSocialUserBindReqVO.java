package cn.iocoder.yudao.module.member.controller.app.social.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.system.enums.social.SocialTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "User APP - social bind request, used code Authorization code.")
@Data
public class AppSocialUserBindReqVO {

    @Schema(description = "Social platform type. See SocialTypeEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @InEnum(SocialTypeEnum.class)
    @NotNull(message = "Social platform type is required")
    private Integer type;

    @Schema(description = "Authorization code", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Authorization code is required")
    private String code;

    @Schema(description = "state", requiredMode = Schema.RequiredMode.REQUIRED, example = "9b2ffbc1-7425-4155-9894-9d5c08541d62")
    @NotEmpty(message = "State is required.")
    private String state;

}
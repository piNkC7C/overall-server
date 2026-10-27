package cn.iocoder.yudao.module.system.api.social.dto;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.system.enums.social.SocialTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "RPC service - cancel bind social user Request DTO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUserBindReqDTO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "User ID is required.")
    private Long userId;
    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(UserTypeEnum.class)
    @NotNull(message = "User type is required.")
    private Integer userType;

    @Schema(description = "Social platform type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(SocialTypeEnum.class)
    @NotNull(message = "Social platform type is required")
    private Integer socialType;
    @Schema(description = "Authorization code", requiredMode = Schema.RequiredMode.REQUIRED, example = "zsw")
    @NotEmpty(message = "Authorization code is required")
    private String code;
    @Schema(description = "state", requiredMode = Schema.RequiredMode.REQUIRED, example = "qtw")
    @NotEmpty(message = "State is required.")
    private String state;

}

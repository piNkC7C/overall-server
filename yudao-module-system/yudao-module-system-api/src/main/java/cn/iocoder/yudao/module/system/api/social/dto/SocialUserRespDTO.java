package cn.iocoder.yudao.module.system.api.social.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "RPC service - social user Response DTO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUserRespDTO {

    @Schema(description = "Social user openid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "zsw")
    private String openid;

    @Schema(description = "Social user Nickname.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String nickname;

    @Schema(description = "Social user Avatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn/1.jpg")
    private String avatar;

    @Schema(description = "Relation user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

}

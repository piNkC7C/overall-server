package cn.iocoder.yudao.module.member.api.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "RPC service - user info Response DTO.")
@Data
public class MemberUserRespDTO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Nickname", example = "Sam")
    private String nickname;

    @Schema(description = "Account status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See CommonStatusEnum enum

    @Schema(description = "UserAvatar.", example = "https://www.iocoder.cn/xxx.jpg")
    private String avatar;

    @Schema(description = "Phone number.", example = "15601691300")
    private String mobile;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== other info ==========

    @Schema(description = "Member level code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long levelId;

    @Schema(description = "Points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "886")
    private Integer point;

}

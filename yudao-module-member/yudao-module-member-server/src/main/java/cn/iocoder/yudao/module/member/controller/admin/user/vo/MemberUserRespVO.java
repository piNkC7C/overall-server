package cn.iocoder.yudao.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - memberuser response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserRespVO extends MemberUserBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23788")
    private Long id;

    @Schema(description = "Register IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String registerIp;

    @Schema(description = "Last sign-in IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String loginIp;

    @Schema(description = "Last sign-in time", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime loginDate;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== other info ==========

    @Schema(description = "Points.", requiredMode  = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer point;

    @Schema(description = "Total points.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    private Integer totalPoint;

    @Schema(description = "Membertag.", example = "[Red, Happy]")
    private List<String> tagNames;

    @Schema(description = "Member level.", example = "Gold member")
    private String levelName;

    @Schema(description = "User group.", example = "Shopper")
    private String groupName;

    @Schema(description = "UserXP.", requiredMode  = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer experience;

}

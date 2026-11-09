package cn.iocoder.yudao.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - 会员用户 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MemberUserRespVO extends MemberUserBaseVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "23788")
    private Long id;

    @Schema(description = "注册 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String registerIp;

    @Schema(description = "最后登录IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String loginIp;

    @Schema(description = "最后登录时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime loginDate;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== other info ==========

    @Schema(description = "积分", requiredMode  = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer point;

    @Schema(description = "总积分", requiredMode = Schema.RequiredMode.REQUIRED, example = "2000")
    private Integer totalPoint;

    @Schema(description = "会员标签", example = "[Red, Happy]")
    private List<String> tagNames;

    @Schema(description = "会员等级", example = "Gold member")
    private String levelName;

    @Schema(description = "用户分组", example = "Shopper")
    private String groupName;

    @Schema(description = "用户经验值", requiredMode  = Schema.RequiredMode.REQUIRED, example = "200")
    private Integer experience;

}

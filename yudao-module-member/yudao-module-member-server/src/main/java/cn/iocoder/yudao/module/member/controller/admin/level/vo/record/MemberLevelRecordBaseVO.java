package cn.iocoder.yudao.module.member.controller.admin.level.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * 会员等级记录 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MemberLevelRecordBaseVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25923")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Level code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25985")
    @NotNull(message = "Level code is required.")
    private Long levelId;

    @Schema(description = "Member level.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Member level is required.")
    private Integer level;

    @Schema(description = "Discount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13319")
    @NotNull(message = "Discount cannot be empty.")
    private Integer discountPercent;

    @Schema(description = "Upgrade experience.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13319")
    @NotNull(message = "Upgrade experience is required.")
    private Integer experience;

    @Schema(description = "Member this time experience.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13319")
    @NotNull(message = "Member this time experience is required.")
    private Integer userExperience;

    @Schema(description = "Notes.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Marketing need")
    @NotNull(message = "Notes is required.")
    private String remark;

    @Schema(description = "Description", requiredMode = Schema.RequiredMode.REQUIRED, example = "Upgrade to gold member")
    @NotNull(message = "Description is required.")
    private String description;

}

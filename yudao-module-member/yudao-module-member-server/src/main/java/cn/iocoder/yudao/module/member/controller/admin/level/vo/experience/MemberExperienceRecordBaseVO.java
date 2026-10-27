package cn.iocoder.yudao.module.member.controller.admin.level.vo.experience;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * 会员经验记录 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MemberExperienceRecordBaseVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3638")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12164")
    @NotNull(message = "Business code is required.")
    private String bizId;

    @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Business type is required.")
    private Integer bizType;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Add experience")
    @NotNull(message = "Title is required.")
    private String title;

    @Schema(description = "Experience.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Experience is required.")
    private Integer experience;

    @Schema(description = "XP after change.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "XP after change cannot be empty.")
    private Integer totalExperience;

    @Schema(description = "Description", requiredMode = Schema.RequiredMode.REQUIRED, example = "Add 100 XP on order")
    @NotNull(message = "Description is required.")
    private String description;

}

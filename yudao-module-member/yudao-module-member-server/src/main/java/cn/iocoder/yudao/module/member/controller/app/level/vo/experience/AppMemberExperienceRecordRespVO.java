package cn.iocoder.yudao.module.member.controller.app.level.vo.experience;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "User App - member experience record response.")
@Data
public class AppMemberExperienceRecordRespVO {

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Add experience")
    private String title;

    @Schema(description = "Experience.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer experience;

    @Schema(description = "Description", requiredMode = Schema.RequiredMode.REQUIRED, example = "Add 100 XP on order")
    private String description;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

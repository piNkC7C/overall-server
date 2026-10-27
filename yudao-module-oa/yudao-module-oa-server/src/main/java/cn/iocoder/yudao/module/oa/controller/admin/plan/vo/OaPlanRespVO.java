package cn.iocoder.yudao.module.oa.controller.admin.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA Work Plan response.")
@Data
public class OaPlanRespVO {

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Nickname", example = "Overall.")
    private String userName;

    @Schema(description = "Department code.", example = "1")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Plan type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Plan status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "This week's plan")
    private String title;

    @Schema(description = "Tag.", example = "This week's focus")
    private String label;

    @Schema(description = "Plan content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish office-supply count variances next week and restock as needed.")
    private String content;

    @Schema(description = "Plan summary.", example = "Completed this week plan Alltask.")
    private String summary;

    @Schema(description = "Plan review.", example = "The plan is on track. Continue follow-up.")
    private String comment;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime endTime;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}

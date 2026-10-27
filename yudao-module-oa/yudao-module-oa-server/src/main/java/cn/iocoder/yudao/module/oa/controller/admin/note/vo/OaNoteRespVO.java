package cn.iocoder.yudao.module.oa.controller.admin.note.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA Note response.")
@Data
public class OaNoteRespVO {

    @Schema(description = "Note code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Creator user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long creatorUserId;

    @Schema(description = "Creator nickname.", example = "Overall.")
    private String creatorUserName;

    @Schema(description = "Directory code.", example = "1024")
    private Long categoryId;

    @Schema(description = "Directory name.", example = "Work")
    private String categoryName;

    @Schema(description = "Note type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Priority", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer priority;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Project meeting minutes")
    private String title;

    @Schema(description = "Content.", example = "Record this week's meeting decisions and action items.")
    private String content;

    @Schema(description = "Is not Favorite.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean favorite;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Recipient user ID list.", example = "[1, 2]")
    private List<Long> receiverUserIds;

    @Schema(description = "Recipient nickname list.", example = "[\"John\", \"Jane\"]")
    private List<String> receiverUserNames;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}

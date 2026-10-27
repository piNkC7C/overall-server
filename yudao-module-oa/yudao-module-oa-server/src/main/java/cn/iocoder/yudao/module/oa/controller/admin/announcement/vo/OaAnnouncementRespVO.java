package cn.iocoder.yudao.module.oa.controller.admin.announcement.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA announcement response.")
@Data
public class OaAnnouncementRespVO {

    @Schema(description = "Announcement code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Publisher user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long publisherUserId;

    @Schema(description = "Publisher nickname.", example = "Overall.")
    private String publisherUserName;

    @Schema(description = "Publisherdepartment code.", example = "1")
    private Long publisherDeptId;

    @Schema(description = "Publisherdepartment name.", example = "Engineering.")
    private String publisherDeptName;

    @Schema(description = "Announcement type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Priority", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer priority;

    @Schema(description = "Announcement title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "National Day holiday notice")
    private String title;

    @Schema(description = "Announcement content.", example = "Please arrange holiday coverage in advance.")
    private String content;

    @Schema(description = "Related URL.", example = "https://example.com/file.pdf")
    private String url;

    @Schema(description = "Is not Pin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean top;

    @Schema(description = "Recipient user ID list.", example = "[1, 2]")
    private List<Long> receiverUserIds;

    @Schema(description = "Recipient nickname list.", example = "[\"John\", \"Jane\"]")
    private List<String> receiverUserNames;

    @Schema(description = "Current Recipient is not Read.", example = "false")
    private Boolean readStatus;

    @Schema(description = "Whether the current recipient forwarded this to reports.", example = "false")
    private Boolean forwarded;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.announcement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS item announcement response.")
@Data
public class PmsProjectAnnouncementRespVO {

    @Schema(description = "Announcement code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long projectId;

    @Schema(description = "Announcement content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Project kickoff")
    private String content;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/a.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Creator user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long creatorUserId;

    @Schema(description = "Creator nickname.", example = "Overall.")
    private String creatorUserName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime updateTime;

}

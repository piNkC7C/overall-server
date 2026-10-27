package cn.iocoder.yudao.module.system.controller.admin.notice.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - notificationannouncement info response.")
@Data
public class NoticeRespVO {

    @Schema(description = "NotificationannouncementNo.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Announcement title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Blogger")
    private String title;

    @Schema(description = "Announcement type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Blogger")
    private Integer type;

    @Schema(description = "Announcement content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Lifelong coding")
    private String content;

    @Schema(description = "Status, see CommonStatusEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Timestamp format.")
    private LocalDateTime createTime;

}

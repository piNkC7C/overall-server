package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - email directory response.")
@Data
public class OaMailFolderRespVO {

    @Schema(description = "Directory search key.", example = "INBOX")
    private String key;

    @Schema(description = "Show name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Inbox")
    private String name;

    @Schema(description = "Unread quantity.", example = "1")
    private Long unreadCount;

}

package cn.iocoder.yudao.module.promotion.controller.admin.kefu.vo.conversation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - support conversation response.")
@Data
public class KeFuConversationRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24988")
    private Long id;

    @Schema(description = "Conversation user.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8300")
    private Long userId;
    @Schema(description = "Conversation userAvatar.", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://yudao.com/images/avatar.jpg")
    private String userAvatar;
    @Schema(description = "Conversation nickname.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String userNickname;

    @Schema(description = "Last chat time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime lastMessageTime;

    @Schema(description = "Last chat content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi there")
    private String lastMessageContent;

    @Schema(description = "Last message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer lastMessageContentType;

    @Schema(description = "Pin in admin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean adminPinned;

    @Schema(description = "UserVisible.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean userDeleted;

    @Schema(description = "AdminVisible.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean adminDeleted;

    @Schema(description = "Admin unread count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6")
    private Integer adminUnreadMessageCount;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}
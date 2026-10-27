package cn.iocoder.yudao.module.im.controller.admin.friend.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * IM 好友申请 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - IM contact apply please response.")
@Data
public class ImFriendRequestRespVO {

    @Schema(description = "Apply please code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Initiatoruser ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long fromUserId;

    @Schema(description = "Recipient user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    private Long toUserId;

    @Schema(description = "Process result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer handleResult; // See ImFriendRequestHandleResultEnum enum

    @Schema(description = "Apply please reason.", example = "I am Potato (a food)")
    private String applyContent;

    @Schema(description = "Handle reason. Optional when the recipient rejects.", example = "Not approved yet")
    private String handleContent;

    @Schema(description = "Add source.", example = "1")
    private Integer addSource; // See ImFriendAddSourceEnum enum

    @Schema(description = "Process time.")
    private LocalDateTime handleTime;

    @Schema(description = "Apply please create time.")
    private LocalDateTime createTime;

    @Schema(description = "Last update time (incremental cursor).")
    private LocalDateTime updateTime;

    // ========== 下面是聚合字段，方便前端显示 ==========

    @Schema(description = "Requester nickname, live-aggregated from AdminUser.", example = "Overall.")
    private String fromNickname;

    @Schema(description = "Requester avatar, live-aggregated from AdminUser.")
    private String fromAvatar;

    @Schema(description = "Recipient nickname, live-aggregated from AdminUser.", example = "John")
    private String toNickname;

    @Schema(description = "Recipient avatar, live-aggregated from AdminUser.")
    private String toAvatar;

}

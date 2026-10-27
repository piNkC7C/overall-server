package cn.iocoder.yudao.module.im.controller.admin.manager.friend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM contactRelationship response.")
@Data
public class ImFriendManagerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "Nickname", example = "John.")
    private String userNickname;

    @Schema(description = "Contact user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long friendUserId;

    @Schema(description = "ContactNickname.", example = "Jane.")
    private String friendNickname;

    @Schema(description = "Friend display remark.")
    private String displayName;

    @Schema(description = "Add source.", example = "1")
    private Integer addSource; // See ImFriendAddSourceEnum enum class

    @Schema(description = "Is not Do Not Disturb.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean silent;

    @Schema(description = "Is not Pincontact.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean pinned;

    @Schema(description = "Blocked.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean blocked;

    @Schema(description = "Contact status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Add contact time.")
    private LocalDateTime addTime;

    @Schema(description = "Deletecontact time.")
    private LocalDateTime deleteTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.im.controller.admin.manager.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - IM group chat response.")
@Data
public class ImGroupManagerRespVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Group name", requiredMode = Schema.RequiredMode.REQUIRED, example = "Tech group")
    private String name;

    @Schema(description = "Group avatar.")
    private String avatar;

    @Schema(description = "Group announcement.")
    private String notice;

    @Schema(description = "Group Owner user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long ownerUserId;

    @Schema(description = "Group OwnerNickname.", example = "John.")
    private String ownerNickname;

    @Schema(description = "Group member count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Integer memberCount;

    @Schema(description = "Group status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See CommonStatusEnum enum class

    @Schema(description = "Disband time.")
    private LocalDateTime dissolvedTime;

    @Schema(description = "Banned.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean banned;

    @Schema(description = "Mute the whole group.")
    private Boolean mutedAll;

    @Schema(description = "Ban reason.")
    private String bannedReason;

    @Schema(description = "Ban time.")
    private LocalDateTime bannedTime;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

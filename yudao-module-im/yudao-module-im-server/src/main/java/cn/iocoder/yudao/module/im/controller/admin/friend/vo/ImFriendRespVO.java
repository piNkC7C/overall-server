package cn.iocoder.yudao.module.im.controller.admin.friend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * IM 好友 Response VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - IM contact response.")
@Data
public class ImFriendRespVO {

    @Schema(description = "Relationshiprecord code.", example = "1024")
    private Long id;

    @Schema(description = "Contact user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long friendUserId;

    @Schema(description = "Is not Do Not Disturb.", example = "false")
    private Boolean silent;

    @Schema(description = "Friend display remark, visible only to you.", example = "John")
    private String displayName;

    @Schema(description = "Pinyin of the friend display remark (lowercase, no spaces).", example = "laozhang")
    private String displayNamePinyin;

    @Schema(description = "Add source.", example = "1")
    private Integer addSource; // See ImFriendAddSourceEnum enum

    @Schema(description = "Is not Pincontact.", example = "false")
    private Boolean pinned;

    @Schema(description = "Blocked, visible only to you.", example = "false")
    private Boolean blocked;

    @Schema(description = "Contact status.", example = "0")
    private Integer status;

    @Schema(description = "Add contact time.")
    private LocalDateTime addTime;

    @Schema(description = "Deletecontact time.")
    private LocalDateTime deleteTime;

    @Schema(description = "Last update time (incremental cursor).")
    private LocalDateTime updateTime;

    // ========== 下面是聚合字段，方便前端显示 ==========

    @Schema(description = "Friend nickname, live-aggregated from AdminUser.", example = "Overall.")
    private String nickname;

    @Schema(description = "Pinyin of the friend nickname (lowercase, no spaces).", example = "yudao")
    private String nicknamePinyin;

    @Schema(description = "Friend avatar, live-aggregated from AdminUser.")
    private String avatar;

}

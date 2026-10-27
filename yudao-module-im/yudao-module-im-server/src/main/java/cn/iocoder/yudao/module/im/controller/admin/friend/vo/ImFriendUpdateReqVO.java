package cn.iocoder.yudao.module.im.controller.admin.friend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - IM contactupdate request.")
@Data
public class ImFriendUpdateReqVO {

    @Schema(description = "Contact user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Contact user ID is required.")
    private Long friendUserId;

    @Schema(description = "Mute notifications. Omit to leave unchanged.", example = "true")
    private Boolean silent;

    @Schema(description = "Friend display remark, visible only to you. Omit to leave unchanged. Empty string clears it.", example = "John")
    @Size(max = 16, message = "Friend remark cannot exceed 16 characters.")
    private String displayName;

    @Schema(description = "Pin contact. Omit to leave unchanged.", example = "true")
    private Boolean pinned;

}

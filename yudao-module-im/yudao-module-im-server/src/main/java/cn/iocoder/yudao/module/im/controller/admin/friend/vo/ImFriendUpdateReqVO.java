package cn.iocoder.yudao.module.im.controller.admin.friend.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - IM 好友更新 Request VO")
@Data
public class ImFriendUpdateReqVO {

    @Schema(description = "好友的用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Contact user ID is required.")
    private Long friendUserId;

    @Schema(description = "是否免打扰；不传表示不修改", example = "true")
    private Boolean silent;

    @Schema(description = "好友展示备注（仅自己可见）；不传表示不修改，传空串表示清空", example = "John")
    @Size(max = 16, message = "Friend remark cannot exceed 16 characters.")
    private String displayName;

    @Schema(description = "是否置顶联系人；不传表示不修改", example = "true")
    private Boolean pinned;

}

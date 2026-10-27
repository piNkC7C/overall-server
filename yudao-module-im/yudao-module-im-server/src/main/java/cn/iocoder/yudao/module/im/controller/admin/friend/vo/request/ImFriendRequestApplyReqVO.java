package cn.iocoder.yudao.module.im.controller.admin.friend.vo.request;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.im.enums.friend.ImFriendAddSourceEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * IM 好友申请 - 发起 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - IM contact apply please start request.")
@Data
public class ImFriendRequestApplyReqVO {

    @Schema(description = "Recipient user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Recipient user ID cannot be empty.")
    private Long toUserId;

    @Schema(description = "Apply please reason.", example = "I am Potato (a food)")
    @Size(max = 255, message = "Request reason cannot exceed 255 characters.")
    private String applyContent;

    @Schema(description = "Remark for the recipient, visible only to you.", example = "John")
    @Size(max = 16, message = "Friend remark cannot exceed 16 characters.")
    private String displayName;

    @Schema(description = "Add source.", example = "1")
    @InEnum(ImFriendAddSourceEnum.class)
    private Integer addSource;

}

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
@Schema(description = "管理后台 - IM 好友申请发起 Request VO")
@Data
public class ImFriendRequestApplyReqVO {

    @Schema(description = "接收方用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Recipient user ID cannot be empty.")
    private Long toUserId;

    @Schema(description = "申请理由", example = "I am Potato (a food)")
    @Size(max = 255, message = "Request reason cannot exceed 255 characters.")
    private String applyContent;

    @Schema(description = "对接收方的备注（仅自己可见）", example = "John")
    @Size(max = 16, message = "Friend remark cannot exceed 16 characters.")
    private String displayName;

    @Schema(description = "添加来源", example = "1")
    @InEnum(ImFriendAddSourceEnum.class)
    private Integer addSource;

}

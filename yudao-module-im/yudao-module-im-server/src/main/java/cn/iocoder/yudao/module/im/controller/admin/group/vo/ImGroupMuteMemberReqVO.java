package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 成员禁言 Request VO")
@Data
public class ImGroupMuteMemberReqVO {

    @Schema(description = "群编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "被禁言的用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "禁言时长（秒），0 表示永久禁言", requiredMode = Schema.RequiredMode.REQUIRED, example = "600")
    @NotNull(message = "Mute duration cannot be empty.")
    @Min(value = 0, message = "Mute duration cannot be less than 0 seconds.")
    private Integer mutedSeconds;

}

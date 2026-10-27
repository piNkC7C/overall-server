package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Unmute a member request VO.")
@Data
public class ImGroupCancelMuteMemberReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "Unmuted user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "User ID is required.")
    private Long userId;

}

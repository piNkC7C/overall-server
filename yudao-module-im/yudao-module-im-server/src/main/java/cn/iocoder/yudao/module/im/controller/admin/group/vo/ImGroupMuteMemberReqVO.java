package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Mute member request VO.")
@Data
public class ImGroupMuteMemberReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "Muted user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Mute duration in seconds. 0 means permanent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "600")
    @NotNull(message = "Mute duration cannot be empty.")
    @Min(value = 0, message = "Mute duration cannot be less than 0 seconds.")
    private Integer mutedSeconds;

}

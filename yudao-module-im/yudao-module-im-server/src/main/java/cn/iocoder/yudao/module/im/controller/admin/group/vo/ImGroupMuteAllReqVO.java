package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Mute the whole group / cancel request VO.")
@Data
public class ImGroupMuteAllReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "Mute the whole group.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Mute the whole group cannot be empty.")
    private Boolean mutedAll;

}

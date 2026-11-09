package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - 全群禁言 / 取消 Request VO")
@Data
public class ImGroupMuteAllReqVO {

    @Schema(description = "群编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "是否全群禁言", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Mute the whole group cannot be empty.")
    private Boolean mutedAll;

}

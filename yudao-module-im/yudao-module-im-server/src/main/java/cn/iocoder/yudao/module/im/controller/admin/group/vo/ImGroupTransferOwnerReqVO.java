package cn.iocoder.yudao.module.im.controller.admin.group.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Transfer group ownership request VO.")
@Data
public class ImGroupTransferOwnerReqVO {

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "13279")
    @NotNull(message = "Group ID is required")
    private Long id;

    @Schema(description = "New group-owner user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "202")
    @NotNull(message = "New group-owner user ID cannot be empty.")
    private Long newOwnerUserId;

}

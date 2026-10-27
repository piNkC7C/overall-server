package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.group;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - PMS item move group request.")
@Data
public class PmsProjectGroupMoveReqVO {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Target project group ID. Omit to move to ungrouped.", example = "2048")
    private Long groupId;

}

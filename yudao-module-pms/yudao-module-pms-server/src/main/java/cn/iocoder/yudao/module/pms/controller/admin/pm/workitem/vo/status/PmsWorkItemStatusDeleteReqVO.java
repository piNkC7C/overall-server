package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - PMS delete work item status request.")
@Data
public class PmsWorkItemStatusDeleteReqVO {

    @Schema(description = "Statuses to deleteID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Statuses to delete cannot be empty.")
    private Long id;

    @Schema(description = "Status ID to move work items into. Required when the deleted status still has work items.", example = "2048")
    private Long transferStatusId;

}

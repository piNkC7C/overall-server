package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - PMS update work item board status request.")
@Data
public class PmsWorkItemStatusUpdateReqVO {

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Work item code is required.")
    private Long id;

    @Schema(description = "Target board status code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Target board status is required.")
    private Long statusId;

}

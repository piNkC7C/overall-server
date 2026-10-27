package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Admin - PMS work item sprint update request.")
@Data
@Accessors(chain = true)
public class PmsWorkItemIterationUpdateReqVO {

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Work item code is required.")
    private Long id;

    @Schema(description = "Sprint ID. Empty moves the item back to backlog.", example = "2048")
    private Long iterationId;

}

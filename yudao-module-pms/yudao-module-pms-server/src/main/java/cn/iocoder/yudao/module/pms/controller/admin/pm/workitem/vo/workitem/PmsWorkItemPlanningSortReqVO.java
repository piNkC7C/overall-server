package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS Unplanned and sprint work item sort request.")
@Data
public class PmsWorkItemPlanningSortReqVO {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Sprint ID; when empty means Backlog.", example = "2048")
    private Long iterationId;

    @Schema(description = "Work item IDs, order is the display order.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Work item code list is required.")
    private List<@NotNull(message = "Work item code is required.") Long> workItemIds;

}

package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS work item board sort request.")
@Data
public class PmsWorkItemSortReqVO {

    @Schema(description = "Board status code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Board status is required.")
    private Long statusId;

    @Schema(description = "Work item IDs. Order is the board display order.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Work item code list is required.")
    private List<@NotNull(message = "Work item code is required.") Long> workItemIds;

}

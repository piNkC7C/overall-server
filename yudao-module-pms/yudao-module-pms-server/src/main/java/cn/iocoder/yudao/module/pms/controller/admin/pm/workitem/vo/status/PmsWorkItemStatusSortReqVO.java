package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.status;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - PMS work item status sort request.")
@Data
public class PmsWorkItemStatusSortReqVO {

    @Schema(description = "Status Code list, order is the display order.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Status code list is required.")
    private List<@NotNull(message = "Status code is required.") Long> statusIds;

}

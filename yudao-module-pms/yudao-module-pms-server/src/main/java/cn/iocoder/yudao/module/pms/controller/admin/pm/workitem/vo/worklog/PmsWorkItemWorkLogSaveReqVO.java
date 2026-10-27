package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.worklog;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - PMS work item time spent record create / edit request.")
@Data
public class PmsWorkItemWorkLogSaveReqVO {

    @Schema(description = "Time spent record code.", example = "1024")
    private Long id;

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "Work item code is required.")
    private Long workItemId;

    @Schema(description = "Actual hours, in hours.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @NotNull(message = "Actual hours cannot be empty.")
    @Min(value = 1, message = "Actual hours must be greater than 0.")
    private Integer actualHours;

    @Schema(description = "Remaining hours after this log.", example = "8")
    @Min(value = 0, message = "Remaining hours cannot be less than 0.")
    private Integer remainingHours;

    @Schema(description = "Time spent Notes.", example = "Finish sign-in API integration")
    @Size(max = 500, message = "Time spent Notes cannot exceed 500 characters.")
    private String description;

}

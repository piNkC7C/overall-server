package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.worklog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "PMS work item time spent summary response VO.")
@Data
public class PmsWorkItemWorkLogSummaryRespVO {

    @Schema(description = "Estimated hours.", example = "16")
    private Integer estimatedHours;

    @Schema(description = "Logged hours.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8")
    private Integer actualHours;

    @Schema(description = "Remaining hours, in hours.", example = "8")
    private Integer remainingHours;

    @Schema(description = "Time spent record list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<PmsWorkItemWorkLogRespVO> records;

}

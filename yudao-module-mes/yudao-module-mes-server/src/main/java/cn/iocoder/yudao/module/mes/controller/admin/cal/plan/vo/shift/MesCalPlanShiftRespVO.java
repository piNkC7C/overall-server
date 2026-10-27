package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.shift;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES plan shift response.")
@Data
public class MesCalPlanShiftRespVO {

    @Schema(description = "Shift code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Schedule plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long planId;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Shift name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Day shift")
    private String name;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "08:00")
    private String startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17:00")
    private String endTime;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

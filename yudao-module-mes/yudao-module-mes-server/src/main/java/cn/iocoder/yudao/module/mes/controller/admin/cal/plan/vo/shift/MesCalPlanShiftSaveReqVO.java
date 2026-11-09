package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.shift;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 计划班次新增/修改 Request VO")
@Data
public class MesCalPlanShiftSaveReqVO {

    @Schema(description = "班次编号", example = "1024")
    private Long id;

    @Schema(description = "排班计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Schedule plan is required.")
    private Long planId;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "班次名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Day shift")
    @NotEmpty(message = "Shift name is required.")
    private String name;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "08:00")
    @NotEmpty(message = "Start time is required.")
    private String startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED, example = "17:00")
    @NotEmpty(message = "End time is required.")
    private String endTime;

    @Schema(description = "备注")
    private String remark;

    }

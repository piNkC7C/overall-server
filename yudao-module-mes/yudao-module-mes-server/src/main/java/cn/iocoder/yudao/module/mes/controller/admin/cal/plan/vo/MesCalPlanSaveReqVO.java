package cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 排班计划新增/修改 Request VO")
@Data
public class MesCalPlanSaveReqVO {

    @Schema(description = "计划编号", example = "1024")
    private Long id;

    @Schema(description = "计划编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "PLAN001")
    @NotEmpty(message = "Plan code is required.")
    private String code;

    @Schema(description = "计划名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024Year schedule plan.")
    @NotEmpty(message = "Plan name is required.")
    private String name;

    @Schema(description = "班组类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Team type is required.")
    private Integer calendarType;

    @Schema(description = "开始日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Start Date is required.")
    private LocalDateTime startDate;

    @Schema(description = "结束日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End Date is required.")
    private LocalDateTime endDate;

    @Schema(description = "轮班方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Rotation method is required.")
    private Integer shiftType;

    @Schema(description = "倒班方式", example = "1")
    private Integer shiftMethod;

    @Schema(description = "倒班天数", example = "7")
    private Integer shiftCount;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

    }

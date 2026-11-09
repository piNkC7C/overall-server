package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 点检保养方案新增/修改 Request VO")
@Data
public class MesDvCheckPlanSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "方案编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHP001")
    @NotEmpty(message = "Plan code is required.")
    private String code;

    @Schema(description = "方案名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Injection-molding daily inspection plan")
    @NotEmpty(message = "Plan name is required.")
    private String name;

    @Schema(description = "方案类型（1=设备点检，2=设备保养）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan type is required.")
    private Integer type;

    @Schema(description = "开始日期")
    private LocalDateTime startDate;

    @Schema(description = "结束日期")
    private LocalDateTime endDate;

    @Schema(description = "周期类型（1=天，2=周，3=月，4=年）", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Cycle Type is required.")
    private Integer cycleType;

    @Schema(description = "周期数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Cycle count cannot be empty.")
    private Integer cycleCount;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

    }

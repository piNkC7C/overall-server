package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES inspection and maintenance plan create / edit request.")
@Data
public class MesDvCheckPlanSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHP001")
    @NotEmpty(message = "Plan code is required.")
    private String code;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Injection-molding daily inspection plan")
    @NotEmpty(message = "Plan name is required.")
    private String name;

    @Schema(description = "Plan type (1=device inspection, 2=device maintenance ).", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan type is required.")
    private Integer type;

    @Schema(description = "Start Date.")
    private LocalDateTime startDate;

    @Schema(description = "End Date.")
    private LocalDateTime endDate;

    @Schema(description = "Cycle Type (1=Days, 2= week, 3=Month, 4=Year).", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Cycle Type is required.")
    private Integer cycleType;

    @Schema(description = "Cycle count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Cycle count cannot be empty.")
    private Integer cycleCount;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Notes.")
    private String remark;

    }

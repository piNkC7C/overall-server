package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo.machinery;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES inspection and maintenance plan device create request.")
@Data
public class MesDvCheckPlanMachinerySaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan code is required.")
    private Long planId;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Device is required.")
    private Long machineryId;

    @Schema(description = "Notes.")
    private String remark;

    }

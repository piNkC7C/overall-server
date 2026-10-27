package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo.machinery;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES inspection and maintenance plan device response.")
@Data
public class MesDvCheckPlanMachineryRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long planId;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long machineryId;

    @Schema(description = "Device code.", example = "EQ001")
    private String machineryCode;

    @Schema(description = "Device name.", example = "Injection-molding machine A")
    private String machineryName;

    @Schema(description = "Brand.", example = "Haitian")
    private String machineryBrand;

    @Schema(description = "Spec / Model", example = "HTF120")
    private String machinerySpecification;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

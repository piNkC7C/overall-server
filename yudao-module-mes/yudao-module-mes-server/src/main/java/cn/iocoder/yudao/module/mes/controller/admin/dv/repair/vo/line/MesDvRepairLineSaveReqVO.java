package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - MES repair work order line create / edit request.")
@Data
public class MesDvRepairLineSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Repair work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Repair work order is required.")
    private Long repairId;

    @Schema(description = "Inspection and maintenance item code.", example = "1")
    private Long subjectId;

    @Schema(description = "Fault description.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hydraulic oil leak")
    @NotBlank(message = "Fault description cannot be empty.")
    private String malfunction;

    @Schema(description = "Fault image URL.", example = "https://example.com/image.png")
    private String malfunctionUrl;

    @Schema(description = "MaintenanceDescription.", example = "Replace the seal")
    private String description;

    @Schema(description = "Notes.", example = "Sample notes.")
    private String remark;

}

package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.machine;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES device resource create request.")
@Data
public class MesMdWorkstationMachineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Workstation is required.")
    private Long workstationId;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Device is required.")
    private Long machineryId;

    @Schema(description = "Quantity.", example = "1")
    private Integer quantity;

    @Schema(description = "Notes.")
    private String remark;

}

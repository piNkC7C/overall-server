package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.machine;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES device resource response.")
@Data
public class MesMdWorkstationMachineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long workstationId;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long machineryId;

    @Schema(description = "Device code.", example = "M001")
    private String machineryCode;

    @Schema(description = "Device name.", example = "CNC machine")
    private String machineryName;

    @Schema(description = "Quantity.", example = "1")
    private Integer quantity;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.tool;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES fixture resource create / edit request.")
@Data
public class MesMdWorkstationToolSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Workstation is required.")
    private Long workstationId;

    @Schema(description = "Tool type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Tool type is required.")
    private Long toolTypeId;

    @Schema(description = "Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    private Integer quantity;

    @Schema(description = "Notes.")
    private String remark;

}

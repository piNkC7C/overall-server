package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.tool;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES fixture resource response.")
@Data
public class MesMdWorkstationToolRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long workstationId;

    @Schema(description = "Tool type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long toolTypeId;

    @Schema(description = "Tool type name.", example = "Drill bit")
    private String toolTypeName;

    @Schema(description = "Quantity.", example = "1")
    private Integer quantity;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.worker;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES labor resource response.")
@Data
public class MesMdWorkstationWorkerRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long workstationId;

    @Schema(description = "Post code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long postId;

    @Schema(description = "Post name.", example = "Operator")
    private String postName;

    @Schema(description = "Quantity.", example = "1")
    private Integer quantity;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

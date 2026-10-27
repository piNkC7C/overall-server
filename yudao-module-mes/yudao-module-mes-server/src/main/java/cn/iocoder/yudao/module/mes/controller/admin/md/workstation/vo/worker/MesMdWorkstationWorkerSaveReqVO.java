package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.worker;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES labor resource create / edit request.")
@Data
public class MesMdWorkstationWorkerSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Workstation is required.")
    private Long workstationId;

    @Schema(description = "Post code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Post is required.")
    private Long postId;

    @Schema(description = "Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    private Integer quantity;

    @Schema(description = "Notes.")
    private String remark;

}

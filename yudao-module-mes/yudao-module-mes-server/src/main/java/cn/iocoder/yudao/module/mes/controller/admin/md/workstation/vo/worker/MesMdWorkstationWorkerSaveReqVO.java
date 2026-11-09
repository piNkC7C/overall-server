package cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.worker;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - MES 人力资源新增/修改 Request VO")
@Data
public class MesMdWorkstationWorkerSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "工作站编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Workstation is required.")
    private Long workstationId;

    @Schema(description = "岗位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Post is required.")
    private Long postId;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Quantity is required.")
    private Integer quantity;

    @Schema(description = "备注")
    private String remark;

}

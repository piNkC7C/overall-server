package cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "管理后台 - MES 维修工单行新增/修改 Request VO")
@Data
public class MesDvRepairLineSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "维修工单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Repair work order is required.")
    private Long repairId;

    @Schema(description = "点检保养项目编号", example = "1")
    private Long subjectId;

    @Schema(description = "故障描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hydraulic oil leak")
    @NotBlank(message = "Fault description cannot be empty.")
    private String malfunction;

    @Schema(description = "故障图片 URL", example = "https://example.com/image.png")
    private String malfunctionUrl;

    @Schema(description = "维修描述", example = "Replace the seal")
    private String description;

    @Schema(description = "备注", example = "Sample notes.")
    private String remark;

}

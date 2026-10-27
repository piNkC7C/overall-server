package cn.iocoder.yudao.module.mes.controller.admin.dv.checkplan.vo.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES inspection and maintenance plan item create request.")
@Data
public class MesDvCheckPlanSubjectSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan code is required.")
    private Long planId;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection and maintenance item is required.")
    private Long subjectId;

    @Schema(description = "Notes.")
    private String remark;

    }

package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM performance plan add or remove employees request VO.")
@Data
public class HrmPerformanceAssessmentBatchReqVO {

    @Schema(description = "Performance reviewplan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Performance reviewplan is required.")
    private Long planId;

    @Schema(description = "Employee code list.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "[1024, 2048]")
    @NotEmpty(message = "Employee is required.")
    private List<Long> employeeIds;

}

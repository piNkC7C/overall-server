package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceAppealStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformancePlanStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceStageTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(description = "Admin - HRM performance reviewplanemployee page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPerformanceAssessmentPageReqVO extends PageParam {

    @Schema(description = "Performance reviewplan code.", example = "1024")
    private Long planId;

    @Schema(description = "Employee code.", example = "2048")
    private Long employeeId;

    @Schema(description = "Employee code list.", example = "[2048, 2049]")
    private List<Long> employeeIds;

    @Schema(description = "Employee Name or Employee No.", example = "John.")
    private String search;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Employment Type", example = "1")
    private Integer employeeType;

    @Schema(description = "Employee status.", example = "1")
    private Integer employeeStatus;

    @Schema(description = "Review status.", example = "1")
    @InEnum(value = HrmPerformancePlanStatusEnum.class, message = "Review status must be {value}.")
    private Integer status;

    @Schema(description = "Stage status.", example = "2")
    @InEnum(value = HrmPerformanceStageTypeEnum.class, message = "Stage status must be {value}.")
    private Integer stageType;

    @Schema(description = "Appeal status.", example = "1")
    @InEnum(value = HrmPerformanceAppealStatusEnum.class, message = "Appeal status must be {value}.")
    private Integer appealStatus;

    @Schema(description = "Result level.", example = "A")
    private String resultLevel;

    @Schema(description = "Result level is not is empty.", example = "false")
    private Boolean resultLevelEmpty;

}

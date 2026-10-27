package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.plan;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformancePlanStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceStageTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "Admin - HRM performance reviewplan page request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPerformancePlanPageReqVO extends PageParam {

    @Schema(description = "Performance reviewplan name.", example = "Q3 2026 performance plan")
    private String name;

    @Schema(description = "Performance reviewplan status.", example = "1")
    @InEnum(value = HrmPerformancePlanStatusEnum.class, message = "Plan status must be {value}.")
    private Integer status;

    @Schema(description = "Stage status.", example = "2")
    @InEnum(value = HrmPerformanceStageTypeEnum.class, message = "Stage status must be {value}.")
    private Integer stageType;

}

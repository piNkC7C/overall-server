package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.task;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceAssessmentStageStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "管理后台 - HRM 员工端绩效任务分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmPortalPerformanceTaskPageReqVO extends PageParam {

    @Schema(description = "绩效计划名称、员工姓名或工号", example = "John.")
    private String search;

    @Schema(description = "阶段处理状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Stage process status is required.")
    @InEnum(value = HrmPerformanceAssessmentStageStatusEnum.class,
            message = "Stage process status must be {value}.")
    private Integer stageStatus;

}

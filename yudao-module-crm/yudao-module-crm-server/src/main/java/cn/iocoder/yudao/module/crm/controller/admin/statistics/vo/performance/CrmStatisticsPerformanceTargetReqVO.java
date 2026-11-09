package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.performance;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.crm.enums.performance.CrmPerformanceConfigBizTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - CRM 业绩目标完成情况 Request VO")
@Data
public class CrmStatisticsPerformanceTargetReqVO {

    @Schema(description = "部门 id", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Department id is required.")
    private Long deptId;

    @Schema(description = "负责人用户 id", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "负责人用户 id 集合", hidden = true, example = "2")
    private List<Long> userIds;

    @Schema(description = "年份", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024")
    @NotNull(message = "Year is required.")
    private Integer year;

    @Schema(description = "目标类型",
            requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    @NotNull(message = "Target type is required.")
    @InEnum(value = CrmPerformanceConfigBizTypeEnum.class, message = "Target type, must be {value}.")
    private Integer bizType;

}

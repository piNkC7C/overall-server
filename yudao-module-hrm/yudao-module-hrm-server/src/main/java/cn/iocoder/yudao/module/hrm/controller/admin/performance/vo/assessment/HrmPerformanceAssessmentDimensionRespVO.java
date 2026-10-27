package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - HRM employeeperformance reviewDimension response.")
@Data
public class HrmPerformanceAssessmentDimensionRespVO {

    @Schema(description = "Dimension code.")
    private Long id;

    @Schema(description = "Employeeperformance reviewReview code.")
    private Long assessmentId;

    @Schema(description = "Dimension name.")
    private String name;

    @Schema(description = "Metric type.")
    private Integer quotaType;

    @Schema(description = "DimensionWeight.")
    private BigDecimal weight;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Is not allow edit.")
    private Boolean allowEdit;

    @Schema(description = "Sort.")
    private Integer sort;

}

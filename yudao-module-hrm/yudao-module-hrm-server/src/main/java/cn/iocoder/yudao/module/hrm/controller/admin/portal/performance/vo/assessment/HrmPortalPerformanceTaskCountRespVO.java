package cn.iocoder.yudao.module.hrm.controller.admin.portal.performance.vo.assessment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "HRM employee performance review task count response VO.")
@Data
@Accessors(chain = true)
public class HrmPortalPerformanceTaskCountRespVO {

    @Schema(description = "Pending KPI count.")
    private Long fillPendingCount;

    @Schema(description = "Already enter metric quantity.")
    private Long fillCompletedCount;

    @Schema(description = "Pending goal-confirm count.")
    private Long targetPendingCount;

    @Schema(description = "Already confirm target quantity.")
    private Long targetCompletedCount;

    @Schema(description = "Pending score count.")
    private Long reviewPendingCount;

    @Schema(description = "Already Score quantity.")
    private Long reviewCompletedCount;

    @Schema(description = "Pending result-review count.")
    private Long resultAuditPendingCount;

    @Schema(description = "Approved result quantity.")
    private Long resultAuditCompletedCount;

    @Schema(description = "Pending result-confirm count.")
    private Long resultConfirmationPendingCount;

    @Schema(description = "Already confirm result quantity.")
    private Long resultConfirmationCompletedCount;

    @Schema(description = "Appealed result count.")
    private Long resultConfirmationAppealedCount;

    @Schema(description = "Pending appeal count.")
    private Long appealPendingCount;

    @Schema(description = "Handled appeal count.")
    private Long appealCompletedCount;

}

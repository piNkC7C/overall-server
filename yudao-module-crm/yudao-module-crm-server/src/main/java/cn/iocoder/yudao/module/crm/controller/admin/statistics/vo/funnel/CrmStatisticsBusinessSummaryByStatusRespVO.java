package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.funnel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "Admin - CRM Opportunity StageStats response.")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CrmStatisticsBusinessSummaryByStatusRespVO {

    @Schema(description = "Opportunity Stage code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long statusId;

    @Schema(description = "Opportunity Stage name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Initial contact")
    private String statusName;

    @Schema(description = "Win rate, percent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer statusPercent;

    @Schema(description = "Sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Opportunity count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long businessCount;

    @Schema(description = "Opportunity total, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private BigDecimal totalPrice;

}

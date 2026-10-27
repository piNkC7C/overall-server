package cn.iocoder.yudao.module.crm.controller.admin.statistics.vo.funnel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "Admin - CRM opportunity end statusStats response.")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CrmStatisticsBusinessSummaryByEndStatusRespVO {

    @Schema(description = "End status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer endStatus;

    @Schema(description = "Opportunity count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long businessCount;

    @Schema(description = "Opportunity total, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private BigDecimal totalPrice;

}

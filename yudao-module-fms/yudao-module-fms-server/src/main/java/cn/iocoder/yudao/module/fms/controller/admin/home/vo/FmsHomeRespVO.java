package cn.iocoder.yudao.module.fms.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - FMS Home response.")
@Data
public class FmsHomeRespVO {

    @Schema(description = "Current Accounting Period.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    private String currentMonth;

    @Schema(description = "Current financial metrics.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Metric> metrics;

    @Schema(description = "Financial metric trend.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Trend> trends;

    @Schema(description = "Admin - FMS Homefinance KPI response.")
    @Data
    public static class Metric {

        @Schema(description = "Metric key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "income")
        private String key;

        @Schema(description = "Metric name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Income")
        private String name;

        @Schema(description = "Metric amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000.00")
        private BigDecimal amount;

    }

    @Schema(description = "Admin - FMS home finance KPI trend response.")
    @Data
    public static class Trend {

        @Schema(description = "Accounting Period", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
        private String month;

        @Schema(description = "Dynamic financial metrics.", requiredMode = Schema.RequiredMode.REQUIRED)
        private List<Metric> metrics;

        @Schema(description = "Income.", requiredMode = Schema.RequiredMode.REQUIRED)
        private BigDecimal income;

        @Schema(description = "Cost.", requiredMode = Schema.RequiredMode.REQUIRED)
        private BigDecimal operatingCost;

        @Schema(description = "Profit.", requiredMode = Schema.RequiredMode.REQUIRED)
        private BigDecimal profit;

        @Schema(description = "Fee.", requiredMode = Schema.RequiredMode.REQUIRED)
        private BigDecimal expense;

        @Schema(description = "Other.", requiredMode = Schema.RequiredMode.REQUIRED)
        private BigDecimal other;

    }

}

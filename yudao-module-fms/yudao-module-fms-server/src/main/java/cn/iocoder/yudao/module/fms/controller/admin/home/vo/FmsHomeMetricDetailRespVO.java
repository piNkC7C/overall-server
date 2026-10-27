package cn.iocoder.yudao.module.fms.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - FMS Homefinance KPIdetail response.")
@Data
public class FmsHomeMetricDetailRespVO {

    @Schema(description = "Metric key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "income")
    private String key;

    @Schema(description = "Metric name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Income")
    private String name;

    @Schema(description = "Financial metric trend.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Trend> trends;

    @Schema(description = "Current account composition.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Structure> structure;

    @Schema(description = "Admin - FMS home finance KPI trend response.")
    @Data
    public static class Trend {

        @Schema(description = "Accounting Period", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
        private String month;

        @Schema(description = "Metric amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000.00")
        private BigDecimal amount;

    }

    @Schema(description = "Home financial-metric account mix response VO.")
    @Data
    public static class Structure {

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long subjectId;

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5001")
        private String subjectCode;

        @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Operating revenue")
        private String subjectName;

        @Schema(description = "Account amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8000.00")
        private BigDecimal amount;

    }

}

package cn.iocoder.yudao.module.fms.controller.admin.report.vo.income;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Income-statement check response VO.")
@Data
public class FmsIncomeStatementCheckRespVO {

    @Schema(description = "Net income matches retained-earnings change.", example = "true")
    private Boolean balanced;

    @Schema(description = "Income statement vs balance sheet difference.", example = "0.00")
    private BigDecimal differenceAmount;

    @Schema(description = "Accounts not in the report formula.")
    private List<UnmappedSubject> unmappedSubjects;

    @Schema(description = "Admin - FMS accounts not in the report formula.")
    @Data
    public static class UnmappedSubject {

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
        private String code;

        @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cash on hand")
        private String name;

    }

}

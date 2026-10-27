package cn.iocoder.yudao.module.fms.controller.admin.report.vo.balance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Balance-sheet check response VO.")
@Data
public class FmsBalanceSheetCheckRespVO {

    @Schema(description = "Report is balanced.", example = "true")
    private Boolean balanced;

    @Schema(description = "Opening balance is balanced.", example = "true")
    private Boolean initialBalanceBalanced;

    @Schema(description = "P&L is closed.", example = "true")
    private Boolean profitLossTransferred;

    @Schema(description = "Opening-year balance difference.", example = "0.00")
    private BigDecimal openingDifferenceAmount;

    @Schema(description = "Ending balance difference.", example = "0.00")
    private BigDecimal closingDifferenceAmount;

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

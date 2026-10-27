package cn.iocoder.yudao.module.fms.controller.admin.report.vo.cashflow;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Admin - FMS Cash Flow Statementupdate request.")
@Data
public class FmsCashFlowStatementUpdateReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Start Accounting Period.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotNull(message = "Start Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "Start Accounting Period format is invalid.")
    private String startMonth;

    @Schema(description = "End Accounting Period.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotNull(message = "End Accounting Period is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "End Accounting Period format is invalid.")
    private String endMonth;

    @Schema(description = "Cash-flow item.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Cash-flow item cannot be empty.")
    @Valid
    private List<Item> items = new ArrayList<>();

    @Schema(description = "Cash-flow statement change item request VO.")
    @Data
    public static class Item {

        @Schema(description = "Report item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Report item code is required.")
        private Long id;

        @Schema(description = "Period amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Period amount cannot be empty.")
        private BigDecimal currentAmount;

        @Schema(description = "YTD amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200.00")
        @NotNull(message = "YTD amount cannot be empty.")
        private BigDecimal yearAmount;

    }

}

package cn.iocoder.yudao.module.fms.controller.admin.closing.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - FMS closing plan response.")
@Data
public class FmsClosingSchemeRespVO {

    @Schema(description = "Plan code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", example = "1")
    private Long accountSetId;

    @Schema(description = "Plan name.", example = "Close this month's rent")
    private String name;

    @Schema(description = "Is not Period-end Close.")
    private Boolean periodEnd;

    @Schema(description = "Source account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Fetch Rule", example = "0")
    private Integer formulaRule;

    @Schema(description = "Source time type.", example = "1")
    private Integer timeType;

    @Schema(description = "Journal entry character code.", example = "11")
    private Long voucherWordId;

    @Schema(description = "Journal entrySummary.", example = "Close P&L.")
    private String digest;

    @Schema(description = "Closing journal type.", example = "2")
    private Integer voucherType;

    @Schema(description = "Prior-year P&L adjustment accountID.", example = "1024")
    private Long priorYearAdjustmentSubjectId;

    @Schema(description = "Prior-year P&L closing accountID.", example = "1025")
    private Long adjustmentClosingSubjectId;

    @Schema(description = "Other P&L closing accountID.", example = "1026")
    private Long otherClosingSubjectId;

    @Schema(description = "Reverse by balance.")
    private Boolean reverseBalance;

    @Schema(description = "Closing date.", example = "31")
    private Integer closingDay;

    @Schema(description = "Type.", example = "1")
    private Integer type;

    @Schema(description = "Closing account ruleArray.")
    private List<SubjectRule> subjects;

    @Schema(description = "Amount to close.", example = "12000.00")
    private BigDecimal balance;

    @Schema(description = "Current period already createjournal entry ID list.")
    private List<Long> voucherIds;

    @Schema(description = "Admin - FMS closing plan account rule.")
    @Data
    public static class SubjectRule {

        @Schema(description = "Account code.", example = "1024")
        private Long subjectId;

        @Schema(description = "Account code snapshot.", example = "6602")
        private String subjectCode;

        @Schema(description = "Summary", example = "Close this month's rent")
        private String digest;

        @Schema(description = "DebitCredit to.", example = "1")
        private Integer direction;

        @Schema(description = "Amount ratio.", example = "100")
        private BigDecimal amountRatio;
    }

}

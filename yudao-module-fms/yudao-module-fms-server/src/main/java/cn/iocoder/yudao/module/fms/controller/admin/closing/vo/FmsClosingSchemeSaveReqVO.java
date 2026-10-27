package cn.iocoder.yudao.module.fms.controller.admin.closing.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.common.FmsDebitCreditDirectionEnum;
import cn.iocoder.yudao.module.fms.enums.closing.FmsClosingTimeTypeEnum;
import cn.iocoder.yudao.module.fms.enums.report.FmsFormulaRuleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Admin - FMS closing plan save request.")
@Data
public class FmsClosingSchemeSaveReqVO {

    @Schema(description = "Plan code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Plan name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Close this month's rent")
    @NotBlank(message = "Plan name is required.")
    @Size(max = 255, message = "Plan name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Is not Period-end Close.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Is not Period-end Close is required.")
    private Boolean periodEnd;

    @Schema(description = "Source account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Source account is required.")
    private Long subjectId;

    @Schema(description = "Fetch Rule", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Fetch Rule is required.")
    @InEnum(FmsFormulaRuleEnum.class)
    private Integer formulaRule;

    @Schema(description = "Source time type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Source time type cannot be empty.")
    @InEnum(FmsClosingTimeTypeEnum.class)
    private Integer timeType;

    @Schema(description = "Journal entry character code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Journal entry character is required.")
    private Long voucherWordId;

    @Schema(description = "Closing account ruleArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Closing account rule cannot be empty.")
    @Size(min = 2, message = "Add at least two closing-account rules.")
    private List<SubjectRule> subjects;

    @Schema(description = "Admin - FMS closing plan account rule.")
    @Data
    public static class SubjectRule {

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Account is required.")
        private Long subjectId;

        @Schema(description = "Summary", requiredMode = Schema.RequiredMode.REQUIRED, example = "Close this month's rent")
        @NotBlank(message = "Summary is required.")
        @Size(max = 500, message = "Summary length cannot exceed 500 characters.")
        private String digest;

        @Schema(description = "DebitCredit to.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "DebitCredit to is required.")
        @InEnum(FmsDebitCreditDirectionEnum.class)
        private Integer direction;

        @Schema(description = "Amount ratio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        @NotNull(message = "Amount ratio cannot be empty.")
        @DecimalMin(value = "0", inclusive = false, message = "Amount ratio must be greater than 0.")
        @DecimalMax(value = "100", message = "Amount ratio cannot exceed 100.")
        private BigDecimal amountRatio;
    }

}

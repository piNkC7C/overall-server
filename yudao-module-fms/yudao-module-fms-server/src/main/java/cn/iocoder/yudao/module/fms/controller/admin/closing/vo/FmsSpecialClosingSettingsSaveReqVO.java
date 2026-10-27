package cn.iocoder.yudao.module.fms.controller.admin.closing.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.common.FmsDebitCreditDirectionEnum;
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

@Schema(description = "Save special closing settings request VO.")
@Data
public class FmsSpecialClosingSettingsSaveReqVO {

    @Schema(description = "Plan code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Plan code is required.")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Journal entry character code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Journal entry character is required.")
    private Long voucherWordId;

    @Schema(description = "Closing account ruleArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Closing account rule cannot be empty.")
    @Size(min = 2, message = "Add at least two closing-account rules.")
    private List<SubjectRule> subjects;

    @Schema(description = "Admin - FMS Special Closing Account Rule.")
    @Data
    public static class SubjectRule {

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Account is required.")
        private Long subjectId;

        @Schema(description = "Summary", requiredMode = Schema.RequiredMode.REQUIRED, example = "Income tax accrual")
        @NotBlank(message = "Summary is required.")
        @Size(max = 500, message = "Summary length cannot exceed 500 characters.")
        private String digest;

        @Schema(description = "DebitCredit to.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "DebitCredit to is required.")
        @InEnum(FmsDebitCreditDirectionEnum.class)
        private Integer direction;

        @Schema(description = "Amount ratio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25")
        @NotNull(message = "Amount ratio cannot be empty.")
        @DecimalMin(value = "0", inclusive = false, message = "Amount ratio must be greater than 0.")
        @DecimalMax(value = "100", message = "Amount ratio cannot exceed 100.")
        private BigDecimal amountRatio;
    }

}

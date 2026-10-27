package cn.iocoder.yudao.module.fms.controller.admin.closing.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.closing.FmsClosingTemplateCategoryEnum;
import cn.iocoder.yudao.module.fms.enums.closing.FmsClosingTimeTypeEnum;
import cn.iocoder.yudao.module.fms.enums.common.FmsDebitCreditDirectionEnum;
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

@Schema(description = "Admin - FMS closing template save request.")
@Data
public class FmsClosingTemplateSaveReqVO {

    @Schema(description = "Template code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Travel reimbursement")
    @NotBlank(message = "Template name is required.")
    @Size(max = 255, message = "Template name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Templatecategory.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Templatecategory is required.")
    @InEnum(FmsClosingTemplateCategoryEnum.class)
    private Integer category;

    @Schema(description = "Is not Period-end Close.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Is not Period-end Close is required.")
    private Boolean periodEnd;

    @Schema(description = "Source account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "Fetch Rule", example = "0")
    @InEnum(FmsFormulaRuleEnum.class)
    private Integer formulaRule;

    @Schema(description = "Source time type.", example = "1")
    @InEnum(FmsClosingTimeTypeEnum.class)
    private Integer timeType;

    @Schema(description = "Closing account ruleArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Closing account rule cannot be empty.")
    @Size(min = 2, message = "Add at least two closing-account rules.")
    private List<SubjectRule> subjects;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Admin - FMS closing templateaccount rule.")
    @Data
    public static class SubjectRule {

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Account is required.")
        private Long subjectId;

        @Schema(description = "Summary", requiredMode = Schema.RequiredMode.REQUIRED, example = "Travel reimbursement")
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

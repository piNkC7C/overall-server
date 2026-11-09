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

@Schema(description = "管理后台 - FMS 结账方案保存 Request VO")
@Data
public class FmsClosingSchemeSaveReqVO {

    @Schema(description = "方案编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "方案名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Close this month's rent")
    @NotBlank(message = "Plan name is required.")
    @Size(max = 255, message = "Plan name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "是否期末结转", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Is not Period-end Close is required.")
    private Boolean periodEnd;

    @Schema(description = "来源科目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Source account is required.")
    private Long subjectId;

    @Schema(description = "取数规则", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Fetch Rule is required.")
    @InEnum(FmsFormulaRuleEnum.class)
    private Integer formulaRule;

    @Schema(description = "取数时间类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Source time type cannot be empty.")
    @InEnum(FmsClosingTimeTypeEnum.class)
    private Integer timeType;

    @Schema(description = "凭证字编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Journal entry character is required.")
    private Long voucherWordId;

    @Schema(description = "结转科目规则数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Closing account rule cannot be empty.")
    @Size(min = 2, message = "Add at least two closing-account rules.")
    private List<SubjectRule> subjects;

    @Schema(description = "管理后台 - FMS 结账方案科目规则")
    @Data
    public static class SubjectRule {

        @Schema(description = "科目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Account is required.")
        private Long subjectId;

        @Schema(description = "摘要", requiredMode = Schema.RequiredMode.REQUIRED, example = "Close this month's rent")
        @NotBlank(message = "Summary is required.")
        @Size(max = 500, message = "Summary length cannot exceed 500 characters.")
        private String digest;

        @Schema(description = "借贷方向", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "DebitCredit to is required.")
        @InEnum(FmsDebitCreditDirectionEnum.class)
        private Integer direction;

        @Schema(description = "金额比例", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        @NotNull(message = "Amount ratio cannot be empty.")
        @DecimalMin(value = "0", inclusive = false, message = "Amount ratio must be greater than 0.")
        @DecimalMax(value = "100", message = "Amount ratio cannot exceed 100.")
        private BigDecimal amountRatio;
    }

}

package cn.iocoder.yudao.module.fms.controller.admin.report.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.report.FmsFormulaRuleEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "FMS report Formula update request VO.")
@Data
public class FmsReportFormulaUpdateReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Setting code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Setting code is required.")
    private Long id;

    @Schema(description = "Formula items.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Formula items cannot be empty.")
    @Valid
    private List<Formula> formulas = new ArrayList<>();

    @Schema(description = "FMS report Formula item request VO.")
    @Data
    public static class Formula {

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Account code is required.")
        private Long subjectId;

        @Schema(description = "Operator.", requiredMode = Schema.RequiredMode.REQUIRED, example = "+")
        @NotNull(message = "Operator cannot be empty.")
        @Pattern(regexp = "[+-]", message = "Operator must be + or -.")
        private String operator;

        @Schema(description = "Fetch Rule", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
        @NotNull(message = "Fetch Rule is required.")
        @InEnum(value = FmsFormulaRuleEnum.class, message = "Fetch Rule must be {value}.")
        private Integer rules;

    }

}

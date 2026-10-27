package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessmenttemplate;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceQuotaScoreTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.config.HrmPerformanceQuotaTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.config.HrmPerformanceScoreCalculationEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.config.HrmPerformanceUpperLimitTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.util.number.MoneyUtils.PERCENT_100;

@Schema(description = "Admin - HRM performance reviewReviewtemplate save request.")
@Data
public class HrmPerformanceAssessmentTemplateSaveReqVO {

    @Schema(description = "Template code.", example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Quarterly review template")
    @NotBlank(message = "Template name is required.")
    @Size(max = 50, message = "Template name cannot exceed 50 characters.")
    private String name;

    @Schema(description = "TemplateNotes.", example = "For quarterly performance reviews")
    @Size(max = 200, message = "TemplateNotes cannot exceed 200 characters.")
    private String illustrate;

    @Schema(description = "Scoring method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Scoring method cannot be empty.")
    @InEnum(value = HrmPerformanceScoreCalculationEnum.class, message = "Scoring method must be {value}.")
    private Integer scoreCalculation;

    @Schema(description = "Score limit type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Score limit type is required.")
    @InEnum(value = HrmPerformanceUpperLimitTypeEnum.class, message = "Score limit type must be {value}.")
    private Integer upperLimitType;

    @Schema(description = "Score limit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Score limit is required.")
    @DecimalMin(value = "0", message = "Score cap cannot be less than 0.")
    @DecimalMax(value = "100", message = "Score cap cannot be greater than 100.")
    private BigDecimal upperLimitScore;

    @Schema(description = "ReviewDimension list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "At least need to need one ReviewDimension.")
    private List<@NotNull(message = "ReviewDimension is required.") Dimension> dimensions;

    @AssertTrue(message = "ReviewDimension name cannot is duplicated.")
    @JsonIgnore
    public boolean isDimensionNamesUnique() {
        if (CollUtil.isEmpty(dimensions)) {
            return true;
        }
        Set<String> names = new HashSet<>();
        for (Dimension dimension : dimensions) {
            if (dimension != null && StrUtil.isNotBlank(dimension.getName())
                    && !names.add(dimension.getName().trim())) {
                return false;
            }
        }
        return true;
    }

    @AssertTrue(message = "Review metric name cannot is duplicated.")
    @JsonIgnore
    public boolean isQuotaNamesUnique() {
        if (CollUtil.isEmpty(dimensions)) {
            return true;
        }
        Set<String> names = new HashSet<>();
        for (Dimension dimension : dimensions) {
            if (dimension == null || CollUtil.isEmpty(dimension.getQuotas())) {
                continue;
            }
            for (Quota quota : dimension.getQuotas()) {
                if (quota != null && StrUtil.isNotBlank(quota.getName())
                        && !names.add(quota.getName().trim())) {
                    return false;
                }
            }
        }
        return true;
    }

    @AssertTrue(message = "Dimension weights must add up to 100%.")
    @JsonIgnore
    public boolean isDimensionWeightTotalValid() {
        if (CollUtil.isEmpty(dimensions)) {
            return true;
        }
        BigDecimal totalWeight = BigDecimal.ZERO;
        for (Dimension dimension : dimensions) {
            if (dimension == null || dimension.getWeight() == null) {
                return true;
            }
            totalWeight = totalWeight.add(dimension.getWeight());
        }
        return totalWeight.compareTo(PERCENT_100) == 0;
    }

    @AssertTrue(message = "Locked-dimension metric weights must add up to 100%.")
    @JsonIgnore
    public boolean isFixedQuotaWeightTotalValid() {
        if (CollUtil.isEmpty(dimensions)) {
            return true;
        }
        for (Dimension dimension : dimensions) {
            if (dimension == null || ObjUtil.notEqual(Boolean.FALSE, dimension.getAllowEdit())
                    || CollUtil.isEmpty(dimension.getQuotas())) {
                continue;
            }
            BigDecimal totalWeight = BigDecimal.ZERO;
            for (Quota quota : dimension.getQuotas()) {
                if (quota == null || quota.getWeight() == null) {
                    return true;
                }
                totalWeight = totalWeight.add(quota.getWeight());
            }
            if (totalWeight.compareTo(PERCENT_100) != 0) {
                return false;
            }
        }
        return true;
    }

    @AssertTrue(message = "Editable-dimension metric weights cannot exceed 100%.")
    @JsonIgnore
    public boolean isEditableQuotaWeightTotalValid() {
        if (CollUtil.isEmpty(dimensions)) {
            return true;
        }
        for (Dimension dimension : dimensions) {
            if (dimension == null || ObjUtil.notEqual(Boolean.TRUE, dimension.getAllowEdit())
                    || CollUtil.isEmpty(dimension.getQuotas())) {
                continue;
            }
            BigDecimal totalWeight = BigDecimal.ZERO;
            for (Quota quota : dimension.getQuotas()) {
                if (quota == null || quota.getWeight() == null) {
                    return true;
                }
                totalWeight = totalWeight.add(quota.getWeight());
            }
            if (totalWeight.compareTo(PERCENT_100) > 0) {
                return false;
            }
        }
        return true;
    }

    @Schema(description = "Admin - HRM performance review templateDimension.")
    @Data
    public static class Dimension {

        @Schema(description = "Dimension name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Job performance")
        @NotBlank(message = "Dimension name is required.")
        @Size(max = 50, message = "Dimension name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "Metric type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Metric type is required.")
        @InEnum(value = HrmPerformanceQuotaTypeEnum.class, message = "Metric type must be {value}.")
        private Integer quotaType;

        @Schema(description = "DimensionWeight.", requiredMode = Schema.RequiredMode.REQUIRED, example = "60")
        @NotNull(message = "DimensionWeight is required.")
        @DecimalMin(value = "0", message = "Dimension weight cannot be less than 0.")
        @DecimalMax(value = "100", message = "Dimension weight cannot be greater than 100.")
        private BigDecimal weight;

        @Schema(description = "Notes.", example = "Core KPI")
        @Size(max = 200, message = "Dimension notes cannot exceed 200 characters.")
        private String remark;

        @Schema(description = "Is not allow employee edit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        @NotNull(message = "Is not allow employee edit is required.")
        private Boolean allowEdit;

        @Schema(description = "Review metric list.", requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty(message = "Each ReviewDimension at least need to need one metric.")
        private List<@NotNull(message = "Review metric is required.") Quota> quotas;
    }

    @Schema(description = "Admin - HRM performance reviewReviewtemplate metric.")
    @Data
    public static class Quota {

        @Schema(description = "Metric name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sales-target attainment")
        @NotBlank(message = "Metric name is required.")
        @Size(max = 50, message = "Metric name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "Metric Notes.", example = "Based on quarterly sales targets")
        @Size(max = 200, message = "Metric Notes cannot exceed 200 characters.")
        private String illustrate;

        @Schema(description = "Score standard.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Full score when completion reaches 100%")
        @NotBlank(message = "Score standard is required.")
        @Size(max = 200, message = "Score standard cannot exceed 200 characters.")
        private String standard;

        @Schema(description = "Metric Weight.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
        @NotNull(message = "Metric Weight is required.")
        @DecimalMin(value = "0", message = "Metric weight cannot be less than 0.")
        @DecimalMax(value = "100", message = "Metric weight cannot be greater than 100.")
        private BigDecimal weight;

        @Schema(description = "Score type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Score type is required.")
        @InEnum(value = HrmPerformanceQuotaScoreTypeEnum.class, message = "Score type must be {value}.")
        private Integer scoreType;
    }

}

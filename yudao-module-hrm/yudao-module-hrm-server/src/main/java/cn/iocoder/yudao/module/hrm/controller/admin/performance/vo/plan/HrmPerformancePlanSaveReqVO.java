package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.plan;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.util.object.ObjectUtils;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessmenttemplate.HrmPerformanceAssessmentTemplateSaveReqVO.Dimension;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.assessmenttemplate.HrmPerformanceAssessmentTemplateSaveReqVO.Quota;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.resulttemplate.HrmPerformanceResultTemplateSaveReqVO.Level;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeStatusEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.info.HrmEmployeeTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.assessment.HrmPerformanceAppealTimeoutActionEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceCycleTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformancePlanScopeTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceQuarterEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceQuotaSettingTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceRaterTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceReviewScoringTypeEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.plan.HrmPerformanceReviewVisibleContentEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.config.HrmPerformanceScoreCalculationEnum;
import cn.iocoder.yudao.module.hrm.enums.performance.config.HrmPerformanceUpperLimitTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.util.number.MoneyUtils.PERCENT_100;

@Schema(description = "Admin - HRM performance reviewplan save request.")
@Data
public class HrmPerformancePlanSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Performance reviewplan name.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "Q3 2026 performance plan")
    @NotBlank(message = "Plan name is required.")
    @Size(max = 50, message = "Plan name cannot exceed 50 characters.")
    private String name;

    @Schema(description = "Review Cycle type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Review Cycle type is required.")
    @InEnum(value = HrmPerformanceCycleTypeEnum.class, message = "Review Cycle type must be {value}.")
    private Integer cycleType;

    @Schema(description = "Review Cycle", example = "2026-08")
    @Size(max = 255, message = "Review Cycle cannot exceed 255 characters.")
    private String cycle;

    @Schema(description = "Quarter.", example = "3")
    @InEnum(value = HrmPerformanceQuarterEnum.class, message = "Quarter must be {value}.")
    private Integer quarter;

    @Schema(description = "Start Date.")
    private LocalDateTime startTime;

    @Schema(description = "End Date.")
    private LocalDateTime endTime;

    @Schema(description = "ReviewNotes.", example = "Q3 2026 performance review")
    @Size(max = 200, message = "ReviewNotes cannot exceed 200 characters.")
    private String description;

    @Schema(description = "Review scopelist.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Review scope cannot be empty.")
    @Size(max = 3, message = "Review scope cannot exceed 3.")
    private List<@NotNull(message = "Review scope cannot be empty.") Scope> scopes;

    @Schema(description = "Reviewtemplate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Reviewtemplate is required.")
    private Long assessmentTemplateId;

    @Schema(description = "Reviewsetting snapshot.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Reviewsetting is required.")
    private AssessmentConfig assessmentConfig;

    @Schema(description = "Metric set type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Metric set type is required.")
    @InEnum(value = HrmPerformanceQuotaSettingTypeEnum.class, message = "Metric set type must be {value}.")
    private Integer quotaSettingType;

    @Schema(description = "Is not need to need target confirm.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not need to need target confirm is required.")
    private Boolean targetConfirmation;

    @Schema(description = "Target confirm node.")
    @Valid
    private HandlerStage targetConfirmationStage;

    @Schema(description = "Scoring Stage list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Scoring Stage is required.")
    private List<@NotNull(message = "Scoring Stage is required.") ReviewStage> reviewStages;

    @Schema(description = "Is not need to need result approval.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not need to need result approval is required.")
    private Boolean resultAudit;

    @Schema(description = "Result approval node list.")
    @Valid
    private List<@NotNull(message = "Result approval node is required.") HandlerStage> resultAuditStages;

    @Schema(description = "Is not need to need result confirm.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not need to need result confirm is required.")
    private Boolean resultConfirmation;

    @Schema(description = "Appeal stageslist.")
    @Valid
    private List<@NotNull(message = "Appeal stages cannot be empty.") HandlerStage> appealStages;

    @Schema(description = "Appeal overdue days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @Min(value = 1, message = "Appeal overdue days cannot be less than 1 day.")
    @Max(value = 100, message = "Appeal overdue days cannot exceed 100 days.")
    @NotNull(message = "Appeal overdue days cannot be empty.")
    private Integer appealTimeoutDays;

    @Schema(description = "Appeal timeout action.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(HrmPerformanceAppealTimeoutActionEnum.class)
    @NotNull(message = "Appeal timeout action cannot be empty.")
    private Integer appealTimeoutAction;

    @Schema(description = "Resulttemplate code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Resulttemplate is required.")
    private Long resultTemplateId;

    @Schema(description = "Result setting snapshot.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "Resultsetting is required.")
    private ResultConfig resultConfig;

    @Schema(description = "Is not sync payroll.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not sync payroll is required.")
    private Boolean syncToSalary;

    @Schema(description = "Pay Month", example = "2026-09")
    @Size(max = 20, message = "Pay Month cannot exceed 20 characters.")
    private String paidForMonth;

    @Schema(description = "Admin - HRM performance plan review scope.")
    @Data
    public static class Scope {

        @Schema(description = "Range type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Review scope type cannot be empty.")
        @InEnum(value = HrmPerformancePlanScopeTypeEnum.class, message = "Review scope type must be {value}.")
        private Integer type;

        @Schema(description = "Employee code list.", example = "[1024, 1025]")
        private List<@NotNull(message = "Employee code is required.") Long> employeeIds;

        @Schema(description = "Department code list.", example = "[100, 101]")
        private List<@NotNull(message = "Department code is required.") Long> deptIds;

        @Schema(description = "Employment Type", example = "1")
        @InEnum(value = HrmEmployeeTypeEnum.class, message = "Employment Type must be {value}.")
        private Integer employeeType;

        @Schema(description = "Employee status list.", example = "[1, 2]")
        @InEnum(value = HrmEmployeeStatusEnum.class, message = "Employee status must be {value}.")
        private List<Integer> employeeStatuses;
    }

    @Schema(description = "Admin - HRM performance reviewplan process node.")
    @Data
    public static class HandlerStage {

        @Schema(description = "Process person type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Process person type is required.")
        @InEnum(value = HrmPerformanceRaterTypeEnum.class, message = "Process person type must be {value}.")
        private Integer type;

        @Schema(description = "Manager or department level.", example = "1")
        @Min(value = 1, message = "Handler level cannot be less than 1.")
        @Max(value = 10, message = "Handler level cannot be greater than 10.")
        private Integer level;

        @Schema(description = "Specified process employee code.", example = "1024")
        private Long employeeId;
    }

    @Schema(description = "Admin - HRM performance plan Scoring Stage.")
    @Data
    public static class ReviewStage {

        @Schema(description = "Scoring Stage name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Direct ManagerScore.")
        @NotBlank(message = "Scoring Stage name is required.")
        @Size(max = 50, message = "Scoring Stage name cannot exceed 50 characters.")
        private String name;

        @Schema(description = "Score person.", requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotNull(message = "Score person is required.")
        private HandlerStage rater;

        @Schema(description = "ScoreWeight.", requiredMode = Schema.RequiredMode.REQUIRED, example = "60")
        @NotNull(message = "ScoreWeight is required.")
        @DecimalMin(value = "0.01", message = "Score weight must be greater than 0.")
        @DecimalMax(value = "100", message = "Score weight cannot be greater than 100.")
        private BigDecimal weight;

        @Schema(description = "Score method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Score method is required.")
        @InEnum(value = HrmPerformanceReviewScoringTypeEnum.class, message = "Score method must be {value}.")
        private Integer scoringType;

        @Schema(description = "Score content visibility.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Score content visibility is required.")
        @InEnum(value = HrmPerformanceReviewVisibleContentEnum.class, message = "Score content visibility must be {value}.")
        private Integer visibleContent;

        @Schema(description = "Comment required.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        @NotNull(message = "Comment required cannot be empty.")
        private Boolean requiredSetting;

        @Schema(description = "Is not Allow Reject.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
        @NotNull(message = "Is not Allow Reject is required.")
        private Boolean rejectAuthority;
    }

    @Schema(description = "Admin - HRM performance review setting snapshot.")
    @Data
    public static class AssessmentConfig {

        @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Quarterly review template")
        @NotBlank(message = "Template name is required.")
        @Size(max = 50, message = "Template name cannot exceed 50 characters.")
        private String name;

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

        @Schema(description = "ReviewDimensionsetting.", requiredMode = Schema.RequiredMode.REQUIRED)
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
    }

    @Schema(description = "Admin - HRM performance review result setting snapshot.")
    @Data
    public static class ResultConfig {

        private static final BigDecimal MIN_SCORE = BigDecimal.ZERO;
        private static final BigDecimal MAX_SCORE = BigDecimal.valueOf(100);
        private static final BigDecimal SCORE_STEP = new BigDecimal("0.01");

        @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Performance review resulttemplate.")
        @NotBlank(message = "Resulttemplate name is required.")
        @Size(max = 255, message = "Resulttemplate name cannot exceed 255 characters.")
        private String name;

        @Schema(description = "Result level setting.", requiredMode = Schema.RequiredMode.REQUIRED)
        @Valid
        @NotEmpty(message = "At least need to need one result level.")
        private List<@NotNull(message = "Result level is required.") Level> levels;

        @AssertTrue(message = "Result level name cannot is duplicated.")
        @JsonIgnore
        public boolean isLevelNamesUnique() {
            if (CollUtil.isEmpty(levels)) {
                return true;
            }
            Set<String> names = new HashSet<>();
            for (Level level : levels) {
                if (level != null && StrUtil.isNotBlank(level.getName())
                        && !names.add(level.getName().trim())) {
                    return false;
                }
            }
            return true;
        }

        @AssertTrue(message = "Result-grade score ranges must cover 0 to 100 without gaps.")
        @JsonIgnore
        public boolean isScoreRangeContinuous() {
            if (CollUtil.isEmpty(levels)) {
                return true;
            }
            List<Level> sortedLevels = new ArrayList<>(levels);
            if (sortedLevels.stream().anyMatch(level -> level == null
                    || level.getMinScore() == null || level.getMaxScore() == null)) {
                return true;
            }
            sortedLevels.sort(Comparator.comparing(Level::getMinScore));
            if (CollUtil.getFirst(sortedLevels).getMinScore().compareTo(MIN_SCORE) != 0) {
                return false;
            }
            for (int i = 1; i < sortedLevels.size(); i++) {
                Level previous = sortedLevels.get(i - 1);
                Level current = sortedLevels.get(i);
                if (current.getMinScore().compareTo(previous.getMaxScore().add(SCORE_STEP)) != 0) {
                    return false;
                }
            }
            return CollUtil.getLast(sortedLevels).getMaxScore().compareTo(MAX_SCORE) == 0;
        }
    }

    // Service 只校验模板、员工和部门等数据引用。
    @AssertTrue(message = "Review scope is invalid.")
    @JsonIgnore
    public boolean isScopeConfigValid() {
        if (CollUtil.isEmpty(scopes)) {
            return true;
        }
        for (Scope scope : scopes) {
            if (scope == null || scope.getType() == null) {
                continue;
            }
            if (Objects.equals(scope.getType(), HrmPerformancePlanScopeTypeEnum.EMPLOYEE_DEPT.getType())) {
                if (CollUtil.isEmpty(scope.getEmployeeIds()) && CollUtil.isEmpty(scope.getDeptIds())) {
                    return false;
                }
            } else if (Objects.equals(scope.getType(), HrmPerformancePlanScopeTypeEnum.EMPLOYMENT.getType())) {
                if (scope.getEmployeeType() == null || CollUtil.isEmpty(scope.getEmployeeStatuses())) {
                    return false;
                }
            } else if (Objects.equals(scope.getType(),
                    HrmPerformancePlanScopeTypeEnum.EXCLUDED_EMPLOYEE.getType())) {
                return false;
            }
        }
        return true;
    }

    @AssertTrue(message = "Score person setting is invalid.")
    @JsonIgnore
    public boolean isReviewStageConfigValid() {
        if (CollUtil.isEmpty(reviewStages)) {
            return true;
        }
        for (ReviewStage reviewStage : reviewStages) {
            if (reviewStage == null || reviewStage.getRater() == null) {
                continue;
            }
            if (!isHandlerStageValid(reviewStage.getRater(), true)
                    || Objects.equals(reviewStage.getRater().getType(), HrmPerformanceRaterTypeEnum.SELF.getType())
                    && Boolean.TRUE.equals(reviewStage.getRejectAuthority())) {
                return false;
            }
        }
        return true;
    }

    @AssertTrue(message = "Score weights must add up to 100%.")
    @JsonIgnore
    public boolean isReviewStageWeightTotalValid() {
        if (CollUtil.isEmpty(reviewStages)) {
            return true;
        }
        BigDecimal totalWeight = BigDecimal.ZERO;
        for (ReviewStage reviewStage : reviewStages) {
            if (reviewStage == null || reviewStage.getWeight() == null) {
                return true;
            }
            totalWeight = totalWeight.add(reviewStage.getWeight());
        }
        return totalWeight.compareTo(PERCENT_100) == 0;
    }

    @AssertTrue(message = "Score person cannot is duplicated.")
    @JsonIgnore
    public boolean isReviewStageRaterUnique() {
        if (CollUtil.isEmpty(reviewStages)) {
            return true;
        }
        List<HandlerStage> raters = new ArrayList<>();
        for (ReviewStage reviewStage : reviewStages) {
            if (reviewStage != null) {
                raters.add(reviewStage.getRater());
            }
        }
        return isHandlerStageUnique(raters);
    }

    @AssertTrue(message = "Target confirm setting is invalid.")
    @JsonIgnore
    public boolean isTargetConfirmationConfigValid() {
        if (quotaSettingType == null || targetConfirmation == null) {
            return true;
        }
        if (Objects.equals(quotaSettingType, HrmPerformanceQuotaSettingTypeEnum.SYSTEM.getType())) {
            return !targetConfirmation;
        }
        return !targetConfirmation || targetConfirmationStage != null
                && isHandlerStageValid(targetConfirmationStage, true);
    }

    @AssertTrue(message = "Result approval nodesetting is invalid.")
    @JsonIgnore
    public boolean isResultAuditConfigValid() {
        return ObjUtil.notEqual(Boolean.TRUE, resultAudit) || isHandlerStagesValid(resultAuditStages);
    }

    @AssertTrue(message = "Appeal stages are invalid.")
    @JsonIgnore
    public boolean isResultConfirmationConfigValid() {
        return ObjUtil.notEqual(Boolean.TRUE, resultConfirmation) || isHandlerStagesValid(appealStages);
    }

    @AssertTrue(message = "Pay Monthsetting is invalid.")
    @JsonIgnore
    public boolean isSalaryConfigValid() {
        if (!Boolean.TRUE.equals(syncToSalary)) {
            return true;
        }
        if (StrUtil.isBlank(paidForMonth)) {
            return false;
        }
        try {
            YearMonth.parse(paidForMonth);
            return true;
        } catch (DateTimeParseException ignored) {
            return false;
        }
    }

    @AssertTrue(message = "Review cycle, quarter, or date range is invalid.")
    @JsonIgnore
    public boolean isCycleConfigValid() {
        if (cycleType == null) {
            return true;
        }
        if (startTime == null || endTime == null || endTime.isBefore(startTime)) {
            return false;
        }
        if (Objects.equals(cycleType, HrmPerformanceCycleTypeEnum.OTHER.getType())) {
            return StrUtil.isNotBlank(cycle) && quarter == null;
        }
        try {
            if (Objects.equals(cycleType, HrmPerformanceCycleTypeEnum.MONTH.getType())) {
                YearMonth month = YearMonth.parse(cycle);
                return quarter == null && startTime.toLocalDate().equals(month.atDay(1))
                        && endTime.toLocalDate().equals(month.atEndOfMonth());
            }
            Year year = Year.parse(cycle);
            int beginMonth = 1;
            int endMonth = 12;
            if (Objects.equals(cycleType, HrmPerformanceCycleTypeEnum.QUARTER.getType())) {
                if (HrmPerformanceQuarterEnum.valueOf(quarter) == null) {
                    return false;
                }
                beginMonth = (quarter - 1) * 3 + 1;
                endMonth = beginMonth + 2;
            } else if (Objects.equals(cycleType,
                    HrmPerformanceCycleTypeEnum.FIRST_HALF_YEAR.getType())) {
                endMonth = 6;
            } else if (Objects.equals(cycleType,
                    HrmPerformanceCycleTypeEnum.SECOND_HALF_YEAR.getType())) {
                beginMonth = 7;
            }
            if (!Objects.equals(cycleType, HrmPerformanceCycleTypeEnum.QUARTER.getType())
                    && quarter != null) {
                return false;
            }
            YearMonth beginYearMonth = year.atMonth(beginMonth);
            YearMonth endYearMonth = year.atMonth(endMonth);
            return startTime.toLocalDate().equals(beginYearMonth.atDay(1))
                    && endTime.toLocalDate().equals(endYearMonth.atEndOfMonth());
        } catch (DateTimeParseException | NullPointerException ignored) {
            return false;
        }
    }

    private boolean isHandlerStagesValid(List<HandlerStage> stages) {
        if (CollUtil.isEmpty(stages) || stages.size() > 3) {
            return false;
        }
        for (HandlerStage stage : stages) {
            if (stage != null && !isHandlerStageValid(stage, false)) {
                return false;
            }
        }
        return isHandlerStageUnique(stages);
    }

    private boolean isHandlerStageValid(HandlerStage stage, boolean allowSelf) {
        if (stage == null || stage.getType() == null) {
            return true;
        }
        if (Objects.equals(stage.getType(), HrmPerformanceRaterTypeEnum.SELF.getType())) {
            return allowSelf;
        }
        if (ObjectUtils.equalsAny(stage.getType(), HrmPerformanceRaterTypeEnum.SUPERIOR.getType(),
                HrmPerformanceRaterTypeEnum.DEPT_LEADER.getType())) {
            return stage.getLevel() != null && stage.getLevel() >= 1 && stage.getLevel() <= 10;
        }
        if (Objects.equals(stage.getType(), HrmPerformanceRaterTypeEnum.SPECIFIED.getType())) {
            return stage.getEmployeeId() != null;
        }
        return true;
    }

    private boolean isHandlerStageUnique(List<HandlerStage> stages) {
        if (CollUtil.isEmpty(stages)) {
            return true;
        }
        Set<String> handlerKeys = new HashSet<>();
        for (HandlerStage stage : stages) {
            String handlerKey = buildHandlerKey(stage);
            if (handlerKey != null && !handlerKeys.add(handlerKey)) {
                return false;
            }
        }
        return true;
    }

    private String buildHandlerKey(HandlerStage stage) {
        if (stage == null || stage.getType() == null) {
            return null;
        }
        if (Objects.equals(stage.getType(), HrmPerformanceRaterTypeEnum.SELF.getType())) {
            return String.valueOf(stage.getType());
        }
        if (Objects.equals(stage.getType(), HrmPerformanceRaterTypeEnum.SPECIFIED.getType())) {
            return stage.getEmployeeId() == null ? null : stage.getType() + ":" + stage.getEmployeeId();
        }
        if (ObjectUtils.equalsAny(stage.getType(), HrmPerformanceRaterTypeEnum.SUPERIOR.getType(),
                HrmPerformanceRaterTypeEnum.DEPT_LEADER.getType())) {
            return stage.getLevel() == null ? null : stage.getType() + ":" + stage.getLevel();
        }
        return null;
    }

}

package cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.resulttemplate;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Schema(description = "Admin - HRM performance review resulttemplate save request.")
@Data
public class HrmPerformanceResultTemplateSaveReqVO {

    private static final BigDecimal MIN_SCORE = BigDecimal.ZERO;
    private static final BigDecimal MAX_SCORE = BigDecimal.valueOf(100);
    private static final BigDecimal SCORE_STEP = new BigDecimal("0.01");

    @Schema(description = "Resulttemplate code.", example = "1024")
    private Long id;

    @Schema(description = "Resulttemplate name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Quarterly review result")
    @NotBlank(message = "Resulttemplate name is required.")
    @Size(max = 255, message = "Resulttemplate name cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Result level list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "At least need to need one result level.")
    private List<@NotNull(message = "Result level is required.") Level> levels;

    /**
     * 校验结果等级名称唯一
     */
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

    /**
     * 校验结果等级分数区间连续覆盖 0 到 100 分
     */
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

    @Schema(description = "Admin - HRM performance review resulttemplate level.")
    @Data
    public static class Level {

        @Schema(description = "Level name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "A")
        @NotBlank(message = "Level name is required.")
        @Size(max = 255, message = "Level name cannot exceed 255 characters.")
        private String name;

        @Schema(description = "Minimum score.", requiredMode = Schema.RequiredMode.REQUIRED, example = "90")
        @NotNull(message = "Minimum score cannot be empty.")
        @DecimalMin(value = "0", message = "Minimum score cannot be less than 0.")
        @DecimalMax(value = "100", message = "Minimum score cannot be greater than 100.")
        @Digits(integer = 3, fraction = 2, message = "Minimum score can have at most 2 decimal places.")
        private BigDecimal minScore;

        @Schema(description = "Maximum score.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        @NotNull(message = "Maximum score cannot be empty.")
        @DecimalMin(value = "0", message = "Maximum score cannot be less than 0.")
        @DecimalMax(value = "100", message = "Maximum score cannot be greater than 100.")
        @Digits(integer = 3, fraction = 2, message = "Maximum score can have at most 2 decimal places.")
        private BigDecimal maxScore;

        @Schema(description = "Performance Factor", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.2")
        @NotNull(message = "Performance Factor is required.")
        @DecimalMin(value = "0", message = "Performance factor cannot be less than 0.")
        @Digits(integer = 8, fraction = 2, message = "Performance factor can have at most 2 decimal places.")
        private BigDecimal coefficient;

        @AssertTrue(message = "Minimum score cannot be greater than maximum score.")
        @JsonIgnore
        public boolean isScoreRangeValid() {
            return minScore == null || maxScore == null || minScore.compareTo(maxScore) <= 0;
        }
    }

}

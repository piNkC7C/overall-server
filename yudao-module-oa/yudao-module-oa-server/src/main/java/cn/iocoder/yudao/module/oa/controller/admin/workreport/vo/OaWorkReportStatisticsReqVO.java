package cn.iocoder.yudao.module.oa.controller.admin.workreport.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.workreport.OaWorkReportTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - OA work reportStats request.")
@Data
public class OaWorkReportStatisticsReqVO {

    @Schema(description = "Report type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Report type cannot be empty.")
    @InEnum(value = OaWorkReportTypeEnum.class, message = "Report type must be {value}.")
    private Integer type;

    @Schema(description = "Stats start time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-01 00:00:00")
    @NotNull(message = "Stats start time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "Stats end time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-30 23:59:59")
    @NotNull(message = "Stats end time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "Full-cycle query start.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-01 00:00:00")
    @NotNull(message = "Search start time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime queryStartTime;

    @Schema(description = "Full-cycle query end.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-30 23:59:59")
    @NotNull(message = "Search end time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime queryEndTime;

    @Schema(description = "Department code.", example = "103")
    private Long deptId;

    @JsonIgnore
    @AssertTrue(message = "Stats end time cannot earlier than start time.")
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || !startTime.isAfter(endTime);
    }

}

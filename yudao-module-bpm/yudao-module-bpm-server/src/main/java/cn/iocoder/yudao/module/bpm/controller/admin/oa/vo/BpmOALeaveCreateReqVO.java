package cn.iocoder.yudao.module.bpm.controller.admin.oa.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - leave requestcreate request.")
@Data
public class BpmOALeaveCreateReqVO {

    @Schema(description = "Leave start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Start time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "Leave end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "Leave Type- see bpm_oa_type enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Read the docs")
    private String reason;

    @Schema(description = "Approvers selected by the starter Map.", example = "{taskKey1: [1, 2]}")
    private Map<String, List<Long>> startUserSelectAssignees;

    @AssertTrue(message = "End time, need to need in start time after.")
    public boolean isEndTimeValid() {
        return !getEndTime().isBefore(getStartTime());
    }

}

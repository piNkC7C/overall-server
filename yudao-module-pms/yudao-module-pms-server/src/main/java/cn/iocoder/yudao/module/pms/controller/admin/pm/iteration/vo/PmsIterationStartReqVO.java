package cn.iocoder.yudao.module.pms.controller.admin.pm.iteration.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - PMS item sprint start request.")
@Data
public class PmsIterationStartReqVO {

    @Schema(description = "Sprint code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Sprint code is required.")
    private Long id;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Sprint start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Sprint end time is required.")
    private LocalDateTime endTime;

    @Schema(hidden = true)
    @AssertTrue(message = "Sprint End time must be later than start time.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || endTime.isAfter(startTime);
    }

}

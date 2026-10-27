package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.leave;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employeeleave requestcreate request.")
@Data
public class HrmAttendanceLeaveCreateReqVO {

    @Schema(description = "Leave Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "Personal leave")
    @NotBlank(message = "Leave Type is required.")
    @Size(max = 64, message = "Leave Type cannot exceed 64 characters.")
    private String type;

    @Schema(description = "Leave start time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Leave start time cannot be empty.")
    private LocalDateTime startTime;

    @Schema(description = "Leave end time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Leave end time cannot be empty.")
    private LocalDateTime endTime;

    @Schema(description = "Leave days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.00")
    @NotNull(message = "Leave days is required.")
    @DecimalMin(value = "0.01", message = "Leave days must be greater than 0.")
    @Digits(integer = 8, fraction = 2, message = "Leave days can have at most 2 decimal places.")
    private BigDecimal day;

    @Schema(description = "Leave Reason", requiredMode = Schema.RequiredMode.REQUIRED, example = "Personal matter")
    @NotBlank(message = "Leave Reason is required.")
    @Size(max = 300, message = "Leave Reason cannot exceed 300 characters.")
    private String reason;

    @Schema(description = "Notes.", example = "Please approval.")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @Schema(hidden = true)
    @AssertTrue(message = "Leave end time must be later than the start time.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || endTime.isAfter(startTime);
    }

}

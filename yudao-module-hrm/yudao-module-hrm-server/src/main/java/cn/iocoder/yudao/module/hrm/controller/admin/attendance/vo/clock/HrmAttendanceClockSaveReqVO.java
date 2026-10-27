package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.clock;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.attendance.record.HrmAttendanceClockTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - HRM clock-in record save request.")
@Data
public class HrmAttendanceClockSaveReqVO {

    @Schema(description = "Clock-in record code.", example = "1024")
    private Long id;

    @Schema(description = "Clock-in employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    @NotNull(message = "Clock-in employee is required.")
    private Long employeeId;

    @Schema(description = "Clock-in time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Clock-in time is required.")
    private LocalDateTime clockTime;

    @Schema(description = "Clock-in type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Clock-in type is required.")
    @InEnum(value = HrmAttendanceClockTypeEnum.class, message = "Clock-in type must be {value}.")
    private Integer type;

    @Schema(description = "Required clock-in time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Required clock-in time cannot be empty.")
    private LocalDateTime attendanceTime;

    @Schema(description = "Clock-in Address.", example = "HQ building")
    @Size(max = 255, message = "Clock-in Address cannot exceed 255 characters.")
    private String address;

    @Schema(description = "Longitude", example = "121.473701")
    @DecimalMin(value = "-180", message = "Longitude must be between -180 and 180.")
    @DecimalMax(value = "180", message = "Longitude must be between -180 and 180.")
    private BigDecimal longitude;

    @Schema(description = "Latitude", example = "31.230416")
    @DecimalMin(value = "-90", message = "Latitude must be between -90 and 90.")
    @DecimalMax(value = "90", message = "Latitude must be between -90 and 90.")
    private BigDecimal latitude;

    @Schema(description = "WiFi name.", example = "office_wifi")
    @Size(max = 50, message = "WiFi name cannot exceed 50 characters.")
    private String ssid;

    @Schema(description = "WiFi MAC Address.", example = "00:11:22:33:44:55")
    @Size(max = 50, message = "WiFi MAC Address cannot exceed 50 characters.")
    private String mac;

    @Schema(description = "Notes.", example = "Manual punch correction")
    @Size(max = 255, message = "Notes cannot exceed 255 characters.")
    private String remark;

}

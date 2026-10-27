package cn.iocoder.yudao.module.hrm.controller.admin.portal.attendance.vo.clock;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "HRM employee attendance record response VO.")
@Data
public class HrmPortalAttendanceRecordRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Clock-in time.")
    private LocalDateTime clockTime;

    @Schema(description = "Employee attendance record type.")
    private Integer type;

    @Schema(description = "Required clock-in time.")
    private LocalDateTime attendanceTime;

    @Schema(description = "Source type.")
    private Integer sourceType;

    @Schema(description = "Employee attendance record status.")
    private Integer status;

    @Schema(description = "Stage")
    private Integer stage;

    @Schema(description = "Address")
    private String address;

    @Schema(description = "Longitude")
    private BigDecimal longitude;

    @Schema(description = "Latitude")
    private BigDecimal latitude;

    @Schema(description = "WiFi name.")
    private String ssid;

    @Schema(description = "WiFi MAC Address.")
    private String mac;

    @Schema(description = "Notes.")
    private String remark;

}

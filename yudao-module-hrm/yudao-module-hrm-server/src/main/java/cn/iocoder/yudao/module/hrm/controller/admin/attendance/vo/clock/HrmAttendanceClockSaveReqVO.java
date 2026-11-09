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

@Schema(description = "管理后台 - HRM 打卡记录保存 Request VO")
@Data
public class HrmAttendanceClockSaveReqVO {

    @Schema(description = "打卡记录编号", example = "1024")
    private Long id;

    @Schema(description = "打卡员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    @NotNull(message = "Clock-in employee is required.")
    private Long employeeId;

    @Schema(description = "打卡时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Clock-in time is required.")
    private LocalDateTime clockTime;

    @Schema(description = "打卡类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Clock-in type is required.")
    @InEnum(value = HrmAttendanceClockTypeEnum.class, message = "Clock-in type must be {value}.")
    private Integer type;

    @Schema(description = "应打卡时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Required clock-in time cannot be empty.")
    private LocalDateTime attendanceTime;

    @Schema(description = "打卡地址", example = "HQ building")
    @Size(max = 255, message = "Clock-in Address cannot exceed 255 characters.")
    private String address;

    @Schema(description = "经度", example = "121.473701")
    @DecimalMin(value = "-180", message = "Longitude must be between -180 and 180.")
    @DecimalMax(value = "180", message = "Longitude must be between -180 and 180.")
    private BigDecimal longitude;

    @Schema(description = "纬度", example = "31.230416")
    @DecimalMin(value = "-90", message = "Latitude must be between -90 and 90.")
    @DecimalMax(value = "90", message = "Latitude must be between -90 and 90.")
    private BigDecimal latitude;

    @Schema(description = "WiFi 名称", example = "office_wifi")
    @Size(max = 50, message = "WiFi name cannot exceed 50 characters.")
    private String ssid;

    @Schema(description = "WiFi MAC 地址", example = "00:11:22:33:44:55")
    @Size(max = 50, message = "WiFi MAC Address cannot exceed 50 characters.")
    private String mac;

    @Schema(description = "备注", example = "Manual punch correction")
    @Size(max = 255, message = "Notes cannot exceed 255 characters.")
    private String remark;

}

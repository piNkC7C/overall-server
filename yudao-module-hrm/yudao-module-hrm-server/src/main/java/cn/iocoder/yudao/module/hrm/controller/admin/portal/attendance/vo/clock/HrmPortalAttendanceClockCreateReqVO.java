package cn.iocoder.yudao.module.hrm.controller.admin.portal.attendance.vo.clock;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - HRM 员工端手机打卡 Request VO")
@Data
public class HrmPortalAttendanceClockCreateReqVO {

    @Schema(description = "打卡地址", example = "Pudong, Shanghai")
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

}

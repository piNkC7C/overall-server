package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.clock;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.hrm.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - HRM clock-in record response.")
@Data
@ExcelIgnoreUnannotated
public class HrmAttendanceClockRespVO {

    @Schema(description = "Clock-in record code.", example = "1024")
    @ExcelProperty(value = "Record ID", index = 0)
    private Long id;

    @Schema(description = "Clock-in employee code.", example = "1001")
    @ExcelProperty(value = "Employee ID", index = 1)
    private Long employeeId;

    @Schema(description = "Employee Name", example = "Overall.")
    @ExcelProperty(value = "Employee Name", index = 2)
    private String employeeName;

    @Schema(description = "Employee No.", example = "HRM001")
    @ExcelProperty(value = "Employee No", index = 3)
    private String jobNumber;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    @ExcelProperty(value = "Department", index = 4)
    private String deptName;

    @Schema(description = "Job Title name.", example = "Java engineer.")
    @ExcelProperty(value = "Job Title", index = 5)
    private String postName;

    @Schema(description = "Clock-in time.")
    @ExcelProperty(value = "Punch Time", index = 8)
    private LocalDateTime clockTime;

    @Schema(description = "Clock-in type.", example = "1")
    @ExcelProperty(value = "Punch Type", index = 6, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_ATTENDANCE_CLOCK_TYPE)
    private Integer type;

    @Schema(description = "Required clock-in time.")
    @ExcelProperty(value = "Required Punch Time", index = 7)
    private LocalDateTime attendanceTime;

    @Schema(description = "Clock-in source.")
    @ExcelProperty(value = "Source", index = 10, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_ATTENDANCE_CLOCK_SOURCE)
    private Integer sourceType;

    @Schema(description = "Clock-in status.")
    @ExcelProperty(value = "Punch Status", index = 9, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_ATTENDANCE_CLOCK_STATUS)
    private Integer status;

    @Schema(description = "Clock-in Stage.")
    private Integer stage;

    @Schema(description = "Clock-in Address.", example = "HQ building")
    @ExcelProperty(value = "Location", index = 11)
    private String address;

    @Schema(description = "Longitude", example = "121.473701")
    private BigDecimal longitude;

    @Schema(description = "Latitude", example = "31.230416")
    private BigDecimal latitude;

    @Schema(description = "WiFi name.", example = "office_wifi")
    private String ssid;

    @Schema(description = "WiFi MAC Address.", example = "00:11:22:33:44:55")
    private String mac;

    @Schema(description = "Notes.", example = "Manual punch correction")
    @ExcelProperty(value = "Notes", index = 12)
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

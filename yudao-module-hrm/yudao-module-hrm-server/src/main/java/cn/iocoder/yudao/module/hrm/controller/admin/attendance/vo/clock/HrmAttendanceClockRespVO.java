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

@Schema(description = "管理后台 - HRM 打卡记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class HrmAttendanceClockRespVO {

    @Schema(description = "打卡记录编号", example = "1024")
    @ExcelProperty(value = "Record ID", index = 0)
    private Long id;

    @Schema(description = "打卡员工编号", example = "1001")
    @ExcelProperty(value = "Employee ID", index = 1)
    private Long employeeId;

    @Schema(description = "员工姓名", example = "Overall.")
    @ExcelProperty(value = "Employee Name", index = 2)
    private String employeeName;

    @Schema(description = "工号", example = "HRM001")
    @ExcelProperty(value = "Employee No", index = 3)
    private String jobNumber;

    @Schema(description = "部门编号", example = "100")
    private Long deptId;

    @Schema(description = "部门名称", example = "Engineering.")
    @ExcelProperty(value = "Department", index = 4)
    private String deptName;

    @Schema(description = "职位名称", example = "Java engineer.")
    @ExcelProperty(value = "Job Title", index = 5)
    private String postName;

    @Schema(description = "打卡时间")
    @ExcelProperty(value = "Punch Time", index = 8)
    private LocalDateTime clockTime;

    @Schema(description = "打卡类型", example = "1")
    @ExcelProperty(value = "Punch Type", index = 6, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_ATTENDANCE_CLOCK_TYPE)
    private Integer type;

    @Schema(description = "应打卡时间")
    @ExcelProperty(value = "Required Punch Time", index = 7)
    private LocalDateTime attendanceTime;

    @Schema(description = "打卡来源")
    @ExcelProperty(value = "Source", index = 10, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_ATTENDANCE_CLOCK_SOURCE)
    private Integer sourceType;

    @Schema(description = "打卡状态")
    @ExcelProperty(value = "Punch Status", index = 9, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_ATTENDANCE_CLOCK_STATUS)
    private Integer status;

    @Schema(description = "打卡阶段")
    private Integer stage;

    @Schema(description = "打卡地址", example = "HQ building")
    @ExcelProperty(value = "Location", index = 11)
    private String address;

    @Schema(description = "经度", example = "121.473701")
    private BigDecimal longitude;

    @Schema(description = "纬度", example = "31.230416")
    private BigDecimal latitude;

    @Schema(description = "WiFi 名称", example = "office_wifi")
    private String ssid;

    @Schema(description = "WiFi MAC 地址", example = "00:11:22:33:44:55")
    private String mac;

    @Schema(description = "备注", example = "Manual punch correction")
    @ExcelProperty(value = "Notes", index = 12)
    private String remark;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}

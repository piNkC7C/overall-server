package cn.iocoder.yudao.module.hrm.controller.admin.attendance;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.holiday.HrmAttendanceHolidayPageReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.holiday.HrmAttendanceHolidayRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.holiday.HrmAttendanceHolidaySaveReqVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.attendance.config.HrmAttendanceHolidayDO;
import cn.iocoder.yudao.module.hrm.service.attendance.config.HrmAttendanceHolidayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Tag(name = "Admin - HRM attendance holiday.")
@RestController
@RequestMapping("/hrm/attendance/holiday")
@Validated
public class HrmAttendanceHolidayController {

    @Resource
    private HrmAttendanceHolidayService attendanceHolidayService;

    @PostMapping("/create")
    @Operation(summary = "Createattendance holiday.")
    @PreAuthorize("@ss.hasPermission('hrm:attendance:holiday:create')")
    public CommonResult<Long> createAttendanceHoliday(@Valid @RequestBody HrmAttendanceHolidaySaveReqVO createReqVO) {
        return success(attendanceHolidayService.createAttendanceHoliday(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit attendance holiday.")
    @PreAuthorize("@ss.hasPermission('hrm:attendance:holiday:update')")
    public CommonResult<Boolean> updateAttendanceHoliday(@Valid @RequestBody HrmAttendanceHolidaySaveReqVO updateReqVO) {
        attendanceHolidayService.updateAttendanceHoliday(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteattendance holiday.")
    @Parameter(name = "id", description = "Attendance holiday code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:attendance:holiday:delete')")
    public CommonResult<Boolean> deleteAttendanceHoliday(@RequestParam("id") Long id) {
        attendanceHolidayService.deleteAttendanceHoliday(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get attendance holiday.")
    @Parameter(name = "id", description = "Attendance holiday code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:attendance:holiday:query')")
    public CommonResult<HrmAttendanceHolidayRespVO> getAttendanceHoliday(@RequestParam("id") Long id) {
        HrmAttendanceHolidayDO holiday = attendanceHolidayService.getAttendanceHoliday(id);
        return success(BeanUtils.toBean(holiday, HrmAttendanceHolidayRespVO.class));
    }

    @GetMapping("/check")
    @Operation(summary = "Check Date is not is attendance holiday.")
    @Parameter(name = "day", description = "Date", required = true)
    @PreAuthorize("@ss.hasPermission('hrm:attendance:holiday:query')")
    public CommonResult<HrmAttendanceHolidayRespVO> checkAttendanceHoliday(
            @RequestParam("day")
            @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND) LocalDateTime day) {
        HrmAttendanceHolidayDO holiday = attendanceHolidayService.checkAttendanceHoliday(day);
        return success(BeanUtils.toBean(holiday, HrmAttendanceHolidayRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get attendance holiday page.")
    @PreAuthorize("@ss.hasPermission('hrm:attendance:holiday:query')")
    public CommonResult<PageResult<HrmAttendanceHolidayRespVO>> getAttendanceHolidayPage(
            @Validated HrmAttendanceHolidayPageReqVO pageReqVO) {
        PageResult<HrmAttendanceHolidayDO> pageResult = attendanceHolidayService.getAttendanceHolidayPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, HrmAttendanceHolidayRespVO.class));
    }

}

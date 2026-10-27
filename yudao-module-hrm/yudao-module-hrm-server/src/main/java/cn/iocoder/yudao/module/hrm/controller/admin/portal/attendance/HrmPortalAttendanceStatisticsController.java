package cn.iocoder.yudao.module.hrm.controller.admin.portal.attendance;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics.HrmAttendanceDailyDetailRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics.HrmAttendanceMonthDetailRespVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.employee.info.HrmEmployeeDO;
import cn.iocoder.yudao.module.hrm.service.attendance.statistics.HrmAttendanceStatisticsService;
import cn.iocoder.yudao.module.hrm.service.employee.info.HrmEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - HRM employee attendance stats.")
@RestController
@RequestMapping("/hrm/portal/attendance/statistics")
@Validated
public class HrmPortalAttendanceStatisticsController {

    @Resource
    private HrmEmployeeService employeeService;
    @Resource
    private HrmAttendanceStatisticsService attendanceStatisticsService;

    @GetMapping("/month-detail")
    @Operation(summary = "Get my monthly attendance detail.")
    @Parameters({
            @Parameter(name = "year", description = "Year.", example = "2026"),
            @Parameter(name = "month", description = "Month", example = "8")
    })
    @PreAuthorize("@ss.hasPermission('hrm:portal:query')")
    public CommonResult<HrmAttendanceMonthDetailRespVO> getAttendanceMonthDetail(
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "month", required = false) Integer month) {
        HrmEmployeeDO employee = employeeService.validateEmployeeBySelf(getLoginUserId());
        YearMonth queryMonth = year == null || month == null
                ? YearMonth.now() : YearMonth.of(year, month);
        return success(attendanceStatisticsService.getAttendanceMonthDetail(
                employee.getId(), queryMonth.getYear(), queryMonth.getMonthValue()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export my monthly attendance daily report.")
    @Parameters({
            @Parameter(name = "year", description = "Year.", required = true, example = "2026"),
            @Parameter(name = "month", description = "Month", required = true, example = "8")
    })
    @PreAuthorize("@ss.hasPermission('hrm:portal:query')")
    public void exportAttendanceMonthDetail(
            @RequestParam("year") Integer year, @RequestParam("month") Integer month,
            HttpServletResponse response) throws Exception {
        HrmEmployeeDO employee = employeeService.validateEmployeeBySelf(getLoginUserId());
        HrmAttendanceMonthDetailRespVO detail = attendanceStatisticsService.getAttendanceMonthDetail(
                employee.getId(), year, month);
        ExcelUtils.write(response, year + "-" + month + " Personal Attendance Daily Report.xls", "Daily Report",
                HrmAttendanceDailyDetailRespVO.class, detail.getDailyDetails());
    }

}

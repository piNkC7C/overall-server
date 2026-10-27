package cn.iocoder.yudao.module.mes.controller.admin.cal.holiday;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.cal.holiday.vo.MesCalHolidayRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.cal.holiday.vo.MesCalHolidaySaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.cal.holiday.MesCalHolidayDO;
import cn.iocoder.yudao.module.mes.service.cal.holiday.MesCalHolidayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - MES holiday set.")
@RestController
@RequestMapping("/mes/cal/holiday")
@Validated
public class MesCalHolidayController {

    @Resource
    private MesCalHolidayService holidayService;

    @PostMapping("/save")
    @Operation(summary = "Save holiday set.", description = "Update if a record already exists for the date.")
    @PreAuthorize("@ss.hasPermission('mes:cal-holiday:create')")
    public CommonResult<Long> saveHoliday(@Valid @RequestBody MesCalHolidaySaveReqVO saveReqVO) {
        return success(holidayService.saveHoliday(saveReqVO));
    }

    @GetMapping("/get-by-day")
    @Operation(summary = "By Date get holiday set.")
    @Parameter(name = "day", description = "Date", required = true)
    @PreAuthorize("@ss.hasPermission('mes:cal-holiday:query')")
    public CommonResult<MesCalHolidayRespVO> getHolidayByDay(
            @RequestParam("day") @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND) LocalDateTime day) {
        MesCalHolidayDO holiday = holidayService.getHolidayByDay(day);
        return success(BeanUtils.toBean(holiday, MesCalHolidayRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get holiday set list.", description = "Optional date-range filter. Omit to return all rows.")
    @PreAuthorize("@ss.hasPermission('mes:cal-holiday:query')")
    public CommonResult<List<MesCalHolidayRespVO>> getHolidayList(
            @RequestParam(value = "startDay", required = false)
            @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND) LocalDateTime startDay,
            @RequestParam(value = "endDay", required = false)
            @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND) LocalDateTime endDay) {
        List<MesCalHolidayDO> list = holidayService.getHolidayList(startDay, endDay);
        return success(BeanUtils.toBean(list, MesCalHolidayRespVO.class));
    }

}

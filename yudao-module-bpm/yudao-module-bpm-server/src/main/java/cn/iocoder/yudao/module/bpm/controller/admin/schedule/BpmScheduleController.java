package cn.iocoder.yudao.module.bpm.controller.admin.schedule;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmScheduleListReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmSchedulePageReqVO;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmScheduleRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo.BpmScheduleSaveReqVO;
import cn.iocoder.yudao.module.bpm.dal.dataobject.schedule.BpmScheduleDO;
import cn.iocoder.yudao.module.bpm.service.schedule.BpmScheduleService;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
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

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "管理后台 - 我的日程")
@RestController
@RequestMapping("/bpm/schedule")
@Validated
public class BpmScheduleController {

    @Resource
    private BpmScheduleService scheduleService;
    @Resource
    private AdminUserApi adminUserApi;
    @Resource
    private DeptApi deptApi;

    @PostMapping("/create")
    @Operation(summary = "创建日程")
    @PreAuthorize("@ss.hasPermission('bpm:schedule:create')")
    public CommonResult<Long> createSchedule(@Valid @RequestBody BpmScheduleSaveReqVO createReqVO) {
        return success(scheduleService.createSchedule(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "更新日程")
    @PreAuthorize("@ss.hasPermission('bpm:schedule:update')")
    public CommonResult<Boolean> updateSchedule(@Valid @RequestBody BpmScheduleSaveReqVO updateReqVO) {
        scheduleService.updateSchedule(updateReqVO, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除日程")
    @Parameter(name = "id", description = "日程编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bpm:schedule:delete')")
    public CommonResult<Boolean> deleteSchedule(@RequestParam("id") Long id) {
        scheduleService.deleteSchedule(id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得日程详情")
    @Parameter(name = "id", description = "日程编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('bpm:schedule:query')")
    public CommonResult<BpmScheduleRespVO> getSchedule(@RequestParam("id") Long id) {
        BpmScheduleDO schedule = scheduleService.getSchedule(id, getLoginUserId());
        return success(CollUtil.getFirst(buildScheduleRespVOList(Collections.singletonList(schedule))));
    }

    @GetMapping("/page")
    @Operation(summary = "获得日程分页")
    @PreAuthorize("@ss.hasPermission('bpm:schedule:query')")
    public CommonResult<PageResult<BpmScheduleRespVO>> getSchedulePage(@Valid BpmSchedulePageReqVO pageReqVO) {
        PageResult<BpmScheduleDO> pageResult = scheduleService.getSchedulePage(pageReqVO, getLoginUserId());
        return success(new PageResult<>(buildScheduleRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/list")
    @Operation(summary = "按时间窗获得日程列表（不分页，日历用）")
    @PreAuthorize("@ss.hasPermission('bpm:schedule:query')")
    public CommonResult<List<BpmScheduleRespVO>> getScheduleList(@Valid BpmScheduleListReqVO listReqVO) {
        List<BpmScheduleDO> list = scheduleService.getScheduleList(listReqVO, getLoginUserId());
        return success(buildScheduleRespVOList(list));
    }

    @GetMapping("/busy-dates")
    @Operation(summary = "按时间窗获得有日程的日期（仅日期标记，不含详情）")
    @PreAuthorize("@ss.hasPermission('bpm:schedule:query')")
    public CommonResult<List<String>> getBusyDates(@Valid BpmScheduleListReqVO listReqVO) {
        return success(scheduleService.getBusyDates(listReqVO, getLoginUserId()));
    }

    @GetMapping("/my-page")
    @Operation(summary = "获得我的日程分页")
    @PreAuthorize("@ss.hasPermission('bpm:schedule:query')")
    public CommonResult<PageResult<BpmScheduleRespVO>> getMySchedulePage(@Valid BpmSchedulePageReqVO pageReqVO) {
        PageResult<BpmScheduleDO> pageResult = scheduleService.getMySchedulePage(pageReqVO, getLoginUserId());
        return success(new PageResult<>(buildScheduleRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    private List<BpmScheduleRespVO> buildScheduleRespVOList(List<BpmScheduleDO> schedules) {
        if (CollUtil.isEmpty(schedules)) {
            return Collections.emptyList();
        }
        Collection<Long> userIds = convertSet(schedules, schedule -> NumberUtils.parseLong(schedule.getCreator()));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(userIds);
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(convertSet(userMap.values(), AdminUserRespDTO::getDeptId));
        return convertList(schedules, scheduleDO -> {
            BpmScheduleRespVO schedule = BeanUtils.toBean(scheduleDO, BpmScheduleRespVO.class);
            MapUtils.findAndThen(userMap, NumberUtils.parseLong(schedule.getCreator()), user -> {
                schedule.setCreatorName(user.getNickname());
                MapUtils.findAndThen(deptMap, user.getDeptId(), dept -> schedule.setCreatorDeptName(dept.getName()));
            });
            return schedule;
        });
    }

}

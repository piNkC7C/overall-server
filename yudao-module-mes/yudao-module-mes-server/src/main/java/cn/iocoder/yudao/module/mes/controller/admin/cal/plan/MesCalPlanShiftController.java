package cn.iocoder.yudao.module.mes.controller.admin.cal.plan;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.shift.MesCalPlanShiftPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.shift.MesCalPlanShiftRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.cal.plan.vo.shift.MesCalPlanShiftSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.cal.plan.MesCalPlanShiftDO;
import cn.iocoder.yudao.module.mes.service.cal.plan.MesCalPlanShiftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - MES plan shift.")
@RestController
@RequestMapping("/mes/cal/plan-shift")
@Validated
public class MesCalPlanShiftController {

    @Resource
    private MesCalPlanShiftService planShiftService;

    @PostMapping("/create")
    @Operation(summary = "Createplan shift.")
    @PreAuthorize("@ss.hasPermission('mes:cal-plan:update')")
    public CommonResult<Long> createPlanShift(@Valid @RequestBody MesCalPlanShiftSaveReqVO createReqVO) {
        return success(planShiftService.createPlanShift(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateplan shift.")
    @PreAuthorize("@ss.hasPermission('mes:cal-plan:update')")
    public CommonResult<Boolean> updatePlanShift(@Valid @RequestBody MesCalPlanShiftSaveReqVO updateReqVO) {
        planShiftService.updatePlanShift(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteplan shift.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:cal-plan:update')")
    public CommonResult<Boolean> deletePlanShift(@RequestParam("id") Long id) {
        planShiftService.deletePlanShift(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get plan shift.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:cal-plan:query')")
    public CommonResult<MesCalPlanShiftRespVO> getPlanShift(@RequestParam("id") Long id) {
        MesCalPlanShiftDO planShift = planShiftService.getPlanShift(id);
        return success(BeanUtils.toBean(planShift, MesCalPlanShiftRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get plan shift page.")
    @PreAuthorize("@ss.hasPermission('mes:cal-plan:query')")
    public CommonResult<PageResult<MesCalPlanShiftRespVO>> getPlanShiftPage(@Valid MesCalPlanShiftPageReqVO pageReqVO) {
        PageResult<MesCalPlanShiftDO> pageResult = planShiftService.getPlanShiftPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesCalPlanShiftRespVO.class));
    }

    @GetMapping("/list-by-plan")
    @Operation(summary = "Get specified schedule plan shift list.")
    @Parameter(name = "planId", description = "Schedule plan code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:cal-plan:query')")
    public CommonResult<List<MesCalPlanShiftRespVO>> getPlanShiftListByPlan(@RequestParam("planId") Long planId) {
        List<MesCalPlanShiftDO> list = planShiftService.getPlanShiftListByPlanId(planId);
        return success(BeanUtils.toBean(list, MesCalPlanShiftRespVO.class));
    }

}

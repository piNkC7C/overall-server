package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo.MesDvCheckRecordPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo.MesDvCheckRecordRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo.MesDvCheckRecordSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.checkplan.MesDvCheckPlanDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.checkrecord.MesDvCheckRecordDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.machinery.MesDvMachineryDO;
import cn.iocoder.yudao.module.mes.service.dv.checkplan.MesDvCheckPlanService;
import cn.iocoder.yudao.module.mes.service.dv.checkrecord.MesDvCheckRecordService;
import cn.iocoder.yudao.module.mes.service.dv.machinery.MesDvMachineryService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - MES device inspection record.")
@RestController
@RequestMapping("/mes/dv/check-record")
@Validated
public class MesDvCheckRecordController {

    @Resource
    private MesDvCheckRecordService checkRecordService;
    @Resource
    private MesDvCheckPlanService checkPlanService;
    @Resource
    private MesDvMachineryService machineryService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Createdevice inspection record.")
    @PreAuthorize("@ss.hasPermission('mes:dv-check-record:create')")
    public CommonResult<Long> createCheckRecord(@Valid @RequestBody MesDvCheckRecordSaveReqVO createReqVO) {
        return success(checkRecordService.createCheckRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatedevice inspection record.")
    @PreAuthorize("@ss.hasPermission('mes:dv-check-record:update')")
    public CommonResult<Boolean> updateCheckRecord(@Valid @RequestBody MesDvCheckRecordSaveReqVO updateReqVO) {
        checkRecordService.updateCheckRecord(updateReqVO);
        return success(true);
    }

    @PutMapping("/submit")
    @Operation(summary = "Submit device inspection record ( draft →completed).")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-check-record:update')")
    public CommonResult<Boolean> submitCheckRecord(@RequestParam("id") Long id) {
        checkRecordService.submitCheckRecord(id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletedevice inspection record.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-check-record:delete')")
    public CommonResult<Boolean> deleteCheckRecord(@RequestParam("id") Long id) {
        checkRecordService.deleteCheckRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get device inspection record.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:dv-check-record:query')")
    public CommonResult<MesDvCheckRecordRespVO> getCheckRecord(@RequestParam("id") Long id) {
        MesDvCheckRecordDO checkRecord = checkRecordService.getCheckRecord(id);
        if (checkRecord == null) {
            return success(null);
        }
        return success(buildCheckRecordRespVOList(Collections.singletonList(checkRecord)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get device inspection record page.")
    @PreAuthorize("@ss.hasPermission('mes:dv-check-record:query')")
    public CommonResult<PageResult<MesDvCheckRecordRespVO>> getCheckRecordPage(@Valid MesDvCheckRecordPageReqVO pageReqVO) {
        PageResult<MesDvCheckRecordDO> pageResult = checkRecordService.getCheckRecordPage(pageReqVO);
        return success(new PageResult<>(buildCheckRecordRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportdevice inspection record Excel.")
    @PreAuthorize("@ss.hasPermission('mes:dv-check-record:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCheckRecordExcel(@Valid MesDvCheckRecordPageReqVO pageReqVO,
                                       HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesDvCheckRecordDO> list = checkRecordService.getCheckRecordPage(pageReqVO).getList();
        ExcelUtils.write(response, "Equipment Inspection Records.xls", "Data", MesDvCheckRecordRespVO.class,
                buildCheckRecordRespVOList(list));
    }

    // ==================== 拼接 VO ====================

    @SuppressWarnings("DuplicatedCode")
    private List<MesDvCheckRecordRespVO> buildCheckRecordRespVOList(List<MesDvCheckRecordDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. batch get relation data
        Map<Long, MesDvCheckPlanDO> planMap = checkPlanService.getCheckPlanMap(
                convertSet(list, MesDvCheckRecordDO::getPlanId));
        Map<Long, MesDvMachineryDO> machineryMap = machineryService.getMachineryMap(
                convertSet(list, MesDvCheckRecordDO::getMachineryId));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(list, MesDvCheckRecordDO::getUserId));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesDvCheckRecordRespVO.class, vo -> {
            MapUtils.findAndThen(planMap, vo.getPlanId(),
                    plan -> vo.setPlanName(plan.getName()).setPlanCode(plan.getCode())
                            .setPlanStartDate(plan.getStartDate()).setPlanEndDate(plan.getEndDate())
                            .setPlanCycleType(plan.getCycleType()).setPlanCycleCount(plan.getCycleCount()));
            MapUtils.findAndThen(machineryMap, vo.getMachineryId(), machinery -> vo
                    .setMachineryCode(machinery.getCode()).setMachineryName(machinery.getName())
                    .setMachineryBrand(machinery.getBrand()).setMachinerySpecification(machinery.getSpecification()));
            MapUtils.findAndThen(userMap, vo.getUserId(),
                    user -> vo.setNickname(user.getNickname()));
        });
    }

}

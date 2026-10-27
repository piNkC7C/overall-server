package cn.iocoder.yudao.module.mes.controller.admin.dv.repair;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.MesDvRepairPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.MesDvRepairRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.MesDvRepairSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.machinery.MesDvMachineryDO;
import cn.iocoder.yudao.module.mes.dal.dataobject.dv.repair.MesDvRepairDO;
import cn.iocoder.yudao.module.mes.service.dv.machinery.MesDvMachineryService;
import cn.iocoder.yudao.module.mes.service.dv.repair.MesDvRepairService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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
import java.util.stream.Stream;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSetByFlatMap;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - MES repair work order.")
@RestController
@RequestMapping("/mes/dv/repair")
@Validated
public class MesDvRepairController {

    @Resource
    private MesDvRepairService repairService;
    @Resource
    private MesDvMachineryService machineryService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create repair work order.")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:create')")
    public CommonResult<Long> createRepair(@Valid @RequestBody MesDvRepairSaveReqVO createReqVO) {
        return success(repairService.createRepair(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update repair work order.")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:update')")
    public CommonResult<Boolean> updateRepair(@Valid @RequestBody MesDvRepairSaveReqVO updateReqVO) {
        repairService.updateRepair(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete repair work order.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:delete')")
    public CommonResult<Boolean> deleteRepair(@RequestParam("id") Long id) {
        repairService.deleteRepair(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get repair work order.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:query')")
    public CommonResult<MesDvRepairRespVO> getRepair(@RequestParam("id") Long id) {
        MesDvRepairDO repair = repairService.getRepair(id);
        if (repair == null) {
            return success(null);
        }
        return success(buildRepairRespVOList(Collections.singletonList(repair)).get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get repair work order page.")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:query')")
    public CommonResult<PageResult<MesDvRepairRespVO>> getRepairPage(@Valid MesDvRepairPageReqVO pageReqVO) {
        PageResult<MesDvRepairDO> pageResult = repairService.getRepairPage(pageReqVO);
        return success(new PageResult<>(buildRepairRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export repair work order Excel.")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRepairExcel(@Valid MesDvRepairPageReqVO pageReqVO,
                                   HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesDvRepairDO> list = repairService.getRepairPage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Maintenance Work Orders.xls", "Data", MesDvRepairRespVO.class,
                buildRepairRespVOList(list));
    }

    // DONE @AI：submit=>confirm=>finish（然后里面有是 resultstatus 这样的字段【对齐实体？】）

    @PutMapping("/submit")
    @Operation(summary = "Submit repair work order ( draft →maintenance ).")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:update')")
    public CommonResult<Boolean> submitRepair(@RequestParam("id") Long id) {
        repairService.submitRepair(id, getLoginUserId());
        return success(true);
    }

    @PutMapping("/confirm")
    @Operation(summary = "Confirm maintenancecomplete (maintenance → pending acceptance ).")
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:update')")
    public CommonResult<Boolean> confirmRepair(@Valid @RequestBody cn.iocoder.yudao.module.mes.controller.admin.dv.repair.vo.MesDvRepairConfirmReqVO confirmReqVO) {
        repairService.confirmRepair(confirmReqVO);
        return success(true);
    }

    @PutMapping("/finish")
    @Operation(summary = "Complete accept ( pending acceptance → already confirm ).")
    @Parameters({
            @Parameter(name = "id", description = "Code.", required = true),
            @Parameter(name = "result", description = "Accept result.", required = true)
    })
    @PreAuthorize("@ss.hasPermission('mes:dv-repair:update')")
    public CommonResult<Boolean> finishRepair(@RequestParam("id") Long id,
                                              @RequestParam("result") Integer result) {
        repairService.finishRepair(id, result, getLoginUserId());
        return success(true);
    }

    // ==================== 拼接 VO ====================

    private List<MesDvRepairRespVO> buildRepairRespVOList(List<MesDvRepairDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1.1 batch get relation data
        Map<Long, MesDvMachineryDO> machineryMap = machineryService.getMachineryMap(
                convertSet(list, MesDvRepairDO::getMachineryId));
        // 1.2 收集所有用户 ID（维修人 + 验收人）
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(convertSetByFlatMap(list,
                repair -> Stream.of(repair.getAcceptedUserId(), repair.getConfirmUserId())));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesDvRepairRespVO.class, vo -> {
            MapUtils.findAndThen(machineryMap, vo.getMachineryId(), machinery -> vo
                    .setMachineryCode(machinery.getCode()).setMachineryName(machinery.getName())
                    .setMachineryBrand(machinery.getBrand()).setMachinerySpecification(machinery.getSpecification()));
            MapUtils.findAndThen(userMap, vo.getAcceptedUserId(),
                    user -> vo.setAcceptedUserNickname(user.getNickname()));
            MapUtils.findAndThen(userMap, vo.getConfirmUserId(),
                    user -> vo.setConfirmUserNickname(user.getNickname()));
        });
    }

}

package cn.iocoder.yudao.module.mes.controller.admin.md.workstation;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.workshop.MesMdWorkshopPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.workshop.MesMdWorkshopRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.workstation.vo.workshop.MesMdWorkshopSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.workstation.MesMdWorkshopDO;
import cn.iocoder.yudao.module.mes.service.md.workstation.MesMdWorkshopService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.*;

@Tag(name = "Admin - MES workshop.")
@RestController
@RequestMapping("/mes/md-workshop")
@Validated
public class MesMdWorkshopController {

    @Resource
    private MesMdWorkshopService workshopService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create workshop.")
    @PreAuthorize("@ss.hasPermission('mes:md-workshop:create')")
    public CommonResult<Long> createWorkshop(@Valid @RequestBody MesMdWorkshopSaveReqVO createReqVO) {
        return success(workshopService.createWorkshop(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update workshop.")
    @PreAuthorize("@ss.hasPermission('mes:md-workshop:update')")
    public CommonResult<Boolean> updateWorkshop(@Valid @RequestBody MesMdWorkshopSaveReqVO updateReqVO) {
        workshopService.updateWorkshop(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete workshop.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:md-workshop:delete')")
    public CommonResult<Boolean> deleteWorkshop(@RequestParam("id") Long id) {
        workshopService.deleteWorkshop(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get workshop.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:md-workshop:query')")
    public CommonResult<MesMdWorkshopRespVO> getWorkshop(@RequestParam("id") Long id) {
        MesMdWorkshopDO workshop = workshopService.getWorkshop(id);
        if (workshop == null) {
            return success(null);
        }
        List<MesMdWorkshopRespVO> voList = buildWorkshopRespVOList(Collections.singletonList(workshop));
        return success(voList.get(0));
    }

    @GetMapping("/page")
    @Operation(summary = "Get workshop page.")
    @PreAuthorize("@ss.hasPermission('mes:md-workshop:query')")
    public CommonResult<PageResult<MesMdWorkshopRespVO>> getWorkshopPage(@Valid MesMdWorkshopPageReqVO pageReqVO) {
        PageResult<MesMdWorkshopDO> pageResult = workshopService.getWorkshopPage(pageReqVO);
        return success(new PageResult<>(buildWorkshopRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get workshop simple list.", description = "Only enabled workshop. Used for dropdowns.")
    public CommonResult<List<MesMdWorkshopRespVO>> getWorkshopSimpleList() {
        List<MesMdWorkshopDO> list = workshopService.getWorkshopListByStatus(CommonStatusEnum.ENABLE.getStatus());
        if (CollUtil.isEmpty(list)) {
            return success(Collections.emptyList());
        }
        // Batch get owner person info
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(list, MesMdWorkshopDO::getChargeUserId));
        return success(convertList(list, ws -> {
            MesMdWorkshopRespVO vo = new MesMdWorkshopRespVO()
                    .setId(ws.getId()).setCode(ws.getCode()).setName(ws.getName()).setArea(ws.getArea());
            MapUtils.findAndThen(userMap, ws.getChargeUserId(),
                    user -> vo.setChargeUserName(user.getNickname()));
            return vo;
        }));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export workshop Excel.")
    @PreAuthorize("@ss.hasPermission('mes:md-workshop:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportWorkshopExcel(@Valid MesMdWorkshopPageReqVO pageReqVO,
                                     HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesMdWorkshopDO> list = workshopService.getWorkshopPage(pageReqVO).getList();
        List<MesMdWorkshopRespVO> voList = buildWorkshopRespVOList(list);
        ExcelUtils.write(response, "Workshops.xls", "Data", MesMdWorkshopRespVO.class, voList);
    }

    // ==================== 拼接 VO ====================

    private List<MesMdWorkshopRespVO> buildWorkshopRespVOList(List<MesMdWorkshopDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. batch get owner person info
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(list, MesMdWorkshopDO::getChargeUserId));
        // 2. 拼接 VO
        return BeanUtils.toBean(list, MesMdWorkshopRespVO.class, vo -> {
            MapUtils.findAndThen(userMap, vo.getChargeUserId(),
                    user -> vo.setChargeUserName(user.getNickname()));
        });
    }

}

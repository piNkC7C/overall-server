package cn.iocoder.yudao.module.mes.controller.admin.pro.route;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.MesProRoutePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.MesProRouteRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.MesProRouteSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.pro.route.MesProRouteDO;
import cn.iocoder.yudao.module.mes.service.pro.route.MesProRouteService;
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
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - MES routing path.")
@RestController
@RequestMapping("/mes/pro/route")
@Validated
public class MesProRouteController {

    @Resource
    private MesProRouteService routeService;

    @PostMapping("/create")
    @Operation(summary = "Createrouting path.")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:create')")
    public CommonResult<Long> createRoute(@Valid @RequestBody MesProRouteSaveReqVO createReqVO) {
        return success(routeService.createRoute(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updaterouting path.")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:update')")
    public CommonResult<Boolean> updateRoute(@Valid @RequestBody MesProRouteSaveReqVO updateReqVO) {
        routeService.updateRoute(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-status")
    @Operation(summary = "Updaterouting path status.")
    @Parameters({
            @Parameter(name = "id", description = "Code.", required = true),
            @Parameter(name = "status", description = "Status.", required = true)
    })
    @PreAuthorize("@ss.hasPermission('mes:pro-route:update')")
    public CommonResult<Boolean> updateRouteStatus(@RequestParam("id") Long id,
                                                    @RequestParam("status") Integer status) {
        routeService.updateRouteStatus(id, status);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleterouting path.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:pro-route:delete')")
    public CommonResult<Boolean> deleteRoute(@RequestParam("id") Long id) {
        routeService.deleteRoute(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get routing path.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:query')")
    public CommonResult<MesProRouteRespVO> getRoute(@RequestParam("id") Long id) {
        MesProRouteDO route = routeService.getRoute(id);
        return success(BeanUtils.toBean(route, MesProRouteRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get routing path page.")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:query')")
    public CommonResult<PageResult<MesProRouteRespVO>> getRoutePage(@Valid MesProRoutePageReqVO pageReqVO) {
        PageResult<MesProRouteDO> pageResult = routeService.getRoutePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesProRouteRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get routing path simple list.", description = "Only enabled routing path. Used for dropdowns.")
    public CommonResult<List<MesProRouteRespVO>> getRouteSimpleList() {
        List<MesProRouteDO> list = routeService.getRouteListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, route -> new MesProRouteRespVO()
                .setId(route.getId()).setName(route.getName()).setCode(route.getCode())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Exportrouting path Excel.")
    @PreAuthorize("@ss.hasPermission('mes:pro-route:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRouteExcel(@Valid MesProRoutePageReqVO pageReqVO,
                                  HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesProRouteDO> list = routeService.getRoutePage(pageReqVO).getList();
        List<MesProRouteRespVO> data = BeanUtils.toBean(list, MesProRouteRespVO.class);
        ExcelUtils.write(response, "Process Routes.xls", "Data", MesProRouteRespVO.class, data);
    }

}

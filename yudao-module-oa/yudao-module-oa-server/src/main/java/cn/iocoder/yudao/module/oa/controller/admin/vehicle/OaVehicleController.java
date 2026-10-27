package cn.iocoder.yudao.module.oa.controller.admin.vehicle;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.oa.controller.admin.vehicle.vo.*;
import cn.iocoder.yudao.module.oa.dal.dataobject.vehicle.OaVehicleDO;
import cn.iocoder.yudao.module.oa.service.vehicle.OaVehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import cn.iocoder.yudao.module.system.api.dept.DeptApi;
import cn.iocoder.yudao.module.system.api.dept.dto.DeptRespDTO;
import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import java.util.*;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.*;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - Vehicle.")
@RestController
@RequestMapping("/oa/vehicle")
@Validated
public class OaVehicleController {

    @Resource
    private DeptApi deptApi;

    @Resource
    private OaVehicleService vehicleService;

    @PostMapping("/create")
    @Operation(summary = "CreateVehicle.")
    @PreAuthorize("@ss.hasPermission('oa:vehicle:create')")
    public CommonResult<Long> createVehicle(@Valid @RequestBody OaVehicleSaveReqVO createReqVO) {
        return success(vehicleService.createVehicle(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateVehicle.")
    @PreAuthorize("@ss.hasPermission('oa:vehicle:update')")
    public CommonResult<Boolean> updateVehicle(@Valid @RequestBody OaVehicleSaveReqVO updateReqVO) {
        vehicleService.updateVehicle(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteVehicle.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('oa:vehicle:delete')")
    public CommonResult<Boolean> deleteVehicle(@RequestParam("id") Long id) {
        vehicleService.deleteVehicle(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get Vehicle.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('oa:vehicle:query')")
    public CommonResult<OaVehicleRespVO> getVehicle(@RequestParam("id") Long id) {
        OaVehicleDO vehicle = vehicleService.validateVehicleExists(id);
        return success(buildVehicleRespVO(vehicle));
    }

    @GetMapping("/page")
    @Operation(summary = "Get Vehicle page.")
    @PreAuthorize("@ss.hasPermission('oa:vehicle:query')")
    public CommonResult<PageResult<OaVehicleRespVO>> getVehiclePage(@Valid OaVehiclePageReqVO pageReqVO) {
        PageResult<OaVehicleDO> pageResult = vehicleService.getVehiclePage(pageReqVO);
        return success(new PageResult<>(buildVehicleRespVOList(pageResult.getList()), pageResult.getTotal()));
    }

    // ==================== 拼接 VO ====================

    /**
     * 拼接车辆详情
     *
     * @param vehicle 车辆
     * @return 车辆响应
     */
    private OaVehicleRespVO buildVehicleRespVO(OaVehicleDO vehicle) {
        if (vehicle == null) {
            return null;
        }
        return CollUtil.getFirst(buildVehicleRespVOList(Collections.singletonList(vehicle)));
    }

    /**
     * 构建车辆响应列表，批量拼接所属部门名称
     *
     * @param vehicles 车辆列表
     * @return 车辆响应列表
     */
    private List<OaVehicleRespVO> buildVehicleRespVOList(List<OaVehicleDO> vehicles) {
        if (CollUtil.isEmpty(vehicles)) {
            return Collections.emptyList();
        }
        // 1. batch search department
        Map<Long, DeptRespDTO> deptMap = deptApi.getDeptMap(convertSet(vehicles, OaVehicleDO::getDeptId));
        // 2. 转换并拼接部门名称
        return convertList(vehicles, vehicle -> {
            OaVehicleRespVO respVO = BeanUtils.toBean(vehicle, OaVehicleRespVO.class);
            MapUtils.findAndThen(deptMap, vehicle.getDeptId(), dept -> respVO.setDeptName(dept.getName()));
            return respVO;
        });
    }

}

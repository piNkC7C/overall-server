package cn.iocoder.yudao.module.iot.controller.admin.device;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.iot.controller.admin.device.vo.group.IotDeviceGroupPageReqVO;
import cn.iocoder.yudao.module.iot.controller.admin.device.vo.group.IotDeviceGroupRespVO;
import cn.iocoder.yudao.module.iot.controller.admin.device.vo.group.IotDeviceGroupSaveReqVO;
import cn.iocoder.yudao.module.iot.dal.dataobject.device.IotDeviceGroupDO;
import cn.iocoder.yudao.module.iot.service.device.IotDeviceGroupService;
import cn.iocoder.yudao.module.iot.service.device.IotDeviceService;
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
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - IoT device group.")
@RestController
@RequestMapping("/iot/device-group")
@Validated
public class IotDeviceGroupController {

    @Resource
    private IotDeviceGroupService deviceGroupService;
    @Resource
    private IotDeviceService deviceService;

    @PostMapping("/create")
    @Operation(summary = "Createdevice group.")
    @PreAuthorize("@ss.hasPermission('iot:device-group:create')")
    public CommonResult<Long> createDeviceGroup(@Valid @RequestBody IotDeviceGroupSaveReqVO createReqVO) {
        return success(deviceGroupService.createDeviceGroup(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatedevice group.")
    @PreAuthorize("@ss.hasPermission('iot:device-group:update')")
    public CommonResult<Boolean> updateDeviceGroup(@Valid @RequestBody IotDeviceGroupSaveReqVO updateReqVO) {
        deviceGroupService.updateDeviceGroup(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletedevice group.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('iot:device-group:delete')")
    public CommonResult<Boolean> deleteDeviceGroup(@RequestParam("id") Long id) {
        deviceGroupService.deleteDeviceGroup(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get device group.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('iot:device-group:query')")
    public CommonResult<IotDeviceGroupRespVO> getDeviceGroup(@RequestParam("id") Long id) {
        IotDeviceGroupDO deviceGroup = deviceGroupService.getDeviceGroup(id);
        return success(BeanUtils.toBean(deviceGroup, IotDeviceGroupRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get device group page.")
    @PreAuthorize("@ss.hasPermission('iot:device-group:query')")
    public CommonResult<PageResult<IotDeviceGroupRespVO>> getDeviceGroupPage(@Valid IotDeviceGroupPageReqVO pageReqVO) {
        PageResult<IotDeviceGroupDO> pageResult = deviceGroupService.getDeviceGroupPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IotDeviceGroupRespVO.class,
                group -> group.setDeviceCount(deviceService.getDeviceCountByGroupId(group.getId()))));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get device group simple info list.", description = "Only enabled group. Used for dropdowns.")
    public CommonResult<List<IotDeviceGroupRespVO>> getSimpleDeviceGroupList() {
        List<IotDeviceGroupDO> list = deviceGroupService.getDeviceGroupListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, group -> // 只返回 id、name 字段
                new IotDeviceGroupRespVO().setId(group.getId()).setName(group.getName())));
    }

}
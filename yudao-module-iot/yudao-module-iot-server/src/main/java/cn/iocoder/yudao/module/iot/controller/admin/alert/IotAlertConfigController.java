package cn.iocoder.yudao.module.iot.controller.admin.alert;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.iot.controller.admin.alert.vo.config.IotAlertConfigPageReqVO;
import cn.iocoder.yudao.module.iot.controller.admin.alert.vo.config.IotAlertConfigRespVO;
import cn.iocoder.yudao.module.iot.controller.admin.alert.vo.config.IotAlertConfigSaveReqVO;
import cn.iocoder.yudao.module.iot.dal.dataobject.alert.IotAlertConfigDO;
import cn.iocoder.yudao.module.iot.service.alert.IotAlertConfigService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSetByFlatMap;

@Tag(name = "Admin - IoT alert setting.")
@RestController
@RequestMapping("/iot/alert-config")
@Validated
public class IotAlertConfigController {

    @Resource
    private IotAlertConfigService alertConfigService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create alert setting.")
    @PreAuthorize("@ss.hasPermission('iot:alert-config:create')")
    public CommonResult<Long> createAlertConfig(@Valid @RequestBody IotAlertConfigSaveReqVO createReqVO) {
        return success(alertConfigService.createAlertConfig(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update alert setting.")
    @PreAuthorize("@ss.hasPermission('iot:alert-config:update')")
    public CommonResult<Boolean> updateAlertConfig(@Valid @RequestBody IotAlertConfigSaveReqVO updateReqVO) {
        alertConfigService.updateAlertConfig(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete alert setting.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('iot:alert-config:delete')")
    public CommonResult<Boolean> deleteAlertConfig(@RequestParam("id") Long id) {
        alertConfigService.deleteAlertConfig(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get alert setting.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('iot:alert-config:query')")
    public CommonResult<IotAlertConfigRespVO> getAlertConfig(@RequestParam("id") Long id) {
        IotAlertConfigDO alertConfig = alertConfigService.getAlertConfig(id);
        return success(BeanUtils.toBean(alertConfig, IotAlertConfigRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get alert setting page.")
    @PreAuthorize("@ss.hasPermission('iot:alert-config:query')")
    public CommonResult<PageResult<IotAlertConfigRespVO>> getAlertConfigPage(@Valid IotAlertConfigPageReqVO pageReqVO) {
        PageResult<IotAlertConfigDO> pageResult = alertConfigService.getAlertConfigPage(pageReqVO);

        // 转换返回
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSetByFlatMap(pageResult.getList(), config -> config.getReceiveUserIds().stream()));
        return success(BeanUtils.toBean(pageResult, IotAlertConfigRespVO.class, vo -> {
            vo.setReceiveUserNames(vo.getReceiveUserIds().stream()
                    .map(userMap::get)
                    .filter(Objects::nonNull)
                    .map(AdminUserRespDTO::getNickname)
                    .collect(Collectors.toList()));
        }));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get a simple alarm-setting list.", description = "Only enabled alert setting. Used for dropdowns.")
    @PreAuthorize("@ss.hasPermission('iot:alert-config:query')")
    public CommonResult<List<IotAlertConfigRespVO>> getAlertConfigSimpleList() {
        List<IotAlertConfigDO> list = alertConfigService.getAlertConfigListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, config -> // 只返回 id、name 字段
                new IotAlertConfigRespVO().setId(config.getId()).setName(config.getName())));
    }

}
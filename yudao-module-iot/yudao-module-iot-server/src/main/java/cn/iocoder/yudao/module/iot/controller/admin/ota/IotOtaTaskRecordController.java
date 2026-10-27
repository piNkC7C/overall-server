package cn.iocoder.yudao.module.iot.controller.admin.ota;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.iot.controller.admin.ota.vo.task.record.IotOtaTaskRecordPageReqVO;
import cn.iocoder.yudao.module.iot.controller.admin.ota.vo.task.record.IotOtaTaskRecordRespVO;
import cn.iocoder.yudao.module.iot.dal.dataobject.device.IotDeviceDO;
import cn.iocoder.yudao.module.iot.dal.dataobject.ota.IotOtaFirmwareDO;
import cn.iocoder.yudao.module.iot.dal.dataobject.ota.IotOtaTaskRecordDO;
import cn.iocoder.yudao.module.iot.service.device.IotDeviceService;
import cn.iocoder.yudao.module.iot.service.ota.IotOtaFirmwareService;
import cn.iocoder.yudao.module.iot.service.ota.IotOtaTaskRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;

@Tag(name = "Admin - IoT OTA upgrade job record.")
@RestController
@RequestMapping("/iot/ota/task/record")
@Validated
public class IotOtaTaskRecordController {

    @Resource
    private IotOtaTaskRecordService otaTaskRecordService;
    @Resource
    private IotDeviceService deviceService;
    @Resource
    private IotOtaFirmwareService otaFirmwareService;

    @GetMapping("/get-status-statistics")
    @Operation(summary = "Get OTA upgrade record statusStats.")
    @Parameters({
        @Parameter(name = "firmwareId", description = "Firmware code.", example = "1024"),
        @Parameter(name = "taskId", description = "Upgrade job code.", example = "2048")
    })
    @PreAuthorize("@ss.hasPermission('iot:ota-task-record:query')")
    public CommonResult<Map<Integer, Long>> getOtaTaskRecordStatusStatistics(
            @RequestParam(value = "firmwareId", required = false) Long firmwareId,
            @RequestParam(value = "taskId", required = false) Long taskId) {
        return success(otaTaskRecordService.getOtaTaskRecordStatusStatistics(firmwareId, taskId));
    }

    @GetMapping("/page")
    @Operation(summary = "Get OTA upgrade record page.")
    @PreAuthorize("@ss.hasPermission('iot:ota-task-record:query')")
    public CommonResult<PageResult<IotOtaTaskRecordRespVO>> getOtaTaskRecordPage(
            @Valid IotOtaTaskRecordPageReqVO pageReqVO) {
        PageResult<IotOtaTaskRecordDO> pageResult = otaTaskRecordService.getOtaTaskRecordPage(pageReqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }

         // Batch search firmware info
         Map<Long, IotOtaFirmwareDO> firmwareMap = otaFirmwareService.getOtaFirmwareMap(
            convertSet(pageResult.getList(), IotOtaTaskRecordDO::getFromFirmwareId));
        Map<Long, IotDeviceDO> deviceMap = deviceService.getDeviceMap(
            convertSet(pageResult.getList(), IotOtaTaskRecordDO::getDeviceId));
        // 转换为响应 VO
        return success(BeanUtils.toBean(pageResult, IotOtaTaskRecordRespVO.class, (vo) -> {
            MapUtils.findAndThen(firmwareMap, vo.getFromFirmwareId(), firmware ->
                vo.setFromFirmwareVersion(firmware.getVersion()));
            MapUtils.findAndThen(deviceMap, vo.getDeviceId(), device ->
                vo.setDeviceName(device.getDeviceName()));
        }));
    }

    @GetMapping("/get")
    @Operation(summary = "Get OTA upgrade record.")
    @PreAuthorize("@ss.hasPermission('iot:ota-task-record:query')")
    @Parameter(name = "id", description = "Upgrade record code.", required = true, example = "1024")
    public CommonResult<IotOtaTaskRecordRespVO> getOtaTaskRecord(@RequestParam("id") Long id) {
        IotOtaTaskRecordDO upgradeRecord = otaTaskRecordService.getOtaTaskRecord(id);
        return success(BeanUtils.toBean(upgradeRecord, IotOtaTaskRecordRespVO.class));
    }

    @PutMapping("/cancel")
    @Operation(summary = "Cancel OTA upgrade record.")
    @PreAuthorize("@ss.hasPermission('iot:ota-task-record:cancel')")
    @Parameter(name = "id", description = "Upgrade record code.", required = true, example = "1024")
    public CommonResult<Boolean> cancelOtaTaskRecord(@RequestParam("id") Long id) {
        otaTaskRecordService.cancelOtaTaskRecord(id);
        return success(true);
    }

}

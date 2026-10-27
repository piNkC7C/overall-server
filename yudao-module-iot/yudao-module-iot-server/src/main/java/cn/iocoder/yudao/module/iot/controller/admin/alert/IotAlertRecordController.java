package cn.iocoder.yudao.module.iot.controller.admin.alert;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.iot.controller.admin.alert.vo.recrod.IotAlertRecordPageReqVO;
import cn.iocoder.yudao.module.iot.controller.admin.alert.vo.recrod.IotAlertRecordProcessReqVO;
import cn.iocoder.yudao.module.iot.controller.admin.alert.vo.recrod.IotAlertRecordRespVO;
import cn.iocoder.yudao.module.iot.dal.dataobject.alert.IotAlertRecordDO;
import cn.iocoder.yudao.module.iot.service.alert.IotAlertRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static java.util.Collections.singleton;

@Tag(name = "Admin - IoT alert record.")
@RestController
@RequestMapping("/iot/alert-record")
@Validated
public class IotAlertRecordController {

    @Resource
    private IotAlertRecordService alertRecordService;

    @GetMapping("/get")
    @Operation(summary = "Get alert record.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('iot:alert-record:query')")
    public CommonResult<IotAlertRecordRespVO> getAlertRecord(@RequestParam("id") Long id) {
        IotAlertRecordDO alertRecord = alertRecordService.getAlertRecord(id);
        return success(BeanUtils.toBean(alertRecord, IotAlertRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get alert record page.")
    @PreAuthorize("@ss.hasPermission('iot:alert-record:query')")
    public CommonResult<PageResult<IotAlertRecordRespVO>> getAlertRecordPage(@Valid IotAlertRecordPageReqVO pageReqVO) {
        PageResult<IotAlertRecordDO> pageResult = alertRecordService.getAlertRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IotAlertRecordRespVO.class));
    }

    @PutMapping("/process")
    @Operation(summary = "Process alert record.")
    @PreAuthorize("@ss.hasPermission('iot:alert-record:process')")
    public CommonResult<Boolean> processAlertRecord(@Valid @RequestBody IotAlertRecordProcessReqVO processReqVO) {
        alertRecordService.processAlertRecordList(singleton(processReqVO.getId()), processReqVO.getProcessRemark());
        return success(true);
    }

}
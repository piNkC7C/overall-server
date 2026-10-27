package cn.iocoder.yudao.module.iot.controller.admin.rule;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.sink.IotDataSinkPageReqVO;
import cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.sink.IotDataSinkRespVO;
import cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.sink.IotDataSinkSaveReqVO;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotDataSinkDO;
import cn.iocoder.yudao.module.iot.service.rule.data.IotDataSinkService;
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

@Tag(name = "Admin - IoT data flow destination.")
@RestController
@RequestMapping("/iot/data-sink")
@Validated
public class IotDataSinkController {

    @Resource
    private IotDataSinkService dataSinkService;

    @PostMapping("/create")
    @Operation(summary = "Create data destination.")
    @PreAuthorize("@ss.hasPermission('iot:data-sink:create')")
    public CommonResult<Long> createDataSink(@Valid @RequestBody IotDataSinkSaveReqVO createReqVO) {
        return success(dataSinkService.createDataSink(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update data destination.")
    @PreAuthorize("@ss.hasPermission('iot:data-sink:update')")
    public CommonResult<Boolean> updateDataSink(@Valid @RequestBody IotDataSinkSaveReqVO updateReqVO) {
        dataSinkService.updateDataSink(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete data destination.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('iot:data-sink:delete')")
    public CommonResult<Boolean> deleteDataSink(@RequestParam("id") Long id) {
        dataSinkService.deleteDataSink(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get data destination.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('iot:data-sink:query')")
    public CommonResult<IotDataSinkRespVO> getDataSink(@RequestParam("id") Long id) {
        IotDataSinkDO sink = dataSinkService.getDataSink(id);
        return success(BeanUtils.toBean(sink, IotDataSinkRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get data destination page.")
    @PreAuthorize("@ss.hasPermission('iot:data-sink:query')")
    public CommonResult<PageResult<IotDataSinkRespVO>> getDataSinkPage(@Valid IotDataSinkPageReqVO pageReqVO) {
        PageResult<IotDataSinkDO> pageResult = dataSinkService.getDataSinkPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IotDataSinkRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get data destination simple info list.", description = "Used by frontend select options.")
    public CommonResult<List<IotDataSinkRespVO>> getDataSinkSimpleList() {
        List<IotDataSinkDO> list = dataSinkService.getDataSinkListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, sink -> // 只返回 id、name 字段
                new IotDataSinkRespVO().setId(sink.getId()).setName(sink.getName())));
    }

}

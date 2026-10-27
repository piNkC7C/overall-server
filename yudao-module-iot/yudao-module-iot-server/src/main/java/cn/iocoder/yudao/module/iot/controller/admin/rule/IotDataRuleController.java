package cn.iocoder.yudao.module.iot.controller.admin.rule;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.rule.IotDataRulePageReqVO;
import cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.rule.IotDataRuleRespVO;
import cn.iocoder.yudao.module.iot.controller.admin.rule.vo.data.rule.IotDataRuleSaveReqVO;
import cn.iocoder.yudao.module.iot.dal.dataobject.rule.IotDataRuleDO;
import cn.iocoder.yudao.module.iot.service.rule.data.IotDataRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - IoT data flow rule.")
@RestController
@RequestMapping("/iot/data-rule")
@Validated
public class IotDataRuleController {

    @Resource
    private IotDataRuleService dataRuleService;

    @PostMapping("/create")
    @Operation(summary = "Create data flow rule.")
    @PreAuthorize("@ss.hasPermission('iot:data-rule:create')")
    public CommonResult<Long> createDataRule(@Valid @RequestBody IotDataRuleSaveReqVO createReqVO) {
        return success(dataRuleService.createDataRule(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update data flow rule.")
    @PreAuthorize("@ss.hasPermission('iot:data-rule:update')")
    public CommonResult<Boolean> updateDataRule(@Valid @RequestBody IotDataRuleSaveReqVO updateReqVO) {
        dataRuleService.updateDataRule(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete data flow rule.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('iot:data-rule:delete')")
    public CommonResult<Boolean> deleteDataRule(@RequestParam("id") Long id) {
        dataRuleService.deleteDataRule(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get data flow rule.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('iot:data-rule:query')")
    public CommonResult<IotDataRuleRespVO> getDataRule(@RequestParam("id") Long id) {
        IotDataRuleDO dataRule = dataRuleService.getDataRule(id);
        return success(BeanUtils.toBean(dataRule, IotDataRuleRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get data flow rule page.")
    @PreAuthorize("@ss.hasPermission('iot:data-rule:query')")
    public CommonResult<PageResult<IotDataRuleRespVO>> getDataRulePage(@Valid IotDataRulePageReqVO pageReqVO) {
        PageResult<IotDataRuleDO> pageResult = dataRuleService.getDataRulePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, IotDataRuleRespVO.class));
    }

}
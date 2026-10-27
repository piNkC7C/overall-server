package cn.iocoder.yudao.module.mes.controller.admin.md.autocode;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.rule.MesMdAutoCodeRulePageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.rule.MesMdAutoCodeRuleRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.rule.MesMdAutoCodeRuleSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.autocode.MesMdAutoCodeRuleDO;
import cn.iocoder.yudao.module.mes.service.md.autocode.MesMdAutoCodeRuleService;
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
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - MES coding rule.")
@RestController
@RequestMapping("/mes/md/auto-code-rule")
@Validated
public class MesMdAutoCodeRuleController {

    @Resource
    private MesMdAutoCodeRuleService ruleService;

    @PostMapping("/create")
    @Operation(summary = "Create coding rule.")
    @PreAuthorize("@ss.hasPermission('mes:auto-code-rule:create')")
    public CommonResult<Long> createAutoCodeRule(@Valid @RequestBody MesMdAutoCodeRuleSaveReqVO createReqVO) {
        return success(ruleService.createAutoCodeRule(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update coding rule.")
    @PreAuthorize("@ss.hasPermission('mes:auto-code-rule:update')")
    public CommonResult<Boolean> updateAutoCodeRule(@Valid @RequestBody MesMdAutoCodeRuleSaveReqVO updateReqVO) {
        ruleService.updateAutoCodeRule(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete coding rule.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:auto-code-rule:delete')")
    public CommonResult<Boolean> deleteAutoCodeRule(@RequestParam("id") Long id) {
        ruleService.deleteAutoCodeRule(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get coding rule.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:auto-code-rule:query')")
    public CommonResult<MesMdAutoCodeRuleRespVO> getAutoCodeRule(@RequestParam("id") Long id) {
        MesMdAutoCodeRuleDO rule = ruleService.getAutoCodeRule(id);
        return success(BeanUtils.toBean(rule, MesMdAutoCodeRuleRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get coding rule page.")
    @PreAuthorize("@ss.hasPermission('mes:auto-code-rule:query')")
    public CommonResult<PageResult<MesMdAutoCodeRuleRespVO>> getAutoCodeRulePage(@Valid MesMdAutoCodeRulePageReqVO pageReqVO) {
        PageResult<MesMdAutoCodeRuleDO> pageResult = ruleService.getAutoCodeRulePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MesMdAutoCodeRuleRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get coding rule simple list.", description = "Only enabled coding rule. Used for dropdowns.")
    public CommonResult<List<MesMdAutoCodeRuleRespVO>> getAutoCodeRuleSimpleList() {
        List<MesMdAutoCodeRuleDO> list = ruleService.getAutoCodeRuleListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, rule -> new MesMdAutoCodeRuleRespVO()
                .setId(rule.getId()).setName(rule.getName()).setCode(rule.getCode())));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "Export coding rule Excel.")
    @PreAuthorize("@ss.hasPermission('mes:auto-code-rule:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportAutoCodeRuleExcel(@Valid MesMdAutoCodeRulePageReqVO pageReqVO,
                                 HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MesMdAutoCodeRuleDO> list = ruleService.getAutoCodeRulePage(pageReqVO).getList();
        List<MesMdAutoCodeRuleRespVO> data = BeanUtils.toBean(list, MesMdAutoCodeRuleRespVO.class);
        ExcelUtils.write(response, "Coding Rules.xls", "Data", MesMdAutoCodeRuleRespVO.class, data);
    }

}

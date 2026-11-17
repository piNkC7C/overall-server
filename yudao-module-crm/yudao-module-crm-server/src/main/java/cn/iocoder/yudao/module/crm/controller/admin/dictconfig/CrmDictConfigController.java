package cn.iocoder.yudao.module.crm.controller.admin.dictconfig;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.crm.controller.admin.dictconfig.vo.CrmDictConfigRespVO;
import cn.iocoder.yudao.module.crm.controller.admin.dictconfig.vo.CrmDictConfigSaveReqVO;
import cn.iocoder.yudao.module.crm.service.dictconfig.CrmDictConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - CRM 字典枚举配置")
@RestController
@RequestMapping("/crm/dict-config")
@Validated
public class CrmDictConfigController {

    @Resource
    private CrmDictConfigService dictConfigService;

    @GetMapping("/follow-up-type/list")
    @Operation(summary = "获得跟进类型列表")
    @PreAuthorize("@ss.hasPermission('crm:dict-config:query')")
    public CommonResult<List<CrmDictConfigRespVO>> getFollowUpTypeList() {
        return success(dictConfigService.getFollowUpTypeList());
    }

    @PostMapping("/follow-up-type/create")
    @Operation(summary = "创建跟进类型")
    @PreAuthorize("@ss.hasPermission('crm:dict-config:create')")
    public CommonResult<Long> createFollowUpType(@Valid @RequestBody CrmDictConfigSaveReqVO createReqVO) {
        return success(dictConfigService.createFollowUpType(createReqVO));
    }

    @PutMapping("/follow-up-type/update")
    @Operation(summary = "更新跟进类型")
    @PreAuthorize("@ss.hasPermission('crm:dict-config:update')")
    public CommonResult<Boolean> updateFollowUpType(@Valid @RequestBody CrmDictConfigSaveReqVO updateReqVO) {
        dictConfigService.updateFollowUpType(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/follow-up-type/delete")
    @Operation(summary = "删除跟进类型")
    @Parameter(name = "id", description = "字典数据编号", required = true)
    @PreAuthorize("@ss.hasPermission('crm:dict-config:delete')")
    public CommonResult<Boolean> deleteFollowUpType(@RequestParam("id") Long id) {
        dictConfigService.deleteFollowUpType(id);
        return success(true);
    }

    @GetMapping("/clue-source/list")
    @Operation(summary = "获得线索来源列表")
    @PreAuthorize("@ss.hasPermission('crm:dict-config:query')")
    public CommonResult<List<CrmDictConfigRespVO>> getClueSourceList() {
        return success(dictConfigService.getClueSourceList());
    }

    @PostMapping("/clue-source/create")
    @Operation(summary = "创建线索来源")
    @PreAuthorize("@ss.hasPermission('crm:dict-config:create')")
    public CommonResult<Long> createClueSource(@Valid @RequestBody CrmDictConfigSaveReqVO createReqVO) {
        return success(dictConfigService.createClueSource(createReqVO));
    }

    @PutMapping("/clue-source/update")
    @Operation(summary = "更新线索来源")
    @PreAuthorize("@ss.hasPermission('crm:dict-config:update')")
    public CommonResult<Boolean> updateClueSource(@Valid @RequestBody CrmDictConfigSaveReqVO updateReqVO) {
        dictConfigService.updateClueSource(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/clue-source/delete")
    @Operation(summary = "删除线索来源")
    @Parameter(name = "id", description = "字典数据编号", required = true)
    @PreAuthorize("@ss.hasPermission('crm:dict-config:delete')")
    public CommonResult<Boolean> deleteClueSource(@RequestParam("id") Long id) {
        dictConfigService.deleteClueSource(id);
        return success(true);
    }

}

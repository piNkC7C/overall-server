package cn.iocoder.yudao.module.hrm.controller.admin.performance;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.number.NumberUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.resulttemplate.HrmPerformanceResultTemplatePageReqVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.resulttemplate.HrmPerformanceResultTemplateRespVO;
import cn.iocoder.yudao.module.hrm.controller.admin.performance.vo.resulttemplate.HrmPerformanceResultTemplateSaveReqVO;
import cn.iocoder.yudao.module.hrm.dal.dataobject.performance.config.HrmPerformanceResultTemplateDO;
import cn.iocoder.yudao.module.hrm.service.performance.config.HrmPerformanceResultTemplateService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@Tag(name = "Admin - HRM performance review resulttemplate.")
@RestController
@RequestMapping("/hrm/performance/result-template")
@Validated
public class HrmPerformanceResultTemplateController {

    @Resource
    private HrmPerformanceResultTemplateService resultTemplateService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Createperformance review resulttemplate.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:result-template:create')")
    public CommonResult<Long> createPerformanceResultTemplate(
            @Valid @RequestBody HrmPerformanceResultTemplateSaveReqVO createReqVO) {
        return success(resultTemplateService.createPerformanceResultTemplate(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updateperformance review resulttemplate.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:result-template:update')")
    public CommonResult<Boolean> updatePerformanceResultTemplate(
            @Valid @RequestBody HrmPerformanceResultTemplateSaveReqVO updateReqVO) {
        resultTemplateService.updatePerformanceResultTemplate(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deleteperformance review resulttemplate.")
    @Parameter(name = "id", description = "Template code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:result-template:delete')")
    public CommonResult<Boolean> deletePerformanceResultTemplate(@RequestParam("id") Long id) {
        resultTemplateService.deletePerformanceResultTemplate(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Operation(summary = "Batch deleteperformance review resulttemplate.")
    @Parameter(name = "ids", description = "Template code list.", required = true, example = "1024,1025")
    @PreAuthorize("@ss.hasPermission('hrm:performance:result-template:delete')")
    public CommonResult<Boolean> deletePerformanceResultTemplateList(@RequestParam("ids") List<Long> ids) {
        resultTemplateService.deletePerformanceResultTemplateList(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get performance review resulttemplate.")
    @Parameter(name = "id", description = "Template code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hrm:performance:result-template:query')")
    public CommonResult<HrmPerformanceResultTemplateRespVO> getPerformanceResultTemplate(
            @RequestParam("id") Long id) {
        // 1. get resulttemplate
        HrmPerformanceResultTemplateDO template = resultTemplateService.getPerformanceResultTemplate(id);
        // 2. 拼接数据
        return success(buildResultTemplateRespVO(template));
    }

    @GetMapping("/page")
    @Operation(summary = "Get performance review resulttemplate page.")
    @PreAuthorize("@ss.hasPermission('hrm:performance:result-template:query')")
    public CommonResult<PageResult<HrmPerformanceResultTemplateRespVO>> getPerformanceResultTemplatePage(
            @Validated HrmPerformanceResultTemplatePageReqVO pageReqVO) {
        PageResult<HrmPerformanceResultTemplateDO> pageResult =
                resultTemplateService.getPerformanceResultTemplatePage(pageReqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty(pageResult.getTotal()));
        }
        // 2. 拼接数据
        return success(new PageResult<>(buildResultTemplateRespVOList(pageResult.getList()),
                pageResult.getTotal()));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get performance review resulttemplate simple list.")
    @Parameter(name = "status", description = "Status.", example = "0")
    @PreAuthorize("@ss.hasPermission('hrm:performance:result-template:query')")
    public CommonResult<List<HrmPerformanceResultTemplateRespVO>> getPerformanceResultTemplateSimpleList(
            @RequestParam(value = "status", required = false) Integer status) {
        List<HrmPerformanceResultTemplateDO> templates =
                resultTemplateService.getPerformanceResultTemplateList(status);
        return success(BeanUtils.toBean(templates, HrmPerformanceResultTemplateRespVO.class));
    }

    // ==================== 拼接 VO ====================

    private HrmPerformanceResultTemplateRespVO buildResultTemplateRespVO(
            HrmPerformanceResultTemplateDO template) {
        if (template == null) {
            return null;
        }
        return CollUtil.getFirst(buildResultTemplateRespVOList(singletonList(template)));
    }

    private List<HrmPerformanceResultTemplateRespVO> buildResultTemplateRespVOList(
            List<HrmPerformanceResultTemplateDO> templates) {
        if (CollUtil.isEmpty(templates)) {
            return emptyList();
        }
        // 1. get creator info
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertSet(templates, template -> NumberUtils.parseLong(template.getCreator())));
        // 2. 拼接响应
        return BeanUtils.toBean(templates, HrmPerformanceResultTemplateRespVO.class, template ->
                MapUtils.findAndThen(userMap, NumberUtils.parseLong(template.getCreator()),
                        user -> template.setCreatorName(user.getNickname())));
    }

}

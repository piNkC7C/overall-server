package cn.iocoder.yudao.module.fms.controller.admin.config;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplate.FmsVoucherTemplateRespVO;
import cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplate.FmsVoucherTemplateSaveReqVO;
import cn.iocoder.yudao.module.fms.dal.dataobject.config.FmsVoucherTemplateCategoryDO;
import cn.iocoder.yudao.module.fms.dal.dataobject.config.FmsVoucherTemplateDO;
import cn.iocoder.yudao.module.fms.service.config.FmsAccountSetService;
import cn.iocoder.yudao.module.fms.service.config.FmsVoucherTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - FMS journal entrytemplate.")
@RestController
@RequestMapping("/fms/config/voucher-template")
@Validated
public class FmsVoucherTemplateController {

    @Resource
    private FmsVoucherTemplateService voucherTemplateService;
    @Resource
    private FmsAccountSetService accountSetService;

    @PostMapping("/create")
    @Operation(summary = "Createjournal entrytemplate.")
    @PreAuthorize("@ss.hasPermission('fms:config:voucher-template:create')")
    public CommonResult<Long> createVoucherTemplate(
            @Valid @RequestBody FmsVoucherTemplateSaveReqVO createReqVO) {
        return success(voucherTemplateService.createVoucherTemplate(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit journal entrytemplate.")
    @PreAuthorize("@ss.hasPermission('fms:config:voucher-template:update')")
    public CommonResult<Boolean> updateVoucherTemplate(
            @Valid @RequestBody FmsVoucherTemplateSaveReqVO updateReqVO) {
        voucherTemplateService.updateVoucherTemplate(updateReqVO, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletejournal entrytemplate.")
    @PreAuthorize("@ss.hasPermission('fms:config:voucher-template:delete')")
    public CommonResult<Boolean> deleteVoucherTemplate(@RequestParam("accountSetId") @NotNull Long accountSetId,
                                                       @RequestParam("id") @NotNull Long id) {
        voucherTemplateService.deleteVoucherTemplate(accountSetId, id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "Get journal entrytemplate list.")
    @PreAuthorize("@ss.hasPermission('fms:config:voucher-template:query')")
    public CommonResult<List<FmsVoucherTemplateRespVO>> getVoucherTemplateList(
            @RequestParam("accountSetId") @NotNull Long accountSetId) {
        accountSetService.validateAccountSetReadPermission(accountSetId, getLoginUserId());
        return success(buildVoucherTemplateRespVOList(accountSetId));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get journal entrytemplate simple list.", description = "Used to apply a journal template when entering journals.")
    public CommonResult<List<FmsVoucherTemplateRespVO>> getVoucherTemplateSimpleList(
            @RequestParam("accountSetId") @NotNull Long accountSetId) {
        accountSetService.validateAccountSetReadPermission(accountSetId, getLoginUserId());
        return success(buildVoucherTemplateRespVOList(accountSetId));
    }

    // ==================== 拼接 VO ====================

    private List<FmsVoucherTemplateRespVO> buildVoucherTemplateRespVOList(Long accountSetId) {
        Map<Long, FmsVoucherTemplateCategoryDO> categoryMap =
                voucherTemplateService.getTemplateCategoryMap(accountSetId);
        List<FmsVoucherTemplateDO> templates = voucherTemplateService.getVoucherTemplateList(accountSetId);
        return BeanUtils.toBean(templates, FmsVoucherTemplateRespVO.class, template -> {
            findAndThen(categoryMap, template.getCategoryId(),
                    category -> template.setCategoryName(category.getName()));
        });
    }

}

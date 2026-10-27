package cn.iocoder.yudao.module.fms.controller.admin.config;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplatecategory.FmsVoucherTemplateCategoryRespVO;
import cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplatecategory.FmsVoucherTemplateCategorySaveReqVO;
import cn.iocoder.yudao.module.fms.dal.dataobject.config.FmsVoucherTemplateCategoryDO;
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

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - FMS journal entrytemplatecategory.")
@RestController
@RequestMapping("/fms/config/voucher-template-category")
@Validated
public class FmsVoucherTemplateCategoryController {

    @Resource
    private FmsVoucherTemplateService voucherTemplateService;
    @Resource
    private FmsAccountSetService accountSetService;

    @PostMapping("/create")
    @Operation(summary = "Createjournal entrytemplatecategory.")
    @PreAuthorize("@ss.hasPermission('fms:config:voucher-template-category:create')")
    public CommonResult<Long> createTemplateCategory(
            @Valid @RequestBody FmsVoucherTemplateCategorySaveReqVO createReqVO) {
        return success(voucherTemplateService.createTemplateCategory(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit journal entrytemplatecategory.")
    @PreAuthorize("@ss.hasPermission('fms:config:voucher-template-category:update')")
    public CommonResult<Boolean> updateTemplateCategory(
            @Valid @RequestBody FmsVoucherTemplateCategorySaveReqVO updateReqVO) {
        voucherTemplateService.updateTemplateCategory(updateReqVO, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletejournal entrytemplatecategory.")
    @PreAuthorize("@ss.hasPermission('fms:config:voucher-template-category:delete')")
    public CommonResult<Boolean> deleteTemplateCategory(@RequestParam("accountSetId") @NotNull Long accountSetId,
                                                        @RequestParam("id") @NotNull Long id) {
        voucherTemplateService.deleteTemplateCategory(accountSetId, id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "Get journal entrytemplatecategory list.")
    @PreAuthorize("@ss.hasPermission('fms:config:voucher-template-category:query')")
    public CommonResult<List<FmsVoucherTemplateCategoryRespVO>> getTemplateCategoryList(
            @RequestParam("accountSetId") @NotNull Long accountSetId) {
        accountSetService.validateAccountSetReadPermission(accountSetId, getLoginUserId());
        List<FmsVoucherTemplateCategoryDO> categories = voucherTemplateService.getTemplateCategoryList(accountSetId);
        return success(BeanUtils.toBean(categories, FmsVoucherTemplateCategoryRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get journal entrytemplatecategory simple list.", description = "Used by frontend select options.")
    public CommonResult<List<FmsVoucherTemplateCategoryRespVO>> getTemplateCategorySimpleList(
            @RequestParam("accountSetId") @NotNull Long accountSetId) {
        accountSetService.validateAccountSetReadPermission(accountSetId, getLoginUserId());
        List<FmsVoucherTemplateCategoryDO> categories = voucherTemplateService.getTemplateCategoryList(accountSetId);
        return success(convertList(categories, category -> new FmsVoucherTemplateCategoryRespVO()
                .setId(category.getId()).setName(category.getName())));
    }

}

package cn.iocoder.yudao.module.trade.controller.admin.delivery;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.expresstemplate.*;
import cn.iocoder.yudao.module.trade.convert.delivery.DeliveryExpressTemplateConvert;
import cn.iocoder.yudao.module.trade.dal.dataobject.delivery.DeliveryExpressTemplateDO;
import cn.iocoder.yudao.module.trade.service.delivery.DeliveryExpressTemplateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - shipping-fee template.")
@RestController
@RequestMapping("/trade/delivery/express-template")
@Validated
public class DeliveryExpressTemplateController {

    @Resource
    private DeliveryExpressTemplateService deliveryExpressTemplateService;

    @PostMapping("/create")
    @Operation(summary = "Create shipping-fee template.")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express-template:create')")
    public CommonResult<Long> createDeliveryExpressTemplate(@Valid @RequestBody DeliveryExpressTemplateCreateReqVO createReqVO) {
        return success(deliveryExpressTemplateService.createDeliveryExpressTemplate(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update shipping-fee template.")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express-template:update')")
    public CommonResult<Boolean> updateDeliveryExpressTemplate(@Valid @RequestBody DeliveryExpressTemplateUpdateReqVO updateReqVO) {
        deliveryExpressTemplateService.updateDeliveryExpressTemplate(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete shipping-fee template.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('trade:delivery:express-template:delete')")
    public CommonResult<Boolean> deleteDeliveryExpressTemplate(@RequestParam("id") Long id) {
        deliveryExpressTemplateService.deleteDeliveryExpressTemplate(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get shipping-fee template.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express-template:query')")
    public CommonResult<DeliveryExpressTemplateDetailRespVO> getDeliveryExpressTemplate(@RequestParam("id") Long id) {
        return success(deliveryExpressTemplateService.getDeliveryExpressTemplate(id));
    }

    @GetMapping("/list")
    @Operation(summary = "Get shipping-fee template list.")
    @Parameter(name = "ids", description = "Code list.", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express-template:query')")
    public CommonResult<List<DeliveryExpressTemplateRespVO>> getDeliveryExpressTemplateList(@RequestParam("ids") Collection<Long> ids) {
        List<DeliveryExpressTemplateDO> list = deliveryExpressTemplateService.getDeliveryExpressTemplateList(ids);
        return success(DeliveryExpressTemplateConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/list-all-simple")
    @Operation(summary = "Get shipping template simple list.", description = "Used by frontend select options.")
    public CommonResult<List<DeliveryExpressTemplateSimpleRespVO>> getSimpleTemplateList() {
        // 获取运费模版列表，只要开启状态的
        List<DeliveryExpressTemplateDO> list = deliveryExpressTemplateService.getDeliveryExpressTemplateList();
        // 排序后，返回给前端
        return success(DeliveryExpressTemplateConvert.INSTANCE.convertList1(list));
    }

    @GetMapping("/page")
    @Operation(summary = "Get shipping-fee template page.")
    @PreAuthorize("@ss.hasPermission('trade:delivery:express-template:query')")
    public CommonResult<PageResult<DeliveryExpressTemplateRespVO>> getDeliveryExpressTemplatePage(@Valid DeliveryExpressTemplatePageReqVO pageVO) {
        PageResult<DeliveryExpressTemplateDO> pageResult = deliveryExpressTemplateService.getDeliveryExpressTemplatePage(pageVO);
        return success(DeliveryExpressTemplateConvert.INSTANCE.convertPage(pageResult));
    }

}

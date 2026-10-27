package cn.iocoder.yudao.module.mes.controller.admin.md.item;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sip.MesMdProductSipPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sip.MesMdProductSipRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sip.MesMdProductSipSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdProductSipDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdProductSipService;
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

@Tag(name = "Admin - MES productSIP.")
@RestController
@RequestMapping("/mes/md/product-sip")
@Validated
public class MesMdProductSipController {

    @Resource
    private MesMdProductSipService productSipService;

    @PostMapping("/create")
    @Operation(summary = "CreateproductSIP.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:create')")
    public CommonResult<Long> createProductSip(@Valid @RequestBody MesMdProductSipSaveReqVO createReqVO) {
        return success(productSipService.createProductSip(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateproductSIP.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:update')")
    public CommonResult<Boolean> updateProductSip(@Valid @RequestBody MesMdProductSipSaveReqVO updateReqVO) {
        productSipService.updateProductSip(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteproductSIP.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:md-item:delete')")
    public CommonResult<Boolean> deleteProductSip(@RequestParam("id") Long id) {
        productSipService.deleteProductSip(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get productSIP.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:md-item:query')")
    public CommonResult<MesMdProductSipRespVO> getProductSip(@RequestParam("id") Long id) {
        MesMdProductSipDO sip = productSipService.getProductSip(id);
        return success(BeanUtils.toBean(sip, MesMdProductSipRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get productSIP page.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:query')")
    public CommonResult<PageResult<MesMdProductSipRespVO>> getProductSipPage(@Valid MesMdProductSipPageReqVO pageReqVO) {
        PageResult<MesMdProductSipDO> pageResult = productSipService.getProductSipPage(pageReqVO);
        // TODO @芋艿：工序模块实现后，补充 processCode/processName 的 JOIN 逻辑
        return success(BeanUtils.toBean(pageResult, MesMdProductSipRespVO.class));
    }

    @GetMapping("/list-by-item-id")
    @Operation(summary = "By material Product code, get product SIP list.")
    @Parameter(name = "itemId", description = "Material product code.", required = true, example = "69")
    @PreAuthorize("@ss.hasPermission('mes:md-item:query')")
    public CommonResult<List<MesMdProductSipRespVO>> getProductSipListByItemId(
            @RequestParam("itemId") Long itemId) {
        List<MesMdProductSipDO> list = productSipService.getProductSipListByItemId(itemId);
        // TODO @芋艿：工序模块实现后，补充 processCode/processName 的 JOIN 逻辑
        return success(BeanUtils.toBean(list, MesMdProductSipRespVO.class));
    }

}

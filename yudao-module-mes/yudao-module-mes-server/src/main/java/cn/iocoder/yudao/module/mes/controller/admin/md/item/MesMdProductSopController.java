package cn.iocoder.yudao.module.mes.controller.admin.md.item;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sop.MesMdProductSopPageReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sop.MesMdProductSopRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.sop.MesMdProductSopSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdProductSopDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdProductSopService;
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

@Tag(name = "Admin - MES productSOP.")
@RestController
@RequestMapping("/mes/md/product-sop")
@Validated
public class MesMdProductSopController {

    @Resource
    private MesMdProductSopService productSopService;

    @PostMapping("/create")
    @Operation(summary = "CreateproductSOP.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:create')")
    public CommonResult<Long> createProductSop(@Valid @RequestBody MesMdProductSopSaveReqVO createReqVO) {
        return success(productSopService.createProductSop(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateproductSOP.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:update')")
    public CommonResult<Boolean> updateProductSop(@Valid @RequestBody MesMdProductSopSaveReqVO updateReqVO) {
        productSopService.updateProductSop(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteproductSOP.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:md-item:delete')")
    public CommonResult<Boolean> deleteProductSop(@RequestParam("id") Long id) {
        productSopService.deleteProductSop(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get productSOP.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:md-item:query')")
    public CommonResult<MesMdProductSopRespVO> getProductSop(@RequestParam("id") Long id) {
        MesMdProductSopDO sop = productSopService.getProductSop(id);
        return success(BeanUtils.toBean(sop, MesMdProductSopRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get productSOP page.")
    @PreAuthorize("@ss.hasPermission('mes:md-item:query')")
    public CommonResult<PageResult<MesMdProductSopRespVO>> getProductSopPage(@Valid MesMdProductSopPageReqVO pageReqVO) {
        PageResult<MesMdProductSopDO> pageResult = productSopService.getProductSopPage(pageReqVO);
        // TODO @芋艿：工序模块实现后，补充 processCode/processName 的 JOIN 逻辑
        return success(BeanUtils.toBean(pageResult, MesMdProductSopRespVO.class));
    }

    @GetMapping("/list-by-item-id")
    @Operation(summary = "By material Product code, get product SOP list.")
    @Parameter(name = "itemId", description = "Material product code.", required = true, example = "69")
    @PreAuthorize("@ss.hasPermission('mes:md-item:query')")
    public CommonResult<List<MesMdProductSopRespVO>> getProductSopListByItemId(
            @RequestParam("itemId") Long itemId) {
        List<MesMdProductSopDO> list = productSopService.getProductSopListByItemId(itemId);
        // TODO @芋艿：工序模块实现后，补充 processCode/processName 的 JOIN 逻辑
        return success(BeanUtils.toBean(list, MesMdProductSopRespVO.class));
    }

}

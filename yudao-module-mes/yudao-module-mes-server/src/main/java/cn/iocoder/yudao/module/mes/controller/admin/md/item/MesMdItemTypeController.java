package cn.iocoder.yudao.module.mes.controller.admin.md.item;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.type.MesMdItemTypeListReqVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.type.MesMdItemTypeRespVO;
import cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.type.MesMdItemTypeSaveReqVO;
import cn.iocoder.yudao.module.mes.dal.dataobject.md.item.MesMdItemTypeDO;
import cn.iocoder.yudao.module.mes.service.md.item.MesMdItemTypeService;
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

@Tag(name = "Admin - MES material product category.")
@RestController
@RequestMapping("/mes/md/item-type")
@Validated
public class MesMdItemTypeController {

    @Resource
    private MesMdItemTypeService itemTypeService;

    @PostMapping("/create")
    @Operation(summary = "Create material product category.")
    @PreAuthorize("@ss.hasPermission('mes:md-item-type:create')")
    public CommonResult<Long> createItemType(@Valid @RequestBody MesMdItemTypeSaveReqVO createReqVO) {
        return success(itemTypeService.createItemType(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Update material product category.")
    @PreAuthorize("@ss.hasPermission('mes:md-item-type:update')")
    public CommonResult<Boolean> updateItemType(@Valid @RequestBody MesMdItemTypeSaveReqVO updateReqVO) {
        itemTypeService.updateItemType(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete material product category.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mes:md-item-type:delete')")
    public CommonResult<Boolean> deleteItemType(@RequestParam("id") Long id) {
        itemTypeService.deleteItemType(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get material product category.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mes:md-item-type:query')")
    public CommonResult<MesMdItemTypeRespVO> getItemType(@RequestParam("id") Long id) {
        MesMdItemTypeDO itemType = itemTypeService.getItemType(id);
        return success(BeanUtils.toBean(itemType, MesMdItemTypeRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "Get material product category list.")
    @PreAuthorize("@ss.hasPermission('mes:md-item-type:query')")
    public CommonResult<List<MesMdItemTypeRespVO>> getItemTypeList(@Valid MesMdItemTypeListReqVO listReqVO) {
        List<MesMdItemTypeDO> list = itemTypeService.getItemTypeList(listReqVO);
        return success(BeanUtils.toBean(list, MesMdItemTypeRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get material product category simple list.", description = "Enabled categories only. Used by frontend dropdowns.")
    public CommonResult<List<MesMdItemTypeRespVO>> getItemTypeSimpleList() {
        List<MesMdItemTypeDO> list = itemTypeService.getItemTypeList(
                new MesMdItemTypeListReqVO().setStatus(CommonStatusEnum.ENABLE.getStatus()));
        return success(convertList(list, itemType -> new MesMdItemTypeRespVO()
                .setId(itemType.getId()).setName(itemType.getName()).setParentId(itemType.getParentId())
                .setCode(itemType.getCode()).setRemark(itemType.getRemark())
                .setItemOrProduct(itemType.getItemOrProduct())));
    }

}

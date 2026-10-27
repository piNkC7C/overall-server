package cn.iocoder.yudao.module.fms.controller.admin.config;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliarytype.FmsAuxiliaryTypeRespVO;
import cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliarytype.FmsAuxiliaryTypeSaveReqVO;
import cn.iocoder.yudao.module.fms.dal.dataobject.config.FmsAuxiliaryTypeDO;
import cn.iocoder.yudao.module.fms.service.config.FmsAuxiliaryTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - FMS Auxiliary accounting Category.")
@RestController
@RequestMapping("/fms/config/auxiliary-type")
@Validated
public class FmsAuxiliaryTypeController {

    @Resource
    private FmsAuxiliaryTypeService auxiliaryTypeService;

    @PostMapping("/create")
    @Operation(summary = "CreateAuxiliary accounting type.")
    @PreAuthorize("@ss.hasPermission('fms:config:auxiliary:create')")
    public CommonResult<Long> createAuxiliaryType(@Valid @RequestBody FmsAuxiliaryTypeSaveReqVO createReqVO) {
        return success(auxiliaryTypeService.createAuxiliaryType(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateAuxiliary accounting type.")
    @PreAuthorize("@ss.hasPermission('fms:config:auxiliary:update')")
    public CommonResult<Boolean> updateAuxiliaryType(@Valid @RequestBody FmsAuxiliaryTypeSaveReqVO updateReqVO) {
        auxiliaryTypeService.updateAuxiliaryType(updateReqVO, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteAuxiliary accounting type.")
    @Parameters({
            @Parameter(name = "accountSetId", description = "Books code.", required = true, example = "1024"),
            @Parameter(name = "id", description = "Auxiliary category ID", required = true, example = "1024")
    })
    @PreAuthorize("@ss.hasPermission('fms:config:auxiliary:delete')")
    public CommonResult<Boolean> deleteAuxiliaryType(
            @RequestParam("accountSetId") @NotNull Long accountSetId,
            @RequestParam("id") @NotNull Long id) {
        auxiliaryTypeService.deleteAuxiliaryType(accountSetId, id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "GetAuxiliary accounting typelist.")
    @Parameter(name = "accountSetId", description = "Books code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('fms:config:auxiliary:query')")
    public CommonResult<List<FmsAuxiliaryTypeRespVO>> getAuxiliaryTypeList(
            @RequestParam("accountSetId") @NotNull Long accountSetId) {
        return success(BeanUtils.toBean(auxiliaryTypeService.getAuxiliaryTypeList(
                accountSetId, getLoginUserId()), FmsAuxiliaryTypeRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "GetAuxiliary accounting typesimple list.", description = "Used by frontend select options.")
    @Parameter(name = "accountSetId", description = "Books code.", required = true, example = "1024")
    public CommonResult<List<FmsAuxiliaryTypeRespVO>> getAuxiliaryTypeSimpleList(
            @RequestParam("accountSetId") @NotNull Long accountSetId) {
        List<FmsAuxiliaryTypeDO> list = auxiliaryTypeService.getAuxiliaryTypeList(
                accountSetId, getLoginUserId());
        return success(convertList(list, auxiliaryType -> new FmsAuxiliaryTypeRespVO()
                .setId(auxiliaryType.getId()).setName(auxiliaryType.getName()).setType(auxiliaryType.getType())));
    }

}

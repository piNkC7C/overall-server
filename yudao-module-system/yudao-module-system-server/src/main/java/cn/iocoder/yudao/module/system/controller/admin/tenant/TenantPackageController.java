package cn.iocoder.yudao.module.system.controller.admin.tenant;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages.TenantPackagePageReqVO;
import cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages.TenantPackageRespVO;
import cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages.TenantPackageSaveReqVO;
import cn.iocoder.yudao.module.system.controller.admin.tenant.vo.packages.TenantPackageSimpleRespVO;
import cn.iocoder.yudao.module.system.dal.dataobject.tenant.TenantPackageDO;
import cn.iocoder.yudao.module.system.service.tenant.TenantPackageService;
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

@Tag(name = "Admin - tenant plan.")
@RestController
@RequestMapping("/system/tenant-package")
@Validated
public class TenantPackageController {

    @Resource
    private TenantPackageService tenantPackageService;

    @PostMapping("/create")
    @Operation(summary = "Createtenant plan.")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:create')")
    public CommonResult<Long> createTenantPackage(@Valid @RequestBody TenantPackageSaveReqVO createReqVO) {
        return success(tenantPackageService.createTenantPackage(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "Updatetenant plan.")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:update')")
    public CommonResult<Boolean> updateTenantPackage(@Valid @RequestBody TenantPackageSaveReqVO updateReqVO) {
        tenantPackageService.updateTenantPackage(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Deletetenant plan.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('system:tenant-package:delete')")
    public CommonResult<Boolean> deleteTenantPackage(@RequestParam("id") Long id) {
        tenantPackageService.deleteTenantPackage(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "Code list.", required = true)
    @Operation(summary = "Batch deletetenant plan.")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:delete')")
    public CommonResult<Boolean> deleteTenantPackageList(@RequestParam("ids") List<Long> ids) {
        tenantPackageService.deleteTenantPackageList(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get tenant plan.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:query')")
    public CommonResult<TenantPackageRespVO> getTenantPackage(@RequestParam("id") Long id) {
        TenantPackageDO tenantPackage = tenantPackageService.getTenantPackage(id);
        return success(BeanUtils.toBean(tenantPackage, TenantPackageRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "Get tenant plan page.")
    @PreAuthorize("@ss.hasPermission('system:tenant-package:query')")
    public CommonResult<PageResult<TenantPackageRespVO>> getTenantPackagePage(@Valid TenantPackagePageReqVO pageVO) {
        PageResult<TenantPackageDO> pageResult = tenantPackageService.getTenantPackagePage(pageVO);
        return success(BeanUtils.toBean(pageResult, TenantPackageRespVO.class));
    }

    @GetMapping({"/get-simple-list", "simple-list"})
    @Operation(summary = "Get tenant plan simple info list.", description = "Only enabled tenant plan. Used for dropdowns.")
    public CommonResult<List<TenantPackageSimpleRespVO>> getTenantPackageList() {
        List<TenantPackageDO> list = tenantPackageService.getTenantPackageListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(BeanUtils.toBean(list, TenantPackageSimpleRespVO.class));
    }

}

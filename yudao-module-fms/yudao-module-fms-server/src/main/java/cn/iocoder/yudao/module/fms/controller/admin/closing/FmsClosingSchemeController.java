package cn.iocoder.yudao.module.fms.controller.admin.closing;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.fms.controller.admin.closing.vo.FmsClosingQueryReqVO;
import cn.iocoder.yudao.module.fms.controller.admin.closing.vo.FmsClosingSchemeRespVO;
import cn.iocoder.yudao.module.fms.controller.admin.closing.vo.FmsClosingSchemeSaveReqVO;
import cn.iocoder.yudao.module.fms.controller.admin.closing.vo.FmsProfitLossSettingsSaveReqVO;
import cn.iocoder.yudao.module.fms.controller.admin.closing.vo.FmsSpecialClosingSettingsSaveReqVO;
import cn.iocoder.yudao.module.fms.service.closing.FmsClosingSchemeService;
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
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - FMS closing plan.")
@RestController
@RequestMapping("/fms/closing/scheme")
@Validated
public class FmsClosingSchemeController {

    @Resource
    private FmsClosingSchemeService closingSchemeService;

    @GetMapping("/list")
    @Operation(summary = "Get closing plan list.")
    @PreAuthorize("@ss.hasPermission('fms:closing:query')")
    public CommonResult<List<FmsClosingSchemeRespVO>> getClosingSchemeList(@Valid FmsClosingQueryReqVO queryReqVO) {
        return success(closingSchemeService.getClosingSchemeList(queryReqVO, getLoginUserId()));
    }

    @PostMapping("/create")
    @Operation(summary = "Create closing plan.")
    @PreAuthorize("@ss.hasPermission('fms:closing:update')")
    public CommonResult<Long> createClosingScheme(@Valid @RequestBody FmsClosingSchemeSaveReqVO createReqVO) {
        return success(closingSchemeService.createClosingScheme(createReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit closing plan.")
    @PreAuthorize("@ss.hasPermission('fms:closing:update')")
    public CommonResult<Boolean> updateClosingScheme(@Valid @RequestBody FmsClosingSchemeSaveReqVO updateReqVO) {
        closingSchemeService.updateClosingScheme(updateReqVO, getLoginUserId());
        return success(true);
    }

    @PutMapping("/update-profit-loss-settings")
    @Operation(summary = "Save close P&L set.")
    @PreAuthorize("@ss.hasPermission('fms:closing:update')")
    public CommonResult<Long> saveProfitLossSettings(@Valid @RequestBody FmsProfitLossSettingsSaveReqVO saveReqVO) {
        return success(closingSchemeService.saveProfitLossSettings(saveReqVO, getLoginUserId()));
    }

    @PutMapping("/update-special-settings")
    @Operation(summary = "Save special closing settings.")
    @PreAuthorize("@ss.hasPermission('fms:closing:update')")
    public CommonResult<Boolean> updateSpecialClosingSettings(@Valid @RequestBody FmsSpecialClosingSettingsSaveReqVO updateReqVO) {
        closingSchemeService.updateSpecialClosingSettings(updateReqVO, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete closing plan.")
    @PreAuthorize("@ss.hasPermission('fms:closing:update')")
    public CommonResult<Boolean> deleteClosingScheme(@RequestParam("accountSetId") @NotNull Long accountSetId,
                                                     @RequestParam("id") @NotNull Long id) {
        closingSchemeService.deleteClosingScheme(accountSetId, id, getLoginUserId());
        return success(true);
    }

}

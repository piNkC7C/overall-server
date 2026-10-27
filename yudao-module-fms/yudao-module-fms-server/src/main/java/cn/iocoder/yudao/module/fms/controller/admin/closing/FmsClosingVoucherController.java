package cn.iocoder.yudao.module.fms.controller.admin.closing;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.fms.controller.admin.closing.vo.FmsClosingSchemeGenerateReqVO;
import cn.iocoder.yudao.module.fms.controller.admin.closing.vo.FmsClosingVoucherGenerateReqVO;
import cn.iocoder.yudao.module.fms.controller.admin.closing.vo.FmsProfitLossGenerateReqVO;
import cn.iocoder.yudao.module.fms.service.closing.FmsClosingVoucherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - FMS closing journal entry.")
@RestController
@RequestMapping("/fms/closing/voucher")
@Validated
public class FmsClosingVoucherController {

    @Resource
    private FmsClosingVoucherService closingVoucherService;

    @PostMapping("/generate-profit-loss")
    @Operation(summary = "Create close P&L journal entry.")
    @PreAuthorize("@ss.hasPermission('fms:closing:profit-loss')")
    public CommonResult<Long> generateProfitLossVoucher(@Valid @RequestBody FmsProfitLossGenerateReqVO generateReqVO) {
        return success(closingVoucherService.generateProfitLossVoucher(generateReqVO, getLoginUserId()));
    }

    @PostMapping("/generate-scheme")
    @Operation(summary = "Create closing plan journal entry.")
    @PreAuthorize("@ss.hasPermission('fms:closing:profit-loss')")
    public CommonResult<Long> generateClosingSchemeVoucher(@Valid @RequestBody FmsClosingSchemeGenerateReqVO generateReqVO) {
        return success(closingVoucherService.generateClosingSchemeVoucher(generateReqVO, getLoginUserId()));
    }

    @PostMapping("/generate-list")
    @Operation(summary = "Batch generate closing journal entry.")
    @PreAuthorize("@ss.hasPermission('fms:closing:profit-loss')")
    public CommonResult<List<Long>> generateClosingVoucherList(@Valid @RequestBody FmsClosingVoucherGenerateReqVO generateReqVO) {
        return success(closingVoucherService.generateClosingVoucherList(generateReqVO, getLoginUserId()));
    }

}

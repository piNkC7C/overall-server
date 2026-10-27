package cn.iocoder.yudao.module.mp.controller.admin.account;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.mp.controller.admin.account.vo.*;
import cn.iocoder.yudao.module.mp.convert.account.MpAccountConvert;
import cn.iocoder.yudao.module.mp.dal.dataobject.account.MpAccountDO;
import cn.iocoder.yudao.module.mp.service.account.MpAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "Admin - Official Account account.")
@RestController
@RequestMapping("/mp/account")
@Validated
public class MpAccountController {

    @Resource
    private MpAccountService mpAccountService;

    @PostMapping("/create")
    @Operation(summary = "CreateOfficial Account account.")
    @PreAuthorize("@ss.hasPermission('mp:account:create')")
    public CommonResult<Long> createAccount(@Valid @RequestBody MpAccountCreateReqVO createReqVO) {
        return success(mpAccountService.createAccount(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateOfficial Account account.")
    @PreAuthorize("@ss.hasPermission('mp:account:update')")
    public CommonResult<Boolean> updateAccount(@Valid @RequestBody MpAccountUpdateReqVO updateReqVO) {
        mpAccountService.updateAccount(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteOfficial Account account.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mp:account:delete')")
    public CommonResult<Boolean> deleteAccount(@RequestParam("id") Long id) {
        mpAccountService.deleteAccount(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get Official Account account.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('mp:account:query')")
    public CommonResult<MpAccountRespVO> getAccount(@RequestParam("id") Long id) {
        MpAccountDO wxAccount = mpAccountService.getAccount(id);
        return success(MpAccountConvert.INSTANCE.convert(wxAccount));
    }

    @GetMapping("/page")
    @Operation(summary = "Get Official Account account page.")
    @PreAuthorize("@ss.hasPermission('mp:account:query')")
    public CommonResult<PageResult<MpAccountRespVO>> getAccountPage(@Valid MpAccountPageReqVO pageVO) {
        PageResult<MpAccountDO> pageResult = mpAccountService.getAccountPage(pageVO);
        return success(MpAccountConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/list-all-simple")
    @Operation(summary = "Get Official Account account simple info list.")
    @PreAuthorize("@ss.hasPermission('mp:account:query')")
    public CommonResult<List<MpAccountSimpleRespVO>> getSimpleAccounts() {
        List<MpAccountDO> list = mpAccountService.getAccountList();
        return success(MpAccountConvert.INSTANCE.convertList02(list));
    }

    @PutMapping("/generate-qr-code")
    @Operation(summary = "CreateOfficial AccountQR Code.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mp:account:qr-code')")
    public CommonResult<Boolean> generateAccountQrCode(@RequestParam("id") Long id) {
        mpAccountService.generateAccountQrCode(id);
        return success(true);
    }

    @PutMapping("/clear-quota")
    @Operation(summary = "Clear official account API quota.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('mp:account:clear-quota')")
    public CommonResult<Boolean> clearAccountQuota(@RequestParam("id") Long id) {
        mpAccountService.clearAccountQuota(id);
        return success(true);
    }

}

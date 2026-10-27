package cn.iocoder.yudao.module.erp.controller.admin.finance;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.erp.controller.admin.finance.vo.account.ErpAccountPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.finance.vo.account.ErpAccountRespVO;
import cn.iocoder.yudao.module.erp.controller.admin.finance.vo.account.ErpAccountSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.finance.ErpAccountDO;
import cn.iocoder.yudao.module.erp.service.finance.ErpAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;

@Tag(name = "Admin - ERP Settlement Account.")
@RestController
@RequestMapping("/erp/account")
@Validated
public class ErpAccountController {

    @Resource
    private ErpAccountService accountService;

    @PostMapping("/create")
    @Operation(summary = "CreateSettlement Account.")
    @PreAuthorize("@ss.hasPermission('erp:account:create')")
    public CommonResult<Long> createAccount(@Valid @RequestBody ErpAccountSaveReqVO createReqVO) {
        return success(accountService.createAccount(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "UpdateSettlement Account.")
    @PreAuthorize("@ss.hasPermission('erp:account:update')")
    public CommonResult<Boolean> updateAccount(@Valid @RequestBody ErpAccountSaveReqVO updateReqVO) {
        accountService.updateAccount(updateReqVO);
        return success(true);
    }

    @PutMapping("/update-default-status")
    @Operation(summary = "UpdateSettlement Account default status.")
    @Parameters({
            @Parameter(name = "id", description = "Code.", required = true),
            @Parameter(name = "status", description = "Status.", required = true)
    })
    public CommonResult<Boolean> updateAccountDefaultStatus(@RequestParam("id") Long id,
                                                              @RequestParam("defaultStatus") Boolean defaultStatus) {
        accountService.updateAccountDefaultStatus(id, defaultStatus);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "DeleteSettlement Account.")
    @Parameter(name = "id", description = "Code.", required = true)
    @PreAuthorize("@ss.hasPermission('erp:account:delete')")
    public CommonResult<Boolean> deleteAccount(@RequestParam("id") Long id) {
        accountService.deleteAccount(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "Get Settlement Account.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('erp:account:query')")
    public CommonResult<ErpAccountRespVO> getAccount(@RequestParam("id") Long id) {
        ErpAccountDO account = accountService.getAccount(id);
        return success(BeanUtils.toBean(account, ErpAccountRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "Get Settlement Account simple list.", description = "Only enabled settlement account. Used for dropdowns.")
    public CommonResult<List<ErpAccountRespVO>> getWarehouseSimpleList() {
        List<ErpAccountDO> list = accountService.getAccountListByStatus(CommonStatusEnum.ENABLE.getStatus());
        return success(convertList(list, account -> new ErpAccountRespVO().setId(account.getId())
                .setName(account.getName()).setDefaultStatus(account.getDefaultStatus())));
    }

    @GetMapping("/page")
    @Operation(summary = "Get Settlement Account page.")
    @PreAuthorize("@ss.hasPermission('erp:account:query')")
    public CommonResult<PageResult<ErpAccountRespVO>> getAccountPage(@Valid ErpAccountPageReqVO pageReqVO) {
        PageResult<ErpAccountDO> pageResult = accountService.getAccountPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ErpAccountRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "ExportSettlement Account Excel.")
    @PreAuthorize("@ss.hasPermission('erp:account:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportAccountExcel(@Valid ErpAccountPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ErpAccountDO> list = accountService.getAccountPage(pageReqVO).getList();
        // Export Excel
        ExcelUtils.write(response, "Settlement Accounts.xls", "Data", ErpAccountRespVO.class,
                        BeanUtils.toBean(list, ErpAccountRespVO.class));
    }

}
package cn.iocoder.yudao.module.pay.controller.admin.demo;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.pay.api.notify.dto.PayTransferNotifyReqDTO;
import cn.iocoder.yudao.module.pay.controller.admin.demo.vo.withdraw.PayDemoWithdrawCreateReqVO;
import cn.iocoder.yudao.module.pay.controller.admin.demo.vo.withdraw.PayDemoWithdrawRespVO;
import cn.iocoder.yudao.module.pay.dal.dataobject.demo.PayDemoWithdrawDO;
import cn.iocoder.yudao.module.pay.service.demo.PayDemoWithdrawService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - sample withdrawal order.") // 目的：演示转账功能
@RestController
@RequestMapping("/pay/demo-withdraw")
@Validated
public class PayDemoWithdrawController {

    @Resource
    private PayDemoWithdrawService demoWithdrawService;

    @PostMapping("/create")
    @Operation(summary = "Create sample withdrawal order.")
    public CommonResult<Long> createDemoWithdraw(@Valid @RequestBody PayDemoWithdrawCreateReqVO createReqVO) {
        Long id = demoWithdrawService.createDemoWithdraw(createReqVO);
        return success(id);
    }

    @PostMapping("/transfer")
    @Operation(summary = "Withdrawal order transfer.")
    @Parameter(name = "id", required = true, description = "Withdrawal order code.", example = "1024")
    public CommonResult<Long> transferDemoWithdraw(@RequestParam("id") Long id) {
        Long payTransferId = demoWithdrawService.transferDemoWithdraw(id, getLoginUserId());
        return success(payTransferId);
    }

    @GetMapping("/page")
    @Operation(summary = "Get sample withdrawal order page.")
    public CommonResult<PageResult<PayDemoWithdrawRespVO>> getDemoWithdrawPage(@Valid PageParam pageVO) {
        PageResult<PayDemoWithdrawDO> pageResult = demoWithdrawService.getDemoWithdrawPage(pageVO);
        return success(BeanUtils.toBean(pageResult, PayDemoWithdrawRespVO.class));
    }

    @PostMapping("/update-transferred")
    @Operation(summary = "Update sample withdrawal order transfer status.") // 由 pay-module 转账服务，进行回调
    @PermitAll // 无需登录，安全由 PayDemoTransferService 内部校验实现
    public CommonResult<Boolean> updateDemoWithdrawTransferred(@RequestBody PayTransferNotifyReqDTO notifyReqDTO) {
        demoWithdrawService.updateDemoWithdrawTransferred(Long.valueOf(notifyReqDTO.getMerchantTransferId()),
                notifyReqDTO.getPayTransferId());
        return success(true);
    }

}

package cn.iocoder.yudao.module.pay.api.refund;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import cn.iocoder.yudao.module.pay.api.refund.dto.PayRefundRespDTO;
import cn.iocoder.yudao.module.pay.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - refund.")
public interface PayRefundApi {

    String PREFIX = ApiConstants.PREFIX + "/refund";

    /**
     * 创建退款单，独立于调用方事务提交，通过退款通知处理最终结果。
     * 重试需要使用相同的 merchantRefundId；渠道明确失败时，会抛出渠道错误的业务异常。
     */
    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Createrefund.")
    CommonResult<Long> createRefund(@Valid @RequestBody PayRefundCreateReqDTO reqDTO);

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Get refund.")
    @Parameter(name = "id", description = "Refund code.", example = "1", required = true)
    CommonResult<PayRefundRespDTO> getRefund(@RequestParam("id") Long id);

}

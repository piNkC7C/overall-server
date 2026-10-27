package cn.iocoder.yudao.module.pay.api.transfer;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.pay.api.transfer.dto.PayTransferCreateReqDTO;
import cn.iocoder.yudao.module.pay.api.transfer.dto.PayTransferCreateRespDTO;
import cn.iocoder.yudao.module.pay.api.transfer.dto.PayTransferRespDTO;
import cn.iocoder.yudao.module.pay.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - transfer order.")
public interface PayTransferApi {

    String PREFIX = ApiConstants.PREFIX + "/transfer";

    /**
     * 创建转账单，独立于调用方事务提交，通过转账通知处理最终结果。
     * 重试需要使用相同的 merchantTransferId；渠道明确失败时，会抛出渠道错误的业务异常。
     */
    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create transfer order.")
    CommonResult<PayTransferCreateRespDTO> createTransfer(@Valid @RequestBody PayTransferCreateReqDTO reqDTO);

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Get transfer order.")
    @Parameter(name = "id", description = "Transfer order code.", required = true, example = "1024")
    CommonResult<PayTransferRespDTO> getTransfer(@RequestParam("id") Long id);

}

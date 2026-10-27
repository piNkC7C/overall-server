package cn.iocoder.yudao.module.pay.api.order;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.pay.api.order.dto.PayOrderCreateReqDTO;
import cn.iocoder.yudao.module.pay.api.order.dto.PayOrderRespDTO;
import cn.iocoder.yudao.module.pay.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - payment order.")
public interface PayOrderApi {

    String PREFIX = ApiConstants.PREFIX + "/order";

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create payment order.")
    CommonResult<Long> createOrder(@Valid @RequestBody PayOrderCreateReqDTO reqDTO);

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Get payment order.")
    @Parameter(name = "id", description = "Payment order code.", example = "1", required = true)
    @PermitAll
    CommonResult<PayOrderRespDTO> getOrder(@RequestParam("id") Long id);

    @PutMapping(PREFIX + "/close")
    @Operation(summary = "Disable payment order.")
    @Parameter(name = "id", description = "Payment order code.", example = "1", required = true)
    CommonResult<Boolean> closeOrder(@RequestParam("id") Long id);

    @PutMapping(PREFIX + "/update-price")
    @Operation(summary = "UpdatepaymentPrice.")
    @Parameters({
            @Parameter(name = "id", description = "Payment order code.", example = "1", required = true),
            @Parameter(name = "payPrice", description = "Payment price.", example = "100", required = true)
    })
    CommonResult<Boolean> updatePayOrderPrice(@RequestParam("id") Long id,
                                              @RequestParam("payPrice") Integer payPrice);

}

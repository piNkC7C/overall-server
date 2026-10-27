package cn.iocoder.yudao.module.trade.api.order;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.trade.api.order.dto.TradeOrderRespDTO;
import cn.iocoder.yudao.module.trade.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - order.")
public interface TradeOrderApi {

    String PREFIX = ApiConstants.PREFIX + "/order";

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "Get order list.")
    @Parameter(name = "ids", description = "Order ID list.", required = true)
    CommonResult<List<TradeOrderRespDTO>> getOrderList(@RequestParam("ids") Collection<Long> ids);

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Get order.")
    @Parameter(name = "id", description = "Order code.", required = true)
    CommonResult<TradeOrderRespDTO> getOrder(@RequestParam("id") Long id);

    @PutMapping(PREFIX + "/cancel-paid")
    @Parameters({
            @Parameter(name = "userId", description = "User ID.", required = true, example = "1024"),
            @Parameter(name = "orderId", description = "Order code.", required = true, example = "2048"),
    })
    CommonResult<Boolean> cancelPaidOrder(@RequestParam("userId") Long userId,
                                          @RequestParam("orderId") Long orderId,
                                          @RequestParam("cancelType") Integer cancelType);

}

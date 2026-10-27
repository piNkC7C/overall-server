package cn.iocoder.yudao.module.promotion.api.bargain;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.promotion.api.bargain.dto.BargainValidateJoinRespDTO;
import cn.iocoder.yudao.module.promotion.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - bargain record.")
public interface BargainRecordApi {

    String PREFIX = ApiConstants.PREFIX + "/bargain-record";

    @GetMapping(PREFIX + "/validate-join")
    @Operation(summary = "Before checkout, validate bargain-campaign eligibility.") // 如果校验失败，则抛出业务异常
    @Parameters({
            @Parameter(name = "userId", description = "User ID.", required = true, example = "1024"),
            @Parameter(name = "bargainRecordId", description = "Bargain record code.", required = true, example = "2048"),
            @Parameter(name = "skuId", description = "SKU code.", required = true, example = "4096"),
    })
    CommonResult<BargainValidateJoinRespDTO> validateJoinBargain(@RequestParam("userId") Long userId,
                                                                 @RequestParam("bargainRecordId") Long bargainRecordId,
                                                                 @RequestParam("skuId") Long skuId);

    @PutMapping(PREFIX + "/update-order-id")
    @Operation(summary = "Update bargain record order code.") // In bargain succeeded after, userstartorder after, will record this order code
    @Parameters({
            @Parameter(name = "id", description = "Bargain record code.", required = true, example = "1024"),
            @Parameter(name = "orderId", description = "Order code.", required = true, example = "2048"),
    })
    CommonResult<Boolean> updateBargainRecordOrderId(@RequestParam("id") Long id,
                                                     @RequestParam("oderId") Long orderId);

}

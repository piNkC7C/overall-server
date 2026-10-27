package cn.iocoder.yudao.module.promotion.api.seckill;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.promotion.api.seckill.dto.SeckillValidateJoinRespDTO;
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
@Tag(name = "RPC service - flash sale campaign.")
public interface SeckillActivityApi {

    String PREFIX = ApiConstants.PREFIX + "/discount-activity";

    @PutMapping(PREFIX + "/update-stock-decr")
    @Operation(summary = "Update flash sale inventory (subtract).")
    @Parameters({
            @Parameter(name = "id", description = "Campaign code.", required = true, example = "1"),
            @Parameter(name = "skuId", description = "SKU code.", required = true, example = "2"),
            @Parameter(name = "count", description = "Quantity.", required = true, example = "3"),
    })
    CommonResult<Boolean> updateSeckillStockDecr(@RequestParam("id") Long id,
                                                 @RequestParam("skuId") Long skuId,
                                                 @RequestParam("count")Integer count);

    @PutMapping(PREFIX + "/update-stock-incr")
    @Operation(summary = "Update flash sale inventory (add).")
    @Parameters({
            @Parameter(name = "id", description = "Campaign code.", required = true, example = "1"),
            @Parameter(name = "skuId", description = "SKU code.", required = true, example = "2"),
            @Parameter(name = "count", description = "Quantity.", required = true, example = "3"),
    })
    CommonResult<Boolean> updateSeckillStockIncr(@RequestParam("id") Long id,
                                                 @RequestParam("skuId") Long skuId,
                                                 @RequestParam("count")Integer count);

    @GetMapping(PREFIX + "/validate-join")
    @Operation(summary = "Before checkout, validate flash-sale eligibility.") // 如果校验失败，则抛出业务异常
    @Parameters({
            @Parameter(name = "activityId", description = "Campaign code.", required = true, example = "1"),
            @Parameter(name = "skuId", description = "SKU code.", required = true, example = "2"),
            @Parameter(name = "count", description = "Quantity.", required = true, example = "3"),
    })
    CommonResult<SeckillValidateJoinRespDTO> validateJoinSeckill(@RequestParam("activityId") Long activityId,
                                                                 @RequestParam("skuId") Long skuId,
                                                                 @RequestParam("count")Integer count);

}

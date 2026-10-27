package cn.iocoder.yudao.module.promotion.api.discount;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.promotion.api.discount.dto.DiscountProductRespDTO;
import cn.iocoder.yudao.module.promotion.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC - Limited-time discount.")
public interface DiscountActivityApi {

    String PREFIX = ApiConstants.PREFIX + "/discount-activity";

    @GetMapping(PREFIX + "/list-by-sku-id")
    @Operation(summary = "Get matching limited-time discount info for a product.")
    @Parameter(name = "skuIds", description = "Product SKU ID list.", required = true, example = "[1, 2]")
    CommonResult<List<DiscountProductRespDTO>> getMatchDiscountProductListBySkuIds(@RequestParam("skuIds") Collection<Long> skuIds);

}

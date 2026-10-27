package cn.iocoder.yudao.module.product.api.category;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.product.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - product category.")
public interface ProductCategoryApi {

    String PREFIX = ApiConstants.PREFIX + "/category";

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "Validate department valid.")
    @Parameter(name = "ids", description = "Product category ID list.", example = "1,2", required = true)
    CommonResult<Boolean> validateCategoryList(@RequestParam("ids") Collection<Long> ids);

}

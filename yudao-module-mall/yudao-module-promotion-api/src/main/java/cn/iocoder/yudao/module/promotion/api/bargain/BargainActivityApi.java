package cn.iocoder.yudao.module.promotion.api.bargain;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.promotion.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - bargain campaign.")
public interface BargainActivityApi {

    String PREFIX = ApiConstants.PREFIX + "/bargain-activity";

    @PutMapping(PREFIX + "/update-stock")
    @Operation(summary = "Update bargain campaigninventory.")
    @Parameters({
            @Parameter(name = "id", description = "Bargain campaign code.", required = true, example = "1024"),
            @Parameter(name = "count", description = "Purchase quantity.", required = true, example = "1"),
    })
    CommonResult<Boolean> updateBargainActivityStock(@RequestParam("id") Long id,
                                                     @RequestParam("count") Integer count);

}

package cn.iocoder.yudao.module.system.api.dict;

import cn.iocoder.yudao.framework.common.biz.system.dict.DictDataCommonApi;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.Operation;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - dictionary data.")
public interface DictDataApi extends DictDataCommonApi {

    String PREFIX = ApiConstants.PREFIX + "/dict-data";

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "Validate dictionary data is valid.")
    @Parameters({
        @Parameter(name = "dictType", description = "Dictionary type.", example = "SEX", required = true),
        @Parameter(name = "descriptions", description = "Dictionary values.", example = "1,2", required = true)
    })
    CommonResult<Boolean> validateDictDataList(@RequestParam("dictType") String dictType,
                                               @RequestParam("values") Collection<String> values);

}

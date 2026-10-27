package cn.iocoder.yudao.framework.common.biz.system.dict;

import cn.iocoder.yudao.framework.common.biz.system.dict.dto.DictDataRespDTO;
import cn.iocoder.yudao.framework.common.enums.RpcConstants;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = RpcConstants.SYSTEM_NAME, primary = false) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - dictionary data.")
public interface DictDataCommonApi {

    String PREFIX = RpcConstants.SYSTEM_PREFIX + "/dict-data";

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "Get specified dictionary type dictionary data list.")
    @Parameter(name = "dictType", description = "Dictionary type.", example = "SEX", required = true)
    CommonResult<List<DictDataRespDTO>> getDictDataList(@RequestParam("dictType") String dictType);

}

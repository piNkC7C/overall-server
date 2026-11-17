package cn.iocoder.yudao.module.system.api.dict;

import cn.iocoder.yudao.framework.common.biz.system.dict.DictDataCommonApi;
import cn.iocoder.yudao.framework.common.biz.system.dict.dto.DictDataRespDTO;
import cn.iocoder.yudao.framework.common.biz.system.dict.dto.DictDataSaveReqDTO;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC 服务 - 字典数据")
public interface DictDataApi extends DictDataCommonApi {

    String PREFIX = ApiConstants.PREFIX + "/dict-data";

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "校验字典数据们是否有效")
    @Parameters({
        @Parameter(name = "dictType", description = "字典类型", example = "SEX", required = true),
        @Parameter(name = "descriptions", description = "字典数据值的数组", example = "1,2", required = true)
    })
    CommonResult<Boolean> validateDictDataList(@RequestParam("dictType") String dictType,
                                               @RequestParam("values") Collection<String> values);

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "获得字典数据")
    @Parameter(name = "id", description = "字典数据编号", required = true, example = "1024")
    CommonResult<DictDataRespDTO> getDictData(@RequestParam("id") Long id);

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "创建字典数据")
    CommonResult<Long> createDictData(@RequestBody DictDataSaveReqDTO reqDTO);

    @PutMapping(PREFIX + "/update")
    @Operation(summary = "更新字典数据")
    CommonResult<Boolean> updateDictData(@RequestBody DictDataSaveReqDTO reqDTO);

    @DeleteMapping(PREFIX + "/delete")
    @Operation(summary = "删除字典数据")
    @Parameter(name = "id", description = "字典数据编号", required = true, example = "1024")
    CommonResult<Boolean> deleteDictData(@RequestParam("id") Long id);

}

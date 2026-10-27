package cn.iocoder.yudao.module.product.api.spu;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.product.api.spu.dto.ProductSpuRespDTO;
import cn.iocoder.yudao.module.product.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMap;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - product SPU.")
public interface ProductSpuApi {

    String PREFIX = ApiConstants.PREFIX + "/spu";

    @GetMapping(PREFIX + "/list")
    @Schema(description = "Batch search SPU Array.")
    @Parameter(name = "ids", description = "SPU code list.", required = true, example = "1,3,5")
    CommonResult<List<ProductSpuRespDTO>> getSpuList(@RequestParam("ids") Collection<Long> ids);

    /**
     * 批量查询 SPU MAP
     *
     * @param ids SPU 编号列表
     * @return SPU MAP
     */
    default Map<Long, ProductSpuRespDTO> getSpuMap(Collection<Long> ids) {
        return convertMap(getSpuList(ids).getCheckedData(), ProductSpuRespDTO::getId);
    }

    @GetMapping(PREFIX + "/valid")
    @Schema(description = "Batch get SPU array, and validate whether SPU is valid.")
    @Parameter(name = "ids", description = "SPU code list.", required = true, example = "1,3,5")
    CommonResult<List<ProductSpuRespDTO>> validateSpuList(@RequestParam("ids") Collection<Long> ids);

    @GetMapping(PREFIX + "/get")
    @Schema(description = "Get SPU.")
    @Parameter(name = "id", description = "SPU code.", required = true, example = "1")
    CommonResult<ProductSpuRespDTO> getSpu(@RequestParam("id") Long id);

}

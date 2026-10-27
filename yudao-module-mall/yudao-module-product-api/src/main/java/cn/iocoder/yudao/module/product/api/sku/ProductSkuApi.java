package cn.iocoder.yudao.module.product.api.sku;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.product.api.sku.dto.ProductSkuRespDTO;
import cn.iocoder.yudao.module.product.api.sku.dto.ProductSkuUpdateStockReqDTO;
import cn.iocoder.yudao.module.product.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMap;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - product SKU.")
public interface ProductSkuApi {

    String PREFIX = ApiConstants.PREFIX + "/sku";

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Search SKU info.")
    @Parameter(name = "id", description = "SKU code.", required = true, example = "1024")
    CommonResult<ProductSkuRespDTO> getSku(@RequestParam("id") Long id);

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "Batch search SKU info.")
    @Parameter(name = "ids", description = "SKU code list.", required = true, example = "1024,2048")
    CommonResult<List<ProductSkuRespDTO>> getSkuList(@RequestParam("ids") Collection<Long> ids);

    /**
     * 批量查询 SKU MAP
     *
     * @param ids SKU 编号列表
     * @return SKU MAP
     */
    default Map<Long, ProductSkuRespDTO> getSkuMap(Collection<Long> ids) {
        return convertMap(getSkuList(ids).getCheckedData(), ProductSkuRespDTO::getId);
    }

    @GetMapping(PREFIX + "/list-by-spu-id")
    @Operation(summary = "Batch search SKU info.")
    @Parameter(name = "spuIds", description = "SPU code list.", required = true, example = "1024,2048")
    CommonResult<List<ProductSkuRespDTO>> getSkuListBySpuId(@RequestParam("spuIds") Collection<Long> spuIds);

    @PostMapping(PREFIX + "/update-stock")
    @Operation(summary = "Update SKU inventory (add or subtract).")
    CommonResult<Boolean> updateSkuStock(@RequestBody @Valid ProductSkuUpdateStockReqDTO updateStockReqDTO);

}

package cn.iocoder.yudao.module.promotion.api.combination;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.promotion.api.combination.dto.CombinationRecordCreateReqDTO;
import cn.iocoder.yudao.module.promotion.api.combination.dto.CombinationRecordCreateRespDTO;
import cn.iocoder.yudao.module.promotion.api.combination.dto.CombinationRecordRespDTO;
import cn.iocoder.yudao.module.promotion.api.combination.dto.CombinationValidateJoinRespDTO;
import cn.iocoder.yudao.module.promotion.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - group buy record.")
public interface CombinationRecordApi {

    String PREFIX = ApiConstants.PREFIX + "/combination-record";

    @GetMapping(PREFIX + "/validate")
    @Operation(summary = "Validate meet group-buy condition.")
    @Parameters({
            @Parameter(name = "userId", description = "User ID.", required = true, example = "1024"),
            @Parameter(name = "activityId", description = "Campaign code.", required = true, example = "2048"),
            @Parameter(name = "headId", description = "Group-leader ID.", required = true, example = "4096"),
            @Parameter(name = "skuId", description = "SKU code.", required = true, example = "8192"),
            @Parameter(name = "count", description = "Quantity.", required = true, example = "1"),
    })
    CommonResult<Boolean> validateCombinationRecord(@RequestParam("userId") Long userId,
                                                    @RequestParam("activityId") Long activityId,
                                                    @RequestParam("headId") Long headId,
                                                    @RequestParam("skuId") Long skuId,
                                                    @RequestParam("count") Integer count);

    @PostMapping(PREFIX + "/create")
    @Operation(summary = "Create a group-buy opening record.")
    CommonResult<CombinationRecordCreateRespDTO> createCombinationRecord(
            @RequestBody @Valid CombinationRecordCreateReqDTO reqDTO);

    @GetMapping(PREFIX + "/get-by-order-id")
    @Operation(summary = "Based on order Code, search group-buy record.")
    @Parameters({
            @Parameter(name = "userId", description = "User ID.", required = true, example = "1024"),
            @Parameter(name = "orderId", description = "Order code.", required = true, example = "2048"),
    })
    CommonResult<CombinationRecordRespDTO> getCombinationRecordByOrderId(@RequestParam("userId") Long userId,
                                                                         @RequestParam("orderId") Long orderId);

    @GetMapping(PREFIX + "/validate-join")
    @Operation(summary = "Before checkout, validate group-buy conditions.") // 如果校验失败，则抛出业务异常
    @Parameters({
            @Parameter(name = "userId", description = "User ID.", required = true, example = "1024"),
            @Parameter(name = "activityId", description = "Campaign code.", required = true, example = "2048"),
            @Parameter(name = "headId", description = "Group-leader ID.", example = "4096"), // 如果新发起的团，headId 不用传递
            @Parameter(name = "skuId", description = "SKU code.", required = true, example = "8192"),
            @Parameter(name = "count", description = "Quantity.", required = true, example = "1"),
    })
    CommonResult<CombinationValidateJoinRespDTO> validateJoinCombination(@RequestParam("userId") Long userId,
                                                                         @RequestParam("activityId") Long activityId,
                                                                         @RequestParam(value = "headId", required = false) Long headId,
                                                                         @RequestParam("skuId") Long skuId,
                                                                         @RequestParam("count") Integer count);

}

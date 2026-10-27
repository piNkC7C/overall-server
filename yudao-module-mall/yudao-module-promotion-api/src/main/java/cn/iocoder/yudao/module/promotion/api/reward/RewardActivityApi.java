package cn.iocoder.yudao.module.promotion.api.reward;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.promotion.api.reward.dto.RewardActivityMatchRespDTO;
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
@Tag(name = "RPC service - spend-and-save.")
public interface RewardActivityApi {

    String PREFIX = ApiConstants.PREFIX + "/reward-activity";

    @GetMapping(PREFIX + "/list-by-spu-id")
    @Operation(summary = "Get product match spend-and-save campaign info.")
    @Parameter(name = "spuIds", description = "Product SPU ID list.", required = true, example = "[1, 2]")
    CommonResult<List<RewardActivityMatchRespDTO>> getMatchRewardActivityListBySpuIds(@RequestParam("spuIds") Collection<Long> spuIds);

}

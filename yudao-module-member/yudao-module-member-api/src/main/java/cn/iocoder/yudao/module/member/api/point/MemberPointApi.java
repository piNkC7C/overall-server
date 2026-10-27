package cn.iocoder.yudao.module.member.api.point;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.member.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.constraints.Min;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - user points.")
public interface MemberPointApi {

    String PREFIX = ApiConstants.PREFIX + "/point";

    @PostMapping(PREFIX + "/add")
    @Operation(summary = "Add user points.")
    @Parameters({
            @Parameter(name = "userId", description = "Member code.", required = true, example = "1024"),
            @Parameter(name = "point", description = "Points.", required = true, example = "100"),
            @Parameter(name = "bizType", description = "Business type.", required = true, example = "1"),
            @Parameter(name = "bizId", description = "Business code.", required = true, example = "1")
    })
    CommonResult<Boolean> addPoint(@RequestParam("userId") Long userId,
                                   @RequestParam("point") @Min(value = 1L, message = "Points must be a positive number.") Integer point,
                                   @RequestParam("bizType") Integer bizType,
                                   @RequestParam("bizId") String bizId);

    @PostMapping(PREFIX + "/reducePoint")
    @Operation(summary = "Subtract user points.")
    @Parameters({
            @Parameter(name = "userId", description = "Member code.", required = true, example = "1024"),
            @Parameter(name = "point", description = "Points.", required = true, example = "100"),
            @Parameter(name = "bizType", description = "Business type.", required = true, example = "1"),
            @Parameter(name = "bizId", description = "Business code.", required = true, example = "1")
    })
    CommonResult<Boolean> reducePoint(@RequestParam("userId") Long userId,
                                      @RequestParam("point") @Min(value = 1L, message = "Points must be a positive number.") Integer point,
                                      @RequestParam("bizType") Integer bizType,
                                      @RequestParam("bizId") String bizId);

}

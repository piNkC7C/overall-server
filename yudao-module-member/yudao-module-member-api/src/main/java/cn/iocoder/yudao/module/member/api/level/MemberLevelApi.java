package cn.iocoder.yudao.module.member.api.level;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.member.api.level.dto.MemberLevelRespDTO;
import cn.iocoder.yudao.module.member.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - member level.")
public interface MemberLevelApi {

    String PREFIX = ApiConstants.PREFIX + "/level";

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Get member level.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    CommonResult<MemberLevelRespDTO> getMemberLevel(@RequestParam("id") Long id);

    @PostMapping(PREFIX + "/add")
    @Operation(summary = "Add member XP.")
    @Parameters({
            @Parameter(name = "userId", description = "Member code.", required = true, example = "1024"),
            @Parameter(name = "experience", description = "XP.", required = true, example = "100"),
            @Parameter(name = "bizType", description = "Business type.", required = true, example = "1"),
            @Parameter(name = "bizId", description = "Business code.", required = true, example = "1")
    })
    CommonResult<Boolean> addExperience(@RequestParam("userId") Long userId,
                                        @RequestParam("experience") Integer experience,
                                        @RequestParam("bizType") Integer bizType,
                                        @RequestParam("bizId") String bizId);

    @PostMapping(PREFIX + "/reduce")
    @Operation(summary = "Deduct member XP.")
    @Parameters({
            @Parameter(name = "userId", description = "Member code.", required = true, example = "1024"),
            @Parameter(name = "experience", description = "XP.", required = true, example = "100"),
            @Parameter(name = "bizType", description = "Business type.", required = true, example = "1"),
            @Parameter(name = "bizId", description = "Business code.", required = true, example = "1")
    })
    CommonResult<Boolean> reduceExperience(@RequestParam("userId") Long userId,
                                           @RequestParam("experience") Integer experience,
                                           @RequestParam("bizType") Integer bizType,
                                           @RequestParam("bizId") String bizId);

}

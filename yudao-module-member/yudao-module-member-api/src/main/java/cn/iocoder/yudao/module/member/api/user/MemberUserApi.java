package cn.iocoder.yudao.module.member.api.user;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.member.api.user.dto.MemberUserRespDTO;
import cn.iocoder.yudao.module.member.enums.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMap;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - memberuser.")
public interface MemberUserApi {

    String PREFIX = ApiConstants.PREFIX + "/user";

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Get memberuser info.")
    @Parameter(name = "id", description = "Code.", required = true, example = "1024")
    CommonResult<MemberUserRespDTO> getUser(@RequestParam("id") Long id);

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "Get member user info list.")
    @Parameter(name = "ids", description = "User ID Array.", example = "1,2", required = true)
    CommonResult<List<MemberUserRespDTO>> getUserList(@RequestParam("ids") Collection<Long> ids);

    /**
     * 获得会员用户 Map
     *
     * @param ids 用户编号的数组
     * @return 会员用户 Map
     */
    default Map<Long, MemberUserRespDTO> getUserMap(Collection<Long> ids) {
        List<MemberUserRespDTO> list = getUserList(ids).getCheckedData();
        return convertMap(list, MemberUserRespDTO::getId);
    }

    @GetMapping(PREFIX + "/list-by-nickname")
    @Operation(summary = "Based onnickname, fuzzy matchuserlist.")
    @Parameter(name = "nickname", description = "Nickname, fuzzy match.", required = true, example = "Potato.")
    CommonResult<List<MemberUserRespDTO>> getUserListByNickname(@RequestParam("nickname") String nickname);

    @GetMapping(PREFIX + "/get-by-mobile")
    @Operation(summary = "Exact-match a user by phone number.")
    @Parameter(name = "mobile", description = "Match a user exactly by phone number.", required = true, example = "1560")
    CommonResult<MemberUserRespDTO> getUserByMobile(@RequestParam("mobile") String mobile);

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "Validate user exists.")
    @Parameter(name = "id", description = "User ID.", required = true, example = "1")
    CommonResult<Boolean> validateUser(@RequestParam("id") Long id);

}

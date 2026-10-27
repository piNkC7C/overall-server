package cn.iocoder.yudao.module.system.api.user;

import cn.hutool.core.convert.Convert;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.collection.CollectionUtils;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import cn.iocoder.yudao.module.system.enums.ApiConstants;
import org.dromara.core.trans.anno.AutoTrans;
import org.dromara.trans.service.AutoTransable;
import feign.FeignIgnore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.module.system.api.user.AdminUserApi.PREFIX;

@FeignClient(name = ApiConstants.NAME) // TODO Overall：fallbackFactory =
@Tag(name = "RPC service - adminuser.")
@AutoTrans(namespace = PREFIX, fields = {"nickname"})
public interface AdminUserApi extends AutoTransable<AdminUserRespDTO> {

    String PREFIX = ApiConstants.PREFIX + "/user";

    @GetMapping(PREFIX + "/get")
    @Operation(summary = "Via user ID searchuser.")
    @Parameter(name = "id", description = "User ID.", example = "1", required = true)
    CommonResult<AdminUserRespDTO> getUser(@RequestParam("id") Long id);

    @GetMapping(PREFIX + "/get-by-mobile")
    @Operation(summary = "Via phone numbersearchuser.")
    CommonResult<AdminUserRespDTO> getUserByMobile(@RequestParam("mobile") String mobile);

    @GetMapping(PREFIX + "/list-by-subordinate")
    @Operation(summary = "Via user ID search user reports.")
    @Parameter(name = "id", description = "User ID.", example = "1", required = true)
    CommonResult<List<AdminUserRespDTO>> getUserListBySubordinate(@RequestParam("id") Long id);

    @GetMapping(PREFIX + "/list")
    @Operation(summary = "Via user ID search user.")
    @Parameter(name = "ids", description = "Department ID list.", example = "1,2", required = true)
    CommonResult<List<AdminUserRespDTO>> getUserList(@RequestParam("ids") Collection<Long> ids);

    @GetMapping(PREFIX + "/list-by-dept-id")
    @Operation(summary = "Get specified department userArray.")
    @Parameter(name = "deptIds", description = "Department ID list.", example = "1,2", required = true)
    CommonResult<List<AdminUserRespDTO>> getUserListByDeptIds(@RequestParam("deptIds") Collection<Long> deptIds);

    @GetMapping(PREFIX + "/list-by-post-id")
    @Operation(summary = "Get specified post userArray.")
    @Parameter(name = "postIds", description = "Post ID list.", example = "2,3", required = true)
    CommonResult<List<AdminUserRespDTO>> getUserListByPostIds(@RequestParam("postIds") Collection<Long> postIds);

    @GetMapping(PREFIX + "/list-by-nickname")
    @Operation(summary = "By nickname fuzzy search user.")
    @Parameter(name = "nickname", description = "NicknameKeyword.", example = "Overall.", required = true)
    CommonResult<List<AdminUserRespDTO>> getUserListByNickname(@RequestParam("nickname") String nickname);

    @GetMapping(PREFIX + "/list-by-status")
    @Operation(summary = "Get specified status user list.")
    @Parameter(name = "status", description = "User status.", required = true, example = "0")
    CommonResult<List<AdminUserRespDTO>> getUserListByStatus(@RequestParam("status") Integer status);

    /**
     * 获得用户 Map
     *
     * @param ids 用户编号数组
     * @return 用户 Map
     */
    default Map<Long, AdminUserRespDTO> getUserMap(Collection<Long> ids) {
        List<AdminUserRespDTO> users = getUserList(ids).getCheckedData();
        return CollectionUtils.convertMap(users, AdminUserRespDTO::getId);
    }

    /**
     * 校验用户是否有效。如下情况，视为无效：
     * 1. 用户编号不存在
     * 2. 用户被禁用
     *
     * @param id 用户编号
     * @return 校验通过的用户信息
     */
    default AdminUserRespDTO validateUser(Long id) {
        validateUserList(Collections.singleton(id)).checkError();
        return getUser(id).getCheckedData();
    }

    @GetMapping(PREFIX + "/valid")
    @Operation(summary = "Validate user is valid.")
    @Parameter(name = "ids", description = "User ID list.", example = "3,5", required = true)
    CommonResult<Boolean> validateUserList(@RequestParam("ids") Collection<Long> ids);

    @Override
    @FeignIgnore
    default List<AdminUserRespDTO> selectByIds(List<?> ids) {
        return getUserList(Convert.toList(Long.class, ids)).getCheckedData();
    }

    @Override
    @FeignIgnore
    default AdminUserRespDTO selectById(Object id) {
        return getUser(Convert.toLong(id)).getCheckedData();
    }

}

package cn.iocoder.yudao.module.im.controller.admin.friend;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.common.util.string.StrUtils;
import cn.iocoder.yudao.module.im.controller.admin.friend.vo.ImFriendRespVO;
import cn.iocoder.yudao.module.im.controller.admin.friend.vo.ImFriendUpdateReqVO;
import cn.iocoder.yudao.module.im.dal.dataobject.friend.ImFriendDO;
import cn.iocoder.yudao.module.im.service.friend.ImFriendService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.singleton;
import static cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - IM contact.")
@RestController
@RequestMapping("/im/friend")
@Validated
public class ImFriendController {

    @Resource
    private ImFriendService friendService;

    @Resource
    private AdminUserApi adminUserApi;

    @GetMapping("/list")
    @Operation(summary = "Get current sign-in user contact list.")
    public CommonResult<List<ImFriendRespVO>> getMyFriendList() {
        List<ImFriendDO> friends = friendService.getFriendList(getLoginUserId());
        return success(buildFriendRespVOList(friends));
    }

    @GetMapping("/pull")
    @Operation(summary = "Incrementally fetch the current user's friends (reconnect / offline catch-up).")
    @Parameters({
            @Parameter(name = "lastUpdateTime", description = "Last update time in ms. Omit on the first fetch."),
            @Parameter(name = "lastId", description = "Last record ID. Omit on the first fetch."),
            @Parameter(name = "limit", description = "Page size.", required = true)
    })
    public CommonResult<List<ImFriendRespVO>> pullMyFriendList(
            @RequestParam(value = "lastUpdateTime", required = false) Long lastUpdateTime,
            @RequestParam(value = "lastId", required = false) Long lastId,
            @RequestParam("limit") @Min(1) @Max(200) Integer limit) {
        List<ImFriendDO> list = friendService.pullFriendList(getLoginUserId(), lastUpdateTime, lastId, limit);
        return success(buildFriendRespVOList(list));
    }

    @GetMapping("/get")
    @Operation(summary = "Get contact details.")
    @Parameter(name = "friendUserId", description = "Contact user ID.", required = true, example = "2048")
    public CommonResult<ImFriendRespVO> getFriend(@RequestParam("friendUserId") Long friendUserId) {
        ImFriendDO friend = friendService.getFriend(getLoginUserId(), friendUserId);
        return success(buildFriendRespVO(friend));
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete a friend (one-way soft delete).")
    @Parameters({
            @Parameter(name = "friendUserId", description = "Contact user ID.", required = true, example = "2048"),
            @Parameter(name = "clear", description = "Whether to cascade-clean local data such as the DM conversation.")
    })
    public CommonResult<Boolean> deleteFriend(
            @RequestParam("friendUserId") @NotNull(message = "Contact user ID is required.") Long friendUserId,
            @RequestParam(value = "clear", required = false) Boolean clear) {
        friendService.deleteFriend(getLoginUserId(), friendUserId, clear);
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "Update one-sided friend attributes (remark / mute / pin).")
    public CommonResult<Boolean> updateFriend(@Valid @RequestBody ImFriendUpdateReqVO reqVO) {
        friendService.updateFriend(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/block")
    @Operation(summary = "Block a friend. Must already be friends. One-sided mute of their DMs.")
    @Parameter(name = "friendUserId", description = "Contact user ID.", required = true, example = "2048")
    public CommonResult<Boolean> blockFriend(
            @RequestParam("friendUserId") @NotNull(message = "Contact user ID is required.") Long friendUserId) {
        friendService.blockFriend(getLoginUserId(), friendUserId);
        return success(true);
    }

    @PutMapping("/unblock")
    @Operation(summary = "Remove from the blocklist.")
    @Parameter(name = "friendUserId", description = "Contact user ID.", required = true, example = "2048")
    public CommonResult<Boolean> unblockFriend(
            @RequestParam("friendUserId") @NotNull(message = "Contact user ID is required.") Long friendUserId) {
        friendService.unblockFriend(getLoginUserId(), friendUserId);
        return success(true);
    }

    // ========== 私有方法：VO 组装 ==========

    private List<ImFriendRespVO> buildFriendRespVOList(Collection<ImFriendDO> friends) {
        if (CollUtil.isEmpty(friends)) {
            return Collections.emptyList();
        }
        // 批量聚合 AdminUser 信息（昵称 / 头像），避免 N+1
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(
                convertList(friends, ImFriendDO::getFriendUserId));
        return convertList(friends, friend -> {
            ImFriendRespVO vo = BeanUtils.toBean(friend, ImFriendRespVO.class);
            MapUtils.findAndThen(userMap, friend.getFriendUserId(), user ->
                    vo.setNickname(user.getNickname()).setAvatar(user.getAvatar()));
            // 备注 / 昵称的拼音，给前端做字母分桶 + 拼音搜索
            vo.setDisplayNamePinyin(StrUtils.toPinyin(vo.getDisplayName()))
                    .setNicknamePinyin(StrUtils.toPinyin(vo.getNickname()));
            return vo;
        });
    }

    private ImFriendRespVO buildFriendRespVO(ImFriendDO friend) {
        if (friend == null) {
            return null;
        }
        return CollUtil.getFirst(buildFriendRespVOList(singleton(friend)));
    }

}

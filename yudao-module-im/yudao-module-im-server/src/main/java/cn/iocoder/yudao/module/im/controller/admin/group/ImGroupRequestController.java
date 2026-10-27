package cn.iocoder.yudao.module.im.controller.admin.group;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.collection.MapUtils;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.im.controller.admin.group.vo.request.ImGroupRequestApplyReqVO;
import cn.iocoder.yudao.module.im.controller.admin.group.vo.request.ImGroupRequestRespVO;
import cn.iocoder.yudao.module.im.dal.dataobject.group.ImGroupDO;
import cn.iocoder.yudao.module.im.dal.dataobject.group.ImGroupMemberDO;
import cn.iocoder.yudao.module.im.dal.dataobject.group.ImGroupRequestDO;
import cn.iocoder.yudao.module.im.enums.group.ImGroupMemberRoleEnum;
import cn.iocoder.yudao.module.im.service.group.ImGroupMemberService;
import cn.iocoder.yudao.module.im.service.group.ImGroupRequestService;
import cn.iocoder.yudao.module.im.service.group.ImGroupService;
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
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.*;
import static cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils.getLoginUserId;

/**
 * IM 加群申请 Controller
 *
 * @author 芋道源码
 */
@Tag(name = "Admin - IM join-group request.")
@RestController
@RequestMapping("/im/group-request")
@Validated
public class ImGroupRequestController {

    @Resource
    private ImGroupRequestService groupRequestService;
    @Resource
    private ImGroupService groupService;
    @Resource
    private ImGroupMemberService groupMemberService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/apply")
    @Operation(summary = "Request to join a group.")
    public CommonResult<Long> applyJoinGroup(@Valid @RequestBody ImGroupRequestApplyReqVO reqVO) {
        ImGroupRequestDO request = groupRequestService.applyJoinGroup(getLoginUserId(), reqVO);
        return success(request != null ? request.getId() : null);
    }

    @PutMapping("/agree")
    @Operation(summary = "Approve a join request (owner or admin).")
    @Parameter(name = "id", description = "Apply please code.", required = true, example = "1024")
    public CommonResult<Boolean> agreeGroupRequest(
            @RequestParam("id") @NotNull(message = "Apply please code is required.") Long id) {
        groupRequestService.agreeGroupRequest(getLoginUserId(), id);
        return success(true);
    }

    @PutMapping("/refuse")
    @Operation(summary = "Reject a join request (owner or admin).")
    public CommonResult<Boolean> refuseGroupRequest(
            @RequestParam("id") @NotNull(message = "Apply please code is required.") Long id,
            @RequestParam(value = "handleContent", required = false)
            @Size(max = 255, message = "Handle reason cannot exceed 255 characters.") String handleContent) {
        groupRequestService.refuseGroupRequest(getLoginUserId(), id, handleContent);
        return success(true);
    }

    @GetMapping("/unhandled-list")
    @Operation(summary = "List pending join requests for groups I manage (not paged). The client store uses this for the banner badge and drawer.")
    public CommonResult<List<ImGroupRequestRespVO>> getUnhandledRequestList() {
        List<ImGroupRequestDO> list = groupRequestService.getUnhandledRequestListByOwnerOrAdmin(getLoginUserId());
        return success(buildVOList(list));
    }

    @GetMapping("/pull")
    @Operation(summary = "Incrementally fetch join requests for groups I manage (reconnect / offline catch-up).")
    @Parameters({
            @Parameter(name = "lastUpdateTime", description = "Last update time in ms. Omit on the first fetch."),
            @Parameter(name = "lastId", description = "Last record ID. Omit on the first fetch."),
            @Parameter(name = "limit", description = "Page size.", required = true)
    })
    public CommonResult<List<ImGroupRequestRespVO>> pullMyGroupRequestList(
            @RequestParam(value = "lastUpdateTime", required = false) Long lastUpdateTime,
            @RequestParam(value = "lastId", required = false) Long lastId,
            @RequestParam("limit") @Min(1) @Max(200) Integer limit) {
        List<ImGroupRequestDO> list = groupRequestService.pullGroupRequestList(
                getLoginUserId(), lastUpdateTime, lastId, limit);
        return success(buildVOList(list));
    }

    @GetMapping("/list-by-group")
    @Operation(summary = "List all join requests for a group, including processed ones. Owner or admin only.")
    @Parameter(name = "groupId", description = "Group ID", required = true, example = "1024")
    public CommonResult<List<ImGroupRequestRespVO>> getGroupRequestListByGroupId(
            @RequestParam("groupId") @NotNull(message = "Group ID is required") Long groupId) {
        List<ImGroupRequestDO> list = groupRequestService.getGroupRequestListByGroupId(getLoginUserId(), groupId);
        return success(buildVOList(list));
    }

    @GetMapping("/get")
    @Operation(summary = "Get one request by ID, with access checks. Use after the WebSocket notice arrives.")
    @Parameter(name = "id", description = "Apply please record code.", required = true)
    public CommonResult<ImGroupRequestRespVO> getGroupRequest(@RequestParam("id") Long id) {
        ImGroupRequestDO request = groupRequestService.getGroupRequest(id);
        if (request == null) {
            return success(null);
        }
        // 越权过滤：申请人 / 邀请人 / 群主 / 管理员之外，当不存在返回 null
        Long currentUserId = getLoginUserId();
        boolean canSee = ObjUtil.equal(request.getUserId(), currentUserId)
                || ObjUtil.equal(request.getInviterUserId(), currentUserId)
                || isGroupOwnerOrAdmin(request.getGroupId(), currentUserId);
        if (!canSee) {
            return success(null);
        }

        // 转换并返回
        return success(CollUtil.getFirst(buildVOList(Collections.singletonList(request))));
    }

    /**
     * 当前用户是否该群的有效群主 / 管理员
     */
    private boolean isGroupOwnerOrAdmin(Long groupId, Long userId) {
        ImGroupMemberDO member = groupMemberService.getGroupMember(groupId, userId);
        return member != null
                && !CommonStatusEnum.DISABLE.getStatus().equals(member.getStatus())
                && ImGroupMemberRoleEnum.isOwnerOrAdmin(member.getRole());
    }

    /** 申请记录列表批量转 VO + 关联回填用户 / 群信息 */
    private List<ImGroupRequestRespVO> buildVOList(List<ImGroupRequestDO> list) {
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }
        // 1. 聚合 user / inviter 用户信息；convertSetByFlatMap 内部已过滤 null
        Set<Long> userIds = convertSetByFlatMap(list,
                request -> Stream.of(request.getUserId(), request.getInviterUserId()));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(userIds);
        // 2. 聚合群信息（封禁 / 解散群也要回填，便于前端展示历史）
        Set<Long> groupIds = convertSet(list, ImGroupRequestDO::getGroupId);
        Map<Long, ImGroupDO> groupMap = groupService.getGroupMap(groupIds);
        return convertList(list, request -> {
            ImGroupRequestRespVO vo = BeanUtils.toBean(request, ImGroupRequestRespVO.class);
            MapUtils.findAndThen(userMap, request.getUserId(), user ->
                    vo.setUserNickname(user.getNickname()).setUserAvatar(user.getAvatar()));
            MapUtils.findAndThen(userMap, request.getInviterUserId(), user ->
                    vo.setInviterNickname(user.getNickname()).setInviterAvatar(user.getAvatar()));
            MapUtils.findAndThen(groupMap, request.getGroupId(), group ->
                    vo.setGroupName(group.getName()).setGroupAvatar(group.getAvatar()));
            return vo;
        });
    }

}

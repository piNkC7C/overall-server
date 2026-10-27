package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.comment.PmsWorkItemCommentRespVO;
import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.comment.PmsWorkItemCommentSaveReqVO;
import cn.iocoder.yudao.module.pms.dal.dataobject.pm.workitem.PmsWorkItemCommentDO;
import cn.iocoder.yudao.module.pms.service.pm.workitem.PmsWorkItemCommentService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.api.user.dto.AdminUserRespDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.common.util.collection.MapUtils.findAndThen;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - PMS work item comment.")
@RestController
@RequestMapping("/pms/pm/work-item-comment")
@Validated
public class PmsWorkItemCommentController {

    @Resource
    private PmsWorkItemCommentService commentService;

    @Resource
    private AdminUserApi adminUserApi;

    @PostMapping("/create")
    @Operation(summary = "Create work item comment.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Long> createWorkItemComment(@Valid @RequestBody PmsWorkItemCommentSaveReqVO saveReqVO) {
        return success(commentService.createWorkItemComment(saveReqVO, getLoginUserId()));
    }

    @PutMapping("/update")
    @Operation(summary = "Edit work item comment.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> updateWorkItemComment(@Valid @RequestBody PmsWorkItemCommentSaveReqVO saveReqVO) {
        commentService.updateWorkItemComment(saveReqVO, getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete work item comment.")
    @Parameter(name = "id", description = "Comment code.", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:update')")
    public CommonResult<Boolean> deleteWorkItemComment(@RequestParam("id") Long id) {
        commentService.deleteWorkItemComment(id, getLoginUserId());
        return success(true);
    }

    @GetMapping("/list")
    @Operation(summary = "Get work item comment list.")
    @PreAuthorize("@ss.hasPermission('pms:pm:work-item:query')")
    public CommonResult<List<PmsWorkItemCommentRespVO>> getWorkItemCommentList(
            @RequestParam("workItemId") Long workItemId) {
        List<PmsWorkItemCommentDO> comments = commentService.getWorkItemCommentList(workItemId, getLoginUserId());
        // 拼接 VO：批量查询评论人和回复对象
        Set<Long> userIds = convertSet(comments, PmsWorkItemCommentDO::getUserId);
        userIds.addAll(convertSet(comments, PmsWorkItemCommentDO::getReplyUserId));
        Map<Long, AdminUserRespDTO> userMap = adminUserApi.getUserMap(userIds);
        // 拼接 VO：转换评论，并按主评论组织回复列表
        Map<Long, PmsWorkItemCommentRespVO> mainCommentMap = new LinkedHashMap<>();
        List<PmsWorkItemCommentRespVO> mainComments = new ArrayList<>();
        for (PmsWorkItemCommentDO comment : comments) {
            PmsWorkItemCommentRespVO commentVO = BeanUtils.toBean(comment, PmsWorkItemCommentRespVO.class).setChildren(new ArrayList<>());
            findAndThen(userMap, comment.getUserId(), user -> commentVO.setUserName(user.getNickname()));
            findAndThen(userMap, comment.getReplyUserId(), user -> commentVO.setReplyUserName(user.getNickname()));
            if (PmsWorkItemCommentDO.MAIN_ID_ROOT.equals(comment.getMainId())) {
                mainCommentMap.put(comment.getId(), commentVO);
                mainComments.add(commentVO);
            } else {
                PmsWorkItemCommentRespVO mainComment = mainCommentMap.get(comment.getMainId());
                if (mainComment != null) {
                    mainComment.getChildren().add(commentVO);
                }
            }
        }
        return success(mainComments);
    }

}

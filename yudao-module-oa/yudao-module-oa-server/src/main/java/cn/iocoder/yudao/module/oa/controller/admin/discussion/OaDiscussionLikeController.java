package cn.iocoder.yudao.module.oa.controller.admin.discussion;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.like.OaDiscussionLikeReqVO;
import cn.iocoder.yudao.module.oa.service.discussion.OaDiscussionLikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "Admin - OA discussion like.")
@RestController
@RequestMapping("/oa/discussion-like")
@Validated
public class OaDiscussionLikeController {

    @Resource
    private OaDiscussionLikeService discussionLikeService;

    @PostMapping("/create")
    @Operation(summary = "Like discussion or top-level reply.")
    public CommonResult<Boolean> createDiscussionLike(@Valid @RequestBody OaDiscussionLikeReqVO reqVO) {
        discussionLikeService.createDiscussionLike(reqVO.getDiscussionId(), reqVO.getReplyId(), getLoginUserId());
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Unlike discussion or top-level reply.")
    public CommonResult<Boolean> deleteDiscussionLike(@Valid OaDiscussionLikeReqVO reqVO) {
        discussionLikeService.deleteDiscussionLike(reqVO.getDiscussionId(), reqVO.getReplyId(), getLoginUserId());
        return success(true);
    }

}

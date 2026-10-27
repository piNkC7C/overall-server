package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.reply;

import cn.iocoder.yudao.framework.common.pojo.SortablePageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "OA discussion reply page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class OaDiscussionReplyPageReqVO extends SortablePageParam {

    @Schema(description = "Discussion ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Discussion ID is required.")
    private Long discussionId;

    @Schema(description = "Reply person user ID.", example = "1")
    private Long userId;

}

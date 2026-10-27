package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.reply;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.AssertTrue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Schema(description = "OA discussion reply create request VO.")
@Data
public class OaDiscussionReplyCreateReqVO {

    @Schema(description = "Discussion ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Discussion ID is required.")
    private Long discussionId;

    @Schema(description = "Parent reply code.", example = "0")
    private Long parentId;

    @Schema(description = "Reply content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Received. Will finish on time.")
    @NotBlank(message = "Reply content is required.")
    private String content;

    /**
     * 楼内评论对齐源端 255 字限制，根回复使用 TEXT 正文。
     *
     * @return 评论长度是否合法
     */
    @AssertTrue(message = "In-building comment cannot exceed 255 characters.")
    @JsonIgnore
    public boolean isCommentLengthValid() {
        return parentId == null || parentId == 0L || content == null || content.length() <= 255;
    }

}

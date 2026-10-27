package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.like;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import lombok.Data;

@Schema(description = "OA discussion like request VO.")
@Data
public class OaDiscussionLikeReqVO {

    @Schema(description = "Discussion ID, and reply code must and can only enter one.", example = "1024")
    private Long discussionId;

    @Schema(description = "Reply code, and Discussion ID must and can only enter one.", example = "2048")
    private Long replyId;

    @JsonIgnore
    @AssertTrue(message = "Discussion ID and reply code must and can only enter one.")
    @Schema(hidden = true)
    public boolean isTargetValid() {
        if (discussionId != null) {
            return replyId == null;
        }
        return replyId != null;
    }

}

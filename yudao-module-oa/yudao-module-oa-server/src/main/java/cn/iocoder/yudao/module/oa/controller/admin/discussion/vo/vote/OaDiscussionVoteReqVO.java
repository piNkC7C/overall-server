package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.vote;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "OA discussion vote request VO.")
@Data
public class OaDiscussionVoteReqVO {

    @Schema(description = "Discussion ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Discussion ID is required.")
    private Long discussionId;

    @Schema(description = "Poll option IDlist.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    @NotEmpty(message = "Poll options cannot be empty.")
    private List<@NotNull(message = "Poll option ID cannot be empty.") Long> optionIds;

}

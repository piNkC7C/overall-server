package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.vote;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - OA 讨论投票 Request VO")
@Data
public class OaDiscussionVoteReqVO {

    @Schema(description = "讨论编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Discussion ID is required.")
    private Long discussionId;

    @Schema(description = "投票选项编号列表", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    @NotEmpty(message = "Poll options cannot be empty.")
    private List<@NotNull(message = "Poll option ID cannot be empty.") Long> optionIds;

}

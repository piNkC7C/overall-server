package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.discussion;

import cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.vote.OaVoteOptionRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "OA discussion response VO.")
@Data
public class OaDiscussionRespVO {

    @Schema(description = "Discussion ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Publisher user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Publisher nickname.", example = "Overall.")
    private String userName;

    @Schema(description = "Discussion Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Vote for next week's team meeting")
    private String title;

    @Schema(description = "Content.", example = "Please share your availability for next week's team meeting.")
    private String content;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<String> fileUrls;

    @Schema(description = "Visit count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer visitCount;

    @Schema(description = "Reply count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer replyCount;

    @Schema(description = "Like count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer likeCount;

    @Schema(description = "Current user is not already Like.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean liked;

    @Schema(description = "Like person nickname list.", example = "[\"John\", \"Jane\"]")
    private List<String> likeUserNames;

    @Schema(description = "Allow multiple votes.", example = "false")
    private Boolean voteMultiple;

    @Schema(description = "Vote start time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime voteStartTime;

    @Schema(description = "Vote end time.", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime voteEndTime;

    @Schema(description = "Poll options list.")
    private List<OaVoteOptionRespVO> voteOptions;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}

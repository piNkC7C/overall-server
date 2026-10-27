package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.reply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "OA discussion reply response VO.")
@Data
public class OaDiscussionReplyRespVO {

    @Schema(description = "Reply code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Discussion ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long discussionId;

    @Schema(description = "Reply person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Reply person nickname.", example = "Overall.")
    private String userName;

    @Schema(description = "Parent reply code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Long parentId;

    @Schema(description = "By reply person user ID.", example = "2")
    private Long replyUserId;

    @Schema(description = "By reply person nickname.", example = "Admin.")
    private String replyUserName;

    @Schema(description = "Reply content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Received. Will finish on time.")
    private String content;

    @Schema(description = "Like count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer likeCount;

    @Schema(description = "Current user is not already Like.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean liked;

    @Schema(description = "Like person nickname list.", example = "[\"John\", \"Jane\"]")
    private List<String> likeUserNames;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

    @Schema(description = "Child replies in the floor.")
    private List<OaDiscussionReplyRespVO> children;

}

package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.vote;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - OA Poll options response.")
@Data
public class OaVoteOptionRespVO {

    @Schema(description = "Poll option ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Option title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Friday afternoon")
    private String title;

    @Schema(description = "Option color.", example = "#409EFF")
    private String color;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer sort;

    @Schema(description = "Vote count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Integer voteCount;

    @Schema(description = "Current user is not already select.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean voted;

    @Schema(description = "Votersnicknamelist.", example = "[\"John\", \"Jane\"]")
    private List<String> voterUserNames;

}

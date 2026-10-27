package cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.discussion;

import cn.iocoder.yudao.module.oa.controller.admin.discussion.vo.vote.OaVoteOptionSaveReqVO;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.discussion.OaDiscussionTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "OA discussion create / update request VO.")
@Data
public class OaDiscussionSaveReqVO {

    @Schema(description = "Discussion ID", example = "1024")
    private Long id;

    @Schema(description = "Discussion Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Discussion Type is required.")
    @InEnum(value = OaDiscussionTypeEnum.class, message = "Discussion Type must be {value}.")
    private Integer type;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Vote for next week's team meeting")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title length cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Content.", example = "Please share your availability for next week's team meeting.")
    private String content;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 512, message = "AttachmentAddress length cannot exceed 512 characters.") String> fileUrls;

    @Schema(description = "Allow multiple votes.", example = "false")
    private Boolean voteMultiple;

    @Schema(description = "Vote start time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime voteStartTime;

    @Schema(description = "Vote end time.", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime voteEndTime;

    @Schema(description = "Poll options list.")
    @Valid
    private List<@NotNull(message = "Poll options cannot be empty.") OaVoteOptionSaveReqVO> voteOptions;

    @JsonIgnore
    @AssertTrue(message = "A poll needs at least two options and valid start and end times.")
    @Schema(hidden = true)
    public boolean isVoteConfigValid() {
        if (ObjectUtil.notEqual(OaDiscussionTypeEnum.VOTE.getType(), type)) {
            return true;
        }
        if (voteMultiple == null || voteStartTime == null || voteEndTime == null) {
            return false;
        }
        return voteEndTime.isAfter(voteStartTime) && CollUtil.size(voteOptions) >= 2;
    }

}

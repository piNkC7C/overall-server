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

@Schema(description = "管理后台 - OA 讨论新增/修改 Request VO")
@Data
public class OaDiscussionSaveReqVO {

    @Schema(description = "讨论编号", example = "1024")
    private Long id;

    @Schema(description = "讨论类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Discussion Type is required.")
    @InEnum(value = OaDiscussionTypeEnum.class, message = "Discussion Type must be {value}.")
    private Integer type;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Vote for next week's team meeting")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title length cannot exceed 255 characters.")
    private String title;

    @Schema(description = "内容", example = "Please share your availability for next week's team meeting.")
    private String content;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 512, message = "AttachmentAddress length cannot exceed 512 characters.") String> fileUrls;

    @Schema(description = "投票是否允许多选", example = "false")
    private Boolean voteMultiple;

    @Schema(description = "投票开始时间", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime voteStartTime;

    @Schema(description = "投票结束时间", type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime voteEndTime;

    @Schema(description = "投票选项列表")
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

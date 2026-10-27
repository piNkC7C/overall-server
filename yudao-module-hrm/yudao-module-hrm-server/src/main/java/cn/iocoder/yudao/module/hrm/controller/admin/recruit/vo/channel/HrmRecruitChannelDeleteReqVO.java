package cn.iocoder.yudao.module.hrm.controller.admin.recruit.vo.channel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - HRM Recruiting Channeldelete request.")
@Data
public class HrmRecruitChannelDeleteReqVO {

    @Schema(description = "Recruiting-channel IDs to delete.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Recruiting-channel IDs to delete cannot be empty.")
    private Long id;

    @Schema(description = "Receiving recruiting-channel ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1025")
    @NotNull(message = "Receiving recruiting-channel ID cannot be empty.")
    private Long transferChannelId;

}

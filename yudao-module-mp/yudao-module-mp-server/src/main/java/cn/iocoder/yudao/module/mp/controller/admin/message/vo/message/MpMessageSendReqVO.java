package cn.iocoder.yudao.module.mp.controller.admin.message.vo.message;

import cn.iocoder.yudao.module.mp.dal.dataobject.message.MpMessageDO;
import cn.iocoder.yudao.module.mp.framework.mp.core.util.MpUtils.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Schema(description = "Admin - Official Accountmessage send request.")
@Data
public class MpMessageSendReqVO {

    @Schema(description = "Official Accountfollower code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Official Accountfollower code is required.")
    private Long userId;

    // ========== message content ==========

    @Schema(description = "Message type TEXT/IMAGE/VOICE/VIDEO/NEWS.", requiredMode = Schema.RequiredMode.REQUIRED, example = "text")
    @NotEmpty(message = "Message type is required.")
    public String type;

    @Schema(description = "Message content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi there")
    @NotEmpty(message = "Message content is required.", groups = TextMessageGroup.class)
    private String content;

    @Schema(description = "Media ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "qqc_2Fot30Jse-HDoZmo5RrUDijz2nGUkP")
    @NotEmpty(message = "Message content is required.", groups = {ImageMessageGroup.class, VoiceMessageGroup.class, VideoMessageGroup.class})
    private String mediaId;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Has no title.")
    @NotEmpty(message = "Message content is required.", groups = VideoMessageGroup.class)
    private String title;

    @Schema(description = "Description", requiredMode = Schema.RequiredMode.REQUIRED, example = "Example.")
    @NotEmpty(message = "MessageDescription is required.", groups = VideoMessageGroup.class)
    private String description;

    @Schema(description = "Thumbnail media ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "qqc_2Fot30Jse-HDoZmo5RrUDijz2nGUkP")
    @NotEmpty(message = "Thumbnail media ID cannot be empty.", groups = MusicMessageGroup.class)
    private String thumbMediaId;

    @Schema(description = "News message.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotNull(message = "News message cannot be empty.", groups = NewsMessageGroup.class)
    private List<MpMessageDO.Article> articles;

    @Schema(description = "Music URL. Used when the message type is MUSIC.", example = "https://www.iocoder.cn/music.mp3")
    private String musicUrl;

    @Schema(description = "HQ music URL. Used when the message type is MUSIC.", example = "https://www.iocoder.cn/music.mp3")
    private String hqMusicUrl;

}

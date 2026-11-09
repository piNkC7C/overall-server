package cn.iocoder.yudao.module.mp.controller.admin.message.vo.autoreply;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.module.mp.dal.dataobject.message.MpMessageDO;
import cn.iocoder.yudao.module.mp.enums.message.MpAutoReplyTypeEnum;
import cn.iocoder.yudao.module.mp.framework.mp.core.util.MpUtils.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.common.api.WxConsts;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * 公众号自动回复  Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MpAutoReplyBaseVO {

    @Schema(description = "回复类型 参见 MpAutoReplyTypeEnum 枚举", example = "1")
    @NotNull(message = "Reply type is required.")
    private Integer type;

    // ==================== 请求消息 ====================

    @Schema(description = "请求的关键字 当 type 为 MpAutoReplyTypeEnum#KEYWORD 时，必填", example = "Keyword")
    private String requestKeyword;
    @Schema(description = "请求的匹配方式 当 type 为 MpAutoReplyTypeEnum#KEYWORD 时，必填", example = "1")
    private Integer requestMatch;

    @Schema(description = "请求的消息类型 当 type 为 MpAutoReplyTypeEnum#MESSAGE 时，必填", example = "text")
    private String requestMessageType;

    // ==================== 响应消息 ====================

    @Schema(description = "回复的消息类型 枚举 TEXT、IMAGE、VOICE、VIDEO、NEWS、MUSIC", example = "text")
    @NotEmpty(message = "Reply message type is required.")
    private String responseMessageType;

    @Schema(description = "回复的消息内容", example = "Thanks for following")
    @NotEmpty(message = "Reply message content is required.", groups = TextMessageGroup.class)
    private String responseContent;

    @Schema(description = "回复的媒体 id", example = "123456")
    @NotEmpty(message = "Reply message mediaId is required.",
            groups = {ImageMessageGroup.class, VoiceMessageGroup.class, VideoMessageGroup.class})
    private String responseMediaId;
    @Schema(description = "回复的媒体 URL", example = "https://www.iocoder.cn/xxx.jpg")
    @NotEmpty(message = "Reply message mediaId is required.",
            groups = {ImageMessageGroup.class, VoiceMessageGroup.class, VideoMessageGroup.class})
    private String responseMediaUrl;

    @Schema(description = "缩略图的媒体 id", example = "123456")
    @NotEmpty(message = "Reply message thumbMediaId is required.", groups = {MusicMessageGroup.class})
    private String responseThumbMediaId;
    @Schema(description = "缩略图的媒体 URL",example = "https://www.iocoder.cn/xxx.jpg")
    @NotEmpty(message = "Reply message thumbMedia Address is required.", groups = {MusicMessageGroup.class})
    private String responseThumbMediaUrl;

    @Schema(description = "回复的标题", example = "Video title.")
    @NotEmpty(message = "Reply message title is required.", groups = VideoMessageGroup.class)
    private String responseTitle;
    @Schema(description = "回复的描述", example = "Video Description.")
    @NotEmpty(message = "MessageDescription is required.", groups = VideoMessageGroup.class)
    private String responseDescription;

    /**
     * 回复的图文消息
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 NEWS
     */
    @NotNull(message = "News reply cannot be empty.", groups = {NewsMessageGroup.class, ViewLimitedButtonGroup.class})
    @Valid
    private List<MpMessageDO.Article> responseArticles;

    @Schema(description = "回复的音乐链接", example = "https://www.iocoder.cn/xxx.mp3")
    @NotEmpty(message = "Music URL cannot be empty.", groups = MusicMessageGroup.class)
    @URL(message = "High-quality music URL format is invalid.", groups = MusicMessageGroup.class)
    private String responseMusicUrl;
    @Schema(description = "高质量音乐链接", example = "https://www.iocoder.cn/xxx.mp3")
    @NotEmpty(message = "High-quality music URL cannot be empty.", groups = MusicMessageGroup.class)
    @URL(message = "High-quality music URL format is invalid.", groups = MusicMessageGroup.class)
    private String responseHqMusicUrl;

    @AssertTrue(message = "Request keyword cannot be empty.")
    public boolean isRequestKeywordValid() {
        return ObjectUtil.notEqual(type, MpAutoReplyTypeEnum.KEYWORD)
                || requestKeyword != null;
    }

    @AssertTrue(message = "Request keyword match cannot be empty.")
    public boolean isRequestMatchValid() {
        return ObjectUtil.notEqual(type, MpAutoReplyTypeEnum.KEYWORD)
                || requestMatch != null;
    }

    @AssertTrue(message = "Request message type cannot be empty.")
    public boolean isRequestMessageTypeValid() {
        return ObjectUtil.notEqual(type, MpAutoReplyTypeEnum.MESSAGE)
                || requestMessageType != null;
    }


}

package cn.iocoder.yudao.module.mp.controller.admin.message.vo.message;

import cn.iocoder.yudao.module.mp.dal.dataobject.message.MpMessageDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.common.api.WxConsts;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Official Accountmessage response.")
@Data
public class MpMessageRespVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer id;

    @Schema(description = "WeChatOfficial Accountmessage id.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23953173569869169")
    private Long msgId;

    @Schema(description = "Official Account account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long accountId;
    @Schema(description = "Official Account account appid.", requiredMode = Schema.RequiredMode.REQUIRED, example = "wx1234567890")
    private String appId;

    @Schema(description = "Official Accountfollower code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long userId;
    @Schema(description = "Official-account follower flag.", requiredMode = Schema.RequiredMode.REQUIRED, example = "o6_bmjrPTlm6_2sgVt7hMZOPfL2M")
    private String openid;

    @Schema(description = "Message type see WxConsts.XmlMsgType enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "text")
    private String type;
    @Schema(description = "Message source see MpMessageSendFromEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sendFrom;

    // ========= 普通消息内容 https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html

    @Schema(description = "Message content. Set when the message type is text.", example = "Hi there")
    private String content;

    @Schema(description = "Media asset Code. Set when the message type is image, voice, video.", example = "1234567890")
    private String mediaId;
    @Schema(description = "Media file URL. Set when the message type is image, voice, video.", example = "https://www.iocoder.cn/xxx.png")
    private String mediaUrl;

    @Schema(description = "Speech-to-text. Set when the message type is voice.", example = "Speech-to-text result")
    private String recognition;
    @Schema(description = "Voice format. Set when the message type is voice.", example = "amr")
    private String format;

    @Schema(description = "Title. Set when the message type is video, music, link.", example = "Me is title.")
    private String title;

    @Schema(description = "Description. Set when the message type is video, music.", example = "Me is Description.")
    private String description;

    @Schema(description = "Thumbnail media id. Set when the message type is video, music.", example = "1234567890")
    private String thumbMediaId;
    @Schema(description = "Thumbnail media URL. Set when the message type is video, music.", example = "https://www.iocoder.cn/xxx.png")
    private String thumbMediaUrl;

    @Schema(description = "Article click URL. Set when the message type is link.", example = "https://www.iocoder.cn")
    private String url;

    @Schema(description = "Latitude. Set when the message type is location.", example = "23.137466")
    private Double locationX;

    @Schema(description = "Longitude. Set when the message type is location.", example = "113.352425")
    private Double locationY;

    @Schema(description = "Map zoom. Set when the message type is location.", example = "13")
    private Double scale;

    @Schema(description = "Full address. Set when the message type is location.", example = "221-4 Huangxing Road")
    private String label;

    /**
     * 图文消息数组
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 NEWS
     */
    private List<MpMessageDO.Article> articles;

    @Schema(description = "Music URL. Set when the message type is music.", example = "https://www.iocoder.cn/xxx.mp3")
    private String musicUrl;
    @Schema(description = "HQ music URL. Set when the message type is music.", example = "https://www.iocoder.cn/xxx.mp3")
    private String hqMusicUrl;

    // ========= 事件推送 https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html

    @Schema(description = "Event type see WxConsts.EventType enum.", example = "subscribe")
    private String event;
    @Schema(description = "Event Key see WxConsts.EventType enum.", example = "qrscene_123456")
    private String eventKey;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

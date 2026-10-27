package cn.iocoder.yudao.module.mp.service.message.bo;

import cn.iocoder.yudao.module.mp.dal.dataobject.message.MpMessageDO;
import cn.iocoder.yudao.module.mp.framework.mp.core.util.MpUtils.*;
import lombok.Data;
import me.chanjar.weixin.common.api.WxConsts;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * 公众号消息发送 Request BO
 *
 * 为什么要有该 BO 呢？在自动回复、客服消息、菜单回复消息等场景，都涉及到 MP 给粉丝发送消息，所以使用该 BO 统一承接
 *
 * @author 芋道源码
 */
@Data
public class MpMessageSendOutReqBO {

    /**
     * 公众号 appId
     */
    @NotEmpty(message = "Official Account appId is required.")
    private String appId;
    /**
     * 公众号粉丝 openid
     */
    @NotEmpty(message = "Official Accountfollower openid is required.")
    private String openid;

    // ========== message content ==========
    /**
     * 消息类型
     *
     * 枚举 {@link WxConsts.XmlMsgType} 中的 TEXT、IMAGE、VOICE、VIDEO、NEWS、MUSIC
     */
    @NotEmpty(message = "Message type is required.")
    public String type;

    /**
     * 消息内容
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 TEXT
     */
    @NotEmpty(message = "Message content is required.", groups = TextMessageGroup.class)
    private String content;

    /**
     * 媒体 id
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 IMAGE、VOICE、VIDEO
     */
    @NotEmpty(message = "Message mediaId is required.", groups = {ImageMessageGroup.class, VoiceMessageGroup.class, VideoMessageGroup.class})
    private String mediaId;

    /**
     * 缩略图的媒体 id
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 VIDEO、MUSIC
     */
    @NotEmpty(message = "Message thumbMediaId is required.", groups = {MusicMessageGroup.class})
    private String thumbMediaId;

    /**
     * 标题
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 VIDEO
     */
    @NotEmpty(message = "Message title is required.", groups = VideoMessageGroup.class)
    private String title;
    /**
     * 描述
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 VIDEO
     */
    @NotEmpty(message = "MessageDescription is required.", groups = VideoMessageGroup.class)
    private String description;

    /**
     * 图文消息
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 NEWS
     */
    @Valid
    @NotNull(message = "News message cannot be empty.", groups = NewsMessageGroup.class)
    private List<MpMessageDO.Article> articles;

    /**
     * 音乐链接
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 MUSIC
     */
    @NotEmpty(message = "Music URL cannot be empty.", groups = MusicMessageGroup.class)
    @URL(message = "High-quality music URL format is invalid.", groups = MusicMessageGroup.class)
    private String musicUrl;

    /**
     * 高质量音乐链接
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 MUSIC
     */
    @NotEmpty(message = "High-quality music URL cannot be empty.", groups = MusicMessageGroup.class)
    @URL(message = "High-quality music URL format is invalid.", groups = MusicMessageGroup.class)
    private String hqMusicUrl;

}

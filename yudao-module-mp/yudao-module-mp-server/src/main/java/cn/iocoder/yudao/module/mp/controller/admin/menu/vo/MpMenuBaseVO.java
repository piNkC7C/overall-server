package cn.iocoder.yudao.module.mp.controller.admin.menu.vo;

import cn.iocoder.yudao.module.mp.dal.dataobject.message.MpMessageDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import me.chanjar.weixin.common.api.WxConsts;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

import static cn.iocoder.yudao.module.mp.framework.mp.core.util.MpUtils.*;

/**
 * 公众号菜单 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class MpMenuBaseVO {

    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单标识
     *
     * 支持多 DB 类型时，无法直接使用 key + @TableField("menuKey") 来实现转换，原因是 "menuKey" AS key 而存在报错
     */
    private String menuKey;
    /**
     * 父菜单编号
     */
    private Long parentId;

    // ========== action ==========

    /**
     * 按钮类型
     *
     * 枚举 {@link WxConsts.MenuButtonType}
     */
    private String type;

    @Schema(description = "Web URL.", example = "https://www.iocoder.cn/")
    @NotEmpty(message = "Web URL cannot be empty.", groups = {ViewButtonGroup.class, MiniProgramButtonGroup.class})
    @URL(message = "Web URL must be a valid URL.")
    private String url;

    @Schema(description = "Mini-program appId.", example = "wx1234567890")
    @NotEmpty(message = "Mini-program appId cannot be empty.", groups = MiniProgramButtonGroup.class)
    private String miniProgramAppId;

    @Schema(description = "Mini-program page path.", example = "pages/index/index")
    @NotEmpty(message = "Mini-program page path cannot be empty.", groups = MiniProgramButtonGroup.class)
    private String miniProgramPagePath;

    @Schema(description ="News media ID.", example = "jCQk93AIIgp8ixClWcW_NXXqBKInNWNmq2XnPeDZl7IMVqWiNeL4FfELtggRXd83")
    @NotEmpty(message = "News media ID cannot be empty.", groups = ViewLimitedButtonGroup.class)
    private String articleId;

    // ========== message content ==========

    @Schema(description = "Reply message type enum TEXT、IMAGE、VOICE、VIDEO、NEWS、MUSIC.", example = "text")
    @NotEmpty(message = "Reply message type is required.", groups = {ClickButtonGroup.class, ScanCodeWaitMsgButtonGroup.class})
    private String replyMessageType;

    @Schema(description = "Reply message content.", example = "Thanks for following")
    @NotEmpty(message = "Reply message content is required.", groups = TextMessageGroup.class)
    private String replyContent;

    @Schema(description = "Reply media ID.", example = "123456")
    @NotEmpty(message = "Reply message mediaId is required.",
            groups = {ImageMessageGroup.class, VoiceMessageGroup.class, VideoMessageGroup.class})
    private String replyMediaId;
    @Schema(description = "Reply media URL.", example = "https://www.iocoder.cn/xxx.jpg")
    @NotEmpty(message = "Reply message mediaId is required.",
            groups = {ImageMessageGroup.class, VoiceMessageGroup.class, VideoMessageGroup.class})
    private String replyMediaUrl;

    @Schema(description = "Thumbnail media ID.", example = "123456")
    @NotEmpty(message = "Reply message thumbMediaId is required.", groups = {MusicMessageGroup.class})
    private String replyThumbMediaId;
    @Schema(description = "Thumbnail media URL.",example = "https://www.iocoder.cn/xxx.jpg")
    @NotEmpty(message = "Reply message thumbMedia Address is required.", groups = {MusicMessageGroup.class})
    private String replyThumbMediaUrl;

    @Schema(description = "Reply title.", example = "Video title.")
    @NotEmpty(message = "Reply message title is required.", groups = VideoMessageGroup.class)
    private String replyTitle;
    @Schema(description = "Reply Description.", example = "Video Description.")
    @NotEmpty(message = "MessageDescription is required.", groups = VideoMessageGroup.class)
    private String replyDescription;

    /**
     * 回复的图文消息数组
     *
     * 消息类型为 {@link WxConsts.XmlMsgType} 的 NEWS
     */
    @NotNull(message = "News reply cannot be empty.", groups = {NewsMessageGroup.class, ViewLimitedButtonGroup.class})
    @Valid
    private List<MpMessageDO.Article> replyArticles;

    @Schema(description = "Music URL.", example = "https://www.iocoder.cn/xxx.mp3")
    @NotEmpty(message = "Music URL cannot be empty.", groups = MusicMessageGroup.class)
    @URL(message = "High-quality music URL format is invalid.", groups = MusicMessageGroup.class)
    private String replyMusicUrl;
    @Schema(description = "High-quality music URL.", example = "https://www.iocoder.cn/xxx.mp3")
    @NotEmpty(message = "High-quality music URL cannot be empty.", groups = MusicMessageGroup.class)
    @URL(message = "High-quality music URL format is invalid.", groups = MusicMessageGroup.class)
    private String replyHqMusicUrl;

}

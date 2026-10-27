package cn.iocoder.yudao.module.system.api.social.dto;

import cn.iocoder.yudao.framework.common.enums.UserTypeEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Schema(description = "WeChat mini program subscribe message send request VO.")
@Data
public class SocialWxaSubscribeMessageSendReqDTO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "User ID is required.")
    private Long userId;
    @Schema(description = "User type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(UserTypeEnum.class)
    @NotNull(message = "User type is required.")
    private Integer userType;

    @Schema(description = "Messagetemplate title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Template title.")
    @NotEmpty(message = "Messagetemplate title is required.")
    private String templateTitle;

    @Schema(description = "Page to open after tapping the template card. Mini-program pages only.", example = "pages/index?foo=bar")
    private String page; // 支持带参数，（示例 index?foo=bar ）。该字段不填则模板无跳转。

    @Schema(description = "Template content parameter.")
    private Map<String, String> messages;

    public SocialWxaSubscribeMessageSendReqDTO addMessage(String key, String value) {
        if (messages == null) {
            messages = new HashMap<>();
        }
        messages.put(key, value);
        return this;
    }

}

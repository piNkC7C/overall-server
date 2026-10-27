package cn.iocoder.yudao.module.im.controller.admin.message.vo.privates;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.im.enums.ImContentTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 私聊消息发送 Request VO
 */
@Schema(description = "Direct message send request VO.")
@Data
public class ImPrivateMessageSendReqVO {

    @Schema(description = "Clientmessage code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "uuid-xxx")
    @NotEmpty(message = "Clientmessage code is required.")
    private String clientMessageId;

    @Schema(description = "Recipient code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Recipient code is required.")
    private Long receiverId;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Message type is required.")
    @InEnum(ImContentTypeEnum.class)
    private Integer type;

    @Schema(description = "Message content, JSON.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{\"content\":\"Hello\"}")
    @NotEmpty(message = "Message content is required.")
    private String content;

    @Schema(description = "Is not need to need Receipt.", example = "false")
    private Boolean receipt;

    /**
     * 仅允许用户消息（normal）类型
     */
    @AssertTrue(message = "Message type is not allowed.")
    @JsonIgnore
    public boolean isTypeNormal() {
        return type == null || ImContentTypeEnum.validate(type).isNormal();
    }

}

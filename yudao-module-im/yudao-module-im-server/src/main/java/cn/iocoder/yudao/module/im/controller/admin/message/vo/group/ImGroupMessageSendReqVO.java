package cn.iocoder.yudao.module.im.controller.admin.message.vo.group;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.im.enums.ImContentTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

/**
 * 群聊消息发送 Request VO
 */
@Schema(description = "Admin - group chat message send request.")
@Data
public class ImGroupMessageSendReqVO {

    @Schema(description = "Clientmessage code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "uuid-xxx")
    @NotEmpty(message = "Clientmessage code is required.")
    private String clientMessageId;

    @Schema(description = "Group ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Group ID is required")
    private Long groupId;

    @Schema(description = "Message type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Message type is required.")
    @InEnum(ImContentTypeEnum.class)
    private Integer type;

    @Schema(description = "Message content, JSON.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{\"content\":\"Hello\"}")
    @NotEmpty(message = "Message content is required.")
    private String content;

    @Schema(description = "@ target user ID list.", example = "[1,2,3]")
    private List<Long> atUserIds;

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

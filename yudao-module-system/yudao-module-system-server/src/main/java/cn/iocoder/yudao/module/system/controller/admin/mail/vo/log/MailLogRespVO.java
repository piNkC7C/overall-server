package cn.iocoder.yudao.module.system.controller.admin.mail.vo.log;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "Email log response VO.")
@Data
public class MailLogRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31020")
    private Long id;

    @Schema(description = "User ID.", example = "30883")
    private Long userId;

    @Schema(description = "User type. See UserTypeEnum.", example = "2")
    private Byte userType;

    @Schema(description = "ReceiveemailAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "user1@example.com, user2@example.com")
    private List<String> toMails;

    @Schema(description = "Cc", requiredMode = Schema.RequiredMode.REQUIRED, example = "user3@example.com, user4@example.com")
    private List<String> ccMails;

    @Schema(description = "Bcc", requiredMode = Schema.RequiredMode.REQUIRED, example = "user5@example.com, user6@example.com")
    private List<String> bccMails;

    @Schema(description = "Email account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18107")
    private Long accountId;

    @Schema(description = "Send emailAddress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "85757@qq.com")
    private String fromMail;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5678")
    private Long templateId;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test_01")
    private String templateCode;

    @Schema(description = "Template send person name.", example = "Jane.")
    private String templateNickname;

    @Schema(description = "Email title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test title")
    private String templateTitle;

    @Schema(description = "Email content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Test content")
    private String templateContent;

    @Schema(description = "Email parameter.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, Object> templateParams;

    @Schema(description = "Send status, see MailSendStatusEnum enum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Byte sendStatus;

    @Schema(description = "Send time.")
    private LocalDateTime sendTime;

    @Schema(description = "Provider message ID", example = "28568")
    private String sendMessageId;

    @Schema(description = "Send error")
    private String sendException;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

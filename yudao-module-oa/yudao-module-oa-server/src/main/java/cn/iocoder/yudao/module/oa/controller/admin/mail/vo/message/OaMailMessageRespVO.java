package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Enterprise email response VO.")
@Data
public class OaMailMessageRespVO {

    @Schema(description = "Email code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Email account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long accountId;

    @Schema(description = "Folder code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long folderId;

    @Schema(description = "Remote mail UID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1001")
    private Long uid;

    @Schema(description = "Remote UID expiry.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long uidValidity;

    @Schema(description = "Email subject.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Project review meeting notice")
    private String subject;

    @Schema(description = "Sender.", example = "sender@example.com")
    private String sender;

    @Schema(description = "To.", example = "[\"recipient@example.com\"]")
    private List<String> recipients;

    @Schema(description = "Cc", example = "[\"cc@example.com\"]")
    private List<String> ccs;

    @Schema(description = "Reply Address.", example = "[\"reply@example.com\"]")
    private List<String> replyTos;

    @Schema(description = "Receive time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime receiveTime;

    @Schema(description = "Is not Read.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean readStatus;

    @Schema(description = "Is not has Attachment.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean hasAttach;

    @Schema(description = "Email size in bytes.", example = "1024")
    private Integer size;

    @Schema(description = "Safe HTML body.", example = "<p>Please review this week's work plan.</p>")
    private String content;

    @Schema(description = "Attachment info.")
    private List<Attachment> attachments;

    @Schema(description = "Admin - email Attachment response.")
    @Data
    public static class Attachment {

        @Schema(description = "MIME part path.", example = "1.2")
        private String part;

        @Schema(description = "Attachment name.", example = "office-supply-count.pdf")
        private String name;

        @Schema(description = "Attachment size in bytes.", example = "1024")
        private Integer size;

    }

}

package cn.iocoder.yudao.module.system.controller.admin.mail.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Schema(description = "Admin - email send Req VO.")
@Data
public class MailTemplateSendReqVO {

    @Schema(description = "Receiveemail.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[user1@example.com, user2@example.com]")
    @NotEmpty(message = "Receiveemail is required.")
    private List<String> toMails;

    @Schema(description = "CC email.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[user3@example.com, user4@example.com]")
    private List<String> ccMails;

    @Schema(description = "BCC email.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[user5@example.com, user6@example.com]")
    private List<String> bccMails;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test_01")
    @NotNull(message = "Template code is required.")
    private String templateCode;

    @Schema(description = "Template parameter.")
    private Map<String, Object> templateParams;

}

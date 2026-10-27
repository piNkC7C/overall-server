package cn.iocoder.yudao.module.oa.controller.admin.mail.vo.message;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;
import cn.iocoder.yudao.module.oa.dal.dataobject.mail.OaMailMessageDO;
import java.util.List;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.mail.OaMailComposeModeEnum;

@Schema(description = "Compose and draft request VO.")
@Data
public class OaMailMessageSaveReqVO {

    @Schema(description = "Email account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Email account code is required.")
    private Long accountId;

    @Schema(description = "Original draft ID.", example = "1024")
    private Long draftId;

    @Schema(description = "To.", example = "[\"recipient@example.com\"]")
    private List<@NotBlank(message = "Recipient address cannot be empty.") String> recipients;

    @Schema(description = "Cc", example = "[\"cc@example.com\"]")
    private List<@NotBlank(message = "CcAddress is required.") String> ccs;

    @Schema(description = "Subject.", example = "Project review meeting notice")
    @Size(max = 65535, message = "Email subject cannot exceed 65535 characters.")
    private String subject;

    @Schema(description = "Body HTML.", example = "<p>Please review this week's work plan.</p>")
    @Size(max = 500000, message = "Body HTML length cannot exceed {max} characters.")
    private String content;

    @Schema(description = "Original email ID for reply or forward.", example = "1024")
    private Long sourceId;

    @Schema(description = "Compose mode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "new")
    @InEnum(value = OaMailComposeModeEnum.class, message = "Compose mode must be {value}.")
    @NotBlank(message = "Compose mode cannot be empty.")
    private String mode;

    @Schema(description = "Kept original attachment paths. An empty list removes all original attachments.")
    private List<String> attachmentParts;

    @Schema(description = "Original attachments. Used only when composing a reply.", accessMode = Schema.AccessMode.READ_ONLY)
    private List<OaMailMessageDO.Attachment> attachments;

    @JsonIgnore
    @Schema(hidden = true)
    private List<MultipartFile> files;

}

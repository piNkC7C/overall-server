package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.send;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.constraints.*;
import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;

@Schema(description = "Outgoing official document create / update request VO.")
@Data
public class OaOfficialDocSendSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Letterhead templateID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Letterhead template cannot be empty.")
    private Long templateId;

    @Schema(description = "Document Title", requiredMode = Schema.RequiredMode.REQUIRED, example = "Notice: Office supply inventory")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Document Title length cannot exceed {max} characters.")
    private String title;

    @Schema(description = "Character no.", example = "OA")
    @Size(max = 64, message = "Character no. length cannot exceed {max} characters.")
    private String noPrefix;

    @Schema(description = "Year.", example = "2026")
    @Min(value = 1, message = "Year cannot be less than {value}.")
    @Max(value = 9999, message = "Year cannot be greater than {value}.")
    private Integer year;

    @Schema(description = "Document sequence.", example = "1")
    @Min(value = 1, message = "Document sequence cannot be less than {value}.")
    private Integer sequence;

    @Schema(description = "Classification.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Classification is required.")
    @InDict(type = DictTypeConstants.OFFICIAL_DOC_SECRET_LEVEL, message = "Classification must be {value}.")
    private Integer secrecyLevel;

    @Schema(description = "Urgency", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Urgency is required")
    @InDict(type = DictTypeConstants.OFFICIAL_DOC_URGENCY_LEVEL, message = "Urgency must be {value}.")
    private Integer urgencyLevel;

    @Schema(description = "Disclosure Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Disclosure Type is required.")
    @InDict(type = DictTypeConstants.OFFICIAL_DOC_PUBLIC_CATEGORY, message = "Disclosure Type must be {value}.")
    private Integer disclosureType;

    @Schema(description = "Issue Date", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Issue Date is required.")
    private LocalDateTime issueTime;

    @Schema(description = "Issuing Dept code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Issuing Dept is required.")
    private Long sendDeptId;

    @Schema(description = "Primary Dept code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    @NotEmpty(message = "Primary Dept is required.")
    private List<@NotNull(message = "Primary Dept code is required.") Long> mainDeptIds;

    @Schema(description = "Cc department IDslist.", example = "[1, 2]")
    private List<@NotNull(message = "Cc department IDs cannot be empty.") Long> copyDeptIds;

    @Schema(description = "Document body.", example = "Please finish the office-supply count and submit results by Friday.")
    private String content;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<@NotBlank(message = "AttachmentAddress is required.") String> fileUrls;

    @Schema(description = "Official DocumentAddress.", example = "https://example.com/file.pdf")
    @Size(max = 2048, message = "Official DocumentAddress length cannot exceed {max} characters.")
    private String formalFileUrl;

    @Schema(description = "Notes.", example = "Please handle this as requested and report back")
    @Size(max = 500, message = "Notes cannot exceed {max} characters.")
    private String remark;

}

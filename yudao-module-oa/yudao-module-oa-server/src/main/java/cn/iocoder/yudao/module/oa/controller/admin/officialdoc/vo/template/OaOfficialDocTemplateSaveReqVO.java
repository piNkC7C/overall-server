package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.template;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "Admin - Letterhead templatecreate/update request.")
@Data
public class OaOfficialDocTemplateSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Admin outgoing-document template")
    @NotBlank(message = "Template name is required.")
    @Size(max = 128, message = "Template name length cannot exceed {max} characters.")
    private String name;

    @Schema(description = "Letterhead name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Yudao Tech LLC file")
    @NotBlank(message = "Letterhead name cannot be empty.")
    @Size(max = 255, message = "Letterhead name cannot exceed {max} characters.")
    private String authorityName;

    @Schema(description = "Letterhead document number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32")
    @NotNull(message = "Character no. is required.")
    @Min(value = 18, message = "Letterhead document number cannot be less than {value}.")
    @Max(value = 72, message = "Letterhead document number cannot be greater than {value}.")
    private Integer fontSize;

    @Schema(description = "Outgoing document-number prefix.", example = "OA")
    @Size(max = 64, message = "Outgoing document-number prefix cannot exceed {max} characters.")
    private String noPrefix;

    @Schema(description = "SealImageAddress.", example = "https://example.com/image.png")
    @Size(max = 2048, message = "SealImageAddress length cannot exceed {max} characters.")
    private String sealPicUrl;

    @Schema(description = "Divider type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Divider type cannot be empty.")
    @InDict(type = DictTypeConstants.OFFICIAL_DOC_SEPARATOR_TYPE, message = "Divider type must be {value}.")
    private Integer separatorType;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes length cannot exceed {max} characters.")
    private String remark;

}

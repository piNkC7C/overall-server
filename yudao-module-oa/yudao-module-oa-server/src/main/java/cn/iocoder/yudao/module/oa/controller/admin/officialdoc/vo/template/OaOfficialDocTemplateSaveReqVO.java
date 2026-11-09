package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.template;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(description = "管理后台 - 套红模板新增/修改 Request VO")
@Data
public class OaOfficialDocTemplateSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "模板名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Admin outgoing-document template")
    @NotBlank(message = "Template name is required.")
    @Size(max = 128, message = "Template name length cannot exceed {max} characters.")
    private String name;

    @Schema(description = "红头名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Yudao Tech LLC file")
    @NotBlank(message = "Letterhead name cannot be empty.")
    @Size(max = 255, message = "Letterhead name cannot exceed {max} characters.")
    private String authorityName;

    @Schema(description = "红头字号", requiredMode = Schema.RequiredMode.REQUIRED, example = "32")
    @NotNull(message = "Character no. is required.")
    @Min(value = 18, message = "Letterhead document number cannot be less than {value}.")
    @Max(value = 72, message = "Letterhead document number cannot be greater than {value}.")
    private Integer fontSize;

    @Schema(description = "发文字号前缀", example = "OA")
    @Size(max = 64, message = "Outgoing document-number prefix cannot exceed {max} characters.")
    private String noPrefix;

    @Schema(description = "印章图片地址", example = "https://example.com/image.png")
    @Size(max = 2048, message = "SealImageAddress length cannot exceed {max} characters.")
    private String sealPicUrl;

    @Schema(description = "分隔线类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Divider type cannot be empty.")
    @InDict(type = DictTypeConstants.OFFICIAL_DOC_SEPARATOR_TYPE, message = "Divider type must be {value}.")
    private Integer separatorType;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    @InEnum(value = CommonStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Sort is required.")
    private Integer sort;

    @Schema(description = "备注", example = "Contact Admin in advance to confirm.")
    @Size(max = 500, message = "Notes length cannot exceed {max} characters.")
    private String remark;

}

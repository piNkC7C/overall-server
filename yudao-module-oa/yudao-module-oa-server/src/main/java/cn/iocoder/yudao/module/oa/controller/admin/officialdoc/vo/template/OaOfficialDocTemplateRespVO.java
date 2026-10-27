package cn.iocoder.yudao.module.oa.controller.admin.officialdoc.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - Letterhead template response.")
@Data
public class OaOfficialDocTemplateRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Admin outgoing-document template")
    private String name;

    @Schema(description = "Letterhead name.", example = "Yudao Tech LLC file")
    private String authorityName;

    @Schema(description = "Letterhead document number.", example = "32")
    private Integer fontSize;

    @Schema(description = "Outgoing document-number prefix.", example = "OA")
    private String noPrefix;

    @Schema(description = "SealImageAddress.", example = "https://example.com/image.png")
    private String sealPicUrl;

    @Schema(description = "Divider type.", example = "0")
    private Integer separatorType;

    @Schema(description = "Status.", example = "0")
    private Integer status;

    @Schema(description = "Sort", example = "1")
    private Integer sort;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    private String remark;

    @Schema(description = "Creator code.", example = "1024")
    private String creator;

    @Schema(description = "Create time.", type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}

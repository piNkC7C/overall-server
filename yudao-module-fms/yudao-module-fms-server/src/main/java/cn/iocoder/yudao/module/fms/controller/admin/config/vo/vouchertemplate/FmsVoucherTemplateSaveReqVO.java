package cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - FMS journal entrytemplate save request.")
@Data
public class FmsVoucherTemplateSaveReqVO {

    @Schema(description = "Template code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Office-supply purchase")
    @NotBlank(message = "Template name is required.")
    @Size(max = 255, message = "Template name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Templatecategory is required.")
    private Long categoryId;

    @Schema(description = "Journal entrytemplate entry Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Journal entrytemplate entry is required.")
    @Size(min = 2, message = "A journal template needs at least two entries.")
    private List<FmsVoucherTemplateEntryVO> entries;

}

package cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Schema(description = "管理后台 - FMS 凭证模板保存 Request VO")
@Data
public class FmsVoucherTemplateSaveReqVO {

    @Schema(description = "模板编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "模板名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Office-supply purchase")
    @NotBlank(message = "Template name is required.")
    @Size(max = 255, message = "Template name length cannot exceed 255 characters.")
    private String name;

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Templatecategory is required.")
    private Long categoryId;

    @Schema(description = "凭证模板分录数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @NotEmpty(message = "Journal entrytemplate entry is required.")
    @Size(min = 2, message = "A journal template needs at least two entries.")
    private List<FmsVoucherTemplateEntryVO> entries;

}

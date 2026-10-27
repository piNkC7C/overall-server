package cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplatecategory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - FMS journal entrytemplatecategory save request.")
@Data
public class FmsVoucherTemplateCategorySaveReqVO {

    @Schema(description = "Category code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Daily income and expense")
    @NotBlank(message = "Category name is required.")
    @Size(max = 255, message = "Category name length cannot exceed 255 characters.")
    private String name;

}

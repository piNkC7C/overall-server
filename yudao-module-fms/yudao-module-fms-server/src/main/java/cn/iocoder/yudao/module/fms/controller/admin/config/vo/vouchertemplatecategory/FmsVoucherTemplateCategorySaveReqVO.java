package cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplatecategory;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - FMS 凭证模板分类保存 Request VO")
@Data
public class FmsVoucherTemplateCategorySaveReqVO {

    @Schema(description = "分类编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Daily income and expense")
    @NotBlank(message = "Category name is required.")
    @Size(max = 255, message = "Category name length cannot exceed 255 characters.")
    private String name;

}

package cn.iocoder.yudao.module.erp.controller.admin.product.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - ERP product category create / edit request.")
@Data
public class ErpProductCategorySaveReqVO {

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5860")
    private Long id;

    @Schema(description = "Parent category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21829")
    @NotNull(message = "Parent category code is required.")
    private Long parentId;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    @NotEmpty(message = "Category name is required.")
    private String name;

    @Schema(description = "Category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "S110")
    @NotEmpty(message = "Category code is required.")
    private String code;

    @Schema(description = "Category sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Category sort is required.")
    private Integer sort;

    @Schema(description = "Enable status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enable status is required.")
    private Integer status;

}
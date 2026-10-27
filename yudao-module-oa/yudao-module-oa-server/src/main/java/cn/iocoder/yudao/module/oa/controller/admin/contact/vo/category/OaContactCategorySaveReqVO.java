package cn.iocoder.yudao.module.oa.controller.admin.contact.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - OA contactcategory create / edit request.")
@Data
public class OaContactCategorySaveReqVO {

    @Schema(description = "Category code.", example = "1024")
    private Long id;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer.")
    @NotBlank(message = "Category name is required.")
    @Size(max = 50, message = "Category name length cannot exceed 50 characters.")
    private String name;

    @Schema(description = "Show sort.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "Show sort is required.")
    private Integer sort;

}

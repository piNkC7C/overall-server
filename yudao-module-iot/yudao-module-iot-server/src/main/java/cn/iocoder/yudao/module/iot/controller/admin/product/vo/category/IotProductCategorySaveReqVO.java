package cn.iocoder.yudao.module.iot.controller.admin.product.vo.category;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - IoT product category create / edit request.")
@Data
public class IotProductCategorySaveReqVO {

    @Schema(description = "Category ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25284")
    private Long id;

    @Schema(description = "Category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @NotEmpty(message = "Category name is required.")
    private String name;

    @Schema(description = "Category sort.")
    private Integer sort;

    @Schema(description = "Category status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Category status is required.")
    private Integer status;

    @Schema(description = "CategoryDescription.", example = "Sample.")
    private String description;

}
package cn.iocoder.yudao.module.product.controller.admin.property.vo.property;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "Admin - attribute item create /update request.")
@Data
public class ProductPropertySaveReqVO {

    @Schema(description = "Primary key.", example = "1")
    private Long id;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Color.")
    @NotBlank(message = "Name is required.")
    private String name;

    @Schema(description = "Notes.", example = "Color.")
    private String remark;

}

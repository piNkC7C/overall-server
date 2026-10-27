package cn.iocoder.yudao.module.product.controller.admin.property.vo.value;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - product attribute valuecreate/update request.")
@Data
public class ProductPropertyValueSaveReqVO {

    @Schema(description = "Primary key.", example = "1024")
    private Long id;

    @Schema(description = "Attribute item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Attribute item code is required.")
    private Long propertyId;

    @Schema(description = "Name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Red")
    @NotEmpty(message = "Name name is required.")
    private String name;

    @Schema(description = "Notes.", example = "Color.")
    private String remark;

}

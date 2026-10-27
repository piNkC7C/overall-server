package cn.iocoder.yudao.module.product.api.property.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "RPC service - product attribute item detail Response DTO.")
@Data
public class ProductPropertyValueDetailRespDTO {

    @Schema(description = "Attribute code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long propertyId;
    @Schema(description = "Attribute name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Color.")
    private String propertyName;

    @Schema(description = "Attribute value ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    private Long valueId;
    @Schema(description = "Attribute value name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Red")
    private String valueName;

}

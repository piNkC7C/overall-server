package cn.iocoder.yudao.module.trade.controller.app.base.property;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "SKU attribute value detail response VO.")
@Data
public class AppProductPropertyValueDetailRespVO {

    @Schema(description = "Attribute code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long propertyId;

    @Schema(description = "Attribute name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Color.")
    private String propertyName;

    @Schema(description = "Attribute value ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long valueId;

    @Schema(description = "Attribute value name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Red")
    private String valueName;

}

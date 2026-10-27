package cn.iocoder.yudao.module.system.controller.admin.dict.vo.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - data dictionary simple response.")
@Data
public class DictDataSimpleRespVO {

    @Schema(description = "Dictionary type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "gender")
    private String dictType;

    @Schema(description = "Dict value", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String value;

    @Schema(description = "Dictionarytag.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Male")
    private String label;

    @Schema(description = "Color type, default、primary、success、info、warning、danger.", example = "default")
    private String colorType;

    @Schema(description = "CSS class", example = "btn-visible")
    private String cssClass;

}

package cn.iocoder.yudao.module.system.controller.app.dict.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "User App - dictionary data info response.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppDictDataRespVO {

    @Schema(description = "Dictionary data code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Dictionarytag.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String label;

    @Schema(description = "Dictionary value.", requiredMode = Schema.RequiredMode.REQUIRED, example = "iocoder")
    private String value;

    @Schema(description = "Dictionary type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "sys_common_sex")
    private String dictType;

}

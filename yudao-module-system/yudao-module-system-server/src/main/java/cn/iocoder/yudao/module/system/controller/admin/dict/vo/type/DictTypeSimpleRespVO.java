package cn.iocoder.yudao.module.system.controller.admin.dict.vo.type;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - dictionary type simple info response.")
@Data
public class DictTypeSimpleRespVO {

    @Schema(description = "Dictionary type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Dictionary type name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String name;

    @Schema(description = "Dictionary type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "sys_common_sex")
    private String type;

}

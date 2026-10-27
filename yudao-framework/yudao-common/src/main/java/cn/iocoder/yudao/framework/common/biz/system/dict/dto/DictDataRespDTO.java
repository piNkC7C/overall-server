package cn.iocoder.yudao.framework.common.biz.system.dict.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "RPC service - dictionary data Response DTO.")
@Data
public class DictDataRespDTO {

    @Schema(description = "Dictionarytag.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
    private String label;

    @Schema(description = "Dictionary value.", requiredMode = Schema.RequiredMode.REQUIRED, example = "iocoder")
    private String value;

    @Schema(description = "Dictionary type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "sys_common_sex")
    private String dictType;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See CommonStatusEnum enum

}

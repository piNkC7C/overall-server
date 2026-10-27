package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - MES material productimport response.")
@Data
@Builder
public class MesMdItemImportRespVO {

    @Schema(description = "Create succeeded material codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createCodes;

    @Schema(description = "Update succeeded material codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateCodes;

    @Schema(description = "Failed material import map. Key is material code. Value is the failure reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureCodes;

}

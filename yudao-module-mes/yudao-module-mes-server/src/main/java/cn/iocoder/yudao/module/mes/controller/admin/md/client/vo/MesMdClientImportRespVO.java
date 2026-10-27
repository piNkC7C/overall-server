package cn.iocoder.yudao.module.mes.controller.admin.md.client.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - MES customerimport response.")
@Data
@Builder
public class MesMdClientImportRespVO {

    @Schema(description = "Create succeeded customer codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createCodes;

    @Schema(description = "Update succeeded customer codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateCodes;

    @Schema(description = "Failed customer import map. Key is customer code. Value is the failure reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureCodes;

}

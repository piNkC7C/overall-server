package cn.iocoder.yudao.module.mes.controller.admin.md.vendor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - MES supplierimport response.")
@Data
@Builder
public class MesMdVendorImportRespVO {

    @Schema(description = "Create succeeded supplier codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createCodes;

    @Schema(description = "Update succeeded supplier codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateCodes;

    @Schema(description = "Failed supplier import map. Key is supplier code. Value is the failure reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureCodes;

}

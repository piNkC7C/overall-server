package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "MES device ledger import response VO.")
@Data
@Builder
public class MesDvMachineryImportRespVO {

    @Schema(description = "Create succeeded device codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createCodes;

    @Schema(description = "Update succeeded device codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateCodes;

    @Schema(description = "Failed device import map, key as Device code, value is the failure reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureCodes;

}

package cn.iocoder.yudao.module.fms.controller.admin.config.vo.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - FMS accountimport result response.")
@Data
public class FmsSubjectImportRespVO {

    @Schema(description = "Total quantity.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer totalCount;

    @Schema(description = "Succeededaccount codeArray.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> successSubjectCodes;

    @Schema(description = "Failedreason Map.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureReasons;

}

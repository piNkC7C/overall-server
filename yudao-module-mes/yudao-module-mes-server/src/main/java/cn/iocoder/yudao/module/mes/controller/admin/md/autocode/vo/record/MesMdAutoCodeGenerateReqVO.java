package cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(description = "Admin - MES codecreate request.")
@Data
public class MesMdAutoCodeGenerateReqVO {

    @Schema(description = "Rule code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM_CODE")
    @NotEmpty(message = "Rule code is required.")
    private String ruleCode;

    @Schema(description = "Input characters.", example = "A")
    private String inputChar;

}

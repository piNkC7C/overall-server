package cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.rule;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - MES coding rule create / edit request.")
@Data
public class MesMdAutoCodeRuleSaveReqVO {

    @Schema(description = "Rule ID.", example = "1024")
    private Long id;

    @Schema(description = "Rule code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM_CODE")
    @NotEmpty(message = "Rule code is required.")
    private String code;

    @Schema(description = "Rule name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material coding rule.")
    @NotEmpty(message = "Rule name is required.")
    private String name;

    @Schema(description = "Description", example = "At create material code.")
    private String description;

    @Schema(description = "Maximum length.", example = "20")
    private Integer maxLength;

    @Schema(description = "Pad.", example = "true")
    private Boolean padded;

    @Schema(description = "Pad character.", example = "0")
    private String paddedChar;

    @Schema(description = "Pad mode.", example = "1")
    private Integer paddedMethod;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "Status is required.")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

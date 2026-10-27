package cn.iocoder.yudao.module.ai.controller.admin.write.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.ai.enums.write.AiWriteTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "AI writing generation request VO.")
@Data
public class AiWriteGenerateReqVO {

    @Schema(description = "Writing type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = AiWriteTypeEnum.class, message = "Writing type must be {value}.")
    private Integer type;

    @Schema(description = "Writing prompt.", example = "1. Write: Tian Ji's horse race; 2. Reply: rejected")
    private String prompt;

    @Schema(description = "Original text.", example = "I am resigning")
    private String originalContent;

    @Schema(description = "Length.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Length is required.")
    private Integer length;

    @Schema(description = "Format.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Format is required.")
    private Integer format;

    @Schema(description = "Tone.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Tone cannot be empty.")
    private Integer tone;

    @Schema(description = "Language.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Language cannot be empty.")
    private Integer language;

}
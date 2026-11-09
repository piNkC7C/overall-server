package cn.iocoder.yudao.module.ai.controller.admin.write.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.ai.enums.write.AiWriteTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - AI 写作生成 Request VO")
@Data
public class AiWriteGenerateReqVO {

    @Schema(description = "写作类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @InEnum(value = AiWriteTypeEnum.class, message = "Writing type must be {value}.")
    private Integer type;

    @Schema(description = "写作内容提示", example = "1. Write: Tian Ji's horse race; 2. Reply: rejected")
    private String prompt;

    @Schema(description = "原文", example = "I am resigning")
    private String originalContent;

    @Schema(description = "长度", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Length is required.")
    private Integer length;

    @Schema(description = "格式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Format is required.")
    private Integer format;

    @Schema(description = "语气", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Tone cannot be empty.")
    private Integer tone;

    @Schema(description = "语言", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Language cannot be empty.")
    private Integer language;

}
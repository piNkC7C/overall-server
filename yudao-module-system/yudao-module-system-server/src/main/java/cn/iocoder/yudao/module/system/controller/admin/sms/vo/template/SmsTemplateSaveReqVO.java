package cn.iocoder.yudao.module.system.controller.admin.sms.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - SMS template create or update request.")
@Data
public class SmsTemplateSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "SMS type, see SmsTemplateTypeEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "SMS type is required.")
    private Integer type;

    @Schema(description = "Enable status, see CommonStatusEnum enum class.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Enable status is required.")
    private Integer status;

    @Schema(description = "Template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "test_01")
    @NotNull(message = "Template code is required.")
    private String code;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "yudao")
    @NotNull(message = "Template name is required.")
    private String name;

    @Schema(description = "Template content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Hi, {name}. You look so {like}!")
    @NotNull(message = "Template content is required.")
    private String content;

    @Schema(description = "Notes.", example = "Haha")
    private String remark;

    @Schema(description = "SMS API template code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4383920")
    @NotNull(message = "SMS API template code is required.")
    private String apiTemplateId;

    @Schema(description = "SMS channel code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "SMS channel code is required.")
    private Long channelId;

}

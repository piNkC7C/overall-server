package cn.iocoder.yudao.module.promotion.controller.app.diy.vo;

import com.fasterxml.jackson.annotation.JsonRawValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "App - decorate templateProperty response.")
@Data
@ToString(callSuper = true)
public class AppDiyTemplatePropertyRespVO {

    @Schema(description = "Decorate template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31209")
    private Long id;

    @Schema(description = "Template name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Default subject.")
    private String name;

    @Schema(description = "Template attribute.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    @JsonRawValue
    private String property;

    @Schema(description = "Home", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    @JsonRawValue
    private String home;

    @Schema(description = "Me.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    @JsonRawValue
    private String user;

}

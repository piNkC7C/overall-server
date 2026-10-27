package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Admin - decorate templatePropertyupdate request.")
@Data
@ToString(callSuper = true)
public class DiyTemplatePropertyUpdateRequestVO {

    @Schema(description = "Decorate template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31209")
    @NotNull(message = "Decorate template ID cannot be empty.")
    private Long id;

    @Schema(description = "Template attribute, JSON.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    @NotBlank(message = "Template attribute is required.")
    private String property;

}

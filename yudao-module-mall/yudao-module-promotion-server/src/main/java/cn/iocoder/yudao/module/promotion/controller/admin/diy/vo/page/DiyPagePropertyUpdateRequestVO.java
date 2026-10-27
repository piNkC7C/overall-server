package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Schema(description = "Admin - decoratePage propertiesupdate request.")
@Data
@ToString(callSuper = true)
public class DiyPagePropertyUpdateRequestVO {

    @Schema(description = "Decorate page ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31209")
    @NotNull(message = "Decorate page ID cannot be empty.")
    private Long id;

    @Schema(description = "Page properties, JSON format.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{}")
    @NotBlank(message = "Page properties cannot be empty.")
    private String property;

}

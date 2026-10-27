package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - decorate templateupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiyTemplateUpdateReqVO extends DiyTemplateBaseVO {

    @Schema(description = "Decorate template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31209")
    @NotNull(message = "Decorate template ID cannot be empty.")
    private Long id;

}

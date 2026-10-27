package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.template;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Schema(description = "Admin - decorate template response.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiyTemplateRespVO extends DiyTemplateBaseVO {

    @Schema(description = "Decorate template ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31209")
    private Long id;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Is not used.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean used;

    @Schema(description = "Used time.", example = "Used time.")
    private LocalDateTime usedTime;

}

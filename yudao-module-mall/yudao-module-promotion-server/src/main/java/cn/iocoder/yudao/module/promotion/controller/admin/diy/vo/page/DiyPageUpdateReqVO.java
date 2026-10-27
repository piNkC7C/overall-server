package cn.iocoder.yudao.module.promotion.controller.admin.diy.vo.page;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - decoratepageupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DiyPageUpdateReqVO extends DiyPageBaseVO {

    @Schema(description = "Decorate page ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12082")
    @NotNull(message = "Decorate page ID cannot be empty.")
    private Long id;

}

package cn.iocoder.yudao.module.trade.controller.app.cart.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.util.Collection;

@Schema(description = "Update cart selected state request VO.")
@Data
public class AppCartUpdateSelectedReqVO {

    @Schema(description = "Code list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024,2048")
    @NotNull(message = "Code list is required.")
    private Collection<Long> ids;

    @Schema(description = "Selected.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Selected cannot be empty.")
    private Boolean selected;

}

package cn.iocoder.yudao.module.pay.controller.admin.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import jakarta.validation.constraints.*;

@Schema(description = "Admin - payment app info update request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayAppUpdateReqVO extends PayAppBaseVO {

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "App code is required.")
    private Long id;

}

package cn.iocoder.yudao.module.pay.controller.admin.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - appupdate status request.")
@Data
public class PayAppUpdateStatusReqVO {

    @Schema(description = "App code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "App code is required.")
    private Long id;

    @Schema(description = "Status. See CommonStatusEnum.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer status;

}

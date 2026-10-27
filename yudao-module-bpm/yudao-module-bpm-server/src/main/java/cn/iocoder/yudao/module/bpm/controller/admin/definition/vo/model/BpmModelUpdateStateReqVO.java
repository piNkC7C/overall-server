package cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Admin - workflow modelupdate status request.")
@Data
public class BpmModelUpdateStateReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private String id;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Status is required.")
    private Integer state; // See Flowable SuspensionState enum

}

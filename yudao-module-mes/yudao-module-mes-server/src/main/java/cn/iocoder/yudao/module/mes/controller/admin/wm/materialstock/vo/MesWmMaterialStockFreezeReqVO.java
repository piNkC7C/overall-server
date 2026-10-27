package cn.iocoder.yudao.module.mes.controller.admin.wm.materialstock.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Freeze or unfreeze inventory ledger request VO.")
@Data
public class MesWmMaterialStockFreezeReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Is not freeze.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Freeze status is required.")
    private Boolean frozen;

}


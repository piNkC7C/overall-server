package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo.bom;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES production work order BOM create / edit request.")
@Data
public class MesProWorkOrderBomSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Production work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Production work order code is required.")
    private Long workOrderId;

    @Schema(description = "BOM material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "BOM material is required.")
    private Long itemId;

    @Schema(description = "Expected usage.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.00")
    @NotNull(message = "Expected usage cannot be empty.")
    private BigDecimal quantity;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

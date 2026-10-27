package cn.iocoder.yudao.module.mes.controller.admin.pro.card.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES production routing card create / edit request.")
@Data
public class MesProCardSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Routing card code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CARD-001")
    @NotEmpty(message = "Routing card code is required.")
    private String code;

    @Schema(description = "Production work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Production work order is required.")
    private Long workOrderId;

    @Schema(description = "Product material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    @Schema(description = "Lot no.", example = "BATCH-001")
    private String batchCode;

    @Schema(description = "Transfer Qty", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Transfer Qty is required.")
    private BigDecimal transferedQuantity;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

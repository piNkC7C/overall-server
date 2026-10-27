package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES transfer detail Save request.")
@Data
public class MesWmTransferDetailSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Transfer order line code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Transfer order line code is required.")
    private Long lineId;

    @Schema(description = "Transfer order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Transfer order code is required.")
    private Long transferId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Put away quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Put away quantity is required.")
    @DecimalMin(value = "0.01", message = "Put-away quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Target warehouse ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Target warehouse ID cannot be empty.")
    private Long toWarehouseId;

    @Schema(description = "Target zone ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Target zone ID cannot be empty.")
    private Long toLocationId;

    @Schema(description = "Target bin ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Target bin ID cannot be empty.")
    private Long toAreaId;

    @Schema(description = "Notes.", example = "Notes info.")
    private String remark;

}

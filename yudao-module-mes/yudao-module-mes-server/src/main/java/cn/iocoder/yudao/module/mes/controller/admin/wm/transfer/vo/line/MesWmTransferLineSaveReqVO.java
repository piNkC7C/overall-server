package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 转移单行 Save Request VO")
@Data
public class MesWmTransferLineSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "转移单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Transfer order code is required.")
    private Long transferId;

    @Schema(description = "库存记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inventoryrecord code is required.")
    private Long materialStockId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "转移数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Transfer quantity is required.")
    @DecimalMin(value = "0.01", message = "Transfer quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次编号", example = "1")
    private Long batchId;

    @Schema(description = "移出仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Remove warehouse code is required.")
    private Long fromWarehouseId;

    @Schema(description = "移出库区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Remove zone code is required.")
    private Long fromLocationId;

    @Schema(description = "移出库位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Remove bin code is required.")
    private Long fromAreaId;

    @Schema(description = "备注", example = "Notes info.")
    private String remark;

}

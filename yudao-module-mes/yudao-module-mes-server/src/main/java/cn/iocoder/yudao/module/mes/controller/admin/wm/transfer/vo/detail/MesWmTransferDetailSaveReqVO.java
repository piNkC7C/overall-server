package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 调拨明细 Save Request VO")
@Data
public class MesWmTransferDetailSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "转移单行编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Transfer order line code is required.")
    private Long lineId;

    @Schema(description = "转移单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Transfer order code is required.")
    private Long transferId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "上架数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Put away quantity is required.")
    @DecimalMin(value = "0.01", message = "Put-away quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次编号", example = "1")
    private Long batchId;

    @Schema(description = "移入仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Target warehouse ID cannot be empty.")
    private Long toWarehouseId;

    @Schema(description = "移入库区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Target zone ID cannot be empty.")
    private Long toLocationId;

    @Schema(description = "移入库位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Target bin ID cannot be empty.")
    private Long toAreaId;

    @Schema(description = "备注", example = "Notes info.")
    private String remark;

}

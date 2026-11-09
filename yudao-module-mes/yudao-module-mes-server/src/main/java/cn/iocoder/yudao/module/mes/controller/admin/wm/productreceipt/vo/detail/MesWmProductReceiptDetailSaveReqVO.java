package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 产品收货单明细新增/修改 Request VO")
@Data
public class MesWmProductReceiptDetailSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "收货单行编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Receiving order line code is required.")
    private Long lineId;

    @Schema(description = "收货单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Receiving order code is required.")
    private Long receiptId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "上架数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Put away quantity is required.")
    @Positive(message = "Put-away quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次编号", example = "1")
    private Long batchId;

    @Schema(description = "仓库编号", example = "1")
    private Long warehouseId;

    @Schema(description = "库区编号", example = "1")
    private Long locationId;

    @Schema(description = "库位编号", example = "1")
    private Long areaId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

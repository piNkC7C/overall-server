package cn.iocoder.yudao.module.mes.controller.admin.wm.miscreceipt.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 杂项入库单行新增/修改 Request VO")
@Data
public class MesWmMiscReceiptLineSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "入库单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound order code is required.")
    private Long receiptId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material is required.")
    private Long itemId;

    @Schema(description = "入库数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Inbound quantity is required.")
    @DecimalMin(value = "0.01", message = "Inbound quantity cannot be less than 0.01.")
    private BigDecimal quantity;

    @Schema(description = "批次号", example = "BATCH20260301")
    private String batchCode;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "库区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone is required.")
    private Long locationId;

    @Schema(description = "库位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bin is required.")
    private Long areaId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

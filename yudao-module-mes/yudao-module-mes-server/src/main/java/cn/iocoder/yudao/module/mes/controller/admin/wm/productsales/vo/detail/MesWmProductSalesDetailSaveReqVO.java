package cn.iocoder.yudao.module.mes.controller.admin.wm.productsales.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 销售出库明细新增/修改 Request VO")
@Data
public class MesWmProductSalesDetailSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "出库单行ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Outbound order line ID is required.")
    private Long lineId;

    @Schema(description = "出库单ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Outbound orderID is required.")
    private Long salesId;

    @Schema(description = "物料ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material is required.")
    private Long itemId;

    @Schema(description = "拣货数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    @NotNull(message = "Picking quantity is required.")
    private BigDecimal quantity;

    @Schema(description = "库存记录ID", example = "1")
    private Long materialStockId;

    @Schema(description = "批次ID", example = "1")
    private Long batchId;

    @Schema(description = "批次号", example = "BATCH001")
    private String batchCode;

    @Schema(description = "仓库ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "库区ID", example = "1")
    private Long locationId;

    @Schema(description = "库位ID", example = "1")
    private Long areaId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

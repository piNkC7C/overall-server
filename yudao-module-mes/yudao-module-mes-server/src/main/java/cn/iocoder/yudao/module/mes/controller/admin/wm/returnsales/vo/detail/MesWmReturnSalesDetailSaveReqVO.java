package cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 管理后台 - MES 销售退货相关
 *
 * @author 芋道源码
 */
@Schema(description = "管理后台 - MES 销售退货明细新增/修改 Request VO")
@Data
public class MesWmReturnSalesDetailSaveReqVO {

    @Schema(description = "明细ID", example = "1")
    private Long id;

    @Schema(description = "退货单ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Return orderID is required.")
    private Long returnId;

    @Schema(description = "行ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Line ID is required.")
    private Long lineId;

    @Schema(description = "物料ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次ID", example = "1")
    private Long batchId;

    @Schema(description = "批次号", example = "B20250101")
    private String batchCode;

    @Schema(description = "仓库ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "WarehouseID is required.")
    private Long warehouseId;

    @Schema(description = "库区ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone ID is required.")
    private Long locationId;

    @Schema(description = "库位ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "BinID is required.")
    private Long areaId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

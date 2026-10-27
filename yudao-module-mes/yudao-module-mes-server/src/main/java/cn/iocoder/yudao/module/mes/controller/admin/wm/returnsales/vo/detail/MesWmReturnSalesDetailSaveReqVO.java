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
@Schema(description = "Admin - MES sales return detail create / edit request.")
@Data
public class MesWmReturnSalesDetailSaveReqVO {

    @Schema(description = "DetailID.", example = "1")
    private Long id;

    @Schema(description = "Return orderID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Return orderID is required.")
    private Long returnId;

    @Schema(description = "Line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Line ID is required.")
    private Long lineId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "B20250101")
    private String batchCode;

    @Schema(description = "WarehouseID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "WarehouseID is required.")
    private Long warehouseId;

    @Schema(description = "Zone ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone ID is required.")
    private Long locationId;

    @Schema(description = "BinID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "BinID is required.")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

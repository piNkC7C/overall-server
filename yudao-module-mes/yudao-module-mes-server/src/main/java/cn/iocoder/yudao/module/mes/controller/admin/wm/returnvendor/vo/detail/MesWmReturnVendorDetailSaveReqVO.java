package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES supplier return detail create / edit request.")
@Data
public class MesWmReturnVendorDetailSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Return order code is required.")
    private Long returnId;
    @Schema(description = "Return order line code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Return order line code is required.")
    private Long lineId;

    @Schema(description = "Inventoryrecord code.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "300.00")
    @NotNull(message = "Return quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Return quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260101001")
    private String batchCode;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Zone code.", example = "1")
    private Long locationId;

    @Schema(description = "Bin code.", example = "1")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}


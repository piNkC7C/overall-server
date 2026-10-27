package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES production material return detail create / edit request.")
@Data
public class MesWmReturnIssueDetailSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Material return order line code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return order line code is required.")
    private Long lineId;

    @Schema(description = "Material return order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return order code is required.")
    private Long issueId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Inventoryrecord code.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "300.00")
    @NotNull(message = "Material return quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Material-return quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH20260101001")
    private String batchCode;

    @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse code is required.")
    private Long warehouseId;

    @Schema(description = "Zone code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone code is required.")
    private Long locationId;

    @Schema(description = "Bin code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bin code is required.")
    private Long areaId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES transfer order line response.")
@Data
public class MesWmTransferLineRespVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Transfer order code.", example = "1")
    private Long transferId;

    @Schema(description = "Inventoryrecord code.", example = "1")
    private Long materialStockId;

    @Schema(description = "Material code.", example = "1")
    private Long itemId;
    @Schema(description = "Material code.")
    private String itemCode;
    @Schema(description = "Material name.")
    private String itemName;
    @Schema(description = "Spec / Model")
    private String specification;
    @Schema(description = "Order characters name.")
    private String unitMeasureName;

    @Schema(description = "Transfer quantity.", example = "100")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;
    @Schema(description = "Lot no.")
    private String batchCode;

    @Schema(description = "Remove warehouse code.", example = "1")
    private Long fromWarehouseId;
    @Schema(description = "Remove warehouse name.")
    private String fromWarehouseName;

    @Schema(description = "Remove zone code.", example = "1")
    private Long fromLocationId;
    @Schema(description = "Remove zone name.")
    private String fromLocationName;

    @Schema(description = "Remove bin code.", example = "1")
    private Long fromAreaId;
    @Schema(description = "Remove bin name.")
    private String fromAreaName;

    @Schema(description = "Notes.", example = "Notes info.")
    private String remark;

}

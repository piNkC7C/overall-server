package cn.iocoder.yudao.module.mes.controller.admin.wm.transfer.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES transfer detail response.")
@Data
public class MesWmTransferDetailRespVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Transfer order line code.", example = "1")
    private Long lineId;

    @Schema(description = "Transfer order code.", example = "1")
    private Long transferId;

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

    @Schema(description = "Put away quantity.", example = "100")
    private BigDecimal quantity;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;
    @Schema(description = "Lot no.")
    private String batchCode;

    @Schema(description = "Target warehouse ID.", example = "1")
    private Long toWarehouseId;
    @Schema(description = "Target warehouse name.")
    private String toWarehouseName;

    @Schema(description = "Target zone ID.", example = "1")
    private Long toLocationId;
    @Schema(description = "Target zone name.")
    private String toLocationName;

    @Schema(description = "Target bin ID.", example = "1")
    private Long toAreaId;
    @Schema(description = "Target bin name.")
    private String toAreaName;

    @Schema(description = "Notes.", example = "Notes info.")
    private String remark;

}

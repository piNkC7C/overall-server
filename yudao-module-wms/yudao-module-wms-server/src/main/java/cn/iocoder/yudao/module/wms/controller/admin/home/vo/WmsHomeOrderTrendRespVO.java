package cn.iocoder.yudao.module.wms.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "WMS home document trend response VO.")
@Data
public class WmsHomeOrderTrendRespVO {

    @Schema(description = "Time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1778169600000")
    private LocalDateTime time;

    @Schema(description = "Inbound order quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Long receiptCount;

    @Schema(description = "Outbound order quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8")
    private Long shipmentCount;

    @Schema(description = "Warehouse transfer order quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Long movementCount;

    @Schema(description = "Inventory count order quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long checkCount;

}

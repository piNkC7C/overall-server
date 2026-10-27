package cn.iocoder.yudao.module.wms.controller.admin.order.shipment.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - WMS outbound orderdetail save request.")
@Data
public class WmsShipmentOrderDetailSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "SKU is required.")
    private Long skuId;

    @Schema(description = "Outbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Outbound quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Outbound quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Unit Price", example = "100.00")
    @DecimalMin(value = "0", message = "Unit price cannot be less than 0")
    private BigDecimal price;

    @Schema(description = "Line amount.", example = "1000.00")
    @DecimalMin(value = "0", message = "Line amount cannot be less than 0.")
    private BigDecimal totalPrice;

}

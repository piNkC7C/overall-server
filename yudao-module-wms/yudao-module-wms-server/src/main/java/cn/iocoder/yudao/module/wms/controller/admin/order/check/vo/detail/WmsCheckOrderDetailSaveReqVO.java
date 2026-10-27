package cn.iocoder.yudao.module.wms.controller.admin.order.check.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - WMS inventory count order detail save request.")
@Data
public class WmsCheckOrderDetailSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "SKU is required.")
    private Long skuId;

    @Schema(description = "Inventory code.", example = "1024")
    private Long inventoryId;

    @Schema(description = "Inbound time.")
    private LocalDateTime receiptTime;

    @Schema(description = "Book quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Book quantity cannot be empty.")
    @DecimalMin(value = "0", message = "Book quantity cannot be less than 0.")
    private BigDecimal quantity;

    @Schema(description = "Counted quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "98.00")
    @NotNull(message = "Counted quantity cannot be empty.")
    @DecimalMin(value = "0", message = "Counted quantity cannot be less than 0.")
    private BigDecimal checkQuantity;

    @Schema(description = "Unit Price", example = "1000.00")
    @DecimalMin(value = "0", message = "Unit price cannot be less than 0")
    private BigDecimal price;

}

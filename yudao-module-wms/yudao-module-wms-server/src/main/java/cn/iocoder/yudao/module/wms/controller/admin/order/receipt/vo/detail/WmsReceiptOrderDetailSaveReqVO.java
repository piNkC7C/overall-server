package cn.iocoder.yudao.module.wms.controller.admin.order.receipt.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - WMS 入库单明细保存 Request VO")
@Data
public class WmsReceiptOrderDetailSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2048")
    @NotNull(message = "SKU is required.")
    private Long skuId;

    @Schema(description = "入库数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Inbound quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Inbound quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "单价", example = "1000.00")
    @DecimalMin(value = "0", message = "Unit price cannot be less than 0")
    private BigDecimal price;

    @Schema(description = "行金额", example = "1500.00")
    @DecimalMin(value = "0", message = "Line amount cannot be less than 0.")
    private BigDecimal totalPrice;

}

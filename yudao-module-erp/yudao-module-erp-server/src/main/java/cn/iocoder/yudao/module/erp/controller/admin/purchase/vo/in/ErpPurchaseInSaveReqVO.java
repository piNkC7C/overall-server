package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - ERP purchase inbound create / edit request.")
@Data
public class ErpPurchaseInSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    private Long id;

    @Schema(description = "Settlement Account code.", example = "31189")
    private Long accountId;

    @Schema(description = "Inbound time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inbound time is required.")
    private LocalDateTime inTime;

    @Schema(description = "Purchase order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    @NotNull(message = "Purchase order code is required.")
    private Long orderId;

    @Schema(description = "Discount rate, percent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "99.88")
    private BigDecimal discountPercent;

    @Schema(description = "Other amount, in yuan.", example = "7127")
    private BigDecimal otherPrice;

    @Schema(description = "AttachmentAddress.", example = "https://www.iocoder.cn")
    private String fileUrl;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Inbound line list.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Inbound item code.", example = "11756")
        private Long id;

        @Schema(description = "Purchase order item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        @NotNull(message = "Purchase order item code is required.")
        private Long orderItemId;

        @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Warehouse code is required.")
        private Long warehouseId;

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Product code is required.")
        private Long productId;

        @Schema(description = "Product order characters order characters.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Product order characters order characters is required.")
        private Long productUnitId;

        @Schema(description = "Unit Price", example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Product quantity is required.")
        @DecimalMin(value = "0", inclusive = false, message = "Product quantity must be greater than 0.")
        private BigDecimal count;

        @Schema(description = "Tax rate, percent.", example = "99.88")
        private BigDecimal taxPercent;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

    }

}
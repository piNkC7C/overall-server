package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - ERP purchase order create / edit request.")
@Data
public class ErpPurchaseOrderSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    private Long id;

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1724")
    @NotNull(message = "Supplier code is required.")
    private Long supplierId;

    @Schema(description = "Settlement Account code.", example = "31189")
    private Long accountId;

    @Schema(description = "Purchase time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Purchase time is required.")
    private LocalDateTime orderTime;

    @Schema(description = "Discount rate, percent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "99.88")
    private BigDecimal discountPercent;

    @Schema(description = "Deposit amount, in yuan.", example = "7127")
    private BigDecimal depositPrice;

    @Schema(description = "AttachmentAddress.", example = "https://www.iocoder.cn")
    private String fileUrl;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Order line list.")
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Order item code.", example = "11756")
        private Long id;

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
        private BigDecimal count;

        @Schema(description = "Tax rate, percent.", example = "99.88")
        private BigDecimal taxPercent;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

    }

}
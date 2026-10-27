package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.check;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - ERP other outbound order create / edit request.")
@Data
public class ErpStockCheckSaveReqVO {

    @Schema(description = "Outbound code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
    private Long id;

    @Schema(description = "Outbound time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Outbound time is required.")
    private LocalDateTime checkTime;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

    @Schema(description = "Attachment URL.", example = "https://www.iocoder.cn/1.doc")
    private String fileUrl;

    @Schema(description = "Outbound item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Outbound item list is required.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Outbound item code.", example = "11756")
        private Long id;

        @Schema(description = "Warehouse code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Warehouse code is required.")
        private Long warehouseId;

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Product code is required.")
        private Long productId;

        @Schema(description = "Unit Price", example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "Book quantity (on-hand).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Book quantity cannot be empty.")
        private BigDecimal stockCount;

        @Schema(description = "Actual quantity (Actualinventory).", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Actual quantity is required.")
        private BigDecimal actualCount;

        @Schema(description = "Gain / Loss Qty", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Gain / Loss Qty is required.")
        private BigDecimal count;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

    }

}
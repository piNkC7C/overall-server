package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.out;

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
public class ErpStockOutSaveReqVO {

    @Schema(description = "Outbound code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
    private Long id;

    @Schema(description = "Customer code.", example = "3113")
    private Long customerId;

    @Schema(description = "Outbound time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Outbound time is required.")
    private LocalDateTime outTime;

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

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Product quantity is required.")
        private BigDecimal count;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

    }

}
package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.check;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - ERP 其它出库单新增/修改 Request VO")
@Data
public class ErpStockCheckSaveReqVO {

    @Schema(description = "出库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
    private Long id;

    @Schema(description = "出库时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Outbound time is required.")
    private LocalDateTime checkTime;

    @Schema(description = "备注", example = "Sample.")
    private String remark;

    @Schema(description = "附件 URL", example = "https://www.iocoder.cn/1.doc")
    private String fileUrl;

    @Schema(description = "出库项列表", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Outbound item list is required.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "出库项编号", example = "11756")
        private Long id;

        @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Warehouse code is required.")
        private Long warehouseId;

        @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        @NotNull(message = "Product code is required.")
        private Long productId;

        @Schema(description = "产品单价", example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "账面数量（当前库存）", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Book quantity cannot be empty.")
        private BigDecimal stockCount;

        @Schema(description = "实际数量（实际库存）", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Actual quantity is required.")
        private BigDecimal actualCount;

        @Schema(description = "盈亏数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Gain / Loss Qty is required.")
        private BigDecimal count;

        @Schema(description = "备注", example = "Sample.")
        private String remark;

    }

}
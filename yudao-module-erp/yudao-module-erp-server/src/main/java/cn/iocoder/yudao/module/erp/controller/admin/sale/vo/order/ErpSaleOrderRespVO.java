package cn.iocoder.yudao.module.erp.controller.admin.sale.vo.order;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - ERP sales order response.")
@Data
@ExcelIgnoreUnannotated
public class ErpSaleOrderRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Sales order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "XS001")
    @ExcelProperty("Sales Order No")
    private String no;

    @Schema(description = "Sales status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Sales Status")
    private Integer status;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1724")
    private Long customerId;
    @Schema(description = "Customer name.", example = "Overall.")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "Settlement Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "311.89")
    @ExcelProperty("Settlement Account ID")
    private Long accountId;

    @Schema(description = "Salesperson ID.", example = "1888")
    private Long saleUserId;

    @Schema(description = "Order time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Order Time")
    private LocalDateTime orderTime;

    @Schema(description = "Total quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15663")
    @ExcelProperty("Total Quantity")
    private BigDecimal totalCount;
    @Schema(description = "Final total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24906")
    @ExcelProperty("Final Total Price")
    private BigDecimal totalPrice;

    @Schema(description = "Product total, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal totalProductPrice;

    @Schema(description = "TotalTax, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal totalTaxPrice;

    @Schema(description = "Discount rate, percent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "99.88")
    private BigDecimal discountPercent;

    @Schema(description = "Discount amount", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal discountPrice;

    @Schema(description = "Deposit amount, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal depositPrice;

    @Schema(description = "AttachmentAddress.", example = "https://www.iocoder.cn")
    @ExcelProperty("Attachment URL")
    private String fileUrl;

    @Schema(description = "Notes.", example = "Example.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Creator.", example = "Overall.")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Order item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Schema(description = "Product info.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Product Info")
    private String productNames;

    // ========== sales outbound ==========

    @Schema(description = "Sales outbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal outCount;

    // ========== sales return ( outbound )) ==========

    @Schema(description = "Sales return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal returnCount;

    @Data
    public static class Item {

        @Schema(description = "Order item code.", example = "11756")
        private Long id;

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long productId;

        @Schema(description = "Product order characters order characters.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long productUnitId;

        @Schema(description = "Unit Price", example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Product quantity is required.")
        private BigDecimal count;

        @Schema(description = "Tax rate, percent.", example = "99.88")
        private BigDecimal taxPercent;

        @Schema(description = "Tax, in yuan.", example = "100.00")
        private BigDecimal taxPrice;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

        // ========== sales outbound ==========

        @Schema(description = "Sales outbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal outCount;

        // ========== sales return ( inbound )) ==========

        @Schema(description = "Sales return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal returnCount;

        // ========== relation field ==========

        @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Chocolate")
        private String productName;
        @Schema(description = "Productbarcode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "A9985")
        private String productBarCode;
        @Schema(description = "Product order characters name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Box")
        private String productUnitName;

        @Schema(description = "Inventory quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal stockCount; // 该字段仅仅在“详情”和“编辑”时使用

    }

}
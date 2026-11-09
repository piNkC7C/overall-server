package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - ERP 采购入库 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpPurchaseInRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "入库单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "XS001")
    @ExcelProperty("Inbound Order No")
    private String no;

    @Schema(description = "入库状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Inbound Status")
    private Integer status;

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1724")
    private Long supplierId;
    @Schema(description = "供应商名称", example = "Overall.")
    @ExcelProperty("Supplier Name")
    private String supplierName;

    @Schema(description = "结算账户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "311.89")
    @ExcelProperty("Settlement Account ID")
    private Long accountId;

    @Schema(description = "入库时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Inbound Time")
    private LocalDateTime inTime;

    @Schema(description = "采购订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    private Long orderId;
    @Schema(description = "采购订单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "XS001")
    private String orderNo;

    @Schema(description = "合计数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "15663")
    @ExcelProperty("Total Quantity")
    private BigDecimal totalCount;
    @Schema(description = "最终合计价格", requiredMode = Schema.RequiredMode.REQUIRED, example = "24906")
    @ExcelProperty("Final Total Price")
    private BigDecimal totalPrice;
    @Schema(description = "已付款金额，单位：元", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal paymentPrice;

    @Schema(description = "合计产品价格，单位：元", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal totalProductPrice;

    @Schema(description = "合计税额，单位：元", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal totalTaxPrice;

    @Schema(description = "优惠率，百分比", requiredMode = Schema.RequiredMode.REQUIRED, example = "99.88")
    private BigDecimal discountPercent;

    @Schema(description = "优惠金额，单位：元", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal discountPrice;

    @Schema(description = "定金金额，单位：元", requiredMode = Schema.RequiredMode.REQUIRED, example = "7127")
    private BigDecimal otherPrice;

    @Schema(description = "附件地址", example = "https://www.iocoder.cn")
    @ExcelProperty("Attachment URL")
    private String fileUrl;

    @Schema(description = "备注", example = "Example.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建人", example = "Overall.")
    private String creator;
    @Schema(description = "创建人名称", example = "Overall.")
    private String creatorName;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "入库项列表", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Schema(description = "产品信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Product Info")
    private String productNames;

    @Data
    public static class Item {

        @Schema(description = "入库项编号", example = "11756")
        private Long id;

        @Schema(description = "采购订单项编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        private Long orderItemId;

        @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long warehouseId;

        @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long productId;

        @Schema(description = "产品单位单位", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long productUnitId;

        @Schema(description = "产品单价", example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "产品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Product quantity is required.")
        private BigDecimal count;

        @Schema(description = "税率，百分比", example = "99.88")
        private BigDecimal taxPercent;

        @Schema(description = "税额，单位：元", example = "100.00")
        private BigDecimal taxPrice;

        @Schema(description = "备注", example = "Sample.")
        private String remark;

        // ========== relation field ==========

        @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Chocolate")
        private String productName;
        @Schema(description = "产品条码", requiredMode = Schema.RequiredMode.REQUIRED, example = "A9985")
        private String productBarCode;
        @Schema(description = "产品单位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Box")
        private String productUnitName;

        @Schema(description = "库存数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal stockCount; // 该字段仅仅在“详情”和“编辑”时使用

    }

}
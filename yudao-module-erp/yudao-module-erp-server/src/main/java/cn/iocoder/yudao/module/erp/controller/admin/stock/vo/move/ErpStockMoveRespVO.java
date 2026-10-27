package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.move;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.module.erp.enums.DictTypeConstants.AUDIT_STATUS;

@Schema(description = "Admin - ERP inventory transfer order response.")
@Data
@ExcelIgnoreUnannotated
public class ErpStockMoveRespVO {

    @Schema(description = "Transfer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
    @ExcelProperty("Transfer ID")
    private Long id;

    @Schema(description = "Transfer order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "S123")
    @ExcelProperty("Transfer No")
    private String no;

    @Schema(description = "Transfer time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Transfer Time")
    private LocalDateTime moveTime;

    @Schema(description = "Total quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15663")
    @ExcelProperty("Total Quantity")
    private BigDecimal totalCount;

    @Schema(description = "TotalAmount, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "24906")
    @ExcelProperty("Total Amount")
    private BigDecimal totalPrice;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(AUDIT_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Attachment URL.", example = "https://www.iocoder.cn/1.doc")
    private String fileUrl;

    @Schema(description = "Creator.", example = "Overall.")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Transfer item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Schema(description = "Product info.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Product Info")
    private String productNames;

    @Data
    public static class Item {

        @Schema(description = "Transfer item code.", example = "11756")
        private Long id;

        @Schema(description = "Outbound warehouse ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long fromWarehouseId;

        @Schema(description = "Inbound warehouse ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
        private Long toWarehouseId;

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long productId;

        @Schema(description = "Unit Price", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal productPrice;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        private BigDecimal count;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

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
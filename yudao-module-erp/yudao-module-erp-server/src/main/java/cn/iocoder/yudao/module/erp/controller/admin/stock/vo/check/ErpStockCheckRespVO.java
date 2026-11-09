package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.check;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.module.erp.enums.DictTypeConstants.AUDIT_STATUS;

@Schema(description = "管理后台 - ERP 库存盘点单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpStockCheckRespVO {

    @Schema(description = "盘点编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
    @ExcelProperty("Count ID")
    private Long id;

    @Schema(description = "盘点单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "S123")
    @ExcelProperty("Count No")
    private String no;

    @Schema(description = "盘点时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Count Time")
    private LocalDateTime checkTime;

    @Schema(description = "合计数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "15663")
    @ExcelProperty("Total Quantity")
    private BigDecimal totalCount;

    @Schema(description = "合计金额，单位：元", requiredMode = Schema.RequiredMode.REQUIRED, example = "24906")
    @ExcelProperty("Total Amount")
    private BigDecimal totalPrice;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(AUDIT_STATUS)
    private Integer status;

    @Schema(description = "备注", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "附件 URL", example = "https://www.iocoder.cn/1.doc")
    private String fileUrl;

    @Schema(description = "创建人", example = "Overall.")
    private String creator;
    @Schema(description = "创建人名称", example = "Overall.")
    private String creatorName;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "盘点项列表", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Schema(description = "产品信息", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Product Info")
    private String productNames;

    @Data
    public static class Item {

        @Schema(description = "盘点项编号", example = "11756")
        private Long id;

        @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long warehouseId;

        @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "3113")
        private Long productId;

        @Schema(description = "产品单价", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
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

        // ========== relation field ==========

        @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Chocolate")
        private String productName;
        @Schema(description = "产品条码", requiredMode = Schema.RequiredMode.REQUIRED, example = "A9985")
        private String productBarCode;
        @Schema(description = "产品单位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Box")
        private String productUnitName;

    }

}
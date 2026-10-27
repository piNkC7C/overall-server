package cn.iocoder.yudao.module.statistics.controller.admin.product.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "Admin - productStats response.")
@Data
@ExcelIgnoreUnannotated
public class ProductStatisticsRespVO {

    @Schema(description = "ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12393")
    private Long id;

    @Schema(description = "StatsDate.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2023-12-16")
    @JsonFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    @ExcelProperty("Stats Date")
    private LocalDate time;

    @Schema(description = "ProductSPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15114")
    @ExcelProperty("SPU ID")
    private Long spuId;

    // Region product info

    @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product name.")
    @ExcelProperty("Product Name")
    private String name;

    @Schema(description = "Product cover image", requiredMode = Schema.RequiredMode.REQUIRED, example = "15114")
    @ExcelProperty("Product Cover Image")
    private String picUrl;

    // endregion

    @Schema(description = "Views.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17505")
    @ExcelProperty("Page Views")
    private Integer browseCount;

    @Schema(description = "Unique visitors.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11814")
    @ExcelProperty("Unique Visitors")
    private Integer browseUserCount;

    @Schema(description = "Favorite quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20950")
    @ExcelProperty("Favorite Count")
    private Integer favoriteCount;

    @Schema(description = "Add-to-cart quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28493")
    @ExcelProperty("Add-to-cart Quantity")
    private Integer cartCount;

    @Schema(description = "Order quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18966")
    @ExcelProperty("Order Quantity")
    private Integer orderCount;

    @Schema(description = "Paid quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15142")
    @ExcelProperty("Paid Quantity")
    private Integer orderPayCount;

    @Schema(description = "Payment amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11595")
    @ExcelProperty("Paid Amount, In Cents")
    private Integer orderPayPrice;

    @Schema(description = "Refund quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2591")
    @ExcelProperty("Refund Quantity")
    private Integer afterSaleCount;

    @Schema(description = "Refund amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "21709")
    @ExcelProperty("Refund Amount, In Cents")
    private Integer afterSaleRefundPrice;

    @Schema(description = "Visitor-to-pay conversion rate (percent).", requiredMode = Schema.RequiredMode.REQUIRED, example = "15")
    private Integer browseConvertPercent;

}
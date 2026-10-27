package cn.iocoder.yudao.module.trade.controller.admin.aftersale.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 交易售后 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AfterSaleBaseVO {

    @Schema(description = "After-sales sequence number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "202211190847450020500077")
    @NotNull(message = "After-sales sequence number is required.")
    private String no;

    @Schema(description = "After-sales status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "After-sales status is required.")
    private Integer status;

    @Schema(description = "After-sales type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "After-sales type is required.")
    private Integer type;

    @Schema(description = "After-sales method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "After-sales method is required.")
    private Integer way;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30337")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "Apply please reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Dislike")
    @NotNull(message = "Apply please reason is required.")
    private String applyReason;

    @Schema(description = "Extra description.", example = "Looks good.")
    private String applyDescription;

    @Schema(description = "Supporting images.", example = "https://www.iocoder.cn/1.png")
    private List<String> applyPicUrls;

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18078")
    @NotNull(message = "Order code is required.")
    private Long orderId;

    @Schema(description = "Order sequence number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022111917190001")
    @NotNull(message = "Order sequence number is required.")
    private String orderNo;

    @Schema(description = "Order item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "572")
    @NotNull(message = "Order item code is required.")
    private Long orderItemId;

    @Schema(description = "Product SPU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2888")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "Product SPU name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotNull(message = "Product SPU name is required.")
    private String spuName;

    @Schema(description = "Product SKU code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15657")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "Product Image", example = "https://www.iocoder.cn/2.png")
    private String picUrl;

    @Schema(description = "Purchase quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20012")
    @NotNull(message = "Purchase quantity cannot be empty.")
    private Integer count;

    @Schema(description = "Approval time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime auditTime;

    @Schema(description = "Approver.", example = "30835")
    private Long auditUserId;

    @Schema(description = "Approval notes.", example = "Not great")
    private String auditReason;

    @Schema(description = "Refund amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18077")
    @NotNull(message = "Refund amount, order characters ：Min is required.")
    private Integer refundPrice;

    @Schema(description = "Payment refund code.", example = "10271")
    private Long payRefundId;

    @Schema(description = "Refund time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime refundTime;

    @Schema(description = "Return carrier ID.", example = "10")
    private Long logisticsId;

    @Schema(description = "Return tracking number.", example = "610003952009")
    private String logisticsNo;

    @Schema(description = "Return time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime deliveryTime;

    @Schema(description = "Receiving time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime receiveTime;

    @Schema(description = "Receiving notes.", example = "Dislike")
    private String receiveReason;

}

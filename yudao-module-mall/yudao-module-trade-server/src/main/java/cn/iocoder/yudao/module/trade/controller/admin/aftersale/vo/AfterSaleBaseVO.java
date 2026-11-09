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

    @Schema(description = "售后流水号", requiredMode = Schema.RequiredMode.REQUIRED, example = "202211190847450020500077")
    @NotNull(message = "After-sales sequence number is required.")
    private String no;

    @Schema(description = "售后状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "After-sales status is required.")
    private Integer status;

    @Schema(description = "售后类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    @NotNull(message = "After-sales type is required.")
    private Integer type;

    @Schema(description = "售后方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    @NotNull(message = "After-sales method is required.")
    private Integer way;

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "30337")
    @NotNull(message = "User ID is required.")
    private Long userId;

    @Schema(description = "申请原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "Dislike")
    @NotNull(message = "Apply please reason is required.")
    private String applyReason;

    @Schema(description = "补充描述", example = "Looks good.")
    private String applyDescription;

    @Schema(description = "补充凭证图片", example = "https://www.iocoder.cn/1.png")
    private List<String> applyPicUrls;

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18078")
    @NotNull(message = "Order code is required.")
    private Long orderId;

    @Schema(description = "订单流水号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022111917190001")
    @NotNull(message = "Order sequence number is required.")
    private String orderNo;

    @Schema(description = "订单项编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "572")
    @NotNull(message = "Order item code is required.")
    private Long orderItemId;

    @Schema(description = "商品 SPU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "2888")
    @NotNull(message = "Product SPU code is required.")
    private Long spuId;

    @Schema(description = "商品 SPU 名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotNull(message = "Product SPU name is required.")
    private String spuName;

    @Schema(description = "商品 SKU 编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "15657")
    @NotNull(message = "Product SKU code is required.")
    private Long skuId;

    @Schema(description = "商品图片", example = "https://www.iocoder.cn/2.png")
    private String picUrl;

    @Schema(description = "购买数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "20012")
    @NotNull(message = "Purchase quantity cannot be empty.")
    private Integer count;

    @Schema(description = "审批时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime auditTime;

    @Schema(description = "审批人", example = "30835")
    private Long auditUserId;

    @Schema(description = "审批备注", example = "Not great")
    private String auditReason;

    @Schema(description = "退款金额，单位：分", requiredMode = Schema.RequiredMode.REQUIRED, example = "18077")
    @NotNull(message = "Refund amount, order characters ：Min is required.")
    private Integer refundPrice;

    @Schema(description = "支付退款编号", example = "10271")
    private Long payRefundId;

    @Schema(description = "退款时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime refundTime;

    @Schema(description = "退货物流公司编号", example = "10")
    private Long logisticsId;

    @Schema(description = "退货物流单号", example = "610003952009")
    private String logisticsNo;

    @Schema(description = "退货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime deliveryTime;

    @Schema(description = "收货时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime receiveTime;

    @Schema(description = "收货备注", example = "Dislike")
    private String receiveReason;

}

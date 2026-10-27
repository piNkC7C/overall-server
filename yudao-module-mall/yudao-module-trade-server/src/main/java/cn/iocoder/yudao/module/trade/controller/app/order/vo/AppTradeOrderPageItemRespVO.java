package cn.iocoder.yudao.module.trade.controller.app.order.vo;

import cn.iocoder.yudao.module.trade.controller.app.order.vo.item.AppTradeOrderItemRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "User App - order trade page item response.")
@Data
public class AppTradeOrderPageItemRespVO {

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Order sequence number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1146347329394184195")
    private String no;

    @Schema(description = "Order type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer type;

    @Schema(description = "Order status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Purchased quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Integer productCount;

    @Schema(description = "Is not review.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean commentStatus;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== Price + payment Basic Info ==========

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long payOrderId;

    @Schema(description = "Payable, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Integer payPrice;

    // ========== 收件 + 物流基本信息 ==========

    @Schema(description = "Delivery Method", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer deliveryType;

    /**
     * 订单项数组
     */
    private List<AppTradeOrderItemRespVO> items;

    // ========== 营销基本信息 ==========

    @Schema(description = "Group buy record code.", example = "100")
    private Long combinationRecordId;

}

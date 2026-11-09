package cn.iocoder.yudao.module.trade.api.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单信息 Response DTO
 *
 * @author HUIHUI
 */
@Schema(description = "RPC 服务 - 订单信息 Response DTO")
@Data
public class TradeOrderRespDTO {

    // ========== orderBasic Info ==========

    @Schema(description = "订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "订单流水号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1146347329394184195")
    private String no;

    @Schema(description = "订单类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type; // See TradeOrderTypeEnum enum

    @Schema(description = "订单来源", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer terminal; // See TerminalEnum enum

    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "用户 IP", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String userIp;

    @Schema(description = "用户备注", example = "This product is pretty good")
    private String userRemark;

    @Schema(description = "订单状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See TradeOrderStatusEnum enum

    @Schema(description = "购买的商品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer productCount;

    @Schema(description = "订单完成时间")
    private LocalDateTime finishTime;

    @Schema(description = "订单取消时间")
    private LocalDateTime cancelTime;

    @Schema(description = "取消类型", example = "1")
    private Integer cancelType; // See TradeOrderCancelTypeEnum enum

    @Schema(description = "商家备注", example = "This user returns often")
    private String remark;

    @Schema(description = "是否评价", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean commentStatus;

    // ========== Price + payment Basic Info ==========

    @Schema(description = "支付订单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long payOrderId;

    @Schema(description = "是否已支付", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean payStatus;

}

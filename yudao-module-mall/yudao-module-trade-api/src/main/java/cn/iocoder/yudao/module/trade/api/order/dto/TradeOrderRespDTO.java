package cn.iocoder.yudao.module.trade.api.order.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单信息 Response DTO
 *
 * @author HUIHUI
 */
@Schema(description = "RPC service - order info Response DTO.")
@Data
public class TradeOrderRespDTO {

    // ========== orderBasic Info ==========

    @Schema(description = "Order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Order sequence number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1146347329394184195")
    private String no;

    @Schema(description = "Order type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type; // See TradeOrderTypeEnum enum

    @Schema(description = "Order source.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer terminal; // See TerminalEnum enum

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "User IP.", requiredMode = Schema.RequiredMode.REQUIRED, example = "127.0.0.1")
    private String userIp;

    @Schema(description = "User notes.", example = "This product is pretty good")
    private String userRemark;

    @Schema(description = "Order status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    private Integer status; // See TradeOrderStatusEnum enum

    @Schema(description = "Purchased quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer productCount;

    @Schema(description = "Ordercomplete time.")
    private LocalDateTime finishTime;

    @Schema(description = "Ordercancel time.")
    private LocalDateTime cancelTime;

    @Schema(description = "Cancel type.", example = "1")
    private Integer cancelType; // See TradeOrderCancelTypeEnum enum

    @Schema(description = "Merchant notes.", example = "This user returns often")
    private String remark;

    @Schema(description = "Is not review.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean commentStatus;

    // ========== Price + payment Basic Info ==========

    @Schema(description = "Payment code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long payOrderId;

    @Schema(description = "Is not already payment.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean payStatus;

}

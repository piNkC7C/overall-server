package cn.iocoder.yudao.module.trade.controller.admin.order.vo;

import cn.iocoder.yudao.framework.common.enums.TerminalEnum;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.framework.common.validation.Mobile;
import cn.iocoder.yudao.module.trade.enums.order.TradeOrderStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - trade order page request.")
@Data
public class TradeOrderPageReqVO extends PageParam {

    @Schema(description = "Order no.", example = "88888888")
    private String no;

    @Schema(description = "User ID.", example = "1024")
    private Long userId;

    @Schema(description = "Nickname", example = "Alex")
    private String userNickname;

    @Schema(description = "Userphone number.", example = "Alex")
    @Mobile
    private String userMobile;

    @Schema(description = "Delivery Method", example = "1")
    private Integer deliveryType;

    @Schema(description = "Shipping carrierID.", example = "1")
    private Long logisticsId;

    @Schema(description = "Pickup Store code.", example = "[1,2]")
    private List<Long> pickUpStoreIds;

    @Schema(description = "Pickup Check-in Code.", example = "12345678")
    private String pickUpVerifyCode;

    @Schema(description = "Order type.", example = "1")
    private Integer type;

    @Schema(description = "Order status.", example = "1")
    @InEnum(value = TradeOrderStatusEnum.class, message = "Order status must be {value}.")
    private Integer status;

    @Schema(description = "Payment channel.", example = "wx_lite")
    private String payChannelCode;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Order source.", example = "10")
    @InEnum(value = TerminalEnum.class, message = "Order source {value}.")
    private Integer terminal;

}

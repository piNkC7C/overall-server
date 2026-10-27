package cn.iocoder.yudao.module.pay.controller.admin.order.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - payment page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayOrderPageReqVO extends PageParam {

    @Schema(description = "App code.", example = "1024")
    private Long appId;

    @Schema(description = "Channel code.", example = "wx_app")
    private String channelCode;

    @Schema(description = "Merchant order number.", example = "4096")
    private String merchantOrderId;

    @Schema(description = "Channel code.", example = "1888")
    private String channelOrderNo;

    @Schema(description = "Payment order no.", example = "2014888")
    private String no;

    @Schema(description = "Payment status.", example = "0")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}

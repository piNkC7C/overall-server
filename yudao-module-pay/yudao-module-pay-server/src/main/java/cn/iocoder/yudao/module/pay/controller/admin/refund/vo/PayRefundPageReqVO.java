package cn.iocoder.yudao.module.pay.controller.admin.refund.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - refund page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayRefundPageReqVO extends PageParam {

    @Schema(description = "App code.", example = "1024")
    private Long appId;

    @Schema(description = "Channel code.", example = "wx_app")
    private String channelCode;

    @Schema(description = "Merchant payment number.", example = "10")
    private String merchantOrderId;

    @Schema(description = "Merchant refund number.", example = "20")
    private String merchantRefundId;

    @Schema(description = "Channel payment order no.", example = "30")
    private String channelOrderNo;

    @Schema(description = "Channelrefund no.", example = "40")
    private String channelRefundNo;

    @Schema(description = "Refund status.", example = "0")
    private Integer status;

    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @Schema(description = "Create time.")
    private LocalDateTime[] createTime;

}

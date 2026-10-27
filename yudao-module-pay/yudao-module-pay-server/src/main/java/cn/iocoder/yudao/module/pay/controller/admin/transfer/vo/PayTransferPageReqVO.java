package cn.iocoder.yudao.module.pay.controller.admin.transfer.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - transfer order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PayTransferPageReqVO extends PageParam {

    @Schema(description = "Transfer order no.")
    private String no;

    @Schema(description = "App code.", example = "12831")
    private Long appId;

    @Schema(description = "Channel code.", example = "wx_app")
    private String channelCode;

    @Schema(description = "Merchant transfer number.", example = "17481")
    private String merchantOrderId;

    @Schema(description = "Transfer status.", example = "2")
    private Integer status;

    @Schema(description = "Receipt person Name.", example = "Alex.")
    private String userName;

    @Schema(description = "Receipt person account.", example = "26589")
    private String userAccount;

    @Schema(description = "Channel transfer order no.")
    private String channelTransferNo;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}

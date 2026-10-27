package cn.iocoder.yudao.module.trade.controller.app.brokerage.vo.record;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.trade.enums.brokerage.BrokerageRecordBizTypeEnum;
import cn.iocoder.yudao.module.trade.enums.brokerage.BrokerageRecordStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Reseller record page request VO.")
@Data
public class AppBrokerageRecordPageReqVO extends PageParam {

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Business type.", example = "1")
    @InEnum(value = BrokerageRecordBizTypeEnum.class, message = "Business type must be {value}.")
    private Integer bizType;

    @Schema(description = "Status.", example = "1")
    @InEnum(value = BrokerageRecordStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

}

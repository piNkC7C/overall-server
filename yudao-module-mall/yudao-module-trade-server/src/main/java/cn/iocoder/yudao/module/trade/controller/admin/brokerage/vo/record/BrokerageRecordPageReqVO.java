package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.record;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Commission record page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BrokerageRecordPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "25973")
    private Long userId;

    @Schema(description = "Business type.", example = "1")
    private Integer bizType;

    @Schema(description = "Status.", example = "1")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "User type.", example = "1")
    private Integer sourceUserLevel;

}

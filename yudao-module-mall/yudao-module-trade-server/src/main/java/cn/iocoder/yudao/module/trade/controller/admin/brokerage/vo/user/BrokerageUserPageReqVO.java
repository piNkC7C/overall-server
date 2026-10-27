package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.user;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - distributorpage request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BrokerageUserPageReqVO extends PageParam {

    @Schema(description = "Promoter code.", example = "4587")
    private Long bindUserId;

    @Schema(description = "Promo Eligibility", example = "true")
    private Boolean brokerageEnabled;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "User level.", example = "1") // 注意，这了不是用户的会员等级，而是过滤推广的层级
    private Integer level;

    @Schema(description = "Bind time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] bindUserTime;

}

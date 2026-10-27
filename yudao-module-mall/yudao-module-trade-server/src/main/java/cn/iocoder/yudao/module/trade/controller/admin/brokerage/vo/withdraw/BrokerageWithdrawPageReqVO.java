package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.withdraw;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.trade.enums.brokerage.BrokerageWithdrawStatusEnum;
import cn.iocoder.yudao.module.trade.enums.brokerage.BrokerageWithdrawTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Commission withdrawal page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BrokerageWithdrawPageReqVO extends PageParam {

    @Schema(description = "User ID.", example = "11436")
    private Long userId;

    @Schema(description = "Withdrawal type.", example = "1")
    @InEnum(value = BrokerageWithdrawTypeEnum.class, message = "Withdrawal type must be {value}.")
    private Integer type;

    @Schema(description = "Legal name.", example = "Sam.")
    private String userName;

    @Schema(description = "Account.", example = "886779132")
    private String userAccount;

    @Schema(description = "Bank name", example = "1")
    private String bankName;

    @Schema(description = "Status.", example = "1")
    @InEnum(value = BrokerageWithdrawStatusEnum.class, message = "Status must be {value}.")
    private Integer status;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}

package cn.iocoder.yudao.module.pay.controller.app.wallet.vo.transaction;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.date.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Schema(description = "App - wallet transactionpage request.")
@Data
public class AppPayWalletTransactionPageReqVO extends PageParam {

    /**
     * 类型 - 收入
     */
    public static final Integer TYPE_INCOME = 1;
    /**
     * 类型 - 支出
     */
    public static final Integer TYPE_EXPENSE = 2;

    @Schema(description = "Type.",  example = "1")
    private Integer type;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}

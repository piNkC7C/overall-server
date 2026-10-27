package cn.iocoder.yudao.module.statistics.controller.admin.member.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - memberStats response.")
@Data
public class MemberSummaryRespVO {

    @Schema(description = "Member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer userCount;

    @Schema(description = "Top-up member quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "221")
    private Integer rechargeUserCount;

    @Schema(description = "Top-up amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer rechargePrice;

    // TODO @疯狂：要不干脆这个字段改成：orderPayPrice？？
    @Schema(description = "Expense amount, unit: cents.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Integer expensePrice; // 只计算 mall 交易订单的支付金额，不考虑退款

}

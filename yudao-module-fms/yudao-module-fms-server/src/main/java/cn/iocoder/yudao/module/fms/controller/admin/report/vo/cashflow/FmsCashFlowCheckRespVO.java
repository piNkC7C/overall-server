package cn.iocoder.yudao.module.fms.controller.admin.report.vo.cashflow;

import cn.iocoder.yudao.module.fms.controller.admin.report.vo.balance.FmsBalanceSheetCheckRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Cash-flow statement check response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FmsCashFlowCheckRespVO extends FmsBalanceSheetCheckRespVO {

    @Schema(description = "Whether the balance sheet meets cash-flow statement source rules.", example = "true")
    private Boolean balanceSheetReady;

}

package cn.iocoder.yudao.module.trade.controller.admin.brokerage.vo.withdraw;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Reject the request request VO.")
@Data
@ToString(callSuper = true)
public class BrokerageWithdrawRejectReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7161")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Rejection reason.", example = "Not for.")
    @NotEmpty(message = "Rejection reason cannot be empty.")
    private String auditReason;

}

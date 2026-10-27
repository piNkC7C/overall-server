package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Schema(description = "Admin - FMS journal entryaccount balance response.")
@Data
@Accessors(chain = true)
public class FmsVoucherSubjectBalanceRespVO {

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long subjectId;

    @Schema(description = "Balance Direction.", example = "Debit")
    private String balanceDirection;

    @Schema(description = "Balance.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    private BigDecimal balance;

}

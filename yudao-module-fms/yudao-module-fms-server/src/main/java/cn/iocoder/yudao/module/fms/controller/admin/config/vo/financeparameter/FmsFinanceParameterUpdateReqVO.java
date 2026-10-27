package cn.iocoder.yudao.module.fms.controller.admin.config.vo.financeparameter;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.ledger.FmsLedgerBalanceModeEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsAccountingStandardEnum;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "FMS finance setting update request VO.")
@Data
public class FmsFinanceParameterUpdateReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "Accounting system.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Accounting system cannot be empty.")
    @InEnum(FmsAccountingStandardEnum.class)
    @DiffLogField(name = "Accounting Standard")
    private Integer standard;

    @Schema(description = "Account level.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @NotNull(message = "Account level cannot be empty.")
    @Min(value = 1, message = "Account level cannot be less than 1.")
    @Max(value = 8, message = "Account level cannot be greater than 8.")
    @DiffLogField(name = "Account Levels")
    private Integer level;

    @Schema(description = "Account coding rule.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4-2-2-2")
    @NotBlank(message = "Account coding rule is required.")
    @Size(max = 64, message = "Account coding rule cannot exceed 64 characters.")
    @DiffLogField(name = "Account coding rule.")
    private String subjectCodeRule;

    @Schema(description = "Book balance-direction mode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Book balance-direction mode cannot be empty.")
    @InEnum(FmsLedgerBalanceModeEnum.class)
    @DiffLogField(name = "Ledger Balance Direction")
    private Integer ledgerBalanceMode;

    @Schema(description = "Closing before is not require journal entry approval.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Closing before journal entry approval set is required.")
    @DiffLogField(name = "Journal entry approval after only then allow closing.")
    private Boolean voucherReviewRequired;

}

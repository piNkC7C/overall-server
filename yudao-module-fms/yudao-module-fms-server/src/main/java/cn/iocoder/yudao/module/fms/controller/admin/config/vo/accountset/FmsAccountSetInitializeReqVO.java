package cn.iocoder.yudao.module.fms.controller.admin.config.vo.accountset;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsAccountingStandardEnum;
import cn.iocoder.yudao.module.fms.enums.config.FmsCurrencyPresetEnum;
import cn.iocoder.yudao.module.fms.enums.ledger.FmsLedgerBalanceModeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - FMS 账套初始化 Request VO")
@Data
public class FmsAccountSetInitializeReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "本位币编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "RMB")
    @NotBlank(message = "Base currency cannot be empty.")
    @InEnum(value = FmsCurrencyPresetEnum.class, message = "Base currency must be {value}.")
    private String currencyCode;

    @Schema(description = "启用期间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Enabled period is required.")
    private LocalDateTime startTime;

    @Schema(description = "会计制度", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Accounting system cannot be empty.")
    @InEnum(value = FmsAccountingStandardEnum.class, message = "Accounting system must be {value}.")
    private Integer standard;

    @Schema(description = "科目层级", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @NotNull(message = "Account level cannot be empty.")
    @Min(value = 1, message = "Account level cannot be less than 1.")
    @Max(value = 8, message = "Account level cannot be greater than 8.")
    private Integer level;

    @Schema(description = "科目编码规则", requiredMode = Schema.RequiredMode.REQUIRED, example = "4-2-2-2")
    @NotBlank(message = "Account coding rule is required.")
    @Size(max = 64, message = "Account coding rule cannot exceed 64 characters.")
    private String subjectCodeRule;

    @Schema(description = "账簿余额方向模式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Book balance-direction mode cannot be empty.")
    @InEnum(FmsLedgerBalanceModeEnum.class)
    private Integer ledgerBalanceMode;

}

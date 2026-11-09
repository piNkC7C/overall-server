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

@Schema(description = "管理后台 - FMS 财务参数更新 Request VO")
@Data
public class FmsFinanceParameterUpdateReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books code is required.")
    private Long accountSetId;

    @Schema(description = "会计制度", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Accounting system cannot be empty.")
    @InEnum(FmsAccountingStandardEnum.class)
    @DiffLogField(name = "会计制度")
    private Integer standard;

    @Schema(description = "科目层级", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @NotNull(message = "Account level cannot be empty.")
    @Min(value = 1, message = "Account level cannot be less than 1.")
    @Max(value = 8, message = "Account level cannot be greater than 8.")
    @DiffLogField(name = "科目层级")
    private Integer level;

    @Schema(description = "科目编码规则", requiredMode = Schema.RequiredMode.REQUIRED, example = "4-2-2-2")
    @NotBlank(message = "Account coding rule is required.")
    @Size(max = 64, message = "Account coding rule cannot exceed 64 characters.")
    @DiffLogField(name = "科目编码规则")
    private String subjectCodeRule;

    @Schema(description = "账簿余额方向模式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Book balance-direction mode cannot be empty.")
    @InEnum(FmsLedgerBalanceModeEnum.class)
    @DiffLogField(name = "账簿余额方向")
    private Integer ledgerBalanceMode;

    @Schema(description = "结账前是否要求凭证审核", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Closing before journal entry approval set is required.")
    @DiffLogField(name = "凭证审核后才允许结账")
    private Boolean voucherReviewRequired;

}

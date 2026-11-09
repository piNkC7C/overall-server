package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "管理后台 - FMS 凭证分录保存 Request VO")
@Data
public class FmsVoucherEntrySaveReqVO {

    @Schema(description = "凭证分录编号", example = "1024")
    private Long id;

    @Schema(description = "摘要内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pay for office supplies")
    @NotBlank(message = "Summary is required.")
    @Size(max = 500, message = "Summary length cannot exceed 500 characters.")
    private String digest;

    @Schema(description = "科目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Account is required.")
    private Long subjectId;

    @Schema(description = "数量", example = "10")
    @DecimalMin(value = "0", message = "Quantity cannot be less than 0.")
    @Digits(integer = 14, fraction = 4, message = "Quantity can have at most 4 decimal places.")
    private BigDecimal quantity;

    @Schema(description = "单价", example = "20.50")
    @DecimalMin(value = "0", message = "Unit price cannot be less than 0")
    @Digits(integer = 12, fraction = 6, message = "Unit price can have at most 6 decimal places.")
    private BigDecimal unitPrice;

    @Schema(description = "借方金额", example = "205.00")
    @Digits(integer = 16, fraction = 2, message = "Debit amount can have at most 2 decimal places.")
    private BigDecimal debitAmount;

    @Schema(description = "贷方金额", example = "205.00")
    @Digits(integer = 16, fraction = 2, message = "Credit amount can have at most 2 decimal places.")
    private BigDecimal creditAmount;

    @Schema(description = "辅助核算项目数组")
    @Valid
    private List<AuxiliaryItem> auxiliaries;

    @Schema(description = "管理后台 - FMS 凭证分录辅助核算项目")
    @Data
    public static class AuxiliaryItem {

        @Schema(description = "辅助核算类别编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
        @NotNull(message = "Auxiliary accounting type cannot be empty.")
        private Long typeId;

        @Schema(description = "辅助核算项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Auxiliary accounting item is required.")
        private Long itemId;
    }

}

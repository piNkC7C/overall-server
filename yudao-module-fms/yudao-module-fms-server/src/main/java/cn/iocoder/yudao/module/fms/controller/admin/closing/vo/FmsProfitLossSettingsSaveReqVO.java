package cn.iocoder.yudao.module.fms.controller.admin.closing.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.closing.FmsClosingVoucherTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - FMS close P&L set save request.")
@Data
public class FmsProfitLossSettingsSaveReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Journal entry character code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Journal entry character is required.")
    private Long voucherWordId;

    @Schema(description = "Journal entrySummary.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Close P&L.")
    @NotBlank(message = "Journal entrySummary is required.")
    @Size(max = 500, message = "Journal entrySummary length cannot exceed 500 characters.")
    private String digest;

    @Schema(description = "Closing journal type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Closing journal type cannot be empty.")
    @InEnum(FmsClosingVoucherTypeEnum.class)
    private Integer voucherType;

    @Schema(description = "Prior-year P&L adjustment accountID.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1024")
    @NotNull(message = "Prior-year P&L adjustment account cannot be empty.")
    private Long priorYearAdjustmentSubjectId;

    @Schema(description = "Prior-year P&L closing accountID.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1025")
    @NotNull(message = "Prior-year P&L closing account cannot be empty.")
    private Long adjustmentClosingSubjectId;

    @Schema(description = "Other P&L closing accountID.", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1026")
    @NotNull(message = "Other P&L closing account cannot be empty.")
    private Long otherClosingSubjectId;

    @Schema(description = "Reverse by balance.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Closing method cannot be empty.")
    private Boolean reverseBalance;

    @Schema(description = "Closing date.", requiredMode = Schema.RequiredMode.REQUIRED, example = "31")
    @NotNull(message = "Closing date cannot be empty.")
    @Min(value = 1, message = "Closing date cannot be less than 1.")
    @Max(value = 31, message = "Closing date cannot be greater than 31.")
    private Integer closingDay;

}

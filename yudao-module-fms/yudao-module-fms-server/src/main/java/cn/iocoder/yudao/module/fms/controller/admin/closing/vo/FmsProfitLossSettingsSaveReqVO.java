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

@Schema(description = "管理后台 - FMS 结转损益设置保存 Request VO")
@Data
public class FmsProfitLossSettingsSaveReqVO {

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "凭证字编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Journal entry character is required.")
    private Long voucherWordId;

    @Schema(description = "凭证摘要", requiredMode = Schema.RequiredMode.REQUIRED, example = "Close P&L.")
    @NotBlank(message = "Journal entrySummary is required.")
    @Size(max = 500, message = "Journal entrySummary length cannot exceed 500 characters.")
    private String digest;

    @Schema(description = "结转凭证类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Closing journal type cannot be empty.")
    @InEnum(FmsClosingVoucherTypeEnum.class)
    private Integer voucherType;

    @Schema(description = "以前年度损益调整科目编号", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1024")
    @NotNull(message = "Prior-year P&L adjustment account cannot be empty.")
    private Long priorYearAdjustmentSubjectId;

    @Schema(description = "以前年度损益调整结转科目编号", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1025")
    @NotNull(message = "Prior-year P&L closing account cannot be empty.")
    private Long adjustmentClosingSubjectId;

    @Schema(description = "其他损益结转科目编号", requiredMode = Schema.RequiredMode.REQUIRED,
            example = "1026")
    @NotNull(message = "Other P&L closing account cannot be empty.")
    private Long otherClosingSubjectId;

    @Schema(description = "是否按余额反向结转", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Closing method cannot be empty.")
    private Boolean reverseBalance;

    @Schema(description = "结转日期", requiredMode = Schema.RequiredMode.REQUIRED, example = "31")
    @NotNull(message = "Closing date cannot be empty.")
    @Min(value = 1, message = "Closing date cannot be less than 1.")
    @Max(value = 31, message = "Closing date cannot be greater than 31.")
    private Integer closingDay;

}

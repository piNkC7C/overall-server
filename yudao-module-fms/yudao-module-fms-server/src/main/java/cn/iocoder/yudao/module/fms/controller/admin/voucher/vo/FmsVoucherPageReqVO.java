package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.fms.enums.voucher.FmsVoucherStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - FMS journal entry page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FmsVoucherPageReqVO extends PageParam {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Journal entry ID list.")
    @Size(max = 200, message = "Journal entry code cannot exceed 200.")
    private List<Long> ids;

    @Schema(description = "Journal entryDateRange.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] voucherTime;

    @Schema(description = "Journal entry character code.", example = "11")
    private Long voucherWordId;

    @Schema(description = "Journal entry no.", example = "1")
    private Integer voucherNumber;

    @Schema(description = "SummaryKeyword.", example = "Office supply")
    private String digest;

    @Schema(description = "Account code.", example = "1024")
    private Long subjectId;

    @Schema(description = "MinimumAmount.", example = "100")
    private BigDecimal minAmount;

    @Schema(description = "MaximumAmount.", example = "500")
    private BigDecimal maxAmount;

    @Schema(description = "Prepared byAdmin user ID.", example = "1")
    private Long creatorUserId;

    @Schema(description = "Approval status.", example = "0")
    @InEnum(FmsVoucherStatusEnum.class)
    private Integer status;

}

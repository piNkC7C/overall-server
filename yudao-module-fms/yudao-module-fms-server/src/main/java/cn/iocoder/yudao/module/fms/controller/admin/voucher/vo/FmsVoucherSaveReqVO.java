package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - FMS 凭证保存 Request VO")
@Data
public class FmsVoucherSaveReqVO {

    @Schema(description = "凭证编号", example = "1024")
    private Long id;

    @Schema(description = "账套编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "凭证字编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Journal entry character is required.")
    private Long voucherWordId;

    @Schema(description = "凭证号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Journal entry no. is required.")
    @Min(value = 1, message = "Journal number must be greater than 0.")
    private Integer voucherNumber;

    @Schema(description = "凭证日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Journal entryDate is required.")
    private LocalDateTime voucherTime;

    @Schema(description = "附单据张数", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Supporting-document count cannot be empty.")
    @Min(value = 0, message = "Supporting-document count cannot be less than 0.")
    private Integer attachmentCount;

    @Schema(description = "凭证分录数组", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @Size(min = 2, message = "A journal entry needs at least two lines.")
    private List<FmsVoucherEntrySaveReqVO> entries;

}

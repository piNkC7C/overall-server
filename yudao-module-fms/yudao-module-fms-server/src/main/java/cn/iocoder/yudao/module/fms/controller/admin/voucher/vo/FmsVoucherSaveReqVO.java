package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - FMS journal entry save request.")
@Data
public class FmsVoucherSaveReqVO {

    @Schema(description = "Journal entry code.", example = "1024")
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Journal entry character code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Journal entry character is required.")
    private Long voucherWordId;

    @Schema(description = "Journal entry no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Journal entry no. is required.")
    @Min(value = 1, message = "Journal number must be greater than 0.")
    private Integer voucherNumber;

    @Schema(description = "Journal entryDate.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Journal entryDate is required.")
    private LocalDateTime voucherTime;

    @Schema(description = "Supporting-document count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Supporting-document count cannot be empty.")
    @Min(value = 0, message = "Supporting-document count cannot be less than 0.")
    private Integer attachmentCount;

    @Schema(description = "Journal entry entry Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    @Valid
    @Size(min = 2, message = "A journal entry needs at least two lines.")
    private List<FmsVoucherEntrySaveReqVO> entries;

}

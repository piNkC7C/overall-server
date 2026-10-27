package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(description = "Admin - FMS journal entry move request.")
@Data
public class FmsVoucherMoveReqVO {

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Books is required.")
    private Long accountSetId;

    @Schema(description = "Journal entryMonth.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-08")
    @NotBlank(message = "Journal entryMonth is required.")
    @Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])", message = "Journal entryMonth format must is yyyy-MM.")
    private String month;

    @Schema(description = "Journal entry character code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
    @NotNull(message = "Journal entry character is required.")
    private Long voucherWordId;

    @Schema(description = "Original journal number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6")
    @NotNull(message = "Original journal number cannot be empty.")
    @Min(value = 1, message = "Original journal number must be greater than 0.")
    private Integer sourceNumber;

    @Schema(description = "Move to journal entry no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Move to journal entry no. is required.")
    @Min(value = 1, message = "Target journal number must be greater than 0.")
    private Integer targetNumber;

}

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

@Schema(description = "Admin - FMS journal entry entry save request.")
@Data
public class FmsVoucherEntrySaveReqVO {

    @Schema(description = "Journal entry entry code.", example = "1024")
    private Long id;

    @Schema(description = "Summary content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pay for office supplies")
    @NotBlank(message = "Summary is required.")
    @Size(max = 500, message = "Summary length cannot exceed 500 characters.")
    private String digest;

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Account is required.")
    private Long subjectId;

    @Schema(description = "Quantity.", example = "10")
    @DecimalMin(value = "0", message = "Quantity cannot be less than 0.")
    @Digits(integer = 14, fraction = 4, message = "Quantity can have at most 4 decimal places.")
    private BigDecimal quantity;

    @Schema(description = "Unit Price", example = "20.50")
    @DecimalMin(value = "0", message = "Unit price cannot be less than 0")
    @Digits(integer = 12, fraction = 6, message = "Unit price can have at most 6 decimal places.")
    private BigDecimal unitPrice;

    @Schema(description = "Debit amount.", example = "205.00")
    @Digits(integer = 16, fraction = 2, message = "Debit amount can have at most 2 decimal places.")
    private BigDecimal debitAmount;

    @Schema(description = "Credit amount.", example = "205.00")
    @Digits(integer = 16, fraction = 2, message = "Credit amount can have at most 2 decimal places.")
    private BigDecimal creditAmount;

    @Schema(description = "Auxiliary accounting item Array.")
    @Valid
    private List<AuxiliaryItem> auxiliaries;

    @Schema(description = "Admin - FMS journal entry entry auxiliary accounting item.")
    @Data
    public static class AuxiliaryItem {

        @Schema(description = "Auxiliary category ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "11")
        @NotNull(message = "Auxiliary accounting type cannot be empty.")
        private Long typeId;

        @Schema(description = "Auxiliary accounting item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        @NotNull(message = "Auxiliary accounting item is required.")
        private Long itemId;
    }

}

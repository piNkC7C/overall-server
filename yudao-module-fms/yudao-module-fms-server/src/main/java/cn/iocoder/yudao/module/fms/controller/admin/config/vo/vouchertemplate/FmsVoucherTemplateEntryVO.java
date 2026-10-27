package cn.iocoder.yudao.module.fms.controller.admin.config.vo.vouchertemplate;

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

@Schema(description = "Admin - FMS journal entrytemplate entry VO.")
@Data
public class FmsVoucherTemplateEntryVO {

    @Schema(description = "Summary content.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Summary is required.")
    @Size(max = 500, message = "Summary length cannot exceed 500 characters.")
    private String digest;

    @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Account is required.")
    private Long subjectId;

    @Schema(description = "Quantity.")
    @DecimalMin(value = "0", message = "Quantity cannot be less than 0.")
    @Digits(integer = 14, fraction = 4, message = "Quantity can have at most 4 decimal places.")
    private BigDecimal quantity;

    @Schema(description = "Unit Price")
    @DecimalMin(value = "0", message = "Unit price cannot be less than 0")
    @Digits(integer = 12, fraction = 6, message = "Unit price can have at most 6 decimal places.")
    private BigDecimal unitPrice;

    @Schema(description = "Debit amount.")
    @Digits(integer = 16, fraction = 2, message = "Debit amount can have at most 2 decimal places.")
    private BigDecimal debitAmount;

    @Schema(description = "Credit amount.")
    @Digits(integer = 16, fraction = 2, message = "Credit amount can have at most 2 decimal places.")
    private BigDecimal creditAmount;

    @Schema(description = "Auxiliary accounting item Array.")
    @Valid
    private List<AuxiliaryItem> auxiliaries;

    @Schema(description = "Admin - FMS journal entrytemplate entry auxiliary accounting item.")
    @Data
    public static class AuxiliaryItem {

        @Schema(description = "Auxiliary accounting type.")
        private Integer type;

        @Schema(description = "Auxiliary category ID", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Auxiliary accounting type cannot be empty.")
        private Long typeId;

        @Schema(description = "Auxiliary accounting item code.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Auxiliary accounting item is required.")
        private Long itemId;

        @Schema(description = "Auxiliary accounting item name.")
        private String name;
    }

}

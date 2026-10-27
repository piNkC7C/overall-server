package cn.iocoder.yudao.module.oa.controller.admin.reimbursement.vo;

import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Expense report create / update request VO.")
@Data
public class OaReimbursementSaveReqVO {

    @Schema(description = "Apply please code.", example = "1024")
    private Long id;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer-project travel reimbursement")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Urgency", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Urgency is required")
    @InDict(type = DictTypeConstants.APPLY_URGENCY, message = "Urgency must be {value}.")
    private Integer urgency;

    @Schema(description = "Reference user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Reference is required.")
    private Long witnessUserId;

    @Schema(description = "Related customer.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Demo Technology Inc.")
    @NotBlank(message = "Related customer cannot be empty.")
    @Size(max = 255, message = "Related customer cannot exceed 255 characters.")
    private String customerName;

    @Schema(description = "Reimbursement method.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Reimbursement method cannot be empty.")
    @InDict(type = DictTypeConstants.REIMBURSEMENT_PAYMENT_METHOD, message = "Reimbursement method must be {value}.")
    private Integer paymentMethod;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    @Size(max = 5, message = "Attachment cannot exceed 5.")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 1024, message = "AttachmentAddress cannot exceed 1024 characters.") String> fileUrls;

    @Schema(description = "Apply please reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Reimburse travel during customer acceptance")
    @NotBlank(message = "Apply please reason is required.")
    @Size(max = 5000, message = "Apply please reason cannot exceed 5000 characters.")
    private String reason;

    @Schema(description = "Reimbursement lines.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Reimbursement lines cannot be empty.")
    @Valid
    private List<@NotNull(message = "Reimbursement lines cannot be empty.") Item> items;


    @Schema(description = "Admin - Reimbursement lines request.")
    @Data
    public static class Item {

        @Schema(description = "Expense time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
        @NotNull(message = "Expense time cannot be empty.")
        private LocalDateTime expenseTime;

        @Schema(description = "Expense Type", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Expense Type is required.")
        @InDict(type = DictTypeConstants.EXPENSE_TYPE, message = "Expense Type must be {value}.")
        private Integer expenseType;

        @Schema(description = "Expense Notes", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer acceptance travel expense")
        @NotBlank(message = "Expense Notes is required.")
        private String description;

        @Schema(description = "Voucher slip count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Voucher slip count cannot be empty.")
        @Min(value = 0, message = "Voucher slip count cannot be less than 0.")
        private Integer invoiceCount;

        @Schema(description = "Reimbursement amount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Reimbursement amount cannot be empty.")
        @DecimalMin(value = "0", message = "Reimbursement amount cannot be less than 0.")
        @Digits(integer = 16, fraction = 2, message = "Amount can have at most 16 integer digits and 2 decimal places.")
        private BigDecimal price;

    }

}

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

@Schema(description = "管理后台 - 费用报销新增/修改 Request VO")
@Data
public class OaReimbursementSaveReqVO {

    @Schema(description = "申请编号", example = "1024")
    private Long id;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer-project travel reimbursement")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "紧急程度", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Urgency is required")
    @InDict(type = DictTypeConstants.APPLY_URGENCY, message = "Urgency must be {value}.")
    private Integer urgency;

    @Schema(description = "证明人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Reference is required.")
    private Long witnessUserId;

    @Schema(description = "相关客户", requiredMode = Schema.RequiredMode.REQUIRED, example = "Demo Technology Inc.")
    @NotBlank(message = "Related customer cannot be empty.")
    @Size(max = 255, message = "Related customer cannot exceed 255 characters.")
    private String customerName;

    @Schema(description = "报销方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Reimbursement method cannot be empty.")
    @InDict(type = DictTypeConstants.REIMBURSEMENT_PAYMENT_METHOD, message = "Reimbursement method must be {value}.")
    private Integer paymentMethod;

    @Schema(description = "附件地址列表", example = "[\"https://example.com/file.pdf\"]")
    @Size(max = 5, message = "Attachment cannot exceed 5.")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 1024, message = "AttachmentAddress cannot exceed 1024 characters.") String> fileUrls;

    @Schema(description = "申请原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "Reimburse travel during customer acceptance")
    @NotBlank(message = "Apply please reason is required.")
    @Size(max = 5000, message = "Apply please reason cannot exceed 5000 characters.")
    private String reason;

    @Schema(description = "报销明细", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Reimbursement lines cannot be empty.")
    @Valid
    private List<@NotNull(message = "Reimbursement lines cannot be empty.") Item> items;


    @Schema(description = "管理后台 - 报销明细 Request VO")
    @Data
    public static class Item {

        @Schema(description = "费用发生时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
        @NotNull(message = "Expense time cannot be empty.")
        private LocalDateTime expenseTime;

        @Schema(description = "费用类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Expense Type is required.")
        @InDict(type = DictTypeConstants.EXPENSE_TYPE, message = "Expense Type must be {value}.")
        private Integer expenseType;

        @Schema(description = "费用说明", requiredMode = Schema.RequiredMode.REQUIRED, example = "Customer acceptance travel expense")
        @NotBlank(message = "Expense Notes is required.")
        private String description;

        @Schema(description = "票据张数", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Voucher slip count cannot be empty.")
        @Min(value = 0, message = "Voucher slip count cannot be less than 0.")
        private Integer invoiceCount;

        @Schema(description = "报销金额", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
        @NotNull(message = "Reimbursement amount cannot be empty.")
        @DecimalMin(value = "0", message = "Reimbursement amount cannot be less than 0.")
        @Digits(integer = 16, fraction = 2, message = "Amount can have at most 16 integer digits and 2 decimal places.")
        private BigDecimal price;

    }

}

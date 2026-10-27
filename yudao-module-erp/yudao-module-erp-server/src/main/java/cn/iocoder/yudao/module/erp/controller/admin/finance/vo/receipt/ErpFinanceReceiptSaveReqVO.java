package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.receipt;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - ERP receipt order create / edit request.")
@Data
public class ErpFinanceReceiptSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23752")
    private Long id;

    @Schema(description = "Receipt time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Receipt time is required.")
    private LocalDateTime receiptTime;

    @Schema(description = "Accountant code.", example = "19690")
    private Long financeUserId;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29399")
    @NotNull(message = "Customer code is required.")
    private Long customerId;

    @Schema(description = "Receipt Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28989")
    @NotNull(message = "Receipt Account code is required.")
    private Long accountId;

    @Schema(description = "Discount amount", requiredMode = Schema.RequiredMode.REQUIRED, example = "11600")
    @NotNull(message = "Discount amount is required.")
    private BigDecimal discountPrice;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Receipt item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Receipt item list is required.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Receipt item code.", example = "11756")
        private Long id;

        @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Business type is required.")
        private Integer bizType;

        @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        @NotNull(message = "Business code is required.")
        private Long bizId;

        @Schema(description = "Received Amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        @NotNull(message = "Received Amount is required.")
        private BigDecimal receiptedPrice;

        @Schema(description = "This Times receipt, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        @NotNull(message = "This Times receipt is required.")
        private BigDecimal receiptPrice;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

    }

}
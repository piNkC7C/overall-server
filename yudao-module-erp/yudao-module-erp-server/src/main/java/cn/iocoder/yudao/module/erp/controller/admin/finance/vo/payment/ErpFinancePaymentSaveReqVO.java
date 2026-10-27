package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.payment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - ERP payment order create / edit request.")
@Data
public class ErpFinancePaymentSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23752")
    private Long id;

    @Schema(description = "Payment time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Payment time is required.")
    private LocalDateTime paymentTime;

    @Schema(description = "Accountant code.", example = "19690")
    private Long financeUserId;

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29399")
    @NotNull(message = "Supplier code is required.")
    private Long supplierId;

    @Schema(description = "Payment Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28989")
    @NotNull(message = "Payment Account code is required.")
    private Long accountId;

    @Schema(description = "Discount amount", requiredMode = Schema.RequiredMode.REQUIRED, example = "11600")
    @NotNull(message = "Discount amount is required.")
    private BigDecimal discountPrice;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Payment item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "Payment item list is required.")
    @Valid
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Payment item code.", example = "11756")
        private Long id;

        @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        @NotNull(message = "Business type is required.")
        private Integer bizType;

        @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        @NotNull(message = "Business code is required.")
        private Long bizId;

        @Schema(description = "Paid Amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        @NotNull(message = "Paid Amount is required.")
        private BigDecimal paidPrice;

        @Schema(description = "This Times payment, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        @NotNull(message = "This Times payment is required.")
        private BigDecimal paymentPrice;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

    }

}
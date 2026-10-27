package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.payment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - ERP payment order response.")
@Data
@ExcelIgnoreUnannotated
public class ErpFinancePaymentRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23752")
    private Long id;

    @Schema(description = "Payment order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "FKD888")
    private String no;

    @Schema(description = "Payment status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Payment time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime paymentTime;

    @Schema(description = "Accountant code.", example = "19690")
    private Long financeUserId;
    @Schema(description = "Accountant name.", example = "John.")
    private String financeUserName;

    @Schema(description = "Supplier code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29399")
    private Long supplierId;
    @Schema(description = "Supplier name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cherry Tomato Inc")
    private String supplierName;

    @Schema(description = "Payment Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28989")
    private Long accountId;
    @Schema(description = "Payment Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String accountName;

    @Schema(description = "TotalPrice, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13832")
    private BigDecimal totalPrice;

    @Schema(description = "Discount amount", requiredMode = Schema.RequiredMode.REQUIRED, example = "11600")
    private BigDecimal discountPrice;

    @Schema(description = "ActualPrice, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
    private BigDecimal paymentPrice;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Creator.", example = "Overall.")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Payment item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Payment item code.", example = "11756")
        private Long id;

        @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer bizType;

        @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        private Long bizId;

        @Schema(description = "Business order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        private String bizNo;

        @Schema(description = "Payable, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        private BigDecimal totalPrice;

        @Schema(description = "Paid Amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        private BigDecimal paidPrice;

        @Schema(description = "This Times payment, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        @NotNull(message = "This Times payment is required.")
        private BigDecimal paymentPrice;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

    }

}
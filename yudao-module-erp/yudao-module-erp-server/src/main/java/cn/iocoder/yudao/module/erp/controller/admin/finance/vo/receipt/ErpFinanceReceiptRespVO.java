package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.receipt;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - ERP receipt order response.")
@Data
@ExcelIgnoreUnannotated
public class ErpFinanceReceiptRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23752")
    private Long id;

    @Schema(description = "Receipt order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "FKD888")
    private String no;

    @Schema(description = "Receipt status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Receipt time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime receiptTime;

    @Schema(description = "Accountant code.", example = "19690")
    private Long financeUserId;
    @Schema(description = "Accountant name.", example = "John.")
    private String financeUserName;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "29399")
    private Long customerId;
    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cherry Tomato Inc")
    private String customerName;

    @Schema(description = "Receipt Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "28989")
    private Long accountId;
    @Schema(description = "Receipt Account name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "John.")
    private String accountName;

    @Schema(description = "TotalPrice, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "13832")
    private BigDecimal totalPrice;

    @Schema(description = "Discount amount", requiredMode = Schema.RequiredMode.REQUIRED, example = "11600")
    private BigDecimal discountPrice;

    @Schema(description = "ActualPrice, in yuan.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
    private BigDecimal receiptPrice;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Creator.", example = "Overall.")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Receipt item list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Item> items;

    @Data
    public static class Item {

        @Schema(description = "Receipt item code.", example = "11756")
        private Long id;

        @Schema(description = "Business type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer bizType;

        @Schema(description = "Business code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        private Long bizId;

        @Schema(description = "Business order no.", requiredMode = Schema.RequiredMode.REQUIRED, example = "11756")
        private String bizNo;

        @Schema(description = "Receivable, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        private BigDecimal totalPrice;

        @Schema(description = "Received Amount, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        private BigDecimal receiptedPrice;

        @Schema(description = "This Times receipt, order characters ：Min.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10000")
        @NotNull(message = "This Times receipt is required.")
        private BigDecimal receiptPrice;

        @Schema(description = "Notes.", example = "Sample.")
        private String remark;

    }

}
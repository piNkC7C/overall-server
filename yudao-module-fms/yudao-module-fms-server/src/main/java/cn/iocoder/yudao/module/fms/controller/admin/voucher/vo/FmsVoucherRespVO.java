package cn.iocoder.yudao.module.fms.controller.admin.voucher.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - FMS journal entry response.")
@Data
public class FmsVoucherRespVO {

    @Schema(description = "Journal entry code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "Books code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long accountSetId;

    @Schema(description = "Journal entry character code.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long voucherWordId;

    @Schema(description = "Journal entry character.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String voucherWordName;

    @Schema(description = "Journal entry no.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer voucherNumber;

    @Schema(description = "Journal entryDate.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime voucherTime;

    @Schema(description = "AttachmentAddressArray.")
    private List<String> attachmentUrls;

    @Schema(description = "Attachment count.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer attachmentCount;

    @Schema(description = "Debit amount.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal debitAmount;

    @Schema(description = "Credit amount.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal creditAmount;

    @Schema(description = "Total amount.", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal total;

    @Schema(description = "Approval status.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer status;

    @Schema(description = "Is not is closing createjournal entry.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean closingGenerated;

    @Schema(description = "Prepared byAdmin user ID.")
    private Long creatorUserId;

    @Schema(description = "Prepared byname.")
    private String creatorUserName;

    @Schema(description = "Approver admin user ID.")
    private Long reviewerUserId;

    @Schema(description = "Approval person name.")
    private String reviewerUserName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    @Schema(description = "Journal entry entry Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<Entry> entries;

    @Schema(description = "Admin - FMS journal entry entry response.")
    @Data
    public static class Entry {

        @Schema(description = "Entry code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Summary content.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String digest;

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long subjectId;

        @Schema(description = "Account code.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String subjectCode;

        @Schema(description = "Account name.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String subjectName;

        @Schema(description = "Quantity.")
        private BigDecimal quantity;

        @Schema(description = "Unit Price")
        private BigDecimal unitPrice;

        @Schema(description = "Debit amount.", requiredMode = Schema.RequiredMode.REQUIRED)
        private BigDecimal debitAmount;

        @Schema(description = "Credit amount.", requiredMode = Schema.RequiredMode.REQUIRED)
        private BigDecimal creditAmount;

        @Schema(description = "Sort", requiredMode = Schema.RequiredMode.REQUIRED)
        private Integer sort;

        @Schema(description = "Auxiliary combination ID.")
        private Long assistCombinationId;

        @Schema(description = "Auxiliary accounting item Array.")
        private List<AuxiliaryItem> auxiliaries;

        @Schema(description = "Admin - FMS journal entry entry auxiliary accounting item.")
        @Data
        public static class AuxiliaryItem {

            @Schema(description = "Auxiliary accounting type.", requiredMode = Schema.RequiredMode.REQUIRED)
            private Integer type;

            @Schema(description = "Auxiliary category ID", requiredMode = Schema.RequiredMode.REQUIRED)
            private Long typeId;

            @Schema(description = "Auxiliary accounting item code.", requiredMode = Schema.RequiredMode.REQUIRED)
            private Long itemId;

            @Schema(description = "Auxiliary accounting item name.", requiredMode = Schema.RequiredMode.REQUIRED)
            private String name;
        }
    }

}

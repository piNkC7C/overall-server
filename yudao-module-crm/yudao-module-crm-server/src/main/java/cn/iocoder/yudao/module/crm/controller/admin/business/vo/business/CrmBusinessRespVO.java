package cn.iocoder.yudao.module.crm.controller.admin.business.vo.business;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - CRM opportunity response.")
@Data
@ExcelIgnoreUnannotated
public class CrmBusinessRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32129")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Opportunity name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Opportunity Name")
    private String name;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10299")
    private Long customerId;
    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "Follow-up status.", requiredMode = Schema.RequiredMode.REQUIRED, example ="true")
    @ExcelProperty("Follow-up Status")
    private Boolean followUpStatus;

    @Schema(description = "Last Follow-up")
    @ExcelProperty("Last Follow-up Time")
    private LocalDateTime contactLastTime;

    @Schema(description = "Next Contact Time")
    @ExcelProperty("Next Contact Time")
    private LocalDateTime contactNextTime;

    @Schema(description = "Owner person user ID.", example = "25682")
    @ExcelProperty("Owner User ID")
    private Long ownerUserId;
    @Schema(description = "Owner person name.", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "Owner person department.")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "Opportunity status group code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25714")
    private Long statusTypeId;
    @Schema(description = "Opportunity status group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "In progress.")
    @ExcelProperty("Opportunity Status Group")
    private String statusTypeName;

    @Schema(description = "Opportunity status code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30320")
    private Long statusId;
    @Schema(description = "Status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Follow-up.")
    @ExcelProperty("Opportunity Status")
    private String statusName;

    @Schema
    @ExcelProperty("End Status")
    private Integer endStatus;

    @ExcelProperty("End Notes")
    private String endRemark;

    @Schema(description = "Expected Close Date")
    @ExcelProperty("Expected Close Date")
    private LocalDateTime dealTime;

    @Schema(description = "Producttotal amount.", example = "12025")
    @ExcelProperty("Product Total Amount")
    private BigDecimal totalProductPrice;

    @Schema(description = "Order discount.")
    @ExcelProperty("Order Discount")
    private BigDecimal discountPercent;

    @Schema(description = "Opportunity amount.", example = "12371")
    @ExcelProperty("Opportunity Amount")
    private BigDecimal totalPrice;

    @Schema(description = "Notes.", example = "Sample.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Creator.", example = "1024")
    @ExcelProperty("Creator")
    private String creator;
    @Schema(description = "Creator name.", example = "Overall.")
    @ExcelProperty("Creator Name")
    private String creatorName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Update time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

    @Schema(description = "Product list.")
    private List<Product> products;

    @Schema(description = "Product list.")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Product {

        @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
        private Long id;

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20529")
        private Long productId;
        @Schema(description = "Product name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
        private String productName;
        @Schema(description = "Productbarcode.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20529")
        private String productNo;
        @Schema(description = "Product order characters.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
        private int productUnit;

        @Schema(description = "Unit Price", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        private BigDecimal productPrice;

        @Schema(description = "OpportunityPrice.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        private BigDecimal businessPrice;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8911")
        private BigDecimal count;

        @Schema(description = "TotalPrice.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        private BigDecimal totalPrice;

    }

}

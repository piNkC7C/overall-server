package cn.iocoder.yudao.module.crm.controller.admin.contract.vo.contract;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - CRM contract response.")
@Data
@ExcelIgnoreUnannotated
public class CrmContractRespVO {

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @ExcelProperty("Contract No")
    private Long id;

    @Schema(description = "Contract name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @ExcelProperty("Contract Name")
    private String name;

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20230101")
    @ExcelProperty("Contract No")
    private String no;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18336")
    @ExcelProperty("Customer ID")
    private Long customerId;
    @Schema(description = "Customer name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18336")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "Opportunity code.", example = "10864")
    @ExcelProperty("Opportunity ID")
    private Long businessId;
    @Schema(description = "Opportunity name.", example = "10864")
    @ExcelProperty("Opportunity Name")
    private String businessName;

    @Schema(description = "Last Follow-up")
    @ExcelProperty("Last Follow-up Time")
    private LocalDateTime contactLastTime;

    @Schema(description = "Owner person user ID.", example = "25682")
    @ExcelProperty("Owner User ID")
    private Long ownerUserId;
    @Schema(description = "Owner person name.", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "Owner person department.")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "Workflow ID.", example = "1043")
    @ExcelProperty("Workflow ID")
    private String processInstanceId;

    @Schema(description = "Approval status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Approval Status")
    private Integer auditStatus;

    @Schema(description = "Order Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Order Date")
    private LocalDateTime orderDate;

    @Schema(description = "Start time.")
    @ExcelProperty("Start Time")
    private LocalDateTime startTime;

    @Schema(description = "End time.")
    @ExcelProperty("End Time")
    private LocalDateTime endTime;

    @Schema(description = "Producttotal amount.", example = "19510")
    @ExcelProperty("Product Total Amount")
    private BigDecimal totalProductPrice;

    @Schema(description = "Order discount.")
    @ExcelProperty("Order Discount")
    private BigDecimal discountPercent;

    @Schema(description = "Contract amount.", example = "5617")
    @ExcelProperty("Contract Amount")
    private BigDecimal totalPrice;

    @Schema(description = "Already collection amount.", example = "5617")
    @ExcelProperty("Collected Amount")
    private BigDecimal totalReceivablePrice;

    @Schema(description = "Customer Signer code.", example = "18546")
    private Long signContactId;
    @Schema(description = "Customer Signer", example = "Bean")
    @ExcelProperty("Customer Signer")
    private String signContactName;

    @Schema(description = "Company Signer", example = "14036")
    private Long signUserId;
    @Schema(description = "Company Signer", example = "Alex")
    @ExcelProperty("Company Signer")
    private String signUserName;

    @Schema(description = "Notes.", example = "Example.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "Creator.", example = "25682")
    @ExcelProperty("Creator")
    private String creator;

    @Schema(description = "Creator name.", example = "test")
    @ExcelProperty("Creator Name")
    private String creatorName;

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

        @Schema(description = "ContractPrice.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        private BigDecimal contractPrice;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8911")
        private BigDecimal count;

        @Schema(description = "TotalPrice.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        private BigDecimal totalPrice;

    }

}

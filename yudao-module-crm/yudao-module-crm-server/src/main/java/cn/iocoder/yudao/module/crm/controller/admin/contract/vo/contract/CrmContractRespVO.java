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

@Schema(description = "管理后台 - CRM 合同 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CrmContractRespVO {

    @Schema(description = "合同编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    @ExcelProperty("Contract No")
    private Long id;

    @Schema(description = "合同名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @ExcelProperty("Contract Name")
    private String name;

    @Schema(description = "合同编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "20230101")
    @ExcelProperty("Contract No")
    private String no;

    @Schema(description = "客户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "18336")
    @ExcelProperty("Customer ID")
    private Long customerId;
    @Schema(description = "客户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "18336")
    @ExcelProperty("Customer Name")
    private String customerName;

    @Schema(description = "商机编号", example = "10864")
    @ExcelProperty("Opportunity ID")
    private Long businessId;
    @Schema(description = "商机名称", example = "10864")
    @ExcelProperty("Opportunity Name")
    private String businessName;

    @Schema(description = "最后跟进时间")
    @ExcelProperty("Last Follow-up Time")
    private LocalDateTime contactLastTime;

    @Schema(description = "负责人的用户编号", example = "25682")
    @ExcelProperty("Owner User ID")
    private Long ownerUserId;
    @Schema(description = "负责人名字", example = "25682")
    @ExcelProperty("Owner Name")
    private String ownerUserName;
    @Schema(description = "负责人部门")
    @ExcelProperty("Owner Department")
    private String ownerUserDeptName;

    @Schema(description = "工作流编号", example = "1043")
    @ExcelProperty("Workflow ID")
    private String processInstanceId;

    @Schema(description = "审批状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty("Approval Status")
    private Integer auditStatus;

    @Schema(description = "下单日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Order Date")
    private LocalDateTime orderDate;

    @Schema(description = "开始时间")
    @ExcelProperty("Start Time")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    @ExcelProperty("End Time")
    private LocalDateTime endTime;

    @Schema(description = "产品总金额", example = "19510")
    @ExcelProperty("Product Total Amount")
    private BigDecimal totalProductPrice;

    @Schema(description = "整单折扣")
    @ExcelProperty("Order Discount")
    private BigDecimal discountPercent;

    @Schema(description = "合同金额", example = "5617")
    @ExcelProperty("Contract Amount")
    private BigDecimal totalPrice;

    @Schema(description = "已回款金额", example = "5617")
    @ExcelProperty("Collected Amount")
    private BigDecimal totalReceivablePrice;

    @Schema(description = "客户签约人编号", example = "18546")
    private Long signContactId;
    @Schema(description = "客户签约人", example = "Bean")
    @ExcelProperty("Customer Signer")
    private String signContactName;

    @Schema(description = "公司签约人", example = "14036")
    private Long signUserId;
    @Schema(description = "公司签约人", example = "Alex")
    @ExcelProperty("Company Signer")
    private String signUserName;

    @Schema(description = "备注", example = "Example.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "创建人", example = "25682")
    @ExcelProperty("Creator")
    private String creator;

    @Schema(description = "创建人名字", example = "test")
    @ExcelProperty("Creator Name")
    private String creatorName;

    @Schema(description = "更新时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Update Time")
    private LocalDateTime updateTime;

    @Schema(description = "产品列表")
    private List<Product> products;

    @Schema(description = "产品列表")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Product {

        @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "888")
        private Long id;

        @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "20529")
        private Long productId;
        @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
        private String productName;
        @Schema(description = "产品条码", requiredMode = Schema.RequiredMode.REQUIRED, example = "20529")
        private String productNo;
        @Schema(description = "产品单位", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
        private int productUnit;

        @Schema(description = "产品单价", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        private BigDecimal productPrice;

        @Schema(description = "合同价格", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        private BigDecimal contractPrice;

        @Schema(description = "产品数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "8911")
        private BigDecimal count;

        @Schema(description = "总计价格", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        private BigDecimal totalPrice;

    }

}

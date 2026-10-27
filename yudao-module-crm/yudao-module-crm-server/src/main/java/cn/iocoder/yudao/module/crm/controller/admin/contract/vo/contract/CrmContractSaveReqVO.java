package cn.iocoder.yudao.module.crm.controller.admin.contract.vo.contract;

import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmBusinessParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmContactParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmCustomerParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.SysAdminUserParseFunction;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - CRM contract create or update request.")
@Data
public class CrmContractSaveReqVO {

    @Schema(description = "Contract code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10430")
    private Long id;

    @Schema(description = "Contract name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Alex.")
    @DiffLogField(name = "Contract name.")
    @NotNull(message = "Contract name is required.")
    private String name;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "18336")
    @DiffLogField(name = "Customer.", function = CrmCustomerParseFunction.NAME)
    @NotNull(message = "Customer code is required.")
    private Long customerId;

    @Schema(description = "Opportunity code.", example = "10864")
    @DiffLogField(name = "Opportunity.", function = CrmBusinessParseFunction.NAME)
    private Long businessId;

    @Schema(description = "Owner person user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "17144")
    @DiffLogField(name = "Owner person.", function = SysAdminUserParseFunction.NAME)
    @NotNull(message = "Owner person is required.")
    private Long ownerUserId;

    @Schema(description = "Order Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @DiffLogField(name = "Order Date.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    @NotNull(message = "Order Date is required.")
    private LocalDateTime orderDate;

    @Schema(description = "Start time.")
    @DiffLogField(name = "Start time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "End time.")
    @DiffLogField(name = "End time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "Order discount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "55.00")
    @DiffLogField(name = "Order Discount")
    @NotNull(message = "Order discount cannot be empty.")
    private BigDecimal discountPercent;

    @Schema(description = "Contract amount.", example = "5617")
    @DiffLogField(name = "Contract amount.")
    @DecimalMin(value = "0", message = "Contract amount cannot be less than 0.")
    private BigDecimal totalPrice;

    @Schema(description = "Customer Signer code.", example = "18546")
    @DiffLogField(name = "Customer Signer", function = CrmContactParseFunction.NAME)
    private Long signContactId;

    @Schema(description = "Company Signer", example = "14036")
    @DiffLogField(name = "Company Signer", function = SysAdminUserParseFunction.NAME)
    private Long signUserId;

    @Schema(description = "Notes.", example = "Example.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Product list.")
    private List<Product> products;

    @Schema(description = "Product list.")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Product {

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20529")
        @NotNull(message = "Product code is required.")
        private Long productId;

        @Schema(description = "Unit Price", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        @NotNull(message = "Unit Price is required.")
        private BigDecimal productPrice;

        @Schema(description = "ContractPrice.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        @NotNull(message = "ContractPrice is required.")
        private BigDecimal contractPrice;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8911")
        @NotNull(message = "Product quantity is required.")
        private Integer count;

    }

}

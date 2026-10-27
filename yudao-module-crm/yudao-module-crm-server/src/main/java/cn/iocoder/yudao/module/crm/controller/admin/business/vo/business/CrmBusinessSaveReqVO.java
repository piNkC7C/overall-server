package cn.iocoder.yudao.module.crm.controller.admin.business.vo.business;

import cn.iocoder.yudao.module.crm.framework.operatelog.core.CrmCustomerParseFunction;
import cn.iocoder.yudao.module.crm.framework.operatelog.core.SysAdminUserParseFunction;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - CRM opportunity create or update request.")
@Data
public class CrmBusinessSaveReqVO {

    @Schema(description = "Primary key.", requiredMode = Schema.RequiredMode.REQUIRED, example = "32129")
    private Long id;

    @Schema(description = "Opportunity name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @DiffLogField(name = "Opportunity name.")
    @NotNull(message = "Opportunity name is required.")
    private String name;

    @Schema(description = "Customer code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10299")
    @DiffLogField(name = "Customer.", function = CrmCustomerParseFunction.NAME)
    @NotNull(message = "Customer is required.")
    private Long customerId;

    @Schema(description = "Next Contact Time")
    @DiffLogField(name = "Next Contact Time")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime contactNextTime;

    @Schema(description = "Owner person user ID.", example = "14334")
    @NotNull(message = "Owner person is required.")
    @DiffLogField(name = "Owner person.", function = SysAdminUserParseFunction.NAME)
    private Long ownerUserId;

    @Schema(description = "Opportunity status group code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "25714")
    @DiffLogField(name = "Opportunity status group.")
    @NotNull(message = "Opportunity status group is required.")
    private Long statusTypeId;

    @Schema(description = "Expected Close Date")
    @DiffLogField(name = "Expected Close Date")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime dealTime;

    @Schema(description = "Order discount.", requiredMode = Schema.RequiredMode.REQUIRED, example = "55.00")
    @DiffLogField(name = "Order Discount")
    @NotNull(message = "Order discount cannot be empty.")
    private BigDecimal discountPercent;

    @Schema(description = "Notes.", example = "Sample.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Contact code.", example = "110")
    private Long contactId; // 使用场景，在【联系人详情】添加商机时，如果需要关联两者，需要传递 contactId 字段

    @Schema(description = "Product list.")
    private List<BusinessProduct> products;

    @Schema(description = "Product list.")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BusinessProduct {

        @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20529")
        @NotNull(message = "Product code is required.")
        private Long productId;

        @Schema(description = "Unit Price", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        @NotNull(message = "Unit Price is required.")
        private BigDecimal productPrice;

        @Schema(description = "OpportunityPrice.", requiredMode = Schema.RequiredMode.REQUIRED, example = "123.00")
        @NotNull(message = "OpportunityPrice is required.")
        private BigDecimal businessPrice;

        @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8911")
        @NotNull(message = "Product quantity is required.")
        private Integer count;

    }

}

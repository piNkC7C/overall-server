package cn.iocoder.yudao.module.erp.controller.admin.finance.vo.payment;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - ERP payment order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpFinancePaymentPageReqVO extends PageParam {

    @Schema(description = "Payment order code.", example = "XS001")
    private String no;

    @Schema(description = "Payment time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] paymentTime;

    @Schema(description = "Supplier code.", example = "1724")
    private Long supplierId;

    @Schema(description = "Creator.", example = "666")
    private String creator;

    @Schema(description = "Accountant code.", example = "888")
    private String financeUserId;

    @Schema(description = "Settlement Account code.", example = "31189")
    private Long accountId;

    @Schema(description = "Payment status.", example = "2")
    private Integer status;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Business code.", example = "123")
    private String bizNo;

}
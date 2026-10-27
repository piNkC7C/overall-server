package cn.iocoder.yudao.module.erp.controller.admin.sale.vo.returns;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - ERP sales return page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpSaleReturnPageReqVO extends PageParam {

    public static final Integer REFUND_STATUS_NONE = 0;
    public static final Integer REFUND_STATUS_PART = 1;
    public static final Integer REFUND_STATUS_ALL = 2;

    @Schema(description = "Sales order code.", example = "XS001")
    private String no;

    @Schema(description = "Customer code.", example = "1724")
    private Long customerId;

    @Schema(description = "Return time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] returnTime;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Return status.", example = "2")
    private Integer status;

    @Schema(description = "Creator.")
    private String creator;

    @Schema(description = "Product code.", example = "1")
    private Long productId;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Settlement account ID.", example = "1")
    private Long accountId;

    @Schema(description = "Sales order no.", example = "1")
    private String orderNo;

    @Schema(description = "Refund status.", example = "1")
    private Integer refundStatus;

    @Schema(description = "Is not can refund.", example = "true")
    private Boolean refundEnable; // Matching refundStatus = [0, 1]

}
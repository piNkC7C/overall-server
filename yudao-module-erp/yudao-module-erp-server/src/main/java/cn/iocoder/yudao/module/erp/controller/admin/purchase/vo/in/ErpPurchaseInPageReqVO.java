package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - ERP purchase inbound page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpPurchaseInPageReqVO extends PageParam {

    public static final Integer PAYMENT_STATUS_NONE = 0;
    public static final Integer PAYMENT_STATUS_PART = 1;
    public static final Integer PAYMENT_STATUS_ALL = 2;

    @Schema(description = "Purchase order code.", example = "XS001")
    private String no;

    @Schema(description = "Supplier code.", example = "1724")
    private Long supplierId;

    @Schema(description = "Inbound time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] inTime;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Inbound status.", example = "2")
    private Integer status;

    @Schema(description = "Creator.")
    private String creator;

    @Schema(description = "Product code.", example = "1")
    private Long productId;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

    @Schema(description = "Settlement account ID.", example = "1")
    private Long accountId;

    @Schema(description = "Payment status.", example = "1")
    private Integer paymentStatus;

    @Schema(description = "Is not can payment.", example = "true")
    private Boolean paymentEnable; // Matching paymentStatus = [0, 1]

    @Schema(description = "Purchase order no.", example = "1")
    private String orderNo;

}
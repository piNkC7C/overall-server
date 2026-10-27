package cn.iocoder.yudao.module.erp.controller.admin.sale.vo.order;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - ERP sales order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpSaleOrderPageReqVO extends PageParam {

    /**
     * 出库状态 - 无
     */
    public static final Integer OUT_STATUS_NONE = 0;
    /**
     * 出库状态 - 部分
     */
    public static final Integer OUT_STATUS_PART = 1;
    /**
     * 出库状态 - 全部
     */
    public static final Integer OUT_STATUS_ALL = 2;

    /**
     * 退货状态 - 无
     */
    public static final Integer RETURN_STATUS_NONE = 0;
    /**
     * 退货状态 - 部分
     */
    public static final Integer RETURN_STATUS_PART = 1;
    /**
     * 退货状态 - 全部
     */
    public static final Integer RETURN_STATUS_ALL = 2;

    @Schema(description = "Sales order code.", example = "XS001")
    private String no;

    @Schema(description = "Customer code.", example = "1724")
    private Long customerId;

    @Schema(description = "Order time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] orderTime;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Sales status.", example = "2")
    private Integer status;

    @Schema(description = "Creator.")
    private String creator;

    @Schema(description = "Product code.", example = "1")
    private Long productId;

    @Schema(description = "Outbound status.", example = "2")
    private Integer outStatus;

    @Schema(description = "Return status.", example = "2")
    private Integer returnStatus;

    @Schema(description = "Is not can outbound.", example = "true")
    private Boolean outEnable;

    @Schema(description = "Is not can return.", example = "true")
    private Boolean returnEnable;

}
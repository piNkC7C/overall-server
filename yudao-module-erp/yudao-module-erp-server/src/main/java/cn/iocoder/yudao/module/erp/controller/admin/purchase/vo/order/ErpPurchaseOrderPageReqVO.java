package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.order;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - ERP purchase order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpPurchaseOrderPageReqVO extends PageParam {

    /**
     * 入库状态 - 无
     */
    public static final Integer IN_STATUS_NONE = 0;
    /**
     * 入库状态 - 部分
     */
    public static final Integer IN_STATUS_PART = 1;
    /**
     * 入库状态 - 全部
     */
    public static final Integer IN_STATUS_ALL = 2;

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

    @Schema(description = "Purchase order code.", example = "XS001")
    private String no;

    @Schema(description = "Supplier code.", example = "1724")
    private Long supplierId;

    @Schema(description = "Purchase time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] orderTime;

    @Schema(description = "Notes.", example = "Example.")
    private String remark;

    @Schema(description = "Purchase status.", example = "2")
    private Integer status;

    @Schema(description = "Creator.")
    private String creator;

    @Schema(description = "Product code.", example = "1")
    private Long productId;

    @Schema(description = "Inbound status.", example = "2")
    private Integer inStatus;

    @Schema(description = "Return status.", example = "2")
    private Integer returnStatus;

    @Schema(description = "Is not can inbound.", example = "true")
    private Boolean inEnable;

    @Schema(description = "Is not can return.", example = "true")
    private Boolean returnEnable;

}
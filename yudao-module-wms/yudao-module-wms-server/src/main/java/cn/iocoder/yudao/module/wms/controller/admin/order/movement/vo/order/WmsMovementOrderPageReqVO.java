package cn.iocoder.yudao.module.wms.controller.admin.order.movement.vo.order;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.wms.enums.order.WmsOrderStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - WMS warehouse transfer order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WmsMovementOrderPageReqVO extends PageParam {

    @Schema(description = "Warehouse transfer order no.", example = "YK202605110001")
    private String no;

    @Schema(description = "Document status.", example = "0")
    @InEnum(WmsOrderStatusEnum.class)
    private Integer status;

    @Schema(description = "Source warehouse code.", example = "1024")
    private Long sourceWarehouseId;

    @Schema(description = "Target warehouse code.", example = "2048")
    private Long targetWarehouseId;

    @Schema(description = "Document Date")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] orderTime;

    @Schema(description = "MinimumQuantity.", example = "1.00")
    private BigDecimal totalQuantityMin;

    @Schema(description = "MaximumQuantity.", example = "100.00")
    private BigDecimal totalQuantityMax;

    @Schema(description = "Minimum total amount.", example = "1.00")
    private BigDecimal totalPriceMin;

    @Schema(description = "Maximum total amount.", example = "1000.00")
    private BigDecimal totalPriceMax;

    @Schema(description = "Createuser.", example = "1")
    private String creator;

    @Schema(description = "Updateuser.", example = "1")
    private String updater;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Update time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] updateTime;

}

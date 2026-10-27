package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.move;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.erp.enums.ErpAuditStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - ERP inventory transfer order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpStockMovePageReqVO extends PageParam {

    @Schema(description = "Transfer order no.", example = "S123")
    private String no;

    @Schema(description = "Transfer time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] moveTime;

    @Schema(description = "Status.", example = "10")
    @InEnum(ErpAuditStatus.class)
    private Integer status;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

    @Schema(description = "Creator.")
    private String creator;

    @Schema(description = "Product code.", example = "1")
    private Long productId;

    @Schema(description = "Outbound warehouse ID.", example = "1")
    private Long fromWarehouseId;

}
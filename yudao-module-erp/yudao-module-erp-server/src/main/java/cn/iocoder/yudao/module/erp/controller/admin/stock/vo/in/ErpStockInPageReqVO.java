package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.in;

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

@Schema(description = "Admin - ERP other inbound order page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpStockInPageReqVO extends PageParam {

    @Schema(description = "Inbound order no.", example = "S123")
    private String no;

    @Schema(description = "Supplier code.", example = "3113")
    private Long supplierId;

    @Schema(description = "Inbound time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] inTime;

    @Schema(description = "Status.", example = "10")
    @InEnum(ErpAuditStatus.class)
    private Integer status;

    @Schema(description = "Notes.", example = "Sample.")
    private String remark;

    @Schema(description = "Creator.")
    private String creator;

    @Schema(description = "Product code.", example = "1")
    private Long productId;

    @Schema(description = "Warehouse code.", example = "1")
    private Long warehouseId;

}
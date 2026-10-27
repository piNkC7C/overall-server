package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.record;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - ERP productinventorydetail page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpStockRecordPageReqVO extends PageParam {

    @Schema(description = "Product code.", example = "10625")
    private Long productId;

    @Schema(description = "Warehouse code.", example = "32407")
    private Long warehouseId;

    @Schema(description = "Business type.", example = "10")
    private Integer bizType;

    @Schema(description = "Business order no.", example = "Z110")
    private String bizNo;

    @Schema(description = "Create time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
package cn.iocoder.yudao.module.wms.controller.admin.inventory.vo.history;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "WMS inventory ledger page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WmsInventoryHistoryPageReqVO extends PageParam {

    @Schema(description = "Product code.", example = "ITEM001")
    private String itemCode;

    @Schema(description = "Product name.", example = "Fuji apple")
    private String itemName;

    @Schema(description = "Product SKU code.", example = "1024")
    private Long skuId;

    @Schema(description = "SKU code.", example = "SKU001")
    private String skuCode;

    @Schema(description = "SKU name.", example = "10kg case")
    private String skuName;

    @Schema(description = "Warehouse code.", example = "2048")
    private Long warehouseId;

    @Schema(description = "Document no.", example = "RK202605110001")
    private String orderNo;

    @Schema(description = "Document type.", example = "1")
    private Integer orderType;

    @Schema(description = "Action time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}

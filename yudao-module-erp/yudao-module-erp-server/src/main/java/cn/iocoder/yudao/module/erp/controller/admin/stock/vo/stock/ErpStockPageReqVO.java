package cn.iocoder.yudao.module.erp.controller.admin.stock.vo.stock;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - ERP inventory page request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpStockPageReqVO extends PageParam {

    @Schema(description = "Product code.", example = "19614")
    private Long productId;

    @Schema(description = "Warehouse code.", example = "2802")
    private Long warehouseId;

}
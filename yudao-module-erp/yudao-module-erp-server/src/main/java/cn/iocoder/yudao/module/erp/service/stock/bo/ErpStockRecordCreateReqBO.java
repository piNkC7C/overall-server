package cn.iocoder.yudao.module.erp.service.stock.bo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 库存明细的创建 Request BO
 *
 * @author 芋道源码
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErpStockRecordCreateReqBO {

    /**
     * 产品编号
     */
    @NotNull(message = "Product code is required.")
    private Long productId;
    /**
     * 仓库编号
     */
    @NotNull(message = "Warehouse code is required.")
    private Long warehouseId;
    /**
     * 出入库数量
     *
     * 正数，表示入库；负数，表示出库
     */
    @NotNull(message = "Inventory quantity cannot be empty.")
    private BigDecimal count;

    /**
     * 业务类型
     */
    @NotNull(message = "Business type is required.")
    private Integer bizType;
    /**
     * 业务编号
     */
    @NotNull(message = "Business code is required.")
    private Long bizId;
    /**
     * 业务项编号
     */
    @NotNull(message = "Business item code is required.")
    private Long bizItemId;
    /**
     * 业务单号
     */
    @NotNull(message = "Business order no. is required.")
    private String bizNo;

}

package cn.iocoder.yudao.module.promotion.api.combination.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 拼团记录的创建 Request DTO
 *
 * @author HUIHUI
 */
@Data
public class CombinationRecordCreateReqDTO {

    /**
     * 拼团活动编号
     */
    @NotNull(message = "Group buy campaign code is required.")
    private Long activityId;
    /**
     * spu 编号
     */
    @NotNull(message = "Spu code is required.")
    private Long spuId;
    /**
     * sku 编号
     */
    @NotNull(message = "Sku code is required.")
    private Long skuId;
    /**
     * 购买的商品数量
     */
    @NotNull(message = "Purchase quantity cannot be empty.")
    private Integer count;
    /**
     * 订单编号
     */
    @NotNull(message = "Order code is required.")
    private Long orderId;
    /**
     * 用户编号
     */
    @NotNull(message = "User ID is required.")
    private Long userId;
    /**
     * 团长编号
     */
    private Long headId;
    /**
     * 拼团商品单价
     */
    @NotNull(message = "Group buy productUnit Price is required.")
    private Integer combinationPrice;

}

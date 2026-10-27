package cn.iocoder.yudao.module.trade.controller.admin.aftersale.vo;

import cn.iocoder.yudao.module.trade.controller.admin.aftersale.vo.log.AfterSaleLogRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.base.member.user.MemberUserRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.base.product.property.ProductPropertyValueDetailRespVO;
import cn.iocoder.yudao.module.trade.controller.admin.order.vo.TradeOrderBaseVO;
import cn.iocoder.yudao.module.trade.controller.admin.order.vo.TradeOrderItemBaseVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Admin - after-sales order details response.")
@Data
public class AfterSaleDetailRespVO extends AfterSaleBaseVO {

    @Schema(description = "After-sales code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;



    /**
     * 订单基本信息
     */
    private TradeOrderBaseVO order;
    /**
     * 订单项列表
     */
    private OrderItem orderItem;

    /**
     * 用户信息
     */
    private MemberUserRespVO user;

    /**
     * 售后日志
     */
    private List<AfterSaleLogRespVO> logs;

    @Schema(description = "Admin - trade order details order item.")
    @Data
    public static class OrderItem extends TradeOrderItemBaseVO {

        /**
         * 属性数组
         */
        private List<ProductPropertyValueDetailRespVO> properties;

    }

}

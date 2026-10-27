package cn.iocoder.yudao.module.trade.controller.app.order;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.pay.api.notify.dto.PayOrderNotifyReqDTO;
import cn.iocoder.yudao.module.trade.controller.app.order.vo.*;
import cn.iocoder.yudao.module.trade.controller.app.order.vo.item.AppTradeOrderItemCommentCreateReqVO;
import cn.iocoder.yudao.module.trade.controller.app.order.vo.item.AppTradeOrderItemRespVO;
import cn.iocoder.yudao.module.trade.convert.order.TradeOrderConvert;
import cn.iocoder.yudao.module.trade.dal.dataobject.delivery.DeliveryExpressDO;
import cn.iocoder.yudao.module.trade.dal.dataobject.order.TradeOrderDO;
import cn.iocoder.yudao.module.trade.dal.dataobject.order.TradeOrderItemDO;
import cn.iocoder.yudao.module.trade.enums.order.TradeOrderStatusEnum;
import cn.iocoder.yudao.module.trade.framework.order.config.TradeOrderProperties;
import cn.iocoder.yudao.module.trade.service.aftersale.AfterSaleService;
import cn.iocoder.yudao.module.trade.service.delivery.DeliveryExpressService;
import cn.iocoder.yudao.module.trade.service.order.TradeOrderQueryService;
import cn.iocoder.yudao.module.trade.service.order.TradeOrderUpdateService;
import cn.iocoder.yudao.module.trade.service.price.TradePriceService;
import com.google.common.collect.Maps;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "User App - trade order.")
@RestController
@RequestMapping("/trade/order")
@Validated
@Slf4j
public class AppTradeOrderController {

    @Resource
    private TradeOrderUpdateService tradeOrderUpdateService;
    @Resource
    private TradeOrderQueryService tradeOrderQueryService;
    @Resource
    private DeliveryExpressService deliveryExpressService;
    @Resource
    private AfterSaleService afterSaleService;
    @Resource
    private TradePriceService priceService;

    @Resource
    private TradeOrderProperties tradeOrderProperties;

    @GetMapping("/settlement")
    @Operation(summary = "Get order settlement info.")
    public CommonResult<AppTradeOrderSettlementRespVO> settlementOrder(@Valid AppTradeOrderSettlementReqVO settlementReqVO) {
        return success(tradeOrderUpdateService.settlementOrder(getLoginUserId(), settlementReqVO));
    }

    @GetMapping("/settlement-product")
    @Operation(summary = "Get product settlement info.", description = "Used on product list and detail to get campaign prices.")
    @Parameter(name = "spuIds", description = "Product SPU ID list.")
    @PermitAll
    public CommonResult<List<AppTradeProductSettlementRespVO>> settlementProduct(@RequestParam("spuIds") List<Long> spuIds) {
        return success(priceService.calculateProductPrice(getLoginUserId(), spuIds));
    }

    @PostMapping("/create")
    @Operation(summary = "Createorder.")
    public CommonResult<AppTradeOrderCreateRespVO> createOrder(@Valid @RequestBody AppTradeOrderCreateReqVO createReqVO) {
        TradeOrderDO order = tradeOrderUpdateService.createOrder(getLoginUserId(), createReqVO);
        return success(new AppTradeOrderCreateRespVO().setId(order.getId()).setPayOrderId(order.getPayOrderId()));
    }

    @PostMapping("/update-paid")
    @Operation(summary = "Updateorder is already payment.") // 由 pay-module 支付服务，进行回调，可见 PayNotifyJob
    @PermitAll
    public CommonResult<Boolean> updateOrderPaid(@RequestBody PayOrderNotifyReqDTO notifyReqDTO) {
        tradeOrderUpdateService.updateOrderPaid(Long.valueOf(notifyReqDTO.getMerchantOrderId()),
                notifyReqDTO.getPayOrderId());
        return success(true);
    }

    @GetMapping("/get-detail")
    @Operation(summary = "Get trade order.")
    @Parameters({
            @Parameter(name = "id", description = "Trade order code."),
            @Parameter(name = "sync", description = "Is not sync payment status.", example = "true")
    })
    public CommonResult<AppTradeOrderDetailRespVO> getOrderDetail(@RequestParam("id") Long id,
                                                                  @RequestParam(value = "sync", required = false) Boolean sync) {
        // 1.1 searchorder
        TradeOrderDO order = tradeOrderQueryService.getOrder(getLoginUserId(), id);
        if (order == null) {
            return success(null);
        }
        // 1.2 sync 仅在等待支付
        if (Boolean.TRUE.equals(sync)
                && TradeOrderStatusEnum.isUnpaid(order.getStatus()) && !order.getPayStatus()) {
            tradeOrderUpdateService.syncOrderPayStatusQuietly(order.getId(), order.getPayOrderId());
            // 重新查询，因为同步后，可能会有变化
            order = tradeOrderQueryService.getOrder(id);
        }

        // 2.1 searchorder item
        List<TradeOrderItemDO> orderItems = tradeOrderQueryService.getOrderItemListByOrderId(order.getId());
        // 2.2 查询物流公司
        DeliveryExpressDO express = order.getLogisticsId() != null && order.getLogisticsId() > 0 ?
                deliveryExpressService.getDeliveryExpress(order.getLogisticsId()) : null;
        // 2.3 最终组合
        return success(TradeOrderConvert.INSTANCE.convert02(order, orderItems, tradeOrderProperties, express));
    }

    @GetMapping("/get-express-track-list")
    @Operation(summary = "Get trade order shipment tracking.")
    @Parameter(name = "id", description = "Trade order code.")
    public CommonResult<List<AppOrderExpressTrackRespDTO>> getOrderExpressTrackList(@RequestParam("id") Long id) {
        return success(TradeOrderConvert.INSTANCE.convertList02(
                tradeOrderQueryService.getExpressTrackList(id, getLoginUserId())));
    }

    @GetMapping("/page")
    @Operation(summary = "Get trade order page.")
    public CommonResult<PageResult<AppTradeOrderPageItemRespVO>> getOrderPage(AppTradeOrderPageReqVO reqVO) {
        // Searchorder
        PageResult<TradeOrderDO> pageResult = tradeOrderQueryService.getOrderPage(getLoginUserId(), reqVO);
        // Searchorder item
        List<TradeOrderItemDO> orderItems = tradeOrderQueryService.getOrderItemListByOrderId(
                convertSet(pageResult.getList(), TradeOrderDO::getId));
        // 最终组合
        return success(TradeOrderConvert.INSTANCE.convertPage02(pageResult, orderItems));
    }

    @GetMapping("/get-count")
    @Operation(summary = "Get trade order quantity.")
    public CommonResult<Map<String, Long>> getOrderCount() {
        Map<String, Long> orderCount = Maps.newLinkedHashMapWithExpectedSize(5);
        // All
        orderCount.put("allCount", tradeOrderQueryService.getOrderCount(getLoginUserId(), null, null));
        // 待付款（未支付）
        orderCount.put("unpaidCount", tradeOrderQueryService.getOrderCount(getLoginUserId(),
                TradeOrderStatusEnum.UNPAID.getStatus(), null));
        // 待发货
        orderCount.put("undeliveredCount", tradeOrderQueryService.getOrderCount(getLoginUserId(),
                TradeOrderStatusEnum.UNDELIVERED.getStatus(), null));
        // 待收货
        orderCount.put("deliveredCount", tradeOrderQueryService.getOrderCount(getLoginUserId(),
                TradeOrderStatusEnum.DELIVERED.getStatus(), null));
        // 待评价
        orderCount.put("uncommentedCount", tradeOrderQueryService.getOrderCount(getLoginUserId(),
                TradeOrderStatusEnum.COMPLETED.getStatus(), false));
        // After-sales quantity
        orderCount.put("afterSaleCount", afterSaleService.getApplyingAfterSaleCount(getLoginUserId()));
        return success(orderCount);
    }

    @PutMapping("/receive")
    @Operation(summary = "Confirm trade order receiving.")
    @Parameter(name = "id", description = "Trade order code.")
    public CommonResult<Boolean> receiveOrder(@RequestParam("id") Long id) {
        tradeOrderUpdateService.receiveOrderByMember(getLoginUserId(), id);
        return success(true);
    }

    @DeleteMapping("/cancel")
    @Operation(summary = "Cancel trade order.")
    @Parameter(name = "id", description = "Trade order code.")
    public CommonResult<Boolean> cancelOrder(@RequestParam("id") Long id) {
        tradeOrderUpdateService.cancelOrderByMember(getLoginUserId(), id);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Delete trade order.")
    @Parameter(name = "id", description = "Trade order code.")
    public CommonResult<Boolean> deleteOrder(@RequestParam("id") Long id) {
        tradeOrderUpdateService.deleteOrder(getLoginUserId(), id);
        return success(true);
    }

    // ========== order item ==========

    @GetMapping("/item/get")
    @Operation(summary = "Get trade order item.")
    @Parameter(name = "id", description = "Trade order item code.")
    public CommonResult<AppTradeOrderItemRespVO> getOrderItem(@RequestParam("id") Long id) {
        TradeOrderItemDO item = tradeOrderQueryService.getOrderItem(getLoginUserId(), id);
        return success(TradeOrderConvert.INSTANCE.convert03(item));
    }

    @PostMapping("/item/create-comment")
    @Operation(summary = "Create trade order item review.")
    public CommonResult<Long> createOrderItemComment(@RequestBody AppTradeOrderItemCommentCreateReqVO createReqVO) {
        return success(tradeOrderUpdateService.createOrderItemCommentByMember(getLoginUserId(), createReqVO));
    }

}

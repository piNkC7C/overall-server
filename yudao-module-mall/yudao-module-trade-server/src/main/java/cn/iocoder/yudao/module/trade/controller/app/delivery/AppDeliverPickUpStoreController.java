package cn.iocoder.yudao.module.trade.controller.app.delivery;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.trade.controller.app.delivery.vo.pickup.AppDeliveryPickUpStoreRespVO;
import cn.iocoder.yudao.module.trade.convert.delivery.DeliveryPickUpStoreConvert;
import cn.iocoder.yudao.module.trade.dal.dataobject.delivery.DeliveryPickUpStoreDO;
import cn.iocoder.yudao.module.trade.service.delivery.DeliveryPickUpStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "User App - Pickup Store.")
@RestController
@RequestMapping("/trade/delivery/pick-up-store")
@Validated
public class AppDeliverPickUpStoreController {

    @Resource
    private DeliveryPickUpStoreService deliveryPickUpStoreService;

    @GetMapping("/list")
    @Operation(summary = "Get Pickup Store list.")
    @Parameters({
            @Parameter(name = "latitude", description = "Precision.", example = "110"),
            @Parameter(name = "longitude", description = "Latitude", example = "120")
    })
    @PermitAll
    public CommonResult<List<AppDeliveryPickUpStoreRespVO>> getDeliveryPickUpStoreList(
            @RequestParam(value = "latitude", required = false) Double latitude,
            @RequestParam(value = "longitude", required = false) Double longitude) {
        List<DeliveryPickUpStoreDO> list = deliveryPickUpStoreService.getDeliveryPickUpStoreListByStatus(
                CommonStatusEnum.ENABLE.getStatus());
        return success(DeliveryPickUpStoreConvert.INSTANCE.convertList(list, latitude, longitude));
    }

    @GetMapping("/get")
    @Operation(summary = "Get Pickup Store.")
    @Parameter(name = "id", description = "Store ID.")
    @PermitAll
    public CommonResult<AppDeliveryPickUpStoreRespVO> getOrder(@RequestParam("id") Long id) {
        DeliveryPickUpStoreDO store = deliveryPickUpStoreService.getDeliveryPickUpStore(id);
        return success(DeliveryPickUpStoreConvert.INSTANCE.convert03(store));
    }

}

package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.pickup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Pickup Storecreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryPickUpStoreCreateReqVO extends DeliveryPickUpStoreBaseVO {

}

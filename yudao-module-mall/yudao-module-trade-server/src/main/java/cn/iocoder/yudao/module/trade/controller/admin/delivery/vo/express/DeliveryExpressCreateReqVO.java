package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.express;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Admin - Couriercreate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryExpressCreateReqVO extends DeliveryExpressBaseVO {

}

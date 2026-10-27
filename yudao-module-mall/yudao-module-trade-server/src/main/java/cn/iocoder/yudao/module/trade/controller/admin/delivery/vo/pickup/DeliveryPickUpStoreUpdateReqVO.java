package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.pickup;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "Admin - Pickup Storeupdate request.")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DeliveryPickUpStoreUpdateReqVO extends DeliveryPickUpStoreBaseVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23128")
    @NotNull(message = "Code is required.")
    private Long id;

}

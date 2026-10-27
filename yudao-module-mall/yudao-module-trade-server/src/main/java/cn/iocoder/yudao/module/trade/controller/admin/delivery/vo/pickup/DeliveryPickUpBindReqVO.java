package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.pickup;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Schema(description = "Pickup store bind redeemer request VO.")
@Data
@ToString(callSuper = true)
public class DeliveryPickUpBindReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23128")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Bound user ID group count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23128")
    @NotEmpty(message = "Bound user ID groups cannot be empty.")
    private List<Long> verifyUserIds;

}
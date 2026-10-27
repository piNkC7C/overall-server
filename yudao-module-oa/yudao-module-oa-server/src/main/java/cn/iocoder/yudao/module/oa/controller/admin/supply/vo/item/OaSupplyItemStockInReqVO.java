package cn.iocoder.yudao.module.oa.controller.admin.supply.vo.item;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "Office supply stock in request VO.")
@Data
public class OaSupplyItemStockInReqVO {

    @Schema(description = "Office-supply ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Office-supply ID cannot be empty.")
    private Long id;

    @Schema(description = "Inbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound quantity is required.")
    @Min(value = 1, message = "Inbound quantity cannot be less than {value}.")
    private Integer quantity;

}

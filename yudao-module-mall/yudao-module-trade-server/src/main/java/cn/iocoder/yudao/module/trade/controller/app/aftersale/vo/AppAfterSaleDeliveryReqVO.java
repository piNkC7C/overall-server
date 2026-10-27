package cn.iocoder.yudao.module.trade.controller.app.aftersale.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "After-sale return-goods request VO.")
@Data
public class AppAfterSaleDeliveryReqVO {

    @Schema(description = "After-sales code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "After-sales code is required.")
    private Long id;

    @Schema(description = "Return carrier ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Return carrier ID cannot be empty.")
    private Long logisticsId;

    @Schema(description = "Return tracking number.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SF123456789")
    @NotNull(message = "Return tracking number cannot be empty.")
    private String logisticsNo;

}

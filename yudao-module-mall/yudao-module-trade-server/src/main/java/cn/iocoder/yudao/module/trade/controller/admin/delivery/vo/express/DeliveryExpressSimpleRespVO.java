package cn.iocoder.yudao.module.trade.controller.admin.delivery.vo.express;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Carrier simple info response VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryExpressSimpleRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6592")
    @NotNull(message = "Code is required.")
    private Long id;

    @Schema(description = "Carrier name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "SF Express")
    @NotNull(message = "Carrier name cannot be empty.")
    private String name;

}

package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES routing pathproduct create / edit request.")
@Data
public class MesProRouteProductSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Routing path code is required.")
    private Long routeId;

    @Schema(description = "Product material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product material code is required.")
    private Long itemId;

    @Schema(description = "Production quantity.", example = "100")
    private Integer quantity;

    @Schema(description = "Production time.", example = "60.00")
    private BigDecimal productionTime;

    @Schema(description = "Time order characters.", example = "MINUTE")
    private String timeUnitType;

    @Schema(description = "Notes.")
    private String remark;

}

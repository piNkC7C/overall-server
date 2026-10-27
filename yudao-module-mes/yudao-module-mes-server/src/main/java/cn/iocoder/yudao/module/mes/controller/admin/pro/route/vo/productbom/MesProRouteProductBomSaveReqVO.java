package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.productbom;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES routing pathproduct BOM create / edit request.")
@Data
public class MesProRouteProductBomSaveReqVO {

    @Schema(description = "Code.", example = "1")
    private Long id;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Routing path code is required.")
    private Long routeId;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Operation code is required.")
    private Long processId;

    @Schema(description = "Product material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product material code is required.")
    private Long productId;

    @Schema(description = "BOM material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "BOM material code is required.")
    private Long itemId;

    @Schema(description = "Material ratio.", example = "1.50")
    private BigDecimal quantity;

    @Schema(description = "Notes.")
    private String remark;

}

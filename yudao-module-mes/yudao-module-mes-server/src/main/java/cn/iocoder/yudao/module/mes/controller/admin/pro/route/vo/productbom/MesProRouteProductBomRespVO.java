package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.productbom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES routing pathproduct BOM response.")
@Data
public class MesProRouteProductBomRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long routeId;

    @Schema(description = "Operation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long processId;

    @Schema(description = "Product material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long productId;

    @Schema(description = "BOM material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "BOM material code.")
    private String itemCode;

    @Schema(description = "BOM material name.")
    private String itemName;

    @Schema(description = "Spec / Model")
    private String specification;

    @Schema(description = "Order characters name.")
    private String unitName;

    @Schema(description = "Material ratio.", example = "1.50")
    private BigDecimal quantity;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES routing pathproduct response.")
@Data
public class MesProRouteProductRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;

    @Schema(description = "Routing path code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long routeId;

    @Schema(description = "Product material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Product material code.")
    private String itemCode;

    @Schema(description = "Product material name.")
    private String itemName;

    @Schema(description = "Spec / Model")
    private String specification;

    @Schema(description = "Order characters name.")
    private String unitName;

    @Schema(description = "Production quantity.", example = "100")
    private Integer quantity;

    @Schema(description = "Production time.", example = "60.00")
    private BigDecimal productionTime;

    @Schema(description = "Time order characters.", example = "MINUTE")
    private String timeUnitType;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

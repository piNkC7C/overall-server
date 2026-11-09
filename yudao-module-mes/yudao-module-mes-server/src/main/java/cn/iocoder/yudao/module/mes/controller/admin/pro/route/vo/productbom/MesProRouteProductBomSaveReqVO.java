package cn.iocoder.yudao.module.mes.controller.admin.pro.route.vo.productbom;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 工艺路线产品 BOM 新增/修改 Request VO")
@Data
public class MesProRouteProductBomSaveReqVO {

    @Schema(description = "编号", example = "1")
    private Long id;

    @Schema(description = "工艺路线编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Routing path code is required.")
    private Long routeId;

    @Schema(description = "工序编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Operation code is required.")
    private Long processId;

    @Schema(description = "产品物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product material code is required.")
    private Long productId;

    @Schema(description = "BOM 物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "BOM material code is required.")
    private Long itemId;

    @Schema(description = "用料比例", example = "1.50")
    private BigDecimal quantity;

    @Schema(description = "备注")
    private String remark;

}

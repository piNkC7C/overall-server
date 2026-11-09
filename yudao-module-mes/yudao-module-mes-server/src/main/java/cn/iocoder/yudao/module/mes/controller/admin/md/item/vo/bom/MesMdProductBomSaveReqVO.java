package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.bom;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 产品BOM新增/修改 Request VO")
@Data
public class MesMdProductBomSaveReqVO {

    @Schema(description = "BOM编号", example = "1024")
    private Long id;

    @Schema(description = "物料产品ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material productID is required.")
    private Long itemId;

    @Schema(description = "BOM物料ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "BOM material ID is required.")
    private Long bomItemId;

    @Schema(description = "物料使用比例", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.5")
    @NotNull(message = "Material usage ratio cannot be empty.")
    private BigDecimal quantity;

    @Schema(description = "是否启用", example = "0")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

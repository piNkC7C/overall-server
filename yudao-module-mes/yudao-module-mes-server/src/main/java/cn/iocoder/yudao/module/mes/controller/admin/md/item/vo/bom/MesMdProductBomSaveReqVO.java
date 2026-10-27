package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.bom;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES productBOM create / edit request.")
@Data
public class MesMdProductBomSaveReqVO {

    @Schema(description = "BOM code.", example = "1024")
    private Long id;

    @Schema(description = "Material productID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material productID is required.")
    private Long itemId;

    @Schema(description = "BOM material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "BOM material ID is required.")
    private Long bomItemId;

    @Schema(description = "Material usage ratio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.5")
    @NotNull(message = "Material usage ratio cannot be empty.")
    private BigDecimal quantity;

    @Schema(description = "Is not Enabled.", example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

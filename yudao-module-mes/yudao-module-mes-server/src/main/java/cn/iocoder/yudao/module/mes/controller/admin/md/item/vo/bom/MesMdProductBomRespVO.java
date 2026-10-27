package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo.bom;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES productBOM response.")
@Data
public class MesMdProductBomRespVO {

    @Schema(description = "BOM code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Material productID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "BOM material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long bomItemId;

    @Schema(description = "Material usage ratio.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.5")
    private BigDecimal quantity;

    @Schema(description = "Is not Enabled.", example = "0")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

    // ========== 关联展示字段 ==========

    @Schema(description = "BOM material code.", example = "ITEM001")
    private String bomItemCode;

    @Schema(description = "BOM material name.", example = "Screw")
    private String bomItemName;

    @Schema(description = "BOM material SKU.", example = "M6*20")
    private String bomItemSpecification;

    @Schema(description = "Unit of measure name.", example = "")
    private String unitMeasureName;

    @Schema(description = "Product material key.", example = "ITEM")
    private String itemOrProduct;

}

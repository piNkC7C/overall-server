package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES material product create / edit request.")
@Data
public class MesMdItemSaveReqVO {

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM001")
    @NotEmpty(message = "Material code is required.")
    private String code;

    @Schema(description = "Material name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Screw")
    @NotEmpty(message = "Material name is required.")
    private String name;

    @Schema(description = "Spec / Model", example = "M6*20")
    private String specification;

    @Schema(description = "Unit of measure code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "202")
    @NotNull(message = "Unit of measure is required.")
    private Long unitMeasureId;

    @Schema(description = "Material category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material category code is required.")
    private Long itemTypeId;

    @Schema(description = "Safety stock enabled.", example = "false")
    private Boolean safeStockFlag;

    @Schema(description = "Minimum stock.", example = "100.0000")
    private BigDecimal minStock;

    @Schema(description = "Maximum stock.", example = "10000.0000")
    private BigDecimal maxStock;

    @Schema(description = "High-value material.", example = "false")
    private Boolean highValue;

    @Schema(description = "Is not Enabled lot control.", example = "true")
    private Boolean batchFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

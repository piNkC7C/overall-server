package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 物料产品新增/修改 Request VO")
@Data
public class MesMdItemSaveReqVO {

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "物料编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM001")
    @NotEmpty(message = "Material code is required.")
    private String code;

    @Schema(description = "物料名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Screw")
    @NotEmpty(message = "Material name is required.")
    private String name;

    @Schema(description = "规格型号", example = "M6*20")
    private String specification;

    @Schema(description = "计量单位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "202")
    @NotNull(message = "Unit of measure is required.")
    private Long unitMeasureId;

    @Schema(description = "物料分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material category code is required.")
    private Long itemTypeId;

    @Schema(description = "是否启用安全库存", example = "false")
    private Boolean safeStockFlag;

    @Schema(description = "最低库存量", example = "100.0000")
    private BigDecimal minStock;

    @Schema(description = "最高库存量", example = "10000.0000")
    private BigDecimal maxStock;

    @Schema(description = "是否高值物料", example = "false")
    private Boolean highValue;

    @Schema(description = "是否启用批次管理", example = "true")
    private Boolean batchFlag;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

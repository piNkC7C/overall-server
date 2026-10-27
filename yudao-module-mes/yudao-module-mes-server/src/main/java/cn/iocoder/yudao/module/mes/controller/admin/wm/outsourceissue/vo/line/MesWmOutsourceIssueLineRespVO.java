package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES subcontract issue order line response.")
@Data
public class MesWmOutsourceIssueLineRespVO {

    @Schema(description = "Line ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Issue materials order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long issueId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemId;

    @Schema(description = "Material code.", example = "M001")
    private String itemCode;

    @Schema(description = "Material name.", example = "Steel plate.")
    private String itemName;

    @Schema(description = "Spec / Model", example = "10mm*100mm")
    private String specification;

    @Schema(description = "Unit of measure name.", example = "Kg.")
    private String unitMeasureName;

    @Schema(description = "Issue materials quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    private BigDecimal quantity;

    @Schema(description = "InventoryID.", example = "1")
    private Long materialStockId;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot code.", example = "BATCH001")
    private String batchCode;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

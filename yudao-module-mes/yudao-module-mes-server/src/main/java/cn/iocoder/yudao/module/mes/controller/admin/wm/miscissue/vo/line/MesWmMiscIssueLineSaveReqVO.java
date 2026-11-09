package cn.iocoder.yudao.module.mes.controller.admin.wm.miscissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 杂项出库单行新增/修改 Request VO")
@Data
public class MesWmMiscIssueLineSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "出库单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Outbound order code is required.")
    private Long issueId;

    @Schema(description = "来源单据行ID", example = "1")
    private Long sourceDocLineId;

    @Schema(description = "库存记录ID", example = "1")
    private Long materialStockId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "出库数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Outbound quantity is required.")
    @DecimalMin(value = "0.01", message = "Outbound quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次编号", example = "1")
    private Long batchId;

    @Schema(description = "批次号", example = "BATCH20260301")
    private String batchCode;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse is required.")
    private Long warehouseId;

    @Schema(description = "库区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone is required.")
    private Long locationId;

    @Schema(description = "库位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bin is required.")
    private Long areaId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

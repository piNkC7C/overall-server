package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 外协发料单明细新增/修改 Request VO")
@Data
public class MesWmOutsourceIssueDetailSaveReqVO {

    @Schema(description = "明细ID", example = "1024")
    private Long id;

    @Schema(description = "行ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Line ID is required.")
    private Long lineId;

    @Schema(description = "发料单ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Issue materials order ID is required.")
    private Long issueId;

    @Schema(description = "物料ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "库存ID", example = "1")
    private Long materialStockId;

    @Schema(description = "数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "300.00")
    @NotNull(message = "Quantity is required.")
    @DecimalMin(value = "0.01", message = "Quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次ID", example = "1")
    private Long batchId;

    @Schema(description = "仓库ID", example = "1")
    private Long warehouseId;

    @Schema(description = "库区ID", example = "1")
    private Long locationId;

    @Schema(description = "库位ID", example = "1")
    private Long areaId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

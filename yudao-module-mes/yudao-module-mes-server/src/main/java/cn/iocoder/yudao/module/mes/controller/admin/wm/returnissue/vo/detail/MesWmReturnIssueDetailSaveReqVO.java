package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 生产退料明细新增/修改 Request VO")
@Data
public class MesWmReturnIssueDetailSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "退料单行编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return order line code is required.")
    private Long lineId;

    @Schema(description = "退料单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return order code is required.")
    private Long issueId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "库存记录编号", example = "1")
    private Long materialStockId;

    @Schema(description = "退料数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "300.00")
    @NotNull(message = "Material return quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Material-return quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次编号", example = "1")
    private Long batchId;

    @Schema(description = "批次号", example = "BATCH20260101001")
    private String batchCode;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Warehouse code is required.")
    private Long warehouseId;

    @Schema(description = "库区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Zone code is required.")
    private Long locationId;

    @Schema(description = "库位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Bin code is required.")
    private Long areaId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

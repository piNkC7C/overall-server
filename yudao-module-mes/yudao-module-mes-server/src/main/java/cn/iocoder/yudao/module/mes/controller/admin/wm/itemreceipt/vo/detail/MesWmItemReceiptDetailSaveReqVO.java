package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 采购入库明细新增/修改 Request VO")
@Data
public class MesWmItemReceiptDetailSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "入库单行编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound order line code is required.")
    private Long lineId;

    @Schema(description = "入库单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound order code is required.")
    private Long receiptId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "上架数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "300.00")
    @NotNull(message = "Put away quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Put-away quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次编号", example = "1")
    private Long batchId;

    @Schema(description = "仓库编号", example = "1")
    private Long warehouseId;

    @Schema(description = "库区编号", example = "1")
    private Long locationId;

    @Schema(description = "库位编号", example = "1")
    private Long areaId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }

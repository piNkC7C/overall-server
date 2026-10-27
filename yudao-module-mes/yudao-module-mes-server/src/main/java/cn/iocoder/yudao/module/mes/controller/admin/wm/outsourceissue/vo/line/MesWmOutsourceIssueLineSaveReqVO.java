package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourceissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES subcontract issue order line create / edit request.")
@Data
public class MesWmOutsourceIssueLineSaveReqVO {

    @Schema(description = "Line ID.", example = "1024")
    private Long id;

    @Schema(description = "Issue materials order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Issue materials order ID is required.")
    private Long issueId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "Issue materials quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    @NotNull(message = "Issue materials quantity is required.")
    @DecimalMin(value = "0.01", message = "Material-issue quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "InventoryID.", example = "1")
    private Long materialStockId;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    @Schema(description = "Lot code.", example = "BATCH001")
    private String batchCode;

}

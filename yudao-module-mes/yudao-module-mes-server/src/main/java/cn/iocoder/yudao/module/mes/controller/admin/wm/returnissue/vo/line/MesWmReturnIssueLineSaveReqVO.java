package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES production material return order line Save request.")
@Data
public class MesWmReturnIssueLineSaveReqVO {

    @Schema(description = "Line ID.", example = "1")
    private Long id;

    @Schema(description = "Material return order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return order ID is required.")
    private Long issueId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "Material return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Material return quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Material-return quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Inventoryrecord ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Lot ID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot code.", example = "BCH20260330001")
    private String batchCode;

    @Schema(description = "Is not need to need quality inspection.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not need to need quality inspection is required.")
    private Boolean rqcCheckFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

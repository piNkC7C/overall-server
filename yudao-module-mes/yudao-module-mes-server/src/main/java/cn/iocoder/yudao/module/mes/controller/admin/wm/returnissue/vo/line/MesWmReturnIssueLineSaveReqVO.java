package cn.iocoder.yudao.module.mes.controller.admin.wm.returnissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 生产退料单行 Save Request VO")
@Data
public class MesWmReturnIssueLineSaveReqVO {

    @Schema(description = "行 ID", example = "1")
    private Long id;

    @Schema(description = "退料单 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material return order ID is required.")
    private Long issueId;

    @Schema(description = "物料 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "退料数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Material return quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Material-return quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "库存记录 ID", example = "1")
    private Long materialStockId;

    @Schema(description = "批次 ID", example = "1")
    private Long batchId;

    @Schema(description = "批次编码", example = "BCH20260330001")
    private String batchCode;

    @Schema(description = "是否需要质检", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not need to need quality inspection is required.")
    private Boolean rqcCheckFlag;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

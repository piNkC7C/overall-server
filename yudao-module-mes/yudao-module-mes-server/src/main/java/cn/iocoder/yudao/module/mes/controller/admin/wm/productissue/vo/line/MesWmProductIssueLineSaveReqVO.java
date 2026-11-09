package cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 领料出库单行 Save Request VO")
@Data
public class MesWmProductIssueLineSaveReqVO {

    @Schema(description = "行ID", example = "1")
    private Long id;

    @Schema(description = "领料单ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material issue order ID is required.")
    private Long issueId;

    @Schema(description = "物料ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "领料数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Material issue quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Issue quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次ID", example = "1")
    private Long batchId;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

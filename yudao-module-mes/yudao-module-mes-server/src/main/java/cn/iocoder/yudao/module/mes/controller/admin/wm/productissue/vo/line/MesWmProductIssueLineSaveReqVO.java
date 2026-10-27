package cn.iocoder.yudao.module.mes.controller.admin.wm.productissue.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES material issue outbound order line Save request.")
@Data
public class MesWmProductIssueLineSaveReqVO {

    @Schema(description = "Line ID.", example = "1")
    private Long id;

    @Schema(description = "Material issue order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material issue order ID is required.")
    private Long issueId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "Material issue quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Material issue quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Issue quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

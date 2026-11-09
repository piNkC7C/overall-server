package cn.iocoder.yudao.module.mes.controller.admin.wm.returnvendor.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 供应商退货单行 Save Request VO")
@Data
public class MesWmReturnVendorLineSaveReqVO {

    @Schema(description = "行ID", example = "1")
    private Long id;

    @Schema(description = "退货单ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Return orderID is required.")
    private Long returnId;

    @Schema(description = "物料ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "退货数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Return quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Return quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "批次ID", example = "1")
    private Long batchId;

    @Schema(description = "批次号", example = "BATCH20260101001")
    private String batchCode;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

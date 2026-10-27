package cn.iocoder.yudao.module.mes.controller.admin.wm.returnsales.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 管理后台 - MES 销售退货相关
 *
 * @author 芋道源码
 */
@Schema(description = "Admin - MES sales return line create / edit request.")
@Data
public class MesWmReturnSalesLineSaveReqVO {

    @Schema(description = "Line ID.", example = "1")
    private Long id;

    @Schema(description = "Return orderID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Return orderID is required.")
    private Long returnId;

    @Schema(description = "Material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material ID is required.")
    private Long itemId;

    @Schema(description = "Return quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Return quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Return quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "LotID.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "B20250101")
    private String batchCode;

    @Schema(description = "Is not need to need quality inspection.", example = "true")
    private Boolean rqcCheckFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

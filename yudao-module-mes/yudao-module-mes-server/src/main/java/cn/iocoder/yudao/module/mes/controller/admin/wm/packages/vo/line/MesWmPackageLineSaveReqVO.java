package cn.iocoder.yudao.module.mes.controller.admin.wm.packages.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * MES 装箱明细新增/修改 Request VO
 *
 * @author 芋道源码
 */
@Schema(description = "管理后台 - MES 装箱明细新增/修改 Request VO")
@Data
public class MesWmPackageLineSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "装箱单 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Packing order ID is required.")
    private Long packageId;

    @Schema(description = "库存记录 ID", example = "1")
    private Long materialStockId;

    @Schema(description = "产品物料 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    @Schema(description = "装箱数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Packing quantity is required.")
    @DecimalMin(value = "0.01", message = "Packed quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "生产工单 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work order is required.")
    private Long workOrderId;

    @Schema(description = "有效期")
    private LocalDateTime expireDate;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

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
@Schema(description = "Admin - MES packing detail create / edit request.")
@Data
public class MesWmPackageLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Packing order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Packing order ID is required.")
    private Long packageId;

    @Schema(description = "Inventoryrecord ID.", example = "1")
    private Long materialStockId;

    @Schema(description = "Product material ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    @Schema(description = "Packing quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Packing quantity is required.")
    @DecimalMin(value = "0.01", message = "Packed quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Production work order ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Production work order is required.")
    private Long workOrderId;

    @Schema(description = "Expiration date.")
    private LocalDateTime expireDate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

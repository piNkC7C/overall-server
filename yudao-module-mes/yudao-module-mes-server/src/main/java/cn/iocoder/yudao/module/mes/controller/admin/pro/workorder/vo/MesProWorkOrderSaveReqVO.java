package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES production work order create / edit request.")
@Data
public class MesProWorkOrderSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Work order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "WO-001")
    @NotEmpty(message = "Work order code is required.")
    private String code;

    @Schema(description = "Work order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Production work order-A.")
    @NotEmpty(message = "Work order name is required.")
    private String name;

    @Schema(description = "Work order type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Work order type is required.")
    private Integer type;

    @Schema(description = "Source type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Source type is required.")
    private Integer orderSourceType;

    @Schema(description = "Source document code.", example = "SO-001")
    private String orderSourceCode;

    @Schema(description = "Product code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Product is required.")
    private Long productId;

    @Schema(description = "Production quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Production quantity is required.")
    private BigDecimal quantity;

    @Schema(description = "Already production quantity.", example = "0")
    private BigDecimal quantityProduced;

    @Schema(description = "Adjust quantity.", example = "0")
    private BigDecimal quantityChanged;

    @Schema(description = "Already Scheduled Qty.", example = "0")
    private BigDecimal quantityScheduled;

    @Schema(description = "Customer code.", example = "300")
    private Long clientId;

    @Schema(description = "Supplier code.", example = "400")
    private Long vendorId;

    @Schema(description = "Lot no.", example = "BATCH-001")
    private String batchCode;

    @Schema(description = "Need-by Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Need-by Date is required.")
    private LocalDateTime requestDate;

    @Schema(description = "Parent work order code.", example = "0")
    private Long parentId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

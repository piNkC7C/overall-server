package cn.iocoder.yudao.module.mes.controller.admin.wm.itemreceipt.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES purchase receipt line create / edit request.")
@Data
public class MesWmItemReceiptLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound order code is required.")
    private Long receiptId;

    @Schema(description = "Receiving notification order line code.", example = "1")
    private Long arrivalNoticeLineId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Inbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    @NotNull(message = "Inbound quantity is required.")
    @DecimalMin(value = "0", inclusive = false, message = "Inbound quantity must be greater than 0.")
    private BigDecimal receivedQuantity;

    @Schema(description = "Production date.")
    private LocalDateTime productionDate;

    @Schema(description = "Expiration date.")
    private LocalDateTime expireDate;

    @Schema(description = "Production lot.", example = "PB20260110")
    private String lotNumber;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }

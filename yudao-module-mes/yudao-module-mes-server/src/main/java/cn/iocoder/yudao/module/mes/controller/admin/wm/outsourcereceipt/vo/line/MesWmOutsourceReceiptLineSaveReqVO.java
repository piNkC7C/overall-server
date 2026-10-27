package cn.iocoder.yudao.module.mes.controller.admin.wm.outsourcereceipt.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES subcontract inbound order line create / edit request.")
@Data
public class MesWmOutsourceReceiptLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Inbound order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inbound order code is required.")
    private Long receiptId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Inbound quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    @NotNull(message = "Inbound quantity is required.")
    private BigDecimal quantity;

    @Schema(description = "Production date.")
    private LocalDateTime productionDate;

    @Schema(description = "Expiration date.")
    private LocalDateTime expireDate;

    @Schema(description = "Production lot.", example = "PB20260301")
    private String lotNumber;

    @Schema(description = "Is not need to need quality inspection.")
    private Boolean iqcCheckFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

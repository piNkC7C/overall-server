package cn.iocoder.yudao.module.mes.controller.admin.wm.productreceipt.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES product receiving order create / edit request.")
@Data
public class MesWmProductReceiptSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Receiving order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "PR202603010001")
    @NotEmpty(message = "Receiving order code is required.")
    private String code;

    @Schema(description = "Receiving order name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Product receiving order -work order001.")
    @NotEmpty(message = "Receiving order name is required.")
    private String name;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Receiving Date.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Receiving Date is required.")
    private LocalDateTime receiptDate;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

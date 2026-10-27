package cn.iocoder.yudao.module.mes.controller.admin.wm.salesnotice.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES shipping notification order line create / edit request.")
@Data
public class MesWmSalesNoticeLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Shipping notification order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Shipping notification order code is required.")
    private Long noticeId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Lot code.", example = "1")
    private Long batchId;

    @Schema(description = "Lot no.", example = "BATCH001")
    private String batchCode;

    @Schema(description = "Shipping quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Shipping quantity is required.")
    @DecimalMin(value = "0.01", message = "Shipped quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "Is not inspection.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not inspection is required.")
    private Boolean oqcCheckFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

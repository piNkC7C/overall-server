package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES receiving notification order line create / edit request.")
@Data
public class MesWmArrivalNoticeLineSaveReqVO {

    @Schema(description = "Code.", example = "1024")
    private Long id;

    @Schema(description = "Receiving notification order code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Receiving notification order code is required.")
    private Long noticeId;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Receiving quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    @NotNull(message = "Receiving quantity is required.")
    @DecimalMin(value = "0.01", message = "Received quantity must be greater than 0.")
    private BigDecimal arrivalQuantity;

    @Schema(description = "Require incoming inspection.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Require incoming inspection cannot be empty.")
    private Boolean iqcCheckFlag;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

    }

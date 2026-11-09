package cn.iocoder.yudao.module.mes.controller.admin.wm.arrivalnotice.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 到货通知单行新增/修改 Request VO")
@Data
public class MesWmArrivalNoticeLineSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "到货通知单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Receiving notification order code is required.")
    private Long noticeId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "到货数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "500.00")
    @NotNull(message = "Receiving quantity is required.")
    @DecimalMin(value = "0.01", message = "Received quantity must be greater than 0.")
    private BigDecimal arrivalQuantity;

    @Schema(description = "是否需要来料检验", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Require incoming inspection cannot be empty.")
    private Boolean iqcCheckFlag;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

    }

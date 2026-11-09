package cn.iocoder.yudao.module.mes.controller.admin.wm.salesnotice.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 发货通知单行新增/修改 Request VO")
@Data
public class MesWmSalesNoticeLineSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "发货通知单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Shipping notification order code is required.")
    private Long noticeId;

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "批次编号", example = "1")
    private Long batchId;

    @Schema(description = "批次号", example = "BATCH001")
    private String batchCode;

    @Schema(description = "发货数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Shipping quantity is required.")
    @DecimalMin(value = "0.01", message = "Shipped quantity must be greater than 0.")
    private BigDecimal quantity;

    @Schema(description = "是否检验", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not inspection is required.")
    private Boolean oqcCheckFlag;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

package cn.iocoder.yudao.module.mes.controller.admin.pro.card.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 生产流转卡新增/修改 Request VO")
@Data
public class MesProCardSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "流转卡编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "CARD-001")
    @NotEmpty(message = "Routing card code is required.")
    private String code;

    @Schema(description = "生产工单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Production work order is required.")
    private Long workOrderId;

    @Schema(description = "产品物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "Product material is required.")
    private Long itemId;

    @Schema(description = "批次号", example = "BATCH-001")
    private String batchCode;

    @Schema(description = "流转数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.00")
    @NotNull(message = "Transfer Qty is required.")
    private BigDecimal transferedQuantity;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

package cn.iocoder.yudao.module.mes.controller.admin.pro.workorder.vo.bom;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - MES 生产工单 BOM 新增/修改 Request VO")
@Data
public class MesProWorkOrderBomSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "生产工单编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Production work order code is required.")
    private Long workOrderId;

    @Schema(description = "BOM 物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "200")
    @NotNull(message = "BOM material is required.")
    private Long itemId;

    @Schema(description = "预计使用量", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.00")
    @NotNull(message = "Expected usage cannot be empty.")
    private BigDecimal quantity;

    @Schema(description = "备注", example = "Notes.")
    private String remark;

}

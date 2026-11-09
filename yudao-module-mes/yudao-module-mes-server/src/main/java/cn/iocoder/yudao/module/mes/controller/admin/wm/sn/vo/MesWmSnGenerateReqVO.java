package cn.iocoder.yudao.module.mes.controller.admin.wm.sn.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - MES SN 码生成 Request VO")
@Data
public class MesWmSnGenerateReqVO {

    @Schema(description = "物料编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "批次号", example = "BATCH001")
    @Size(max = 100, message = "Lot no. length cannot exceed 100 characters.")
    private String batchCode;

    @Schema(description = "生产工单编号", example = "1")
    private Long workOrderId;

    @Schema(description = "生成数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Create quantity is required.")
    @Min(value = 1, message = "Generate count must be at least 1.")
    @Max(value = 1000, message = "Generate count cannot exceed 1000.")
    private Integer count;

}

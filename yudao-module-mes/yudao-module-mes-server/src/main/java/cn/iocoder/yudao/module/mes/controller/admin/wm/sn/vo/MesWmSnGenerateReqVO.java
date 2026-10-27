package cn.iocoder.yudao.module.mes.controller.admin.wm.sn.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "MES Serial number create request VO.")
@Data
public class MesWmSnGenerateReqVO {

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Material code is required.")
    private Long itemId;

    @Schema(description = "Lot no.", example = "BATCH001")
    @Size(max = 100, message = "Lot no. length cannot exceed 100 characters.")
    private String batchCode;

    @Schema(description = "Production work order code.", example = "1")
    private Long workOrderId;

    @Schema(description = "Create quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Create quantity is required.")
    @Min(value = 1, message = "Generate count must be at least 1.")
    @Max(value = 1000, message = "Generate count cannot exceed 1000.")
    private Integer count;

}

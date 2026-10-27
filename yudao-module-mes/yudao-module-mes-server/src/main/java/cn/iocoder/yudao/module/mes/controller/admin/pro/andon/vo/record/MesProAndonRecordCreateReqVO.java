package cn.iocoder.yudao.module.mes.controller.admin.pro.andon.vo.record;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "MES andon call record create request VO.")
@Data
public class MesProAndonRecordCreateReqVO {

    @Schema(description = "Andon settingID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Andon setting cannot be empty.")
    private Long configId;

    @Schema(description = "Workstation code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    @NotNull(message = "Workstation is required.")
    private Long workstationId;

    @Schema(description = "Start user ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Startuser is required.")
    private Long userId;

    @Schema(description = "Production work order code.", example = "200")
    private Long workOrderId;

    @Schema(description = "Operation code.", example = "300")
    private Long processId;

    @Schema(description = "Notes.", example = "Notes.")
    private String remark;

}

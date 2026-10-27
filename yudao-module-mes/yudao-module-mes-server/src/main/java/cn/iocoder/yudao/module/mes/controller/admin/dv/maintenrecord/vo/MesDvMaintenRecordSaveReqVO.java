package cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES device maintenance record create / edit request.")
@Data
public class MesDvMaintenRecordSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Plan code.", example = "1")
    private Long planId;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Device is required.")
    private Long machineryId;

    @Schema(description = "Maintenance time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Maintenance time is required.")
    private LocalDateTime maintenTime;

    @Schema(description = "User ID.", example = "1")
    private Long userId;

    @Schema(description = "Notes.", example = "Sample notes.")
    private String remark;

}

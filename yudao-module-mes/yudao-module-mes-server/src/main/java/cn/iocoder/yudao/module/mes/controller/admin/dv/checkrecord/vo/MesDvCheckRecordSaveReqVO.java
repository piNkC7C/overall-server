package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES device inspection record create / edit request.")
@Data
public class MesDvCheckRecordSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inspection plan code.", example = "1")
    private Long planId;

    @Schema(description = "Device code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Device is required.")
    private Long machineryId;

    @Schema(description = "Inspection time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Inspection time is required.")
    private LocalDateTime checkTime;

    @Schema(description = "Inspection person code.", example = "1")
    private Long userId;

    @Schema(description = "Notes.", example = "Sample notes.")
    private String remark;

}

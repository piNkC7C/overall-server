package cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - MES device maintenance recorddetail create / edit request.")
@Data
public class MesDvMaintenRecordLineSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Maintenance record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Maintenance record is required.")
    private Long recordId;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Item is required.")
    private Long subjectId;

    @Schema(description = "Maintenance result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Maintenance result is required.")
    private Integer status;

    @Schema(description = "Exception Notes", example = "Found damage")
    private String result;

    @Schema(description = "Notes.", example = "Sample notes.")
    private String remark;

}

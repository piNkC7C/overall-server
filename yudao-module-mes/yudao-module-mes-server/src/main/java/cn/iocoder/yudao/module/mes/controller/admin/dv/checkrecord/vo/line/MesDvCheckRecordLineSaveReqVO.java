package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo.line;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Schema(description = "Admin - MES device inspection recorddetail create / edit request.")
@Data
public class MesDvCheckRecordLineSaveReqVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Inspection record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection record is required.")
    private Long recordId;

    @Schema(description = "Inspection item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection item is required.")
    private Long subjectId;

    @Schema(description = "Inspection result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Inspection result is required.")
    private Integer checkStatus;

    @Schema(description = "Exception Notes", example = "Unusual equipment noise")
    private String checkResult;

    @Schema(description = "Notes.", example = "Sample notes.")
    private String remark;

}

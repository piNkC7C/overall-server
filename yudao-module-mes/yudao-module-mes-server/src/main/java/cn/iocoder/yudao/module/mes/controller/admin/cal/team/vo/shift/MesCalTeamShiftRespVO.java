package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo.shift;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES team schedule response.")
@Data
public class MesCalTeamShiftRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Schedule plan code.", example = "1")
    private Long planId;

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "201")
    private Long teamId;

    @Schema(description = "Team name.", example = "Injection team A")
    private String teamName;

    @Schema(description = "Shift code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long shiftId;

    @Schema(description = "Shift name.", example = "Day shift")
    private String shiftName;

    @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime day;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

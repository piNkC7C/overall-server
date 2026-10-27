package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES team response.")
@Data
@ExcelIgnoreUnannotated
public class MesCalTeamRespVO {

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Team ID")
    private Long id;

    @Schema(description = "Team code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "TEAM-A")
    @ExcelProperty("Team Code")
    private String code;

    @Schema(description = "Team name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Injection team A")
    @ExcelProperty("Team Name")
    private String name;

    @Schema(description = "Team type.", example = "1")
    @ExcelProperty("Team Type")
    private Integer calendarType;

    @Schema(description = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

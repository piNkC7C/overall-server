package cn.iocoder.yudao.module.mes.controller.admin.cal.team.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 班组 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesCalTeamRespVO {

    @Schema(description = "班组编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Team ID")
    private Long id;

    @Schema(description = "班组编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "TEAM-A")
    @ExcelProperty("Team Code")
    private String code;

    @Schema(description = "班组名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Injection team A")
    @ExcelProperty("Team Name")
    private String name;

    @Schema(description = "班组类型", example = "1")
    @ExcelProperty("Team Type")
    private Integer calendarType;

    @Schema(description = "备注")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord.vo.line;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES device maintenance recorddetail response.")
@Data
@ExcelIgnoreUnannotated
public class MesDvMaintenRecordLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Maintenance record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long recordId;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long subjectId;

    @Schema(description = "Item name.", example = "Check engine oil")
    @ExcelProperty("Project Name")
    private String subjectName;

    @Schema(description = "Item content.", example = "Check whether engine oil is sufficient")
    @ExcelProperty("Project Content")
    private String subjectContent;

    @Schema(description = "Item standard.", example = "No oil leak")
    @ExcelProperty("Standard")
    private String subjectStandard;

    @Schema(description = "Maintenance result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Maintenance Result", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_MAINTEN_STATUS)
    private Integer status;

    @Schema(description = "Exception Notes", example = "Found damage")
    @ExcelProperty("Exception Description")
    private String result;

    @Schema(description = "Notes.", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo.line;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES device inspection recorddetail response.")
@Data
@ExcelIgnoreUnannotated
public class MesDvCheckRecordLineRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Inspection record code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long recordId;

    @Schema(description = "Inspection item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long subjectId;

    @Schema(description = "Item code.", example = "S001")
    @ExcelProperty("Project Code")
    private String subjectCode;

    @Schema(description = "Item name.", example = "Lubricant check")
    @ExcelProperty("Project Name")
    private String subjectName;

    @Schema(description = "Item type.", example = "1")
    @ExcelProperty("Project Type")
    private Integer subjectType;

    @Schema(description = "Check content.", example = "Check whether lubricant is sufficient")
    @ExcelProperty("Check Content")
    private String subjectContent;

    @Schema(description = "Check standard.", example = "Oil level is not below the minimum mark")
    @ExcelProperty("Check Standard")
    private String subjectStandard;

    @Schema(description = "Inspection result.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Inspection Result", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_CHECK_RESULT)
    private Integer checkStatus;

    @Schema(description = "Exception Notes", example = "Unusual equipment noise")
    @ExcelProperty("Exception Description")
    private String checkResult;

    @Schema(description = "Notes.", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

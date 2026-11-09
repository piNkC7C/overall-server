package cn.iocoder.yudao.module.mes.controller.admin.dv.checkrecord.vo.line;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 设备点检记录明细 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesDvCheckRecordLineRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "点检记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long recordId;

    @Schema(description = "点检项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long subjectId;

    @Schema(description = "项目编码", example = "S001")
    @ExcelProperty("Project Code")
    private String subjectCode;

    @Schema(description = "项目名称", example = "Lubricant check")
    @ExcelProperty("Project Name")
    private String subjectName;

    @Schema(description = "项目类型", example = "1")
    @ExcelProperty("Project Type")
    private Integer subjectType;

    @Schema(description = "检查内容", example = "Check whether lubricant is sufficient")
    @ExcelProperty("Check Content")
    private String subjectContent;

    @Schema(description = "检查标准", example = "Oil level is not below the minimum mark")
    @ExcelProperty("Check Standard")
    private String subjectStandard;

    @Schema(description = "点检结果", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Inspection Result", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_CHECK_RESULT)
    private Integer checkStatus;

    @Schema(description = "异常描述", example = "Unusual equipment noise")
    @ExcelProperty("Exception Description")
    private String checkResult;

    @Schema(description = "备注", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

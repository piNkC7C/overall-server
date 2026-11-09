package cn.iocoder.yudao.module.mes.controller.admin.dv.maintenrecord.vo.line;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 设备保养记录明细 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesDvMaintenRecordLineRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "保养记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long recordId;

    @Schema(description = "项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long subjectId;

    @Schema(description = "项目名称", example = "Check engine oil")
    @ExcelProperty("Project Name")
    private String subjectName;

    @Schema(description = "项目内容", example = "Check whether engine oil is sufficient")
    @ExcelProperty("Project Content")
    private String subjectContent;

    @Schema(description = "项目标准", example = "No oil leak")
    @ExcelProperty("Standard")
    private String subjectStandard;

    @Schema(description = "保养结果", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Maintenance Result", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_MAINTEN_STATUS)
    private Integer status;

    @Schema(description = "异常描述", example = "Found damage")
    @ExcelProperty("Exception Description")
    private String result;

    @Schema(description = "备注", example = "Sample notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.mes.controller.admin.dv.subject.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 点检保养项目 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesDvSubjectRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "项目编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHK001")
    @ExcelProperty("Project Code")
    private String code;

    @Schema(description = "项目名称", example = "Injection-machine visual check")
    @ExcelProperty("Project Name")
    private String name;

    @Schema(description = "项目类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Project Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_SUBJECT_TYPE)
    private Integer type;

    @Schema(description = "项目内容", requiredMode = Schema.RequiredMode.REQUIRED, example = "Check the injection-molding machine housing for cracks")
    @ExcelProperty("Project Content")
    private String content;

    @Schema(description = "标准", example = "Appearance is good. No visible damage.")
    @ExcelProperty("Standard")
    private String standard;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat("common_status")
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

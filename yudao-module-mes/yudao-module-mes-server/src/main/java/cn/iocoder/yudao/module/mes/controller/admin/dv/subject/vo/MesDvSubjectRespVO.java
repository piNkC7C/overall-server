package cn.iocoder.yudao.module.mes.controller.admin.dv.subject.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES inspection and maintenance item response.")
@Data
@ExcelIgnoreUnannotated
public class MesDvSubjectRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHK001")
    @ExcelProperty("Project Code")
    private String code;

    @Schema(description = "Item name.", example = "Injection-machine visual check")
    @ExcelProperty("Project Name")
    private String name;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Project Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_SUBJECT_TYPE)
    private Integer type;

    @Schema(description = "Item content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Check the injection-molding machine housing for cracks")
    @ExcelProperty("Project Content")
    private String content;

    @Schema(description = "Standard.", example = "Appearance is good. No visible damage.")
    @ExcelProperty("Standard")
    private String standard;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat("common_status")
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

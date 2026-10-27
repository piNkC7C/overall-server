package cn.iocoder.yudao.module.mes.controller.admin.qc.indicator.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES quality inspection metric response.")
@Data
@ExcelIgnoreUnannotated
public class MesQcIndicatorRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Inspect item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "QI001")
    @ExcelProperty("Checkpoint Code")
    private String code;

    @Schema(description = "Inspect item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Length.")
    @ExcelProperty("Checkpoint Name")
    private String name;

    @Schema(description = "Inspect item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Checkpoint Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_INDICATOR_TYPE)
    private Integer type;

    @Schema(description = "Inspect tool.", example = "Caliper")
    @ExcelProperty("Inspection Tool")
    private String tool;

    @Schema(description = "Result value type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Result Value Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_QC_RESULT_TYPE)
    private Integer resultType;

    @Schema(description = "Result-value property.", example = "IMG")
    @ExcelProperty("Result Property")
    private String resultSpecification;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

package cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.rule;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES coding rule response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdAutoCodeRuleRespVO {

    @Schema(description = "Rule ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Rule ID")
    private Long id;

    @Schema(description = "Rule code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM_CODE")
    @ExcelProperty("Rule Code")
    private String code;

    @Schema(description = "Rule name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material coding rule.")
    @ExcelProperty("Rule Name")
    private String name;

    @Schema(description = "Description", example = "At create material code.")
    @ExcelProperty("Description")
    private String description;

    @Schema(description = "Maximum length.", example = "20")
    @ExcelProperty("Max Length")
    private Integer maxLength;

    @Schema(description = "Pad.", example = "true")
    @ExcelProperty("Pad")
    private Boolean padded;

    @Schema(description = "Pad character.", example = "0")
    @ExcelProperty("Pad Character")
    private String paddedChar;

    @Schema(description = "Pad mode.", example = "1")
    @ExcelProperty(value = "Padding Mode", converter = DictConvert.class)
    @DictFormat("mes_auto_code_padded_method")
    private Integer paddedMethod;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

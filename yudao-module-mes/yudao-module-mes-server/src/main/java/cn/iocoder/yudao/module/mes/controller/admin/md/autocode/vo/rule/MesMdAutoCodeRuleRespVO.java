package cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.rule;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 编码规则 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesMdAutoCodeRuleRespVO {

    @Schema(description = "规则 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Rule ID")
    private Long id;

    @Schema(description = "规则编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM_CODE")
    @ExcelProperty("Rule Code")
    private String code;

    @Schema(description = "规则名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Material coding rule.")
    @ExcelProperty("Rule Name")
    private String name;

    @Schema(description = "描述", example = "At create material code.")
    @ExcelProperty("Description")
    private String description;

    @Schema(description = "最大长度", example = "20")
    @ExcelProperty("Max Length")
    private Integer maxLength;

    @Schema(description = "是否补齐", example = "true")
    @ExcelProperty("Pad")
    private Boolean padded;

    @Schema(description = "补齐字符", example = "0")
    @ExcelProperty("Pad Character")
    private String paddedChar;

    @Schema(description = "补齐方式", example = "1")
    @ExcelProperty(value = "Padding Mode", converter = DictConvert.class)
    @DictFormat("mes_auto_code_padded_method")
    private Integer paddedMethod;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

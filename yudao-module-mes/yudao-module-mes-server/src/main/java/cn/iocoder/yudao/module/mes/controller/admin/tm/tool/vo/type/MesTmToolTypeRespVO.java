package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo.type;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES tool type response.")
@Data
@ExcelIgnoreUnannotated
public class MesTmToolTypeRespVO {

    @Schema(description = "Code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "Type code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "TT-001")
    @ExcelProperty("Type Code")
    private String code;

    @Schema(description = "Type name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Milling cutter")
    @ExcelProperty("Type Name")
    private String name;

    @Schema(description = "Is not code admin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Serial Control")
    private Boolean codeFlag;

    @Schema(description = "Maintenance Type", example = "1")
    @ExcelProperty(value = "Maintenance Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_TM_MAINTEN_TYPE)
    private Integer maintenType;

    @Schema(description = "Maintenance cycle.", example = "30")
    @ExcelProperty("Maintenance Cycle")
    private Integer maintenPeriod;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

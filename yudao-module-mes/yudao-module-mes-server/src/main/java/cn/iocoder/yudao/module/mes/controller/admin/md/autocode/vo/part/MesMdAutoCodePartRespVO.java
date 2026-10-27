package cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.part;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "Admin - MES coding rule consist of response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdAutoCodePartRespVO {

    @Schema(description = "Segment ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Segment ID")
    private Long id;

    @Schema(description = "Rule ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Rule ID")
    private Long ruleId;

    @Schema(description = "Segment No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Segment Sequence")
    private Integer sort;

    @Schema(description = "Segment type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Segment Type", converter = DictConvert.class)
    @DictFormat("mes_auto_code_part_type")
    private Integer type;

    @Schema(description = "Segment length.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @ExcelProperty("Segment Length")
    private Integer length;

    @Schema(description = "Date format.", example = "yyyyMMdd")
    @ExcelProperty("Date Format")
    private String dateFormat;

    @Schema(description = "Fixed text.", example = "ITEM_")
    @ExcelProperty("Fixed Characters")
    private String fixCharacter;

    @Schema(description = "Sequence start.", example = "1")
    @ExcelProperty("Sequence Start")
    private Integer serialStartNo;

    @Schema(description = "Sequence step.", example = "1")
    @ExcelProperty("Sequence Step")
    private Integer serialStep;

    @Schema(description = "Sequence cycles.", example = "true")
    @ExcelProperty("Sequence Cycles")
    private Boolean cycleFlag;

    @Schema(description = "Cycle mode.", example = "3")
    @ExcelProperty(value = "Cycle Mode", converter = DictConvert.class)
    @DictFormat("mes_auto_code_cycle_method")
    private Integer cycleMethod;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

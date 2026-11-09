package cn.iocoder.yudao.module.mes.controller.admin.md.autocode.vo.part;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 编码规则组成 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesMdAutoCodePartRespVO {

    @Schema(description = "分段 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Segment ID")
    private Long id;

    @Schema(description = "规则 ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Rule ID")
    private Long ruleId;

    @Schema(description = "分段序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("Segment Sequence")
    private Integer sort;

    @Schema(description = "分段类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Segment Type", converter = DictConvert.class)
    @DictFormat("mes_auto_code_part_type")
    private Integer type;

    @Schema(description = "分段长度", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    @ExcelProperty("Segment Length")
    private Integer length;

    @Schema(description = "日期格式", example = "yyyyMMdd")
    @ExcelProperty("Date Format")
    private String dateFormat;

    @Schema(description = "固定字符", example = "ITEM_")
    @ExcelProperty("Fixed Characters")
    private String fixCharacter;

    @Schema(description = "流水号起始值", example = "1")
    @ExcelProperty("Sequence Start")
    private Integer serialStartNo;

    @Schema(description = "流水号步长", example = "1")
    @ExcelProperty("Sequence Step")
    private Integer serialStep;

    @Schema(description = "流水号是否循环", example = "true")
    @ExcelProperty("Sequence Cycles")
    private Boolean cycleFlag;

    @Schema(description = "循环方式", example = "3")
    @ExcelProperty(value = "Cycle Mode", converter = DictConvert.class)
    @DictFormat("mes_auto_code_cycle_method")
    private Integer cycleMethod;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

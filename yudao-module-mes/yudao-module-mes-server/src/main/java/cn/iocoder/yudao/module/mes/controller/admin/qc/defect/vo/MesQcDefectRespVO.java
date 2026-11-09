package cn.iocoder.yudao.module.mes.controller.admin.qc.defect.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 缺陷类型 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesQcDefectRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "缺陷编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "DF001")
    @ExcelProperty("Defect Code")
    private String code;

    @Schema(description = "缺陷描述", requiredMode = Schema.RequiredMode.REQUIRED, example = "Appearance defect")
    @ExcelProperty("Defect Description")
    private String name;

    @Schema(description = "检测项类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty(value = "Checkpoint Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_INDICATOR_TYPE)
    private Integer type;

    @Schema(description = "缺陷等级", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "Defect Level", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DEFECT_LEVEL)
    private Integer level;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

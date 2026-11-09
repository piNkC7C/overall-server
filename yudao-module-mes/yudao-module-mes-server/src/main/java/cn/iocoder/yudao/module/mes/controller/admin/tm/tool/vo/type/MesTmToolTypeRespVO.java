package cn.iocoder.yudao.module.mes.controller.admin.tm.tool.vo.type;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 工具类型 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesTmToolTypeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Code")
    private Long id;

    @Schema(description = "类型编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "TT-001")
    @ExcelProperty("Type Code")
    private String code;

    @Schema(description = "类型名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Milling cutter")
    @ExcelProperty("Type Name")
    private String name;

    @Schema(description = "是否编码管理", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Serial Control")
    private Boolean codeFlag;

    @Schema(description = "保养维护类型", example = "1")
    @ExcelProperty(value = "Maintenance Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_TM_MAINTEN_TYPE)
    private Integer maintenType;

    @Schema(description = "保养周期", example = "30")
    @ExcelProperty("Maintenance Cycle")
    private Integer maintenPeriod;

    @Schema(description = "备注", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

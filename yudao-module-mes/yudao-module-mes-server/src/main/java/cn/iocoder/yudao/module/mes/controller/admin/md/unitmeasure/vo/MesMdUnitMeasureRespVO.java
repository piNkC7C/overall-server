package cn.iocoder.yudao.module.mes.controller.admin.md.unitmeasure.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - MES 计量单位 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MesMdUnitMeasureRespVO {

    @Schema(description = "单位编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Unit ID")
    private Long id;

    @Schema(description = "单位编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "KG")
    @ExcelProperty("Unit Code")
    private String code;

    @Schema(description = "单位名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "kg")
    @ExcelProperty("Unit Name")
    private String name;

    @Schema(description = "是否主单位", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Primary Unit")
    private Boolean primaryFlag;

    @Schema(description = "主单位编号", example = "200")
    @ExcelProperty("Primary Unit ID")
    private Long primaryId;

    @Schema(description = "与主单位换算比例", example = "1000.0000")
    @ExcelProperty("Conversion To Primary Unit")
    private BigDecimal changeRate;

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

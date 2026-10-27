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

@Schema(description = "Admin - MES unit of measure response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdUnitMeasureRespVO {

    @Schema(description = "Order characters code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Unit ID")
    private Long id;

    @Schema(description = "Order characters code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "KG")
    @ExcelProperty("Unit Code")
    private String code;

    @Schema(description = "Order characters name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "kg")
    @ExcelProperty("Unit Name")
    private String name;

    @Schema(description = "Is not primary unit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @ExcelProperty("Primary Unit")
    private Boolean primaryFlag;

    @Schema(description = "Primary unit code.", example = "200")
    @ExcelProperty("Primary Unit ID")
    private Long primaryId;

    @Schema(description = "Conversion to the base unit.", example = "1000.0000")
    @ExcelProperty("Conversion To Primary Unit")
    private BigDecimal changeRate;

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

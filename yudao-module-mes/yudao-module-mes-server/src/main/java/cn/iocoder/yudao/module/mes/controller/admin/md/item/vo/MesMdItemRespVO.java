package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Admin - MES material product response.")
@Data
@ExcelIgnoreUnannotated
public class MesMdItemRespVO {

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("Material ID")
    private Long id;

    @Schema(description = "Material code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ITEM001")
    @ExcelProperty("Material Code")
    private String code;

    @Schema(description = "Material name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Screw")
    @ExcelProperty("Material Name")
    private String name;

    @Schema(description = "Spec / Model", example = "M6*20")
    @ExcelProperty("Spec / Model")
    private String specification;

    @Schema(description = "Unit of measure code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "202")
    private Long unitMeasureId;
    @Schema(description = "Unit of measure name.", example = "")
    @ExcelProperty("Unit Of Measure")
    private String unitMeasureName;

    @Schema(description = "Material category code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long itemTypeId;
    @Schema(description = "Material category name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Raw material")
    @ExcelProperty("Material Category")
    private String itemTypeName;

    @Schema(description = "Material /product key.", example = "ITEM")
    @ExcelProperty("Material / Product Key")
    private String itemOrProduct;

    @Schema(description = "Status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @Schema(description = "Safety stock enabled.", example = "false")
    @ExcelProperty("Safety Stock Enabled")
    private Boolean safeStockFlag;

    @Schema(description = "Minimum stock.", example = "100.0000")
    @ExcelProperty("Min Stock")
    private BigDecimal minStock;

    @Schema(description = "Maximum stock.", example = "10000.0000")
    @ExcelProperty("Max Stock")
    private BigDecimal maxStock;

    @Schema(description = "High-value material.", example = "false")
    @ExcelProperty("High-value Material")
    private Boolean highValue;

    @Schema(description = "Is not Enabled lot control.", example = "true")
    @ExcelProperty("Lot Control Enabled")
    private Boolean batchFlag;

    @Schema(description = "Notes.", example = "Notes.")
    @ExcelProperty("Notes")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

}

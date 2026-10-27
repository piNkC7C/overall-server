package cn.iocoder.yudao.module.mes.controller.admin.md.item.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;

/**
 * 物料产品 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MesMdItemImportExcelVO {

    @ExcelProperty("Material Code")
    private String code;

    @ExcelProperty("Material Name")
    private String name;

    @ExcelProperty("Spec / Model")
    private String specification;

    @ExcelProperty("Unit Code")
    private String unitMeasureCode;

    @ExcelProperty("Material Category ID")
    private Long itemTypeId;

    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

    @ExcelProperty("Safety Stock Enabled")
    private Boolean safeStockFlag;

    @ExcelProperty("Min Stock")
    private BigDecimal minStock;

    @ExcelProperty("Max Stock")
    private BigDecimal maxStock;

    @ExcelProperty("High-value Material")
    private Boolean highValue;

    @ExcelProperty("Lot Control Enabled")
    private Boolean batchFlag;

    @ExcelProperty("Notes")
    private String remark;

}

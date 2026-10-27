package cn.iocoder.yudao.module.mes.controller.admin.dv.machinery.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelProperty;

/**
 * 设备台账 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MesDvMachineryImportExcelVO {

    @ExcelProperty("Device Code")
    private String code;

    @ExcelProperty("Device Name")
    private String name;

    @ExcelProperty("Brand")
    private String brand;

    @ExcelProperty("Spec / Model")
    private String specification;

    @ExcelProperty("Device Type Code")
    private String machineryTypeCode;

    @ExcelProperty("Shop Floor Code")
    private String workshopCode;

    @ExcelProperty(value = "Device Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_DV_MACHINERY_STATUS)
    private Integer status;

    @ExcelProperty("Notes")
    private String remark;

}

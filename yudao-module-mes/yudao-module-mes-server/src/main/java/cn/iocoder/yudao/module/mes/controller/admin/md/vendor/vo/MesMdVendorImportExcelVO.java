package cn.iocoder.yudao.module.mes.controller.admin.md.vendor.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelProperty;

/**
 * 供应商 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MesMdVendorImportExcelVO {

    @ExcelProperty("Supplier Code")
    private String code;

    @ExcelProperty("Supplier Name")
    private String name;

    @ExcelProperty("Supplier Short Name")
    private String nickname;

    @ExcelProperty(value = "Supplier Grade", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_VENDOR_LEVEL)
    private String level;

    @ExcelProperty("Supplier Phone")
    private String telephone;

    @ExcelProperty("Supplier Email")
    private String email;

    @ExcelProperty("Supplier English Name")
    private String englishName;

    @ExcelProperty("Supplier Summary")
    private String description;

    @ExcelProperty("Supplier Address")
    private String address;

    @ExcelProperty("Supplier Website")
    private String website;

    @ExcelProperty("Contact 1")
    private String contact1Name;

    @ExcelProperty("Contact 1 Phone")
    private String contact1Telephone;

    @ExcelProperty("Contact 1 Email")
    private String contact1Email;

    @ExcelProperty("Contact 2")
    private String contact2Name;

    @ExcelProperty("Contact 2 Phone")
    private String contact2Telephone;

    @ExcelProperty("Contact 2 Email")
    private String contact2Email;

    @ExcelProperty("USCC")
    private String creditCode;

    @ExcelProperty(value = "Status", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.system.enums.DictTypeConstants.COMMON_STATUS)
    private Integer status;

}

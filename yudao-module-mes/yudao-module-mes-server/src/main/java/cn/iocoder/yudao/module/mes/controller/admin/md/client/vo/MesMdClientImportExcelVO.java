package cn.iocoder.yudao.module.mes.controller.admin.md.client.vo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.mes.enums.DictTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelProperty;

/**
 * 客户 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MesMdClientImportExcelVO {

    @ExcelProperty("Customer Code")
    private String code;

    @ExcelProperty("Customer Name")
    private String name;

    @ExcelProperty("Customer Short Name")
    private String nickname;

    @ExcelProperty(value = "CustomerType", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.MES_CLIENT_TYPE)
    private Integer type;

    @ExcelProperty("Customer Phone")
    private String telephone;

    @ExcelProperty("Customer Email")
    private String email;

    @ExcelProperty("Customer English Name")
    private String englishName;

    @ExcelProperty("Customer Summary")
    private String description;

    @ExcelProperty("Customer Address")
    private String address;

    @ExcelProperty("Customer Website")
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

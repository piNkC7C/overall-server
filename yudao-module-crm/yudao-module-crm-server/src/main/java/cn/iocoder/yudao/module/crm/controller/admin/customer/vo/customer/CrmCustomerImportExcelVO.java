package cn.iocoder.yudao.module.crm.controller.admin.customer.vo.customer;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.annotations.ExcelColumnSelect;
import cn.iocoder.yudao.framework.excel.core.convert.AreaConvert;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.crm.framework.excel.core.AreaExcelColumnSelectFunction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import static cn.iocoder.yudao.module.crm.enums.DictTypeConstants.*;

/**
 * 客户 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CrmCustomerImportExcelVO {

    @ExcelProperty("Customer Name")
    private String name;

    @ExcelProperty("Mobile")
    private String mobile;

    @ExcelProperty("Phone")
    private String telephone;

    @ExcelProperty("QQ")
    private String qq;

    @ExcelProperty("WeChat")
    private String wechat;

    @ExcelProperty("Email")
    private String email;

    @ExcelProperty(value = "Region", converter = AreaConvert.class)
    @ExcelColumnSelect(functionName = AreaExcelColumnSelectFunction.NAME)
    private Integer areaId;

    @ExcelProperty("Full Address")
    private String detailAddress;

    @ExcelProperty(value = "Industry", converter = DictConvert.class)
    @DictFormat(CRM_CUSTOMER_INDUSTRY)
    @ExcelColumnSelect(dictType = CRM_CUSTOMER_INDUSTRY)
    private Integer industryId;

    @ExcelProperty(value = "Customer Level", converter = DictConvert.class)
    @DictFormat(CRM_CUSTOMER_LEVEL)
    @ExcelColumnSelect(dictType = CRM_CUSTOMER_LEVEL)
    private Integer level;

    @ExcelProperty(value = "Customer Source", converter = DictConvert.class)
    @DictFormat(CRM_CUSTOMER_SOURCE)
    @ExcelColumnSelect(dictType = CRM_CUSTOMER_SOURCE)
    private Integer source;

    @ExcelProperty("Notes")
    private String remark;

}

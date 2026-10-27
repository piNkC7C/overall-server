package cn.iocoder.yudao.module.fms.controller.admin.config.vo.auxiliaryitem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelProperty;

/**
 * FMS 辅助核算项目 Excel 导入 VO
 *
 * @author 芋道源码
 */
@Data
public class FmsAuxiliaryItemImportExcelVO {

    @ExcelProperty("Code")
    @NotBlank(message = "Code is required.")
    @Size(max = 64, message = "Code length cannot exceed 64 characters.")
    private String code;

    @ExcelProperty("Name")
    @NotBlank(message = "Name is required.")
    @Size(max = 255, message = "Name length cannot exceed 255 characters.")
    private String name;

    @ExcelProperty("Notes")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @ExcelProperty("SKU")
    @Size(max = 255, message = "SKU length cannot exceed 255 characters.")
    private String specification;

    @ExcelProperty("Unit")
    @Size(max = 255, message = "Order characters length cannot exceed 255 characters.")
    private String unit;

}

package cn.iocoder.yudao.module.fms.controller.admin.config.vo.subject;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelProperty;

/**
 * FMS 科目 Excel 导入 VO
 *
 * @author 芋道源码
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FmsSubjectImportExcelVO {

    @ExcelProperty("Account Code")
    @NotBlank(message = "Account code is required.")
    private String code;

    @ExcelProperty("Account Name")
    @NotBlank(message = "Account name is required.")
    private String name;

    @ExcelProperty("Parent Account Code")
    private String parentSubjectCode;

    @ExcelProperty("Balance Side")
    @NotBlank(message = "Balance Direction is required.")
    private String balanceDirection;

    @ExcelProperty("Category")
    @NotBlank(message = "Category cannot be empty.")
    private String categoryName;

    @ExcelProperty("Auxiliary Accounting")
    private String auxiliaryNames;

}

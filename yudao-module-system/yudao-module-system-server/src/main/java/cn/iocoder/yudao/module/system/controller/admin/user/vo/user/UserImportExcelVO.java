package cn.iocoder.yudao.module.system.controller.admin.user.vo.user;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.system.enums.DictTypeConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelProperty;

/**
 * 用户 Excel 导入 VO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserImportExcelVO {

    @ExcelProperty("Login Name")
    private String username;

    @ExcelProperty("User Name")
    private String nickname;

    @ExcelProperty("Department ID")
    private Long deptId;

    @ExcelProperty("User Email")
    private String email;

    @ExcelProperty("Mobile Number")
    private String mobile;

    @ExcelProperty(value = "User Gender", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.USER_SEX)
    private Integer sex;

    @ExcelProperty(value = "Account Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.COMMON_STATUS)
    private Integer status;

}

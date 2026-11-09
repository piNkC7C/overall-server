package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import cn.iocoder.yudao.framework.excel.core.annotations.ExcelColumnSelect;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.AreaConvert;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.hrm.enums.DictTypeConstants;
import cn.iocoder.yudao.module.hrm.framework.excel.core.HrmEmployeeProbationExcelColumnSelectFunction;
import cn.iocoder.yudao.module.hrm.framework.excel.core.HrmRecruitChannelExcelColumnSelectFunction;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - HRM 员工档案 Excel 导入 VO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ExcelIgnoreUnannotated
public class HrmEmployeeImportExcelVO {

    @ExcelProperty("Employee Name")
    @Schema(description = "员工姓名")
    private String name;

    @ExcelProperty("Employee No")
    @Schema(description = "工号")
    private String jobNumber;

    @ExcelProperty("Phone Number")
    @Schema(description = "手机号")
    private String mobile;

    @ExcelProperty("Country Or Region")
    @Schema(description = "国家或地区")
    private String country;

    @ExcelProperty("Ethnicity")
    @Schema(description = "民族")
    private String nation;

    @ExcelProperty(value = "ID Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_ID_TYPE)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_ID_TYPE)
    @Schema(description = "证件类型")
    private Integer idType;

    @ExcelProperty("ID Number")
    @Schema(description = "证件号码")
    private String idNumber;

    @ExcelProperty(value = "Gender", converter = DictConvert.class)
    @DictFormat(cn.iocoder.yudao.module.system.enums.DictTypeConstants.USER_SEX)
    @ExcelColumnSelect(dictType = cn.iocoder.yudao.module.system.enums.DictTypeConstants.USER_SEX)
    @Schema(description = "性别")
    private Integer sex;

    @ExcelProperty("Email")
    @Schema(description = "邮箱")
    private String email;

    @ExcelProperty("Hometown")
    @Schema(description = "籍贯")
    private String nativePlace;

    @ExcelProperty("Date Of Birth")
    @Schema(description = "出生日期")
    private LocalDateTime birthday;

    @ExcelProperty("Household Address")
    @Schema(description = "户籍地址")
    private String address;

    @ExcelProperty(value = "Highest Education", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_EDUCATION)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_EDUCATION)
    @Schema(description = "最高学历")
    private Integer highestEducation;

    @ExcelProperty("Department ID")
    @Schema(description = "部门编号")
    private Long deptId;

    @ExcelProperty("Manager Employee No")
    @Schema(description = "直属上级工号")
    private String leaderJobNumber;

    @ExcelProperty("Position Name")
    @Schema(description = "职位名称")
    private String postName;

    @ExcelProperty("Job Grade")
    @Schema(description = "岗位职级")
    private String postLevel;

    @ExcelProperty(value = "Hire Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_ENTRY_STATUS)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_ENTRY_STATUS)
    @Schema(description = "入职状态")
    private Integer entryStatus;

    @ExcelProperty(value = "Employee Status", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_STATUS)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_STATUS)
    @Schema(description = "员工状态")
    private Integer status;

    @ExcelProperty(value = "Employment Type", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_EMPLOYEE_TYPE)
    @ExcelColumnSelect(dictType = DictTypeConstants.HRM_EMPLOYEE_TYPE)
    @Schema(description = "聘用形式")
    private Integer type;

    @ExcelProperty("Hire Date")
    @Schema(description = "入职时间")
    private LocalDateTime entryTime;

    @ExcelProperty("Probation (months)")
    @ExcelColumnSelect(functionName = HrmEmployeeProbationExcelColumnSelectFunction.NAME)
    @Schema(description = "试用期（月）")
    private Integer probation;

    @ExcelProperty("Confirmation Date")
    @Schema(description = "转正时间")
    private LocalDateTime regularTime;

    @ExcelProperty("Termination Date")
    @Schema(description = "离职时间")
    private LocalDateTime leaveTime;

    @ExcelProperty("Work City")
    @Schema(description = "工作城市")
    private String workCity;

    @ExcelProperty("Work Location")
    @Schema(description = "工作地点")
    private String workAddress;

    @ExcelProperty("Work Address")
    @Schema(description = "工作详细地址")
    private String workDetailAddress;

    @ExcelProperty("Recruiting Channel")
    @ExcelColumnSelect(functionName = HrmRecruitChannelExcelColumnSelectFunction.NAME)
    @Schema(description = "招聘渠道选项，格式为名称（ID）")
    private String channelName;

    @ExcelProperty("Company Seniority Start")
    @Schema(description = "司龄起算时间")
    private LocalDateTime companyAgeStartTime;

    @ExcelProperty("Bound User Phone")
    @Schema(description = "绑定后台用户的手机号")
    private String userMobile;

    @ExcelProperty("Bank Card No")
    @Schema(description = "银行卡号")
    private String bankCardNumber;

    @ExcelProperty(value = "Bank Region", converter = AreaConvert.class)
    @Schema(description = "开户地区")
    private Integer bankAreaId;

    @ExcelProperty("Bank Name")
    @Schema(description = "银行名称")
    private String bankName;

    @ExcelProperty("Bank Branch Name")
    @Schema(description = "开户支行名称")
    private String bankBranchName;

    @ExcelProperty(value = "First-time Benefits Enrollment", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    @ExcelColumnSelect(dictType = DictTypeConstants.BOOLEAN_STRING)
    @Schema(description = "是否首次参保")
    private Boolean firstSocialSecurity;

    @ExcelProperty(value = "First-time Housing-fund Contribution", converter = DictConvert.class)
    @DictFormat(DictTypeConstants.BOOLEAN_STRING)
    @ExcelColumnSelect(dictType = DictTypeConstants.BOOLEAN_STRING)
    @Schema(description = "是否首次缴纳公积金")
    private Boolean firstAccumulationFund;

    @ExcelProperty("Personal Social-security Account")
    @Schema(description = "个人社保账号")
    private String socialSecurityNumber;

    @ExcelProperty("Personal Housing-fund Account")
    @Schema(description = "个人公积金账号")
    private String accumulationFundNumber;

    @ExcelProperty("Benefits Start Month")
    @Schema(description = "社保起缴月份")
    private LocalDateTime socialSecurityStartMonth;

    @ExcelProperty("Benefits Plan Name")
    @Schema(description = "参保方案名称")
    private String schemeName;

    @ExcelProperty("Notes")
    @Schema(description = "备注")
    private String remark;

}

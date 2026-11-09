package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.employeeinfo;

import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionValueVO;
import cn.iocoder.yudao.module.hrm.enums.DictTypeConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - HRM 员工薪资信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class HrmSalaryEmployeeInfoRespVO {

    @ExcelProperty(value = "Employee Pay ID", index = 0)
    @Schema(description = "员工薪资编号")
    private Long id;

    @ExcelProperty(value = "Employee ID", index = 1)
    @Schema(description = "员工编号")
    private Long employeeId;

    @ExcelProperty(value = "Employee Name", index = 2)
    @Schema(description = "员工姓名")
    private String employeeName;

    @ExcelProperty(value = "Employee No", index = 3)
    @Schema(description = "工号")
    private String jobNumber;

    @Schema(description = "手机号")
    private String mobile;

    @ExcelProperty(value = "Department ID", index = 4)
    @Schema(description = "部门编号")
    private Long deptId;

    @Schema(description = "部门名称")
    private String deptName;

    @Schema(description = "岗位名称")
    private String postName;

    @Schema(description = "入职状态")
    private Integer entryStatus;

    @Schema(description = "员工状态")
    private Integer status;

    @Schema(description = "入职时间")
    private LocalDateTime entryTime;

    @Schema(description = "转正时间")
    private LocalDateTime regularTime;

    @ExcelProperty(value = "Adjustment Reason", index = 6, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_SALARY_CHANGE_REASON)
    @Schema(description = "调整原因")
    private Integer changeReason;

    @ExcelProperty(value = "Effective Date", index = 7)
    @Schema(description = "生效日期")
    private LocalDateTime effectTime;

    @ExcelProperty(value = "Pay Status", index = 5, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_SALARY_CHANGE_TYPE)
    @Schema(description = "薪资状态")
    private Integer changeType;

    @ExcelProperty(value = "Probation Salary", index = 9)
    @Schema(description = "试用期工资")
    private BigDecimal probationSalary;

    @ExcelProperty(value = "Regular Salary", index = 8)
    @Schema(description = "正式工资")
    private BigDecimal regularSalary;

    @ExcelProperty(value = "Notes", index = 10)
    @Schema(description = "备注")
    private String remark;

    @Schema(description = "薪资项列表")
    private List<HrmSalaryOptionValueVO> salaryOptions;

    @Schema(description = "试用期薪资项列表")
    private List<HrmSalaryOptionValueVO> probationSalaryOptions;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}

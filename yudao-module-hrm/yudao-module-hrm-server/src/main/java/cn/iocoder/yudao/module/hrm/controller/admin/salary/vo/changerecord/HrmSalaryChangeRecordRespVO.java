package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.changerecord;

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

@Schema(description = "Admin - HRM Set Salary/Salary Changerecord response.")
@Data
@ExcelIgnoreUnannotated
public class HrmSalaryChangeRecordRespVO {

    @ExcelProperty(value = "Record ID", index = 0)
    @Schema(description = "Record code.")
    private Long id;

    @ExcelProperty(value = "Employee ID", index = 1)
    @Schema(description = "Employee code.")
    private Long employeeId;

    @Schema(description = "Record type.")
    private Integer recordType;

    @ExcelProperty(value = "Record Type", index = 2)
    @Schema(description = "Record type.")
    private String recordTypeName;

    @ExcelProperty(value = "Adjustment Reason", index = 3, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_SALARY_CHANGE_REASON)
    @Schema(description = "Adjust reason.")
    private Integer changeReason;

    @ExcelProperty(value = "Effective Date", index = 4)
    @Schema(description = "Effective Date")
    private LocalDateTime effectTime;

    @ExcelProperty(value = "Regular Salary Before Change", index = 5)
    @Schema(description = "Regular salary before change.")
    private BigDecimal beforeTotal;

    @ExcelProperty(value = "Regular Salary After Change", index = 6)
    @Schema(description = "Regular salary after change.")
    private BigDecimal afterTotal;

    @ExcelProperty(value = "Probation Salary Before Change", index = 7)
    @Schema(description = "Probation salary before change.")
    private BigDecimal probationBeforeTotal;

    @ExcelProperty(value = "Probation Salary After Change", index = 8)
    @Schema(description = "Probation salary after change.")
    private BigDecimal probationAfterTotal;

    @ExcelProperty(value = "Status", index = 9, converter = DictConvert.class)
    @DictFormat(DictTypeConstants.HRM_SALARY_CHANGE_RECORD_STATUS)
    @Schema(description = "Status.")
    private Integer status;

    @ExcelProperty(value = "Notes", index = 10)
    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Payroll item list.")
    private List<HrmSalaryOptionValueVO> salaryOptions;

    @Schema(description = "Probation pay items.")
    private List<HrmSalaryOptionValueVO> probationSalaryOptions;

    @ExcelProperty(value = "Create Time", index = 11)
    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

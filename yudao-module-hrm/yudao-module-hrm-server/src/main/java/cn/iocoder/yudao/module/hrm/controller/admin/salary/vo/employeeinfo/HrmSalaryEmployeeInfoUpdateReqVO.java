package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.employeeinfo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option.HrmSalaryOptionValueVO;
import cn.iocoder.yudao.module.hrm.enums.salary.employee.HrmSalaryChangeReasonEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.employee.HrmSalaryChangeRecordTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - HRM employeepayroll info edit request.")
@Data
public class HrmSalaryEmployeeInfoUpdateReqVO {

    @Schema(description = "Pay-change record ID. Pass when editing pending or canceled records.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee is required.")
    private Long employeeId;

    @Schema(description = "Record type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Record type is required.")
    @InEnum(value = HrmSalaryChangeRecordTypeEnum.class, message = "Record type must be {value}.")
    private Integer recordType;

    @Schema(description = "Adjust reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Adjust reason is required.")
    @InEnum(value = HrmSalaryChangeReasonEnum.class, message = "Adjust reason must be {value}.")
    private Integer changeReason;

    @Schema(description = "Effective Date")
    private LocalDateTime effectTime;

    @Schema(description = "Notes.", example = "Annual raise")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @Schema(description = "Payroll item list.")
    @Valid
    private List<HrmSalaryOptionValueVO> salaryOptions;

    @Schema(description = "Probation pay items.")
    @Valid
    private List<HrmSalaryOptionValueVO> probationSalaryOptions;

}

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

@Schema(description = "管理后台 - HRM 员工薪资信息修改 Request VO")
@Data
public class HrmSalaryEmployeeInfoUpdateReqVO {

    @Schema(description = "定薪/调薪记录编号；编辑待生效或已取消记录时传入", example = "1024")
    private Long id;

    @Schema(description = "员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee is required.")
    private Long employeeId;

    @Schema(description = "记录类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Record type is required.")
    @InEnum(value = HrmSalaryChangeRecordTypeEnum.class, message = "Record type must be {value}.")
    private Integer recordType;

    @Schema(description = "调整原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Adjust reason is required.")
    @InEnum(value = HrmSalaryChangeReasonEnum.class, message = "Adjust reason must be {value}.")
    private Integer changeReason;

    @Schema(description = "生效日期")
    private LocalDateTime effectTime;

    @Schema(description = "备注", example = "Annual raise")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

    @Schema(description = "薪资项列表")
    @Valid
    private List<HrmSalaryOptionValueVO> salaryOptions;

    @Schema(description = "试用期薪资项列表")
    @Valid
    private List<HrmSalaryOptionValueVO> probationSalaryOptions;

}

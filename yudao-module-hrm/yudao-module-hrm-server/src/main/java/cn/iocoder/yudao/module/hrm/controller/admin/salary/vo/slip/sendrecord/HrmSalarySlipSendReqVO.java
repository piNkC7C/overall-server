package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.sendrecord;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.template.HrmSalarySlipTemplateOptionVO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM payslip send request VO.")
@Data
public class HrmSalarySlipSendReqVO {

    @Schema(description = "Payroll ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Payroll ID is required.")
    private Long monthRecordId;

    @Schema(description = "Hide empty items.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Hide empty items cannot be empty.")
    private Boolean hideEmpty;

    @Schema(description = "Payslip template items.")
    @Valid
    private List<HrmSalarySlipTemplateOptionVO> options;

    @Schema(description = "Send to all filtered employees.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Send to all filtered employees cannot be empty.")
    private Boolean all;

    @Schema(description = "Employee code list.", example = "[1024, 1025]")
    private List<Long> employeeIds;

    @Schema(description = "Employee Name、Employee No. or phone number.", example = "John.")
    private String search;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Is not already send.", example = "false")
    private Boolean sent;

    @AssertTrue(message = "Selected employees cannot be empty.")
    @JsonIgnore
    public boolean isEmployeeIdsValid() {
        return Boolean.TRUE.equals(all) || CollUtil.isNotEmpty(employeeIds);
    }

}

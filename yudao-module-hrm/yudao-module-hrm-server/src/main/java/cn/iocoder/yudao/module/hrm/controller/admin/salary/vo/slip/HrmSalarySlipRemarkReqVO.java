package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - HRM payslipnotes request.")
@Data
public class HrmSalarySlipRemarkReqVO {

    @Schema(description = "Payslip ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Payslip ID cannot be empty.")
    private Long id;

    @Schema(description = "Notes.", example = "This month's performance bonus is included")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}

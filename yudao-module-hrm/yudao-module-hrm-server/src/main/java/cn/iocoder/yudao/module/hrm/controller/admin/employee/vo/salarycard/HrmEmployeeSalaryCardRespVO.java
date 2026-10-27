package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.salarycard;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM employee payroll card response VO.")
@Data
public class HrmEmployeeSalaryCardRespVO {

    @Schema(description = "Payroll card ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long employeeId;

    @Schema(description = "Bank Account", example = "622202600001")
    private String bankCardNumber;

    @Schema(description = "Bank Region code.", example = "440300")
    private Integer bankAreaId;

    @Schema(description = "Bank Region name.", example = "CA San Jose")
    private String bankAreaName;

    @Schema(description = "Bank name", example = "China Merchants Bank")
    private String bankName;

    @Schema(description = "Bank Branch name.", example = "Tech Park branch")
    private String bankBranchName;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

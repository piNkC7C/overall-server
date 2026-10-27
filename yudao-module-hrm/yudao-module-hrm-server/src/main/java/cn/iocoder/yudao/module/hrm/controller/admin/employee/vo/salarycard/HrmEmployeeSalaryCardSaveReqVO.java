package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.salarycard;

import cn.iocoder.yudao.module.hrm.framework.operatelog.core.HrmBankCardNumberParseFunction;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "HRM employee payroll card save request VO.")
@Data
public class HrmEmployeeSalaryCardSaveReqVO {

    @Schema(description = "Payroll card ID.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Employee is required.")
    private Long employeeId;

    @Schema(description = "Bank Account", requiredMode = Schema.RequiredMode.REQUIRED, example = "622202600001")
    @NotBlank(message = "Bank Account is required.")
    @Size(max = 64, message = "Bank Account cannot exceed 64 characters.")
    @DiffLogField(name = "Bank Account", function = HrmBankCardNumberParseFunction.NAME)
    private String bankCardNumber;

    @Schema(description = "Bank Region code.", example = "440300")
    @DiffLogField(name = "Bank Region code.")
    private Integer bankAreaId;

    @Schema(description = "Bank name", example = "China Merchants Bank")
    @Size(max = 64, message = "Bank name cannot exceed 64 characters.")
    @DiffLogField(name = "Bank name")
    private String bankName;

    @Schema(description = "Bank Branch name.", example = "Tech Park branch")
    @Size(max = 128, message = "Bank Branch name cannot exceed 128 characters.")
    @DiffLogField(name = "Bank Branch name.")
    private String bankBranchName;

}

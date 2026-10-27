package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.sendrecord;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "HRM payslip send record response VO.")
@Data
public class HrmSalarySlipSendRecordRespVO {

    @Schema(description = "Code.")
    private Long id;

    @Schema(description = "Payroll ID")
    private Long monthRecordId;

    @Schema(description = "Payroll Headcount")
    private Integer employeeCount;

    @Schema(description = "Paid employee count.")
    private Integer sendEmployeeCount;

    @Schema(description = "Readheadcount.")
    private Integer readCount;

    @Schema(description = "Year.")
    private Integer year;

    @Schema(description = "Month")
    private Integer month;

    @Schema(description = "Creator code.")
    private String creator;

    @Schema(description = "Creator Name.")
    private String creatorName;

    @Schema(description = "Create time.")
    private LocalDateTime createTime;

}

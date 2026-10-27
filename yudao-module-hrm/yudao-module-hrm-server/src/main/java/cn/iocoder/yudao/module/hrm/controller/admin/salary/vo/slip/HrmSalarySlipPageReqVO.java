package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(description = "Admin - HRM payslippage request.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmSalarySlipPageReqVO extends PageParam {
    @Schema(description = "PaysliprecordID.", example = "1024")
    private Long sendRecordId;
    @Schema(description = "Employee code.", example = "2048")
    private Long employeeId;
    @Schema(description = "Employee code list.", example = "[2048, 2049]")
    private List<Long> employeeIds;
    @Schema(description = "Search keyword.", example = "John.")
    private String search;
    @Schema(description = "Department code.", example = "100")
    private Long deptId;
    @Schema(description = "Read status.", example = "1")
    private Integer readStatus;
    @Schema(description = "Notes.", example = "7 Monthpayslip")
    private String remark;
}

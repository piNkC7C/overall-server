package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "HRM payslip item response VO.")
@Data
public class HrmSalarySlipOptionRespVO {

    @Schema(description = "Payslip option name.")
    private String name;

    @Schema(description = "Payslip option type.")
    private Integer type;

    @Schema(description = "Code.")
    private Integer code;

    @Schema(description = "Value.")
    private BigDecimal value;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Sort.")
    private Integer sort;

    @Schema(description = "Payslip sub-item.")
    private List<HrmSalarySlipOptionRespVO> children;

}

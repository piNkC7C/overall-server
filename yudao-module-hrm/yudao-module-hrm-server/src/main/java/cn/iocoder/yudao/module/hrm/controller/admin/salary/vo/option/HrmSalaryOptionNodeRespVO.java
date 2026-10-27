package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.option;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Schema(description = "HRM payroll sheet pay item node response VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmSalaryOptionNodeRespVO extends HrmSalaryOptionRespVO {

    @Schema(description = "Child pay item.")
    private List<HrmSalaryOptionNodeRespVO> children;

}

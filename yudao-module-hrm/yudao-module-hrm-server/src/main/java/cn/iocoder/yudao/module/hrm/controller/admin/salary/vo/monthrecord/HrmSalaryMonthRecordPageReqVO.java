package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.monthrecord;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.monthrecord.HrmSalaryMonthRecordStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "HRM monthly payroll sheet page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmSalaryMonthRecordPageReqVO extends PageParam {

    @Schema(description = "Year.", example = "2026")
    private Integer year;

    @Schema(description = "Month", example = "7")
    private Integer month;

    @Schema(description = "Accounting status.", example = "1")
    @InEnum(value = HrmSalaryMonthRecordStatusEnum.class, message = "Monthly payroll status must be {value}.")
    private Integer status;

}

package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.slip.sendrecord;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "HRM payslip send record page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmSalarySlipSendRecordPageReqVO extends PageParam {

    @Schema(description = "Year.", example = "2026")
    private Integer year;

    @Schema(description = "Month", example = "7")
    private Integer month;

}

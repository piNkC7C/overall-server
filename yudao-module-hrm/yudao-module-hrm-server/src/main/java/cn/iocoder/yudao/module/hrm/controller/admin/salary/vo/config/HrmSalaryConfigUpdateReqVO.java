package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.config;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.salary.config.HrmSalarySocialSecurityMonthTypeEnum;
import cn.iocoder.yudao.module.hrm.framework.operatelog.core.HrmSalarySocialSecurityMonthTypeParseFunction;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "HRM payroll setting update request VO.")
@Data
public class HrmSalaryConfigUpdateReqVO {

    @Schema(description = "Social security matching Month type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Social security matching Month type is required.")
    @InEnum(value = HrmSalarySocialSecurityMonthTypeEnum.class, message = "Social security matching Month type must be {value}.")
    @DiffLogField(name = "Social security matching Month.", function = HrmSalarySocialSecurityMonthTypeParseFunction.NAME)
    private Integer socialSecurityMonthType;

}

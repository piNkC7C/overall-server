package cn.iocoder.yudao.module.hrm.controller.admin.insurance.vo.monthrecord.employee;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.insurance.employee.HrmInsuranceEmployeeStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "HRM employee monthly benefits page request VO.")
@Data
@EqualsAndHashCode(callSuper = true)
public class HrmInsuranceMonthEmployeeRecordPageReqVO extends PageParam {

    @Schema(description = "Monthly insurance ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Social security Table ID is required.")
    private Long monthRecordId;

    @Schema(description = "Employee code.", example = "1024")
    private Long employeeId;

    @Schema(description = "Employee Name", example = "John.")
    private String employeeName;

    @Schema(description = "Social security plan code.", example = "1024")
    private Long schemeId;

    @Schema(description = "Insurance region ID.", example = "440300")
    private Integer areaId;

    @Schema(description = "Insurance status.", example = "1")
    @InEnum(value = HrmInsuranceEmployeeStatusEnum.class, message = "Insurance status must be {value}.")
    private Integer status;

}

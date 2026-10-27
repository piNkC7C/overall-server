package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Admin - HRM employee status quantity response.")
@Data
@AllArgsConstructor
public class HrmEmployeeStatusCountRespVO {

    @Schema(description = "Status tab.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Integer status;

    @Schema(description = "Quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long count;

}

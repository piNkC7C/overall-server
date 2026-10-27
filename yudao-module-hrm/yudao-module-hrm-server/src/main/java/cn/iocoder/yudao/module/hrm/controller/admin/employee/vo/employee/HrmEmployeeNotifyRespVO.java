package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "Admin - HRM employeenotification send result response.")
@Data
@Accessors(chain = true)
public class HrmEmployeeNotifyRespVO {

    @Schema(description = "Send succeeded quantity.", example = "10")
    private Integer successCount;

    @Schema(description = "Skipped users without an admin account.", example = "2")
    private Integer skippedCount;

    @Schema(description = "Send failed quantity.", example = "1")
    private Integer failureCount;

}

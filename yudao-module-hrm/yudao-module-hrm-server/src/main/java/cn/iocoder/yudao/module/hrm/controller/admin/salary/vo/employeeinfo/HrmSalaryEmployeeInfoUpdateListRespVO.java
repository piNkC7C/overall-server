package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.employeeinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Schema(description = "Admin - HRM batch Salary Change response.")
@Data
public class HrmSalaryEmployeeInfoUpdateListRespVO {

    @Schema(description = "Succeededemployee code list.")
    private List<Long> successEmployeeIds = new ArrayList<>();

    @Schema(description = "Failed employees and reasons.")
    private Map<Long, String> failureEmployeeReasons = new LinkedHashMap<>();

}

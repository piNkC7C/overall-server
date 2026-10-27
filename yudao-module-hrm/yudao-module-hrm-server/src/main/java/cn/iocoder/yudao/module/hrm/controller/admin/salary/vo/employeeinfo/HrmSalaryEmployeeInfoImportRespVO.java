package cn.iocoder.yudao.module.hrm.controller.admin.salary.vo.employeeinfo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - HRM employeepayroll info import response.")
@Data
@Builder
public class HrmSalaryEmployeeInfoImportRespVO {

    @Schema(description = "Import succeeded Employee No.Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> successJobNumbers;

    @Schema(description = "Failed employee import map. Key is employee no. or row no. Value is the failure reason.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureJobNumbers;

}

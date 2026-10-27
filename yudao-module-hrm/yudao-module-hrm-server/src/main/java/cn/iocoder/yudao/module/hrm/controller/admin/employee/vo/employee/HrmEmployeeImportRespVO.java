package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - HRM employee profile import response.")
@Data
@Builder
public class HrmEmployeeImportRespVO {

    @Schema(description = "Create succeeded Employee No.Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> createJobNumbers;

    @Schema(description = "Update succeeded Employee No.Array.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> updateJobNumbers;

    @Schema(description = "Skipped duplicate employee nos.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<String> skipJobNumbers;

    @Schema(description = "Failed employee import map. Key is source row and employee key. Value is the failure reason.",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, String> failureJobNumbers;

}

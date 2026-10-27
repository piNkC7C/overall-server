package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Admin - HRM employeefieldsetting response.")
@Data
public class HrmEmployeeFieldConfigRespVO {

    @Schema(description = "Field Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "name")
    private String name;

    @Schema(description = "Field title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Employee Name")
    private String title;

    @Schema(description = "Field group name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Basic Info")
    private String groupName;

    @Schema(description = "Is not Show.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean visible;

    @Schema(description = "Is not allow employee edit.", example = "true")
    private Boolean editable;

    @Schema(description = "Is not lock Show.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean visibleLocked;

    @Schema(description = "Is not lock edit.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    private Boolean editableLocked;

}

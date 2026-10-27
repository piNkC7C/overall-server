package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.config;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - HRM employeefieldsetting save request.")
@Data
public class HrmEmployeeFieldConfigSaveReqVO {

    @Schema(description = "Field Name", requiredMode = Schema.RequiredMode.REQUIRED, example = "name")
    @NotBlank(message = "Field Name is required.")
    @Size(max = 40, message = "Field Name cannot exceed 40 characters.")
    @DiffLogField(name = "Field Name")
    private String name;

    @Schema(description = "Is not Show.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Is not Show is required.")
    @DiffLogField(name = "Is not Show.")
    private Boolean visible;

    @Schema(description = "Is not allow employee edit.", example = "true")
    @DiffLogField(name = "Is not allow employee edit.")
    private Boolean editable;

}

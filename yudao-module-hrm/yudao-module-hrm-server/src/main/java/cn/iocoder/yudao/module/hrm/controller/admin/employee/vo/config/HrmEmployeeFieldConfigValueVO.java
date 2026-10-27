package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.config;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "HRM employee field setting value VO.")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrmEmployeeFieldConfigValueVO {

    @Schema(description = "Field Name", example = "mobile")
    private String name;

    @Schema(description = "Is not Show.", example = "true")
    private Boolean visible;

    @Schema(description = "Is not allow employee edit.", example = "true")
    private Boolean editable;

}

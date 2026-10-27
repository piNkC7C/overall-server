package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.contact;

import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - HRM employeecontact save request.")
@Data
public class HrmEmployeeContactSaveReqVO {

    @Schema(description = "Contact code.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Contact name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Jane.")
    @NotBlank(message = "Contact name is required.")
    @Size(max = 64, message = "Contact name length cannot exceed 64 characters.")
    @DiffLogField(name = "Contact name.")
    private String name;

    @Schema(description = "Relationship", example = "Spouse")
    @Size(max = 64, message = "Relationship length cannot exceed 64 characters.")
    @DiffLogField(name = "Relationship")
    private String relation;

    @Schema(description = "ContactPhone.", example = "15601691301")
    @Size(max = 40, message = "ContactPhone length cannot exceed 40 characters.")
    @DiffLogField(name = "ContactPhone.")
    private String phone;

    @Schema(description = "Contact employer.", example = "Sample Tech")
    @Size(max = 128, message = "Contact employer length cannot exceed 128 characters.")
    @DiffLogField(name = "Contact employer.")
    private String workUnit;

    @Schema(description = "ContactTitle.", example = "Product manager")
    @Size(max = 128, message = "ContactTitle length cannot exceed 128 characters.")
    @DiffLogField(name = "ContactTitle.")
    private String postName;

    @Schema(description = "ContactAddress.", example = "Xihu District, Hangzhou")
    @Size(max = 255, message = "ContactAddress length cannot exceed 255 characters.")
    @DiffLogField(name = "ContactAddress.")
    private String address;

    @Schema(description = "Sort.", example = "1")
    @DiffLogField(name = "Sort.")
    private Integer sort;

}

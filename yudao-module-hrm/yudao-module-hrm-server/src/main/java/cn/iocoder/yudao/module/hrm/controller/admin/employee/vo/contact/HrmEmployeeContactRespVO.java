package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.contact;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employeecontact response.")
@Data
public class HrmEmployeeContactRespVO {

    @Schema(description = "Contact code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long employeeId;

    @Schema(description = "Contact name.", example = "Jane.")
    private String name;

    @Schema(description = "Relationship", example = "Spouse")
    private String relation;

    @Schema(description = "ContactPhone.", example = "15601691301")
    private String phone;

    @Schema(description = "Contact employer.")
    private String workUnit;

    @Schema(description = "ContactTitle.")
    private String postName;

    @Schema(description = "ContactAddress.")
    private String address;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

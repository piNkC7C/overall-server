package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.educationexperience;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employeeeducation response.")
@Data
public class HrmEmployeeEducationExperienceRespVO {

    @Schema(description = "Education ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long employeeId;

    @Schema(description = "Education", example = "8")
    private Integer education;

    @Schema(description = "School", example = "Zhejiang University")
    private String graduateSchool;

    @Schema(description = "Major", example = "Software engineering")
    private String major;

    @Schema(description = "Enrollment Date")
    private LocalDateTime admissionTime;

    @Schema(description = "Graduation Date")
    private LocalDateTime graduationTime;

    @Schema(description = "Teaching method.", example = "1")
    private Integer teachingMethods;

    @Schema(description = "First degree.", example = "true")
    private Boolean firstDegree;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

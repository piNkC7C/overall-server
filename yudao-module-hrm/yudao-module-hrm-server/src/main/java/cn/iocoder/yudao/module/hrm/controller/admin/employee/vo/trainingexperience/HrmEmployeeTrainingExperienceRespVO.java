package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.trainingexperience;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employeetraining response.")
@Data
public class HrmEmployeeTrainingExperienceRespVO {

    @Schema(description = "Training ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long employeeId;

    @Schema(description = "Training Course", example = "Item admin.")
    private String course;

    @Schema(description = "Training Provider name.", example = "Internal academy")
    private String organizationName;

    @Schema(description = "Training start date.")
    private LocalDateTime startTime;

    @Schema(description = "Training end date.")
    private LocalDateTime endTime;

    @Schema(description = "Training duration.", example = "16 hours")
    private String duration;

    @Schema(description = "Training Score", example = "Excellent")
    private String result;

    @Schema(description = "Training certificate name.", example = "PMP")
    private String certificateName;

    @Schema(description = "Notes.")
    private String remark;

    @Schema(description = "Sort.", example = "1")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

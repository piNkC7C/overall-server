package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.trainingexperience;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mzt.logapi.starter.annotation.DiffLogField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.isAfterOrEqual;

@Schema(description = "Admin - HRM employeetrainingsave request.")
@Data
public class HrmEmployeeTrainingExperienceSaveReqVO {

    @Schema(description = "Training ID.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Training Course", requiredMode = Schema.RequiredMode.REQUIRED, example = "Item admin.")
    @NotBlank(message = "Training Course is required.")
    @Size(max = 128, message = "Training Course length cannot exceed 128 characters.")
    @DiffLogField(name = "Training Course")
    private String course;

    @Schema(description = "Training Provider name.", example = "Internal academy")
    @Size(max = 128, message = "Training Provider name length cannot exceed 128 characters.")
    @DiffLogField(name = "Training Provider name.")
    private String organizationName;

    @Schema(description = "Training start date.")
    @DiffLogField(name = "Training Start Date")
    private LocalDateTime startTime;

    @Schema(description = "Training end date.")
    @DiffLogField(name = "Training End Date")
    private LocalDateTime endTime;

    @Schema(description = "Training duration.", example = "16 hours")
    @Size(max = 64, message = "Training duration cannot exceed 64 characters.")
    @DiffLogField(name = "Training Duration")
    private String duration;

    @Schema(description = "Training Score", example = "Excellent")
    @Size(max = 64, message = "Training Score length cannot exceed 64 characters.")
    @DiffLogField(name = "Training Score")
    private String result;

    @Schema(description = "Training certificate name.", example = "PMP")
    @Size(max = 128, message = "Training certificate name cannot exceed 128 characters.")
    @DiffLogField(name = "Training Certificate Name")
    private String certificateName;

    @Schema(description = "Notes.", example = "Internal training")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "Notes.")
    private String remark;

    @Schema(description = "Sort.", example = "1")
    @DiffLogField(name = "Sort.")
    private Integer sort;

    @AssertTrue(message = "Training end date cannot be earlier than the start date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || isAfterOrEqual(endTime, startTime);
    }

}

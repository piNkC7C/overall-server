package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.workexperience;

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

@Schema(description = "Admin - HRM employeework experiencesave request.")
@Data
public class HrmEmployeeWorkExperienceSaveReqVO {

    @Schema(description = "Work-experience ID.", example = "1024")
    private Long id;

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Employer.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sample Tech")
    @NotBlank(message = "Employer is required.")
    @Size(max = 255, message = "Employer length cannot exceed 255 characters.")
    @DiffLogField(name = "Employer")
    private String workUnit;

    @Schema(description = "Title", requiredMode = Schema.RequiredMode.REQUIRED, example = "Software engineer")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title length cannot exceed 255 characters.")
    @DiffLogField(name = "Title")
    private String postName;

    @Schema(description = "Work start date.")
    @DiffLogField(name = "Work Start Date")
    private LocalDateTime startTime;

    @Schema(description = "Work end date.")
    @DiffLogField(name = "Work End Date")
    private LocalDateTime endTime;

    @Schema(description = "Offboarding reason.", example = "Career development")
    @Size(max = 1024, message = "Offboarding reason length cannot exceed 1024 characters.")
    @DiffLogField(name = "Offboarding reason.")
    private String reason;

    @Schema(description = "Reference", example = "Jane.")
    @Size(max = 255, message = "Reference length cannot exceed 255 characters.")
    @DiffLogField(name = "Reference")
    private String witnessName;

    @Schema(description = "Referencephone number.", example = "15601691301")
    @Size(max = 32, message = "Referencephone number length cannot exceed 32 characters.")
    @DiffLogField(name = "Referencephone number.")
    private String witnessPhone;

    @Schema(description = "Work notes.", example = "Own core business R&D")
    @Size(max = 500, message = "Work notes cannot exceed 500 characters.")
    @DiffLogField(name = "Work Notes")
    private String remark;

    @Schema(description = "Sort.", example = "1")
    @DiffLogField(name = "Sort.")
    private Integer sort;

    @AssertTrue(message = "Work-experience end date cannot be earlier than the start date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || isAfterOrEqual(endTime, startTime);
    }

}

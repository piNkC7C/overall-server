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

@Schema(description = "管理后台 - HRM 员工工作经历保存 Request VO")
@Data
public class HrmEmployeeWorkExperienceSaveReqVO {

    @Schema(description = "工作经历编号", example = "1024")
    private Long id;

    @Schema(description = "员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "工作单位", requiredMode = Schema.RequiredMode.REQUIRED, example = "Sample Tech")
    @NotBlank(message = "Employer is required.")
    @Size(max = 255, message = "Employer length cannot exceed 255 characters.")
    @DiffLogField(name = "工作单位")
    private String workUnit;

    @Schema(description = "职务", requiredMode = Schema.RequiredMode.REQUIRED, example = "Software engineer")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title length cannot exceed 255 characters.")
    @DiffLogField(name = "职务")
    private String postName;

    @Schema(description = "工作开始日期")
    @DiffLogField(name = "工作开始日期")
    private LocalDateTime startTime;

    @Schema(description = "工作结束日期")
    @DiffLogField(name = "工作结束日期")
    private LocalDateTime endTime;

    @Schema(description = "离职原因", example = "Career development")
    @Size(max = 1024, message = "Offboarding reason length cannot exceed 1024 characters.")
    @DiffLogField(name = "离职原因")
    private String reason;

    @Schema(description = "证明人", example = "Jane.")
    @Size(max = 255, message = "Reference length cannot exceed 255 characters.")
    @DiffLogField(name = "证明人")
    private String witnessName;

    @Schema(description = "证明人手机号", example = "15601691301")
    @Size(max = 32, message = "Referencephone number length cannot exceed 32 characters.")
    @DiffLogField(name = "证明人手机号")
    private String witnessPhone;

    @Schema(description = "工作备注", example = "Own core business R&D")
    @Size(max = 500, message = "Work notes cannot exceed 500 characters.")
    @DiffLogField(name = "工作备注")
    private String remark;

    @Schema(description = "排序", example = "1")
    @DiffLogField(name = "排序")
    private Integer sort;

    @AssertTrue(message = "Work-experience end date cannot be earlier than the start date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || isAfterOrEqual(endTime, startTime);
    }

}

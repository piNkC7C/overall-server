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

@Schema(description = "管理后台 - HRM 员工培训经历保存 Request VO")
@Data
public class HrmEmployeeTrainingExperienceSaveReqVO {

    @Schema(description = "培训经历编号", example = "1024")
    private Long id;

    @Schema(description = "员工编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "培训课程", requiredMode = Schema.RequiredMode.REQUIRED, example = "Item admin.")
    @NotBlank(message = "Training Course is required.")
    @Size(max = 128, message = "Training Course length cannot exceed 128 characters.")
    @DiffLogField(name = "培训课程")
    private String course;

    @Schema(description = "培训机构名称", example = "Internal academy")
    @Size(max = 128, message = "Training Provider name length cannot exceed 128 characters.")
    @DiffLogField(name = "培训机构名称")
    private String organizationName;

    @Schema(description = "培训开始日期")
    @DiffLogField(name = "培训开始日期")
    private LocalDateTime startTime;

    @Schema(description = "培训结束日期")
    @DiffLogField(name = "培训结束日期")
    private LocalDateTime endTime;

    @Schema(description = "培训时长", example = "16 hours")
    @Size(max = 64, message = "Training duration cannot exceed 64 characters.")
    @DiffLogField(name = "培训时长")
    private String duration;

    @Schema(description = "培训成绩", example = "Excellent")
    @Size(max = 64, message = "Training Score length cannot exceed 64 characters.")
    @DiffLogField(name = "培训成绩")
    private String result;

    @Schema(description = "培训证书名称", example = "PMP")
    @Size(max = 128, message = "Training certificate name cannot exceed 128 characters.")
    @DiffLogField(name = "培训证书名称")
    private String certificateName;

    @Schema(description = "备注", example = "Internal training")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    @DiffLogField(name = "备注")
    private String remark;

    @Schema(description = "排序", example = "1")
    @DiffLogField(name = "排序")
    private Integer sort;

    @AssertTrue(message = "Training end date cannot be earlier than the start date.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || isAfterOrEqual(endTime, startTime);
    }

}

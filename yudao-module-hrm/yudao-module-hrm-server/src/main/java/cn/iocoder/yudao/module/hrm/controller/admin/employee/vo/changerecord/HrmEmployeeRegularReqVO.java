package cn.iocoder.yudao.module.hrm.controller.admin.employee.vo.changerecord;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.hrm.enums.employee.employment.HrmEmployeeChangeReasonEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - HRM employee confirmation request.")
@Data
public class HrmEmployeeRegularReqVO {

    @Schema(description = "Employee code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Employee code is required.")
    private Long employeeId;

    @Schema(description = "Change Reason", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Change Reason is required.")
    @InEnum(value = HrmEmployeeChangeReasonEnum.class, message = "Change Reason must be {value}.")
    private Integer reason;

    @Schema(description = "New department ID. Leave empty to keep unchanged.", example = "200")
    private Long newDeptId;

    @Schema(description = "New job title; leave empty to keep unchanged.", example = "Java engineer.")
    @Size(max = 255, message = "New job title cannot exceed 255 characters.")
    private String newPostName;

    @Schema(description = "New job level; leave empty to keep unchanged.", example = "P6")
    @Size(max = 255, message = "New job level cannot exceed 255 characters.")
    private String newPostLevel;

    @Schema(description = "New work location; leave empty to keep unchanged.", example = "Shanghai")
    @Size(max = 255, message = "New work location cannot exceed 255 characters.")
    private String newWorkAddress;

    @Schema(description = "New manager employee ID. Leave empty to keep unchanged.", example = "3")
    private Long newLeaderEmployeeId;

    @Schema(description = "Effective Date", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Effective Date is required.")
    private LocalDateTime effectTime;

    @Schema(description = "Notes.", example = "Probation review passed")
    @Size(max = 500, message = "Notes cannot exceed 500 characters.")
    private String remark;

}

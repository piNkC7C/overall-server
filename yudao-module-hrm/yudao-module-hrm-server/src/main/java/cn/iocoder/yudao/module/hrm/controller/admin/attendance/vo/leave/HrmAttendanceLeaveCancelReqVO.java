package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.leave;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - HRM 员工请假申请取消 Request VO")
@Data
public class HrmAttendanceLeaveCancelReqVO {

    @Schema(description = "请假记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Leave record ID cannot be empty.")
    private Long id;

    @Schema(description = "取消原因", requiredMode = Schema.RequiredMode.REQUIRED, example = "Trip canceled")
    @NotBlank(message = "Cancelreason is required.")
    @Size(max = 500, message = "Cancelreason cannot exceed 500 characters.")
    private String reason;

}

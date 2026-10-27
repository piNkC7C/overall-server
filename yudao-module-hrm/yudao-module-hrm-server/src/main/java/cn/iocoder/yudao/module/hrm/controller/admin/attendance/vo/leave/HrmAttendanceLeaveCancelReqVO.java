package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.leave;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - HRM employeeleave requestcancel request.")
@Data
public class HrmAttendanceLeaveCancelReqVO {

    @Schema(description = "Leave record ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Leave record ID cannot be empty.")
    private Long id;

    @Schema(description = "Cancelreason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Trip canceled")
    @NotBlank(message = "Cancelreason is required.")
    @Size(max = 500, message = "Cancelreason cannot exceed 500 characters.")
    private String reason;

}

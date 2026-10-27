package cn.iocoder.yudao.module.oa.controller.admin.attendance.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.attendance.OaAttendanceStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "Admin - OA attendance edit request.")
@Data
public class OaAttendanceUpdateReqVO {

    @Schema(description = "Attendancerecord code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Attendancerecord code is required.")
    private Long id;

    @Schema(description = "Attendance status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Attendance status is required.")
    @InEnum(value = OaAttendanceStatusEnum.class, message = "Attendance status must be {value}.")
    private Integer status;

    @Schema(description = "Attendance notes.", example = "Late due to traffic")
    @Size(max = 500, message = "AttendanceNotes cannot exceed 500 characters.")
    private String remark;

}

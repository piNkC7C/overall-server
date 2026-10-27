package cn.iocoder.yudao.module.oa.controller.admin.attendance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Schema(description = "Admin - OA attendance response.")
@Data
@Accessors(chain = true)
public class OaAttendanceRespVO {

    @Schema(description = "Attendancerecord code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Nickname", example = "Overall.")
    private String userName;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Attendance type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "Attendance status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Attendance time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    private LocalDateTime attendanceTime;

    @Schema(description = "Attendance IP.", example = "127.0.0.1")
    private String attendanceIp;

    @Schema(description = "Attendance notes.", example = "Normal clock-in.")
    private String remark;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    private LocalDateTime createTime;

}

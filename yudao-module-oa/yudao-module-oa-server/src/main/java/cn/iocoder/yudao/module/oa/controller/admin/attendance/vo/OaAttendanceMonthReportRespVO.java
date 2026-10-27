package cn.iocoder.yudao.module.oa.controller.admin.attendance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Schema(description = "OA attendance monthly report response VO.")
@Data
@Accessors(chain = true)
public class OaAttendanceMonthReportRespVO {

    @Schema(description = "User ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long userId;

    @Schema(description = "Nickname", example = "Overall.")
    private String userName;

    @Schema(description = "Department code.", example = "100")
    private Long deptId;

    @Schema(description = "Department name.", example = "Engineering.")
    private String deptName;

    @Schema(description = "Clock-in count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer clockInCount;

    @Schema(description = "Clock-out count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "19")
    private Integer clockOutCount;

    @Schema(description = "On-time count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "36")
    private Integer normalCount;

    @Schema(description = "Late Count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer lateCount;

    @Schema(description = "Left-early Count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer earlyCount;

    @Schema(description = "Leave days, approved and start time in Current Month apply please days Total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer leaveDays;

    @Schema(description = "Travel Days, approved and start time in Current Month apply please days Total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Integer travelDays;

    @Schema(description = "Absence days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer absentDays;

}

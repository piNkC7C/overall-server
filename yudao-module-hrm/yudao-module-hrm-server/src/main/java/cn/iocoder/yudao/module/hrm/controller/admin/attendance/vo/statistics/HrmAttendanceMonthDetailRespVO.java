package cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.statistics;

import cn.iocoder.yudao.module.hrm.controller.admin.attendance.vo.leave.HrmAttendanceLeaveRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM employee monthly attendance detail response VO.")
@Data
public class HrmAttendanceMonthDetailRespVO {

    @Schema(description = "Monthly summary.")
    private HrmAttendanceMonthRecordRespVO summary;

    @Schema(description = "Each Day clock-in detail.")
    private List<HrmAttendanceDailyDetailRespVO> dailyDetails;

    @Schema(description = "Leave record.")
    private List<HrmAttendanceLeaveRespVO> leaves;

}

package cn.iocoder.yudao.module.oa.controller.admin.meetingroom.vo.booking;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Meeting room busy slots request VO.")
@Data
public class OaMeetingRoomBookingScheduleReqVO {

    @Schema(description = "Meeting-room ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Meeting-room ID cannot be empty.")
    private Long roomId;

    @Schema(description = "Search start time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-14 10:00:00")
    @NotNull(message = "Search start time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "Search end time.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-14 11:00:00")
    @NotNull(message = "Search end time is required.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

}

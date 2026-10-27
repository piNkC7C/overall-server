package cn.iocoder.yudao.module.oa.controller.admin.attendance.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Schema(description = "Admin - OA attendanceWeekly Report request.")
@Data
public class OaAttendanceWeekReportReqVO {

    @Schema(description = "Week start Date.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-09-07")
    @NotNull(message = "Week start Date is required.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @Schema(description = "User ID.", example = "1")
    private Long userId;

}

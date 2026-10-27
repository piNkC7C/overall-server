package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.worklog;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - PMS item time spent report request.")
@Data
public class PmsProjectWorkLogReportReqVO {

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Time-log range.", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Time-log range cannot be empty.")
    @Size(min = 2, max = 2, message = "Time-log range must include both start and end time.")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "Sprint name.", example = "Sprint 1")
    private String iterationName;

}

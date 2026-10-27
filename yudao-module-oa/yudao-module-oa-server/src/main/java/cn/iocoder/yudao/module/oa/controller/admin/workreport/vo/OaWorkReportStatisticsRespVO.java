package cn.iocoder.yudao.module.oa.controller.admin.workreport.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.time.LocalDateTime;

@Schema(description = "Admin - OA work reportStats response.")
@Data
public class OaWorkReportStatisticsRespVO {

    @Schema(description = "Statsheadcount.", example = "1")
    private Integer userCount;

    @Schema(description = "Required count.", example = "1")
    private Integer expectedCount;

    @Schema(description = "Completed count.", example = "1")
    private Integer submittedCount;

    @Schema(description = "Missing count.", example = "1")
    private Integer missingCount;

    @Schema(description = "EmployeeStats list.")
    private List<UserStatistics> users;

    @Schema(description = "Admin - employeework reportStats response.")
    @Data
    public static class UserStatistics {

        @Schema(description = "Employee user ID.", example = "1024")
        private Long userId;

        @Schema(description = "EmployeeNickname.", example = "John.")
        private String userName;

        @Schema(description = "Department code.", example = "1024")
        private Long deptId;

        @Schema(description = "Department name.", example = "Administration.")
        private String deptName;

        @Schema(description = "Required count.", example = "1")
        private Integer expectedCount;

        @Schema(description = "Completed count.", example = "1")
        private Integer submittedCount;

        @Schema(description = "Missing count.", example = "1")
        private Integer missingCount;

        @Schema(description = "Submitted reports.")
        private List<Report> submittedReports;

        @Schema(description = "Missing cycles.", example = "[\"2026-09-14\"]")
        private List<String> missingPeriodKeys;

    }

    @Schema(description = "Admin - Submitted reportsMemo response.")
    @Data
    public static class Report {

        @Schema(description = "Report ID", example = "1024")
        private Long id;

        @Schema(description = "Report number.", example = "HB202609140001")
        private String no;

        @Schema(description = "Report Title", example = "2026-09-14 daily report")
        private String title;

        @Schema(description = "Report status.", example = "2")
        private Integer status;

        @Schema(description = "Start time.", type = "integer", format = "int64", example = "1789347600000")
        private LocalDateTime startTime;

        @Schema(description = "Create time.", type = "integer", format = "int64", example = "1789347600000")
        private LocalDateTime createTime;

        @Schema(description = "Report cycle.", example = "2026-09-14")
        private String periodKey;

    }

}

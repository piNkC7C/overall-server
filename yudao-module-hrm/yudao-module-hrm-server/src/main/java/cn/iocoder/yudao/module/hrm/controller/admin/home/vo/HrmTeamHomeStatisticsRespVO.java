package cn.iocoder.yudao.module.hrm.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "HRM team workspace stats response VO.")
@Data
public class HrmTeamHomeStatisticsRespVO {

    @Schema(description = "Current manager employee ID.", example = "1")
    private Long leaderEmployeeId;

    @Schema(description = "My team.")
    private TeamOverview teamOverview;

    @Schema(description = "Team overview.")
    private TeamSurvey teamSurvey;

    @Schema(description = "HRM team workspace my team response VO.")
    @Data
    public static class TeamOverview {

        @Schema(description = "Team size.", example = "12")
        private Long employeeCount;

        @Schema(description = "Hires this month.", example = "2")
        private Long entryThisMonthCount;

        @Schema(description = "Terminations this month.", example = "1")
        private Long leaveThisMonthCount;

        @Schema(description = "Confirmations this month.", example = "3")
        private Long regularThisMonthCount;

    }

    @Schema(description = "HRM team workspace team overview response VO.")
    @Data
    public static class TeamSurvey {

        @Schema(description = "Employee status mix.")
        private List<AnalysisItem> statusAnalysis;

        @Schema(description = "Gender mix.")
        private List<AnalysisItem> sexAnalysis;

        @Schema(description = "Age mix.")
        private List<AnalysisItem> ageAnalysis;

        @Schema(description = "Tenure mix.")
        private List<AnalysisItem> companyAgeAnalysis;

    }

    @Schema(description = "HRM team workspace stats item response VO.")
    @Data
    public static class AnalysisItem {

        @Schema(description = "Category type. Null means not set.", example = "1")
        private Integer type;

        @Schema(description = "Quantity.", example = "8")
        private Long count;

    }

}

package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.worklog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - PMS item time spent report response.")
@Data
public class PmsProjectWorkLogReportRespVO {

    @Schema(description = "ReportDate list.")
    private List<String> dates;

    @Schema(description = "Total hours.")
    private Integer totalHours;

    @Schema(description = "Sprint group.")
    private List<Group> groups;

    @Data
    public static class Group {

        @Schema(description = "Sprint ID. Empty for unplanned items.")
        private Long iterationId;

        @Schema(description = "Sprint name.")
        private String iterationName;

        @Schema(description = "Group total hours.")
        private Integer totalHours;

        @Schema(description = "Work item list.")
        private List<Item> items;

    }

    @Schema(description = "Admin - PMS item time spent report work item detail.")
    @Data
    public static class Item {

        @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long workItemId;

        @Schema(description = "Work-item number in the project.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
        private Integer serialNumber;

        @Schema(description = "Work item title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Complete sign-in interface.")
        private String name;

        @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Integer type;

        @Schema(description = "Work-item total hours.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8")
        private Integer totalHours;

        @Schema(description = "Daily hours. Key is the date. Value is hours.", requiredMode = Schema.RequiredMode.REQUIRED,
                example = "{\"2026-08-22\": 4}")
        private Map<String, Integer> dailyHours;

    }

}

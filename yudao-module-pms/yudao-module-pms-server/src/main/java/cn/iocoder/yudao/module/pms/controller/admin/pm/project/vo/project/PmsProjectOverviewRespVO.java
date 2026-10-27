package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "PMS item overview response VO.")
@Data
public class PmsProjectOverviewRespVO {

    @Schema(description = "Work item total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Long totalCount;

    @Schema(description = "Not start work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8")
    private Long pendingCount;

    @Schema(description = "In progress work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6")
    private Long processingCount;

    @Schema(description = "Completed work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "6")
    private Long completedCount;

    @Schema(description = "By work item Type stats.")
    private Map<Integer, Long> typeCountMap;

    @Schema(description = "Completion trend for the last 14 days.")
    private List<TrendPoint> completedTrends;

    @Schema(description = "Open work items assigned to the current user.")
    private List<AssignedWorkItem> assignedWorkItems;

    @Schema(description = "PMS project overview - trend point.")
    @Data
    public static class TrendPoint {

        @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED)
        private String date;

        @Schema(description = "Completed today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Long count;

    }

    @Schema(description = "PMS project overview - work items assigned to me.")
    @Data
    public static class AssignedWorkItem {

        @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long id;

        @Schema(description = "Project sequence.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
        private Integer serialNumber;

        @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Integer type;

        @Schema(description = "Work item title.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String name;

        @Schema(description = "Semantic status", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
        private Integer status;

        @Schema(description = "Due time.")
        private LocalDateTime endTime;

        @Schema(description = "Complete progress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "60")
        private Integer progress;

    }

}

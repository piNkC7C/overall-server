package cn.iocoder.yudao.module.pms.controller.admin.pm.iteration.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Schema(description = "PMS sprint overview response VO.")
@Data
public class PmsIterationOverviewRespVO {

    @Schema(description = "Work item total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Integer totalCount;

    @Schema(description = "Not start work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Integer pendingCount;

    @Schema(description = "In progress work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    private Integer processingCount;

    @Schema(description = "Completed work item quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer completedCount;

    @Schema(description = "Completion percent.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    private Integer progress;

    @Schema(description = "Work item type quantityStats.", requiredMode = Schema.RequiredMode.REQUIRED, example = "{\"1\": 60, \"2\": 40}")
    private Map<Integer, Integer> typeCountMap;

    @Schema(description = "Work item type and status quantityStats.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<Integer, Map<Integer, Integer>> typeStatusCountMap;

    @Schema(description = "Status trend.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<TrendItem> statusTrends;

    @Schema(description = "Burndown data.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<BurnDownItem> burnDowns;

    @Schema(description = "Recent activity list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ActivityItem> recentActivities;

    @Schema(description = "PMS sprint overview Status trend item VO.")
    @Data
    public static class TrendItem {

        @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-01-01")
        private String date;

        @Schema(description = "Work items not started today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
        private Integer pendingCount;

        @Schema(description = "Work items in progress today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Integer processingCount;

        @Schema(description = "Work items completed today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
        private Integer completedCount;

    }

    @Schema(description = "PMS sprint overview burndown item VO.")
    @Data
    public static class BurnDownItem {

        @Schema(description = "Date", requiredMode = Schema.RequiredMode.REQUIRED, example = "2026-01-01")
        private String date;

        @Schema(description = "Ideal remaining hours.", requiredMode = Schema.RequiredMode.REQUIRED, example = "40")
        private Integer idealRemaining;

        @Schema(description = "ActualRemaining hours, in hours.", requiredMode = Schema.RequiredMode.REQUIRED, example = "38")
        private Integer actualRemaining;

    }

    @Schema(description = "PMS sprint overview activity item VO.")
    @Data
    public static class ActivityItem {

        @Schema(description = "Activity ID.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long id;

        @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private Long workItemId;

        @Schema(description = "Work item No.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
        private Integer workItemSerialNumber;

        @Schema(description = "Work item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Improve the sign-in page")
        private String workItemName;

        @Schema(description = "Action person code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Long operatorUserId;

        @Schema(description = "Action person Nickname.", example = "Overall.")
        private String operatorUserName;

        @Schema(description = "Activity content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Statusupdate is 「completed」.")
        private String content;

        @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
        private LocalDateTime createTime;

    }

}

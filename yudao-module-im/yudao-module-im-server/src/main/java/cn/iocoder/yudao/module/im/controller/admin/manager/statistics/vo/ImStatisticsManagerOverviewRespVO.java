package cn.iocoder.yudao.module.im.controller.admin.manager.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "IM dashboard overview response VO.")
@Data
public class ImStatisticsManagerOverviewRespVO {

    @Schema(description = "User total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12345")
    private Long totalUser;

    @Schema(description = "New users today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "23")
    private Long newUserToday;

    @Schema(description = "Total groups.", requiredMode = Schema.RequiredMode.REQUIRED, example = "678")
    private Long totalGroup;

    @Schema(description = "New groups today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    private Long newGroupToday;

    @Schema(description = "DAU. Distinct users who sent a message today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1023")
    private Long activeUserDaily;

    @Schema(description = "WAU. Distinct users who sent a message in the last 7 days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "4567")
    private Long activeUserWeekly;

    @Schema(description = "MAU. Distinct users who sent a message in the last 30 days.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8901")
    private Long activeUserMonthly;

    @Schema(description = "Private messages today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "8765")
    private Long privateMessageToday;

    @Schema(description = "Group messages today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3210")
    private Long groupMessageToday;

    @Schema(description = "Private messages yesterday.", requiredMode = Schema.RequiredMode.REQUIRED, example = "7890")
    private Long privateMessageYesterday;

    @Schema(description = "Group messages yesterday.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3000")
    private Long groupMessageYesterday;

}

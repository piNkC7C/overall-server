package cn.iocoder.yudao.module.iot.controller.admin.statistics.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Map;

/**
 * 管理后台 - IoT 统计 Response VO
 */
@Schema(description = "Admin - IoT Stats response.")
@Data
public class IotStatisticsSummaryRespVO {

    @Schema(description = "Category count.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long productCategoryCount;

    @Schema(description = "Product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Long productCount;

    @Schema(description = "Device quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long deviceCount;

    @Schema(description = "Reported quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Long deviceMessageCount;

    @Schema(description = "New categories today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "10")
    private Long productCategoryTodayCount;

    @Schema(description = "Today create product quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Long productTodayCount;

    @Schema(description = "Today create device quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
    private Long deviceTodayCount;

    @Schema(description = "New reports today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1000")
    private Long deviceMessageTodayCount;

    @Schema(description = "Online quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "80")
    private Long deviceOnlineCount;

    @Schema(description = "Offline quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15")
    private Long deviceOfflineCount;

    @Schema(description = "Pending-activation devices.", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Long deviceInactiveCount;

    @Schema(description = "Device count by category.")
    private Map<String, Integer> productCategoryDeviceCounts;

}

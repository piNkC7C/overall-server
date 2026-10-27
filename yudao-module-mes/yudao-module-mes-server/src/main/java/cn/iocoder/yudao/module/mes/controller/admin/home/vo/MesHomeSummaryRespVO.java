package cn.iocoder.yudao.module.mes.controller.admin.home.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "Admin - MES HomesummaryStats response.")
@Data
public class MesHomeSummaryRespVO {

    // ========== work orderStats ==========

    @Schema(description = "In-progress work orders.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    private Long workOrderActiveCount;

    @Schema(description = "Unscheduled work orders (draft).", requiredMode = Schema.RequiredMode.REQUIRED, example = "5")
    private Long workOrderPrepareCount;

    @Schema(description = "Completed work orders.", requiredMode = Schema.RequiredMode.REQUIRED, example = "30")
    private Long workOrderFinishedCount;

    // ========== 产量统计 ==========

    @Schema(description = "Reported output today.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1234")
    private BigDecimal todayOutput;

    @Schema(description = "Reported output yesterday.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1100")
    private BigDecimal yesterdayOutput;

    // ========== quality Stats ==========

    @Schema(description = "Todaypassed quantity quantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1200")
    private BigDecimal todayQualifiedQuantity;

    @Schema(description = "TodaydefectQuantity.", requiredMode = Schema.RequiredMode.REQUIRED, example = "34")
    private BigDecimal todayUnqualifiedQuantity;

    // ========== deviceStats ==========

    @Schema(description = "Device total.", requiredMode = Schema.RequiredMode.REQUIRED, example = "20")
    private Long machineryTotal;

    @Schema(description = "Running devices.", requiredMode = Schema.RequiredMode.REQUIRED, example = "15")
    private Long machineryProducing;

    @Schema(description = "Stopped devices.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Long machineryStop;

    @Schema(description = "Devices in maintenance.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long machineryMaintenance;

    // ========== 异常/待办统计 ==========

    @Schema(description = "Unhandled Andon alerts.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    private Long andonActiveCount;

    @Schema(description = "Open maintenance work orders.", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Long repairActiveCount;

}

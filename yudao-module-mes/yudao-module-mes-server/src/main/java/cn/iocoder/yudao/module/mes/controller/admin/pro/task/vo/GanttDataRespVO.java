package cn.iocoder.yudao.module.mes.controller.admin.pro.task.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 甘特图数据项 VO
 */
@Schema(description = "Gantt data item response VO.")
@Data
@Accessors(chain = true)
public class GanttDataRespVO {

    @Schema(description = "Node ID (MesBizTypeConstants + '_' + original ID).", example = "301_1")
    private String id;

    @Schema(description = "Original business ID (work-order or task ID) used when writing edits back.")
    private Long originalId;

    @Schema(description = "Node type.")
    private Integer type; // 使用 MesBizTypeConstants 区分，如 301=工单, 303=任务

    @Schema(description = "Display text.")
    private String text;

    @Schema(description = "Parent node ID.")
    private String parent;

    @Schema(description = "Workstation name.")
    private String workstation;

    @Schema(description = "Operation name.")
    private String process;

    @Schema(description = "Product name.")
    private String product;

    @Schema(description = "Scheduled Qty")
    private BigDecimal quantity;

    @Schema(description = "Complete progress (0~1).")
    private Float progress;

    @Schema(description = "Gantt color.")
    private String color;

    @Schema(description = "Start time.")
    private LocalDateTime startDate;

    @Schema(description = "End time.")
    private LocalDateTime endDate;

    @Schema(description = "Production Duration")
    private Long duration;

}

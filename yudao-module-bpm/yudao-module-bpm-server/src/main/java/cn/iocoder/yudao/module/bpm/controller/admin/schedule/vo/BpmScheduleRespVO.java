package cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 我的日程 Response VO")
@Data
public class BpmScheduleRespVO {

    @Schema(description = "日程编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "创建人用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private String creator;

    @Schema(description = "创建人用户昵称", example = "Jerry")
    private String creatorName;

    @Schema(description = "创建人部门名称", example = "Sales")
    private String creatorDeptName;

    @Schema(description = "日程类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer type;

    @Schema(description = "优先级", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer priority;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime endTime;

    @Schema(description = "是否提醒", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean remind;

    @Schema(description = "提醒提前分钟数，0=准时", example = "15")
    private Integer remindMinutes;

    @Schema(description = "日程状态：0未执行 1执行中 2已结束 3已取消", example = "0")
    private Integer status;

    @Schema(description = "状态变更时间")
    private LocalDateTime processTime;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

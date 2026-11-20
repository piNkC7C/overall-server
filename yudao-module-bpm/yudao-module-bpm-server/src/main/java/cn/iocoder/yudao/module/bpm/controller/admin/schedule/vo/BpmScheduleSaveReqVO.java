package cn.iocoder.yudao.module.bpm.controller.admin.schedule.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmSchedulePriorityEnum;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmScheduleStatusEnum;
import cn.iocoder.yudao.module.bpm.enums.schedule.BpmScheduleTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 我的日程新增/修改 Request VO")
@Data
public class BpmScheduleSaveReqVO {

    @Schema(description = "日程编号", example = "1024")
    private Long id;

    @Schema(description = "日程类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Calendar type is required.")
    @InEnum(value = BpmScheduleTypeEnum.class, message = "Calendar type must be {value}.")
    private Integer type;

    @Schema(description = "优先级", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Priority is required.")
    @InEnum(value = BpmSchedulePriorityEnum.class, message = "Priority must be {value}.")
    private Integer priority;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Weekly sync")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title length cannot exceed 255 characters.")
    private String title;

    @Schema(description = "描述", example = "Finish review next week")
    @Size(max = 1000, message = "Description length cannot exceed 1000 characters.")
    private String description;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "是否提醒", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Remind cannot be empty.")
    private Boolean remind;

    @Schema(description = "提醒提前分钟数，0=准时", example = "15")
    private Integer remindMinutes;

    @Schema(description = "日程状态：0未执行 1执行中 2已结束 3已取消", example = "0")
    @InEnum(value = BpmScheduleStatusEnum.class, message = "Schedule status must be {value}.")
    private Integer status;

    @JsonIgnore
    @AssertTrue(message = "End time must be later than start time.")
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || startTime.isBefore(endTime);
    }

}

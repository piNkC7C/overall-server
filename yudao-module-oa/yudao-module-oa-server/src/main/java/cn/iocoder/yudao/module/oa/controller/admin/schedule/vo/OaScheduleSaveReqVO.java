package cn.iocoder.yudao.module.oa.controller.admin.schedule.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaPriorityEnum;
import cn.iocoder.yudao.module.oa.enums.schedule.OaScheduleTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - OA 日程新增/修改 Request VO")
@Data
public class OaScheduleSaveReqVO {

    @Schema(description = "日程编号", example = "1024")
    private Long id;

    @Schema(description = "日程类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Calendar type is required.")
    @InEnum(value = OaScheduleTypeEnum.class, message = "Calendar type must be {value}.")
    private Integer type;

    @Schema(description = "优先级", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Priority is required.")
    @InEnum(value = OaPriorityEnum.class, message = "Priority must be {value}.")
    private Integer priority;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Week will.")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title length cannot exceed 255 characters.")
    private String title;

    @Schema(description = "描述", example = "Finish count-variance review next week")
    @Size(max = 1000, message = "Description length cannot exceed 1000 characters.")
    private String description;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "是否提醒", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Remind cannot be empty.")
    private Boolean remind;

    @Schema(description = "参与人用户编号列表", example = "[1, 2]")
    private List<@NotNull(message = "Participant ID cannot be empty.") Long> participantUserIds;

    @JsonIgnore
    @AssertTrue(message = "CalendarEnd time must be later than start time.")
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || startTime.isBefore(endTime);
    }

}

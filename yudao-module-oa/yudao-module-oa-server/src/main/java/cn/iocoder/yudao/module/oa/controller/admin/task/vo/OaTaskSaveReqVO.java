package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.task.OaTaskTypeEnum;
import cn.iocoder.yudao.module.oa.enums.task.OaTaskStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA task create / edit request.")
@Data
public class OaTaskSaveReqVO {

    @Schema(description = "Task code.", example = "1024")
    private Long id;

    @Schema(description = "Task type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Task type is required.")
    @InEnum(value = OaTaskTypeEnum.class, message = "Task type must be {value}.")
    private Integer type;

    @Schema(description = "Task status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Task status is required.")
    @InEnum(value = OaTaskStatusEnum.class, message = "Task status must be {value}.")
    private Integer status;

    @Schema(description = "Is not Pin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not Pin is required.")
    private Boolean top;

    @Schema(description = "Is not cancel.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Is not cancel is required.")
    private Boolean canceled;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Complete OA task admin transition.")
    @NotBlank(message = "Task title is required.")
    @Size(max = 255, message = "Task title length cannot exceed 255 characters.")
    private String title;

    @Schema(description = "TaskDescription.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish this week's office-supply count and submit results")
    @NotBlank(message = "TaskDescription is required.")
    @Size(max = 2000, message = "TaskDescription length cannot exceed 2000 characters.")
    private String description;

    @Schema(description = "Task review.", example = "Completed on time. Count result is accurate.")
    @Size(max = 1000, message = "Task review length cannot exceed 1000 characters.")
    private String comment;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "Recipient user ID list.", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1, 2]")
    @NotEmpty(message = "TaskRecipient is required.")
    private List<@NotNull(message = "Recipient code is required.") Long> receiverUserIds;

    @JsonIgnore
    @AssertTrue(message = "TaskEnd time must be later than start time.")
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || startTime.isBefore(endTime);
    }

}

package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemDefectTypeEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemPriorityEnum;
import cn.iocoder.yudao.module.pms.enums.pm.workitem.PmsWorkItemTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS work item create / edit request.")
@Data
public class PmsWorkItemSaveReqVO {

    @Schema(description = "Work item code.", example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Work item type is required.")
    @InEnum(PmsWorkItemTypeEnum.class)
    private Integer type;

    @Schema(description = "Work item title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish the sign-in page")
    @NotBlank(message = "Work item title is required.")
    @Size(max = 100, message = "Work item title cannot exceed 100 characters.")
    private String name;

    @Schema(description = "Work item Description.", example = "Implement username-password sign-in")
    @Size(max = 5000, message = "Work item Description cannot exceed 5000 characters.")
    private String description;

    @Schema(description = "Priority", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Priority is required.")
    @InEnum(PmsWorkItemPriorityEnum.class)
    private Integer priority;

    @Schema(description = "Owner person user ID.", example = "1024")
    private Long assigneeUserId;

    @Schema(description = "Participant user IDs.", example = "[1024, 2048]")
    private List<Long> memberUserIds;

    @Schema(description = "Sprint code.", example = "1024")
    private Long iterationId;

    @Schema(description = "Parent work item code.", example = "1024")
    private Long parentId;

    @Schema(description = "Relation requirement code.", example = "1024")
    private Long relatedRequirementId;

    @Schema(description = "Defect type.", example = "1")
    @InEnum(PmsWorkItemDefectTypeEnum.class)
    private Integer defectType;

    @Schema(description = "Start time.")
    private LocalDateTime startTime;

    @Schema(description = "Due time.")
    private LocalDateTime endTime;

    @Schema(description = "Estimated hours.", example = "8")
    @Min(value = 0, message = "Estimated hours cannot be less than 0.")
    private Integer estimatedHours;

    @Schema(description = "Complete progress.", example = "50")
    @NotNull(message = "Complete progress is required.")
    @Min(value = 0, message = "Completion progress cannot be less than 0.")
    @Max(value = 100, message = "Completion progress cannot be greater than 100.")
    private Integer progress;

    @Schema(description = "AttachmentAddress list.")
    private List<String> fileUrls;

    @Schema(description = "Tag code list.", example = "[1024, 2048]")
    private List<Long> labelIds;

    @Schema(description = "Child work-item titles created at the same time.")
    private List<@NotBlank(message = "Child work-item title cannot be empty.")
            @Size(max = 100, message = "Child work-item title cannot exceed 100 characters.") String> childWorkItemNames;

    @Schema(description = "Actual hours logged at creation.", example = "2")
    @Min(value = 1, message = "Actual hours must be greater than 0.")
    private Integer actualHours;

    @Schema(description = "Remaining hours logged at creation.", example = "6")
    @Min(value = 0, message = "Remaining hours cannot be less than 0.")
    private Integer remainingHours;

    @AssertTrue(message = "Work item End time must be later than start time.")
    public boolean isTimeValid() {
        return startTime == null || endTime == null || startTime.isBefore(endTime);
    }

    @AssertTrue(message = "Actual hours are required when remaining hours are set.")
    public boolean isWorkLogValid() {
        return remainingHours == null || actualHours != null;
    }

}

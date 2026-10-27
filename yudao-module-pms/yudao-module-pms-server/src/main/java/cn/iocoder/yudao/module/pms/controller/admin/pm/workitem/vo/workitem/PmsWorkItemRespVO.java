package cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.workitem;

import cn.iocoder.yudao.module.pms.controller.admin.pm.workitem.vo.label.PmsWorkItemLabelRespVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.fesod.sheet.annotation.ExcelIgnoreUnannotated;
import org.apache.fesod.sheet.annotation.ExcelProperty;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - PMS work item response.")
@Data
@ExcelIgnoreUnannotated
public class PmsWorkItemRespVO {

    @Schema(description = "Work item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long id;

    @Schema(description = "Item code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long projectId;

    @Schema(description = "Work item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @ExcelProperty("Type")
    private Integer type;

    @Schema(description = "Work-item number in the project.", requiredMode = Schema.RequiredMode.REQUIRED, example = "12")
    @ExcelProperty("Code")
    private Integer serialNumber;

    @Schema(description = "Work item title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish the sign-in page")
    @ExcelProperty("Title")
    private String name;

    @Schema(description = "Work item Description.")
    @ExcelProperty("Description")
    private String description;

    @Schema(description = "Priority", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("Priority")
    private Integer priority;

    @Schema(description = "Owner person user ID.", example = "1024")
    private Long assigneeUserId;

    @Schema(description = "Owner person Name.", example = "Overall.")
    @ExcelProperty("Owner")
    private String assigneeUserName;

    @Schema(description = "Participant user IDs.")
    private List<Long> memberUserIds;

    @Schema(description = "ParticipantNamelist.")
    private List<String> memberUserNames;

    @Schema(description = "Board status code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long statusId;

    @Schema(description = "Board status name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Not start.")
    @ExcelProperty("Status")
    private String statusName;

    @Schema(description = "Semantic status", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status;

    @Schema(description = "Lifecycle: 1 normal, 2 archived, 3 trash.", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer lifecycleStatus;

    @Schema(description = "Archived")
    private LocalDateTime archiveTime;

    @Schema(description = "Trashed at.")
    private LocalDateTime recycleTime;

    @Schema(description = "Sprint code.", example = "1024")
    private Long iterationId;

    @Schema(description = "Sprint name.", example = "Phase 1")
    @ExcelProperty("Sprint")
    private String iterationName;

    @Schema(description = "Parent work item code.", example = "1024")
    private Long parentId;

    @Schema(description = "Relation requirement code.", example = "1024")
    private Long relatedRequirementId;

    @Schema(description = "Relation requirement title.", example = "User sign-in.")
    private String relatedRequirementName;

    @Schema(description = "Defect type.", example = "1")
    private Integer defectType;

    @Schema(description = "Start time.")
    @ExcelProperty("Start Time")
    private LocalDateTime startTime;

    @Schema(description = "Due time.")
    @ExcelProperty("Due Time")
    private LocalDateTime endTime;

    @Schema(description = "Estimated hours.", example = "8")
    @ExcelProperty("Estimated Hours")
    private Integer estimatedHours;

    @Schema(description = "Complete progress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "50")
    @ExcelProperty("Progress")
    private Integer progress;

    @Schema(description = "AttachmentAddress list.")
    private List<String> fileUrls;

    @Schema(description = "Tag code list.")
    private List<Long> labelIds;

    @Schema(description = "Tag list.")
    private List<PmsWorkItemLabelRespVO> labels;

    @Schema(description = "Board display order.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer sort;

    @Schema(description = "Create time.", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createTime;

}

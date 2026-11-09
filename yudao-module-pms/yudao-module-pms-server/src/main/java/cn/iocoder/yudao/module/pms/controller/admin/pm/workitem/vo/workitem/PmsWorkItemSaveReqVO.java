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

@Schema(description = "管理后台 - PMS 工作项新增/修改 Request VO")
@Data
public class PmsWorkItemSaveReqVO {

    @Schema(description = "工作项编号", example = "1024")
    private Long id;

    @Schema(description = "项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "工作项类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Work item type is required.")
    @InEnum(PmsWorkItemTypeEnum.class)
    private Integer type;

    @Schema(description = "工作项标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish the sign-in page")
    @NotBlank(message = "Work item title is required.")
    @Size(max = 100, message = "Work item title cannot exceed 100 characters.")
    private String name;

    @Schema(description = "工作项描述", example = "Implement username-password sign-in")
    @Size(max = 5000, message = "Work item Description cannot exceed 5000 characters.")
    private String description;

    @Schema(description = "优先级", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "Priority is required.")
    @InEnum(PmsWorkItemPriorityEnum.class)
    private Integer priority;

    @Schema(description = "负责人用户编号", example = "1024")
    private Long assigneeUserId;

    @Schema(description = "参与人用户编号列表", example = "[1024, 2048]")
    private List<Long> memberUserIds;

    @Schema(description = "所属迭代编号", example = "1024")
    private Long iterationId;

    @Schema(description = "父工作项编号", example = "1024")
    private Long parentId;

    @Schema(description = "关联需求编号", example = "1024")
    private Long relatedRequirementId;

    @Schema(description = "缺陷类型", example = "1")
    @InEnum(PmsWorkItemDefectTypeEnum.class)
    private Integer defectType;

    @Schema(description = "开始时间")
    private LocalDateTime startTime;

    @Schema(description = "截止时间")
    private LocalDateTime endTime;

    @Schema(description = "预估工时，单位：小时", example = "8")
    @Min(value = 0, message = "Estimated hours cannot be less than 0.")
    private Integer estimatedHours;

    @Schema(description = "完成进度", example = "50")
    @NotNull(message = "Complete progress is required.")
    @Min(value = 0, message = "Completion progress cannot be less than 0.")
    @Max(value = 100, message = "Completion progress cannot be greater than 100.")
    private Integer progress;

    @Schema(description = "附件地址列表")
    private List<String> fileUrls;

    @Schema(description = "标签编号列表", example = "[1024, 2048]")
    private List<Long> labelIds;

    @Schema(description = "创建时同时新增的子工作项标题列表")
    private List<@NotBlank(message = "Child work-item title cannot be empty.")
            @Size(max = 100, message = "Child work-item title cannot exceed 100 characters.") String> childWorkItemNames;

    @Schema(description = "创建时登记的实际投入工时，单位：小时", example = "2")
    @Min(value = 1, message = "Actual hours must be greater than 0.")
    private Integer actualHours;

    @Schema(description = "创建时登记的剩余工时，单位：小时", example = "6")
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

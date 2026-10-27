package cn.iocoder.yudao.module.oa.controller.admin.workreport.vo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.workreport.OaWorkReportTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA work reportcreate/update request.")
@Data
public class OaWorkReportSaveReqVO {

    @Schema(description = "Report ID", example = "1024")
    private Long id;

    @Schema(description = "Report type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Report type cannot be empty.")
    @InEnum(value = OaWorkReportTypeEnum.class, message = "Report type must be {value}.")
    private Integer type;

    @Schema(description = "Report Title", example = "2026-09-10 daily report")
    @Size(max = 255, message = "Report Title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Cycle start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Cycle start time cannot be empty.")
    private LocalDateTime startTime;

    @Schema(description = "Cycle end time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "Cycle end time cannot be empty.")
    private LocalDateTime endTime;

    @Schema(description = "Work summary.", example = "Finished this week's inventory count and variance list")
    @Size(max = 5000, message = "Work summary cannot exceed 5000 characters.")
    private String summary;

    @Schema(description = "Work-plan notes.", example = "Finish count-variance review next week")
    @Size(max = 5000, message = "Work-plan notes cannot exceed 5000 characters.")
    private String plan;

    @Schema(description = "Issues and follow-ups.", example = "Need warehouse to review count variances")
    @Size(max = 5000, message = "Issues and follow-ups cannot exceed 5000 characters.")
    private String problem;

    @Schema(description = "Completed work item.")
    @Valid
    @Size(max = 100, message = "Completed work item cannot exceed 100 item.")
    private List<@NotNull(message = "Completed work item is required.") WorkItem> workItems;

    @Schema(description = "Work-plan items.")
    @Valid
    @Size(max = 100, message = "A work plan cannot have more than 100 items.")
    private List<@NotNull(message = "Work-plan items cannot be empty.") PlanItem> planItems;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    @Size(max = 10, message = "Attachment cannot exceed 10.")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 1024, message = "AttachmentAddress cannot exceed 1024 characters.") String> fileUrls;

    @Schema(description = "Notes.", example = "Contact Admin in advance to confirm.")
    @Size(max = 1000, message = "Notes cannot exceed 1000 characters.")
    private String remark;

    /**
     * 校验汇报周期的起止时间顺序，空值由字段必填注解校验
     *
     * @return 时间顺序是否有效
     */
    @JsonIgnore
    @AssertTrue(message = "Cycle end time cannot be earlier than the start time.")
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || !startTime.isAfter(endTime);
    }

    /**
     * 保存时可填写文字总结、计划说明或工作明细
     *
     * @return 是否填写了汇报内容
     */
    @JsonIgnore
    @AssertTrue(message = "Enter a work summary, plan notes, or work items.")
    public boolean isContentValid() {
        return StrUtil.isNotBlank(summary) || StrUtil.isNotBlank(plan)
                || CollUtil.isNotEmpty(workItems) || CollUtil.isNotEmpty(planItems);
    }

    @Schema(description = "Work report completed work items request VO.")
    @Data
    public static class WorkItem {

        @Schema(description = "Work content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish the office-supply inventory count")
        @NotBlank(message = "Work content cannot be empty.")
        @Size(max = 1000, message = "Content cannot exceed 1000 characters.")
        private String content;

        @Schema(description = "Complete progress.", requiredMode = Schema.RequiredMode.REQUIRED, example = "100")
        @NotNull(message = "Complete progress is required.")
        @Min(value = 0, message = "Completion progress cannot be less than 0.")
        @Max(value = 100, message = "Completion progress cannot be greater than 100.")
        private Integer progress;

    }

    @Schema(description = "Admin - work reportWork-plan items request.")
    @Data
    public static class PlanItem {

        @Schema(description = "Plan content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish office-supply count variances next week and restock as needed.")
        @NotBlank(message = "Plan content is required.")
        @Size(max = 1000, message = "Content cannot exceed 1000 characters.")
        private String content;

    }

}

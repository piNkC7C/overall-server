package cn.iocoder.yudao.module.oa.controller.admin.plan.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.plan.OaPlanStatusEnum;
import cn.iocoder.yudao.module.oa.enums.plan.OaPlanTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Admin - OA Work Plancreate/update request.")
@Data
public class OaPlanSaveReqVO {

    @Schema(description = "Plan code.", example = "1024")
    private Long id;

    @Schema(description = "Plan type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan type is required.")
    @InEnum(value = OaPlanTypeEnum.class, message = "Plan type must be {value}.")
    private Integer type;

    @Schema(description = "Plan status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Plan status is required.")
    @InEnum(value = OaPlanStatusEnum.class, message = "Plan status must be {value}.")
    private Integer status;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "This week's plan")
    @NotBlank(message = "Title is required.")
    @Size(max = 50, message = "Title length cannot exceed 50 characters.")
    private String title;

    @Schema(description = "Tag.", example = "Key")
    @Size(max = 255, message = "Tag length cannot exceed 255 characters.")
    private String label;

    @Schema(description = "Plan content.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish office-supply count variances next week and restock as needed.")
    @NotBlank(message = "Plan content is required.")
    @Size(min = 20, message = "Plan content must be at least 20 characters.")
    private String content;

    @Schema(description = "Plan summary.", example = "Completed this week plan Alltask.")
    private String summary;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "AttachmentAddress list.", example = "[\"https://example.com/file.pdf\"]")
    private List<@NotBlank(message = "AttachmentAddress is required.") @Size(max = 512, message = "AttachmentAddress length cannot exceed 512 characters.") String> fileUrls;

    @JsonIgnore
    @AssertTrue(message = "PlanEnd time must be later than start time.")
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || startTime.isBefore(endTime);
    }

    @JsonIgnore
    @AssertTrue(message = "Plan summary must be at least 20 characters.")
    public boolean isSummaryValid() {
        return summary == null || summary.isEmpty() || summary.trim().length() >= 20;
    }

}

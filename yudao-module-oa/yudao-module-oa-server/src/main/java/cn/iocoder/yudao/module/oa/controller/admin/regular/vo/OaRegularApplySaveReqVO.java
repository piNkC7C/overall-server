package cn.iocoder.yudao.module.oa.controller.admin.regular.vo;

import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Admin - confirmation apply please create / edit request.")
@Data
public class OaRegularApplySaveReqVO {

    @Schema(description = "Apply please code.", example = "1024")
    private Long id;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Probation confirmation request")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Urgency", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Urgency is required")
    @InDict(type = DictTypeConstants.APPLY_URGENCY, message = "Urgency must be {value}.")
    private Integer urgency;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "Probation reflection.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Learned the team workflow and finished assigned tasks")
    @NotBlank(message = "Probation reflection cannot be empty.")
    @Size(max = 255, message = "Probation reflection cannot exceed 255 characters.")
    private String experience;

    @Schema(description = "Role understanding.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Own project development, delivery, and maintenance")
    @NotBlank(message = "Role understanding cannot be empty.")
    @Size(max = 255, message = "Role understanding cannot exceed 255 characters.")
    private String understanding;

    @Schema(description = "Probation growth.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Can independently deliver features and troubleshoot issues")
    @NotBlank(message = "Probation growth cannot be empty.")
    @Size(max = 255, message = "Probation growth cannot exceed 255 characters.")
    private String growth;

    @Schema(description = "Current gaps.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cross-team communication still needs improvement")
    @NotBlank(message = "Current gaps cannot be empty.")
    @Size(max = 255, message = "Current gaps cannot exceed 255 characters.")
    private String deficiency;

    @Schema(description = "Work improvement.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Break down tasks and follow progress daily")
    @NotBlank(message = "Work improvement cannot be empty.")
    @Size(max = 255, message = "Work improvement cannot exceed 255 characters.")
    private String improvement;

    @Schema(description = "Product feedback.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Suggest simplifying the expense form")
    @NotBlank(message = "Product feedback cannot be empty.")
    @Size(max = 255, message = "Product feedback cannot exceed 255 characters.")
    private String suggestion;

    @AssertTrue(message = "End time cannot earlier than start time.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || !endTime.isBefore(startTime);
    }

}

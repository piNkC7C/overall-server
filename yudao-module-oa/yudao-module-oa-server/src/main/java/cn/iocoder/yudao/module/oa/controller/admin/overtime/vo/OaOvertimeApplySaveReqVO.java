package cn.iocoder.yudao.module.oa.controller.admin.overtime.vo;

import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "Overtime request create / update request VO.")
@Data
public class OaOvertimeApplySaveReqVO {

    @Schema(description = "Apply please code.", example = "1024")
    private Long id;

    @Schema(description = "Title.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Go-live overtime request")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "Urgency", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Urgency is required")
    @InDict(type = DictTypeConstants.APPLY_URGENCY, message = "Urgency must be {value}.")
    private Integer urgency;

    @Schema(description = "Overtime type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Overtime type cannot be empty.")
    @InDict(type = DictTypeConstants.OVERTIME_TYPE, message = "Overtime type must be {value}.")
    private Integer type;

    @Schema(description = "Start time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "End time.", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "Apply please reason.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Finish pre-launch integration")
    @NotBlank(message = "Apply please reason is required.")
    @Size(max = 5000, message = "Apply please reason cannot exceed 5000 characters.")
    private String reason;

    @AssertTrue(message = "End time cannot earlier than start time.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || !endTime.isBefore(startTime);
    }

}

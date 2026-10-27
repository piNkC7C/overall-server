package cn.iocoder.yudao.module.pms.controller.admin.pm.project.vo.project;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectLevelEnum;
import cn.iocoder.yudao.module.pms.enums.pm.project.PmsProjectTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "Admin - PMS item create / edit request.")
@Data
public class PmsProjectSaveReqVO {

    @Schema(description = "Item code.", example = "1024")
    private Long id;

    @Schema(description = "Item name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Website rewrite")
    @NotBlank(message = "Item name is required.")
    @Size(max = 31, message = "Item name cannot exceed 31 characters.")
    private String name;

    @Schema(description = "Item type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Item type is required.")
    @InEnum(PmsProjectTypeEnum.class)
    private Integer type;

    @Schema(description = "Item Priority.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Item Priority is required.")
    @InEnum(PmsProjectLevelEnum.class)
    private Integer level;

    @Schema(description = "Item Description.", example = "Finish the website frontend and backend rewrite")
    @Size(max = 500, message = "Item Description cannot exceed 500 characters.")
    private String description;

    @Schema(description = "Public", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    @NotNull(message = "Item visibility is required.")
    private Boolean openStatus;

    @Schema(description = "Item Icon.", requiredMode = Schema.RequiredMode.REQUIRED, example = "ep:folder")
    @NotBlank(message = "Item Icon is required.")
    private String icon;

    @Schema(description = "Start time.", example = "2026-08-01 00:00:00")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "Due time.", example = "2026-12-31 23:59:59")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "Initial member code list.", example = "[1, 2]")
    private List<Long> memberUserIds;

    @JsonIgnore
    @Schema(hidden = true)
    @AssertTrue(message = "Project due time must be later than the start time, and both are required together.")
    public boolean isTimeValid() {
        return startTime == null && endTime == null
                || startTime != null && endTime != null && startTime.isBefore(endTime);
    }

}

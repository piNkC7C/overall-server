package cn.iocoder.yudao.module.pms.controller.admin.pm.iteration.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - PMS 项目迭代新增/修改 Request VO")
@Data
public class PmsIterationSaveReqVO {

    @Schema(description = "迭代编号", example = "1024")
    private Long id;

    @Schema(description = "项目编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Item code is required.")
    private Long projectId;

    @Schema(description = "迭代名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "Phase 1")
    @NotBlank(message = "Sprint name is required.")
    @Size(max = 100, message = "Sprint name length cannot exceed 100 characters.")
    private String name;

    @Schema(description = "负责人用户编号", example = "1")
    private Long ownerUserId;

    @Schema(description = "开始时间")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    private LocalDateTime endTime;

    @Schema(description = "迭代目标", example = "Finish the core workflow")
    @Size(max = 255, message = "Sprint target length cannot exceed 255 characters.")
    private String target;

    @Schema(description = "迭代描述")
    private String description;

    @Schema(hidden = true)
    @AssertTrue(message = "Sprint end time must be later than the start time, and both are required together.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null && endTime == null
                || startTime != null && endTime != null && endTime.isAfter(startTime);
    }

}

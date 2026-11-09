package cn.iocoder.yudao.module.oa.controller.admin.regular.vo;

import cn.iocoder.yudao.framework.dict.validation.InDict;
import cn.iocoder.yudao.module.oa.enums.DictTypeConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - 转正申请新增/修改 Request VO")
@Data
public class OaRegularApplySaveReqVO {

    @Schema(description = "申请编号", example = "1024")
    private Long id;

    @Schema(description = "标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "Probation confirmation request")
    @NotBlank(message = "Title is required.")
    @Size(max = 255, message = "Title cannot exceed 255 characters.")
    private String title;

    @Schema(description = "紧急程度", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "Urgency is required")
    @InDict(type = DictTypeConstants.APPLY_URGENCY, message = "Urgency must be {value}.")
    private Integer urgency;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789347600000")
    @NotNull(message = "Start time is required.")
    private LocalDateTime startTime;

    @Schema(description = "结束时间", requiredMode = Schema.RequiredMode.REQUIRED, type = "integer", format = "int64", example = "1789380000000")
    @NotNull(message = "End time is required.")
    private LocalDateTime endTime;

    @Schema(description = "试用期心得", requiredMode = Schema.RequiredMode.REQUIRED, example = "Learned the team workflow and finished assigned tasks")
    @NotBlank(message = "Probation reflection cannot be empty.")
    @Size(max = 255, message = "Probation reflection cannot exceed 255 characters.")
    private String experience;

    @Schema(description = "岗位职责理解", requiredMode = Schema.RequiredMode.REQUIRED, example = "Own project development, delivery, and maintenance")
    @NotBlank(message = "Role understanding cannot be empty.")
    @Size(max = 255, message = "Role understanding cannot exceed 255 characters.")
    private String understanding;

    @Schema(description = "试用期成长", requiredMode = Schema.RequiredMode.REQUIRED, example = "Can independently deliver features and troubleshoot issues")
    @NotBlank(message = "Probation growth cannot be empty.")
    @Size(max = 255, message = "Probation growth cannot exceed 255 characters.")
    private String growth;

    @Schema(description = "目前不足", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cross-team communication still needs improvement")
    @NotBlank(message = "Current gaps cannot be empty.")
    @Size(max = 255, message = "Current gaps cannot exceed 255 characters.")
    private String deficiency;

    @Schema(description = "工作改进", requiredMode = Schema.RequiredMode.REQUIRED, example = "Break down tasks and follow progress daily")
    @NotBlank(message = "Work improvement cannot be empty.")
    @Size(max = 255, message = "Work improvement cannot exceed 255 characters.")
    private String improvement;

    @Schema(description = "产品意见建议", requiredMode = Schema.RequiredMode.REQUIRED, example = "Suggest simplifying the expense form")
    @NotBlank(message = "Product feedback cannot be empty.")
    @Size(max = 255, message = "Product feedback cannot exceed 255 characters.")
    private String suggestion;

    @AssertTrue(message = "End time cannot earlier than start time.")
    @JsonIgnore
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || !endTime.isBefore(startTime);
    }

}

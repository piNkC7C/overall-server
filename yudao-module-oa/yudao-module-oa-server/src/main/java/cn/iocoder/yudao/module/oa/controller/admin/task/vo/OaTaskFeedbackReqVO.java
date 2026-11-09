package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.task.OaTaskStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "管理后台 - OA 任务反馈新增 Request VO")
@Data
public class OaTaskFeedbackReqVO {

    @Schema(description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Task code is required.")
    private Long taskId;

    @Schema(description = "是否从发布管理反馈", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Feedback scene cannot be empty.")
    private Boolean publisher;

    @Schema(description = "任务状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Task status is required.")
    @InEnum(value = OaTaskStatusEnum.class, message = "Task status must be {value}.")
    private Integer status;

    @Schema(description = "反馈内容", example = "Completed stocktake, result already submit.")
    @Size(max = 1000, message = "Feedback cannot exceed 1000 characters.")
    private String content;

}

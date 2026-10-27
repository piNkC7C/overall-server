package cn.iocoder.yudao.module.oa.controller.admin.task.vo;

import cn.iocoder.yudao.framework.common.validation.InEnum;
import cn.iocoder.yudao.module.oa.enums.task.OaTaskStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(description = "OA task feedback create request VO.")
@Data
public class OaTaskFeedbackReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "Task code is required.")
    private Long taskId;

    @Schema(description = "Feedback from publish admin.", requiredMode = Schema.RequiredMode.REQUIRED, example = "false")
    @NotNull(message = "Feedback scene cannot be empty.")
    private Boolean publisher;

    @Schema(description = "Task status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "3")
    @NotNull(message = "Task status is required.")
    @InEnum(value = OaTaskStatusEnum.class, message = "Task status must be {value}.")
    private Integer status;

    @Schema(description = "Feedback.", example = "Completed stocktake, result already submit.")
    @Size(max = 1000, message = "Feedback cannot exceed 1000 characters.")
    private String content;

}

package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Collection;

@Schema(description = "管理后台 - 抄送流程任务的 Request VO")
@Data
public class BpmTaskCopyReqVO {

    @Schema(description = "任务编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "抄送的用户编号数组", requiredMode = Schema.RequiredMode.REQUIRED, example = "[1,2]")
    @NotEmpty(message = "Cc users cannot be empty.")
    private Collection<Long> copyUserIds;

    @Schema(description = "抄送意见", example = "Please take a look!")
    private String reason;
}

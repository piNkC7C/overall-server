package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Schema(description = "Admin - not via workflow task request.")
@Data
public class BpmTaskRejectReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "Approval comment.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Looks good!")
    private String reason;

    @Schema(description = "Attachment", example = "[https://test.yudao.iocoder.cn/20260609/test.txt]")
    private List<String> attachments;

}

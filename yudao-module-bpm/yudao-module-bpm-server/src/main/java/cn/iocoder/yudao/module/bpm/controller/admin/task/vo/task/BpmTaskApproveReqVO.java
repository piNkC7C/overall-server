package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Schema(description = "Admin - via workflow task request.")
@Data
public class BpmTaskApproveReqVO {

    @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotEmpty(message = "Task code is required.")
    private String id;

    @Schema(description = "Approval comment.", example = "Looks good!")
    private String reason;

    @Schema(description = "Signature.", example = "https://www.iocoder.cn/sign.png")
    private String signPicUrl;

    @Schema(description = "Attachment", example = "[https://test.yudao.iocoder.cn/20260609/test.txt]")
    private List<String> attachments;

    @Schema(description = "Variable instance (dynamic form).", requiredMode = Schema.RequiredMode.REQUIRED)
    private Map<String, Object> variables;

    @Schema(description = "Next nodeapprover.", example = "{nodeId:[1, 2]}")
    private Map<String, List<Long>> nextAssignees; // 为什么是 Map，而不是 List 呢？因为下一个节点可能是多个，例如说并行网关的情况

}

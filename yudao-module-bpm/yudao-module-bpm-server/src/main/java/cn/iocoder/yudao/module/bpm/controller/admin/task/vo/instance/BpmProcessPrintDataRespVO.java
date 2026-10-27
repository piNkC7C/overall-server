package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Schema(description = "Workflow instance print-data response VO.")
@Data
public class BpmProcessPrintDataRespVO {

    @Schema(description = "Workflow instance data.")
    private BpmProcessInstanceRespVO processInstance;

    @Schema(description = "WhetherEnabledCustomprint template.", requiredMode = Schema.RequiredMode.REQUIRED, example = "true")
    private Boolean printTemplateEnable;

    @Schema(description = "Customprint template HTML.")
    private String printTemplateHtml;

    @Schema(description = "Approval task list.")
    private List<Task> tasks;

    @Schema(description = "Workflow task.")
    @Data
    public static class Task {

        @Schema(description = "Workflow task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
        private String id;

        @Schema(description = "Task name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Overall.")
        private String name;

        @Schema(description = "Signature URL.", example = "https://www.iocoder.cn/sign.png")
        private String signPicUrl;

        @Schema(description = "TaskDescription.", requiredMode = Schema.RequiredMode.REQUIRED)
        private String description; // 该字段由后端拼接

    }

}

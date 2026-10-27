package cn.iocoder.yudao.module.bpm.controller.admin.task.vo.instance;

import cn.iocoder.yudao.module.bpm.controller.admin.base.user.UserSimpleBaseVO;
import cn.iocoder.yudao.module.bpm.controller.admin.definition.vo.process.BpmProcessDefinitionRespVO;
import cn.iocoder.yudao.module.bpm.controller.admin.task.vo.task.BpmTaskRespVO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Schema(description = "Admin - approval details response.")
@Data
public class BpmApprovalDetailRespVO {

    @Schema(description = "Workflow instance status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Integer status; // See BpmProcessInstanceStatusEnum enum

    @Schema(description = "Campaign node list.", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<ActivityNode> activityNodes;

    @Schema(description = "Form field permission.")
    private Map<String, String> formFieldsPermission;

    @Schema(description = "Todo task.")
    private BpmTaskRespVO todoTask;

    /**
     * 所属流程定义信息
     */
    private BpmProcessDefinitionRespVO processDefinition;

    /**
     * 所属流程实例信息
     */
    private BpmProcessInstanceRespVO processInstance;

    @Schema(description = "Campaign node info.")
    @Data
    public static class ActivityNode {

        @Schema(description = "Node code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "StartUserNode")
        private String id;

        @Schema(description = "Node name.", requiredMode = Schema.RequiredMode.REQUIRED, example = "Start person.")
        private String name;

        @Schema(description = "Node type.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer nodeType; // See BpmSimpleModelNodeType enum

        @Schema(description = "Node status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
        private Integer status; // See BpmTaskStatusEnum enum

        @Schema(description = "Node start time.")
        private LocalDateTime startTime;
        @Schema(description = "Node end time.")
        private LocalDateTime endTime;

        @Schema(description = "Approval node task info.")
        private List<ActivityNodeTask> tasks;

        @Schema(description = "Candidate strategy.", example = "35")
        private Integer candidateStrategy; // 参见 BpmTaskCandidateStrategyEnum 枚举。主要用于发起时，审批节点、抄送节点自选

        @Schema(description = "Candidateuser ID list.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1818")
        @JsonIgnore // 不返回，只是方便后续读取，赋值给 candidateUsers
        private List<Long> candidateUserIds;

        @Schema(description = "Candidateuser list.")
        private List<UserSimpleBaseVO> candidateUsers; // 只包含未生成 ApprovalTaskInfo 的用户列表

        @Schema(description = "Workflow code.", example = "8761d8e0-0922-11f0-bd37-00ff1db677bf")
        private String processInstanceId; // 当且仅当，该节点是子流程节点时，才会有值（CallActivity 的 calledProcessInstanceId 字段）

    }

    @Schema(description = "Campaign node task info.")
    @Data
    public static class ActivityNodeTask {

        @Schema(description = "Task code.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private String id;

        @Schema(description = "Task person code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "1818")
        @JsonIgnore // 不返回，只是方便后续读取，赋值给 ownerUser
        private Long owner;

        @Schema(description = "Task person.", example = "1024")
        private UserSimpleBaseVO ownerUser;

        @Schema(description = "Task assign person code.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "2048")
        @JsonIgnore // 不返回，只是方便后续读取，赋值给 assigneeUser
        private Long assignee;

        @Schema(description = "Task assign person.", example = "2048")
        private UserSimpleBaseVO assigneeUser;

        @Schema(description = "Task status.", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
        private Integer status;  // See BpmTaskStatusEnum enum

        @Schema(description = "Approval comment.", example = "Approved")
        private String reason;

        @Schema(description = "Signature.", example = "https://www.iocoder.cn/sign.png")
        private String signPicUrl;

        @Schema(description = "Attachment", example = "[https://test.yudao.iocoder.cn/20260609/test.txt]")
        private List<String> attachments;

    }

}

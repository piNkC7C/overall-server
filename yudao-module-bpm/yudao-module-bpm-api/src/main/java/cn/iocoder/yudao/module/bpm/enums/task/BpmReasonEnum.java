package cn.iocoder.yudao.module.bpm.enums.task;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 流程实例/任务的的处理原因枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum BpmReasonEnum {

    // ========== 流程实例的独有原因 ==========

    REJECT_TASK("Approval not via task, : {}."), // 场景：用户审批不通过任务。修改文案时，需要注意 isRejectReason 方法
    CANCEL_PROCESS_INSTANCE_BY_START_USER("User canceled the workflow. Reason: {}"), // 场景：用户主动取消流程
    CANCEL_PROCESS_INSTANCE_BY_ADMIN("Admin[{}]cancelworkflow, : {}."), // 场景：管理员取消流程
    CANCEL_CHILD_PROCESS_INSTANCE_BY_MAIN_PROCESS("Child workflow canceled because the parent was canceled"),
    REJECT_CHILD_PROCESS("Child workflow approval not via."),

    // ========== 流程任务的独有原因 ==========

    CANCEL_BY_SYSTEM("Canceled by the system"), // 场景：非常多，比如说：1）多任务审批已经满足条件，无需审批该任务；2）流程实例被取消，无需审批该任务；等等
    TIMEOUT_APPROVE("Approval timed out and was auto-approved"),
    TIMEOUT_REJECT("Approval timed out and was auto-rejected"),
    ASSIGN_START_USER_APPROVE("Approver and submit person is the same person time, Auto via."),
    ASSIGN_START_USER_APPROVE_WHEN_SKIP("Approver and submit person is the same person time, Auto via."),
    ASSIGN_START_USER_APPROVE_WHEN_SKIP_START_USER_NODE("Starter node auto-passed the first time"), // 目前仅“子流程”使用
    ASSIGN_START_USER_APPROVE_WHEN_DEPT_LEADER_NOT_FOUND("Approver is the submitter and no department lead was found, so it auto-passed"),
    ASSIGN_START_USER_TRANSFER_DEPT_LEADER("Approver is the submitter, so it was sent to the department lead"),
    ASSIGN_EMPTY_APPROVE("Approver is empty, Auto via."),
    ASSIGN_EMPTY_REJECT("Approver is empty, Auto not via."),
    APPROVE_TYPE_AUTO_APPROVE("Non-manual review, auto-approved"),
    APPROVE_TYPE_AUTO_REJECT("Non-manual review, auto-rejected"),
    CANCEL_BY_PROCESS_CLEAN("Canceled by process cleanup"),
    CANCEL_BY_WITHDRAW("Canceled because the previous task was withdrawn"),
    ;

    private final String reason;

    /**
     * 格式化理由
     *
     * @param args 参数
     * @return 理由
     */
    public String format(Object... args) {
        return StrUtil.format(reason, args);
    }

}

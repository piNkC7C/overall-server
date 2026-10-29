package cn.iocoder.yudao.module.bpm.enums.task;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 流程任务的 Comment 评论类型枚举
 *
 * @author kehaiyou
 */
@Getter
@AllArgsConstructor
public enum BpmCommentTypeEnum {

    COMMENT("0", "Comment", "{}"),
    APPROVE("1", "Approved", "Approved. Reason: {}"),
    REJECT("2", "Reject", "Rejected. Reason: {}"),
    CANCEL("3", "Canceled", "Canceled by the system. Reason: {}"),
    RETURN("4", "Return", "Returned the task. Reason: {}"),
    DELEGATE_START("5", "Delegation started", "[{}] delegated the task to [{}]. Reason: {}"),
    DELEGATE_END("6", "Delegation completed", "[{}] finished the delegated task. It returned to [{}]. Comment: {}"),
    TRANSFER("7", "Reassign", "[{}] reassigned the task to [{}]. Reason: {}"),
    ADD_SIGN("8", "Countersign", "[{}] {} to [{}]. Reason: {}"),
    SUB_SIGN("9", "Remove countersign", "[{}] removed a countersignature. Approver [{}]'s task was canceled"),
    ;

    /**
     * 操作类型
     *
     * 由于 BPM Comment 类型为 String，所以这里就不使用 Integer
     */
    private final String type;
    /**
     * 操作名字
     */
    private final String name;
    /**
     * 操作描述
     */
    private final String comment;

    public String formatComment(Object... params) {
        return StrUtil.format(comment, params);
    }

}

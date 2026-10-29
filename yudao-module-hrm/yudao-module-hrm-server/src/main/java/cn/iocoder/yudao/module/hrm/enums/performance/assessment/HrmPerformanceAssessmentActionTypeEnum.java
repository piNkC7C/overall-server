package cn.iocoder.yudao.module.hrm.enums.performance.assessment;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 员工绩效考核动作类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmPerformanceAssessmentActionTypeEnum implements ArrayValuable<Integer> {

    FILL_QUOTA(1, "Submit performance review metric", "Submitted performance metrics"), // Enter Review metric
    CONFIRM_TARGET(2, "Confirm performance review target", "Confirmed performance goals %s"), // Confirm Review target
    REJECT_TARGET(3, "Reject performance goals", "Rejected performance goals %s"), // 驳回考核目标
    SCORE(4, "Submit the score", "Submitted scores. Stage score: %s%s"), // Performance reviewScore
    REJECT_SCORE(5, "Reject performance score", "Returned to [%s]. Reason: %s"), // 驳回绩效评分
    CONFIRM_RESULT(6, "Confirm performance review result", "Confirmed the performance result %s"), // Confirm performance review result
    SUBMIT_APPEAL(7, "Submit performance appeal", "Submitted a performance appeal. Reason: %s"), // 提交绩效申诉
    PASS_RESULT_AUDIT(8, "Via performance review result approval", "Approved the performance-result review %s"), // Via result approval
    REJECT_RESULT_AUDIT(9, "Reject performance-result review", "Rejected the performance-result review %s"), // 驳回结果审核
    PASS_APPEAL(10, "Approve performance appeal", "Approved performance appeal %s"), // 通过绩效申诉
    REJECT_APPEAL(11, "Reject performance appeal", "Rejected performance appeal %s"), // 驳回绩效申诉
    APPEAL_TIMEOUT_PASS(12, "Auto-approved the performance appeal", "Approved performance appeal %s"), // 超时自动通过申诉
    APPEAL_TIMEOUT_REJECT(13, "Auto-rejected the performance appeal", "Rejected performance appeal %s"), // 超时自动驳回申诉
    TERMINATE(14, "Terminate performance review", "Terminated the performance review"); // 终止绩效考核

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmPerformanceAssessmentActionTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 动作类型
     */
    private final Integer type;
    /**
     * 动作标题
     */
    private final String title;
    /**
     * 动作内容模板
     */
    private final String contentTemplate;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmPerformanceAssessmentActionTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

    /**
     * 格式化动作内容
     *
     * @param args 内容参数
     * @return 动作内容
     */
    public String formatContent(Object... args) {
        return String.format(contentTemplate, args);
    }

}

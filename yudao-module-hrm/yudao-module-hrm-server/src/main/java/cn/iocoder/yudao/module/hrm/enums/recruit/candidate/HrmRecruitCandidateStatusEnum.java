package cn.iocoder.yudao.module.hrm.enums.recruit.candidate;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import cn.iocoder.yudao.framework.common.util.collection.SetUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Set;

/**
 * HRM 招聘候选人状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmRecruitCandidateStatusEnum implements ArrayValuable<Integer> {

    NEW(1, "New candidate"),
    PRIMARY_PASS(2, "Screening passed"),
    INTERVIEW(3, "Interview scheduled"),
    INTERVIEW_PASS(4, "Selected"),
    OFFER_SENT(5, "Offer sent"),
    PENDING_ENTRY(6, "Pending hire"),
    ELIMINATED(7, "Rejected"),
    JOINED(8, "Hired");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmRecruitCandidateStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 候选人列表需要展示最近一次面试信息的状态集合
     */
    public static final Set<Integer> INTERVIEW_RELATED_STATUSES = SetUtils.asSet(
            INTERVIEW.getStatus(), INTERVIEW_PASS.getStatus(), OFFER_SENT.getStatus(),
            PENDING_ENTRY.getStatus(), ELIMINATED.getStatus(), JOINED.getStatus());

    /**
     * HRM 首页日历允许展示面试事项的候选人状态集合
     */
    public static final Set<Integer> CALENDAR_STATUSES = SetUtils.asSet(
            NEW.getStatus(), PRIMARY_PASS.getStatus(), INTERVIEW.getStatus(), INTERVIEW_PASS.getStatus());

    /**
     * 招聘流程中的候选人状态集合
     */
    public static final Set<Integer> PROCESSING_STATUSES = SetUtils.asSet(
            NEW.getStatus(), PRIMARY_PASS.getStatus(), INTERVIEW.getStatus(),
            INTERVIEW_PASS.getStatus(), OFFER_SENT.getStatus());

    /**
     * 允许安排面试的候选人状态集合
     */
    public static final Set<Integer> INTERVIEW_ARRANGE_STATUSES = SetUtils.asSet(
            NEW.getStatus(), PRIMARY_PASS.getStatus(), INTERVIEW.getStatus(), INTERVIEW_PASS.getStatus());

    /**
     * 允许淘汰的候选人状态集合
     */
    public static final Set<Integer> ELIMINATE_STATUSES = SetUtils.asSet(
            NEW.getStatus(), PRIMARY_PASS.getStatus(), INTERVIEW.getStatus(), INTERVIEW_PASS.getStatus(),
            OFFER_SENT.getStatus(), PENDING_ENTRY.getStatus());

    /**
     * 允许转为员工的候选人状态集合
     */
    public static final Set<Integer> CONVERT_EMPLOYEE_STATUSES = SetUtils.asSet(
            INTERVIEW_PASS.getStatus(), OFFER_SENT.getStatus());

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmRecruitCandidateStatusEnum valueOf(Integer status) {
        return ArrayUtil.firstMatch(item -> item.getStatus().equals(status), values());
    }

}

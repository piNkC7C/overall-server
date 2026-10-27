package cn.iocoder.yudao.module.hrm.enums.recruit.candidate;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 招聘面试结果枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmRecruitInterviewResultEnum implements ArrayValuable<Integer> {

    UNFINISHED(1, "Interview not complete."),
    PASS(2, "Interview via."),
    NOT_PASS(3, "Interview not via."),
    CANCEL(4, "Interview cancel.");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmRecruitInterviewResultEnum::getResult).toArray(Integer[]::new);

    /**
     * 结果
     */
    private final Integer result;
    /**
     * 名字
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static HrmRecruitInterviewResultEnum valueOf(Integer result) {
        return Arrays.stream(values()).filter(item -> item.getResult().equals(result)).findFirst().orElse(null);
    }

}

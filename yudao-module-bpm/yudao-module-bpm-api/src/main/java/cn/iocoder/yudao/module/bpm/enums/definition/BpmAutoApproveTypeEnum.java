package cn.iocoder.yudao.module.bpm.enums.definition;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * BPM 自动去重的类型的枚举
 *
 * @author Lesan
 */
@Getter
@AllArgsConstructor
public enum BpmAutoApproveTypeEnum implements ArrayValuable<Integer> {

    NONE(0, "Do not auto-approve"),
    APPROVE_ALL(1, "Approve once; later duplicate nodes auto-pass"),
    APPROVE_SEQUENT(2, "Auto-pass only consecutive approval nodes");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BpmAutoApproveTypeEnum::getType).toArray(Integer[]::new);

    private final Integer type;
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}
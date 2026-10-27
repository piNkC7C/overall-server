package cn.iocoder.yudao.module.promotion.enums.combination;

import cn.hutool.core.util.ObjectUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 拼团状态枚举
 *
 * @author HUIHUI
 */
@AllArgsConstructor
@Getter
public enum CombinationRecordStatusEnum implements ArrayValuable<Integer> {

    IN_PROGRESS(0, "In progress."),
    SUCCESS(1, "Group buy succeeded."),
    FAILED(2, "Group buy failed.");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(CombinationRecordStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态值
     */
    private final Integer status;
    /**
     * 状态名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static boolean isSuccess(Integer status) {
        return ObjectUtil.equal(status, SUCCESS.getStatus());
    }

    public static boolean isInProgress(Integer status) {
        return ObjectUtil.equal(status, IN_PROGRESS.getStatus());
    }

    public static boolean isFailed(Integer status) {
        return ObjectUtil.equal(status, FAILED.getStatus());
    }

}

package cn.iocoder.yudao.module.oa.enums.seal;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 用印类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaSealApplyTypeEnum implements ArrayValuable<Integer> {

    CONTRACT(1, "Contract seal"),
    AGREEMENT(2, "Agreement seal"),
    CERTIFICATE(3, "Certificate seal"),
    AUTHORIZATION(4, "Authorization seal"),
    OTHER(5, "Other seal use");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(OaSealApplyTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 用印类型
     */
    private final Integer type;
    /**
     * 名称
     */
    private final String name;

    public static OaSealApplyTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}

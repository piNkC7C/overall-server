package cn.iocoder.yudao.module.oa.enums.supply;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 办公用品申请明细状态枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaSupplyApplyItemStatusEnum implements ArrayValuable<Integer> {

    APPLYING(-1, "Apply please."),
    PENDING(0, "Pending issue"),
    RECEIVED(1, "Issued"),
    RETURN_PENDING(2, "Pending return"),
    RETURNED(3, "Returned");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(OaSupplyApplyItemStatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}

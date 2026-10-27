package cn.iocoder.yudao.module.oa.enums.note;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 笔记类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum OaNoteTypeEnum implements ArrayValuable<Integer> {

    PRIVATE(1, "Me Note"),
    COMPANY(2, "CompanyNote."),
    SHARED(3, "Shared note");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(OaNoteTypeEnum::getType).toArray(Integer[]::new);

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}

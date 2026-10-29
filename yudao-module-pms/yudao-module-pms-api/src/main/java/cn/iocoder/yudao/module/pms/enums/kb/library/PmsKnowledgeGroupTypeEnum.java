package cn.iocoder.yudao.module.pms.enums.kb.library;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * PMS 知识库分组类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum PmsKnowledgeGroupTypeEnum implements ArrayValuable<Integer> {

    ALL(1, "All knowledge base"),
    UNGROUPED(2, "Ungrouped"),
    CUSTOM(3, "Custom group");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(PmsKnowledgeGroupTypeEnum::getType).toArray(Integer[]::new);

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

    public static PmsKnowledgeGroupTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

}

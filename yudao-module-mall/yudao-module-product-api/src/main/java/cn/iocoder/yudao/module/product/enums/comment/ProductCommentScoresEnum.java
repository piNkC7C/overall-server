package cn.iocoder.yudao.module.product.enums.comment;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 商品评论的星级枚举
 *
 * @author wangzhs
 */
@Getter
@AllArgsConstructor
public enum ProductCommentScoresEnum implements ArrayValuable<Integer> {

    ONE(1, "1 star"),
    TWO(2, "2 stars"),
    THREE(3, "3 stars"),
    FOUR(4, "4 stars"),
    FIVE(5, "5 stars");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(ProductCommentScoresEnum::getScores).toArray(Integer[]::new);

    /**
     * 星级
     */
    private final Integer scores;

    /**
     * 星级名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}

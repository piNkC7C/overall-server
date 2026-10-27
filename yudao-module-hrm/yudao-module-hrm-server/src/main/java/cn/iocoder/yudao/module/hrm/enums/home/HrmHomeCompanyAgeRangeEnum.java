package cn.iocoder.yudao.module.hrm.enums.home;

import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 团队工作台司龄区间枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmHomeCompanyAgeRangeEnum implements ArrayValuable<Integer> {

    WITHIN_3_MONTHS(1, "Within 3 months", 89L),
    MONTHS_3_TO_6(2, "3 to 6 Month.", 179L),
    MONTHS_6_TO_1_YEAR(3, "6 Monthto 1 Year", 364L),
    YEARS_1_TO_3(4, "1 to 3 Year", 1094L),
    YEARS_3_TO_5(5, "3 to 5 Year", 1824L),
    YEARS_5_TO_10(6, "5 to 10 Year", 3649L),
    YEARS_10_AND_ABOVE(7, "10 Year", Long.MAX_VALUE);

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmHomeCompanyAgeRangeEnum::getType).toArray(Integer[]::new);

    private final Integer type;
    private final String name;
    private final Long maximumDays;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    /**
     * 根据司龄天数获得区间类型
     *
     * @param companyAgeDays 司龄天数
     * @return 区间类型；司龄未填写或非法时返回 {@code null}
     */
    public static Integer getType(Long companyAgeDays) {
        if (companyAgeDays == null || companyAgeDays < 0) {
            return null;
        }
        return Arrays.stream(values()).filter(item -> companyAgeDays <= item.maximumDays)
                .findFirst().map(HrmHomeCompanyAgeRangeEnum::getType).orElse(null);
    }

}

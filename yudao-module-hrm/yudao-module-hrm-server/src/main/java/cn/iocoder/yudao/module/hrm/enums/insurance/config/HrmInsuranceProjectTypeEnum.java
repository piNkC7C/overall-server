package cn.iocoder.yudao.module.hrm.enums.insurance.config;

import cn.hutool.core.util.ArrayUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * HRM 社保项目类型枚举
 *
 * @author 芋道源码
 */
@Getter
@AllArgsConstructor
public enum HrmInsuranceProjectTypeEnum implements ArrayValuable<Integer> {

    PENSION_INSURANCE(1, "Pension"),
    MEDICAL_INSURANCE(2, "Medical insurance"),
    UNEMPLOYMENT_INSURANCE(3, "Unemployment insurance"),
    WORK_INJURY_INSURANCE(4, "Work-injury insurance"),
    MATERNITY_INSURANCE(5, "Maternity insurance"),
    SUPPLEMENTARY_MEDICAL_INSURANCE(6, "Supplemental critical-illness"),
    SUPPLEMENTARY_PENSION_INSURANCE(7, "Supplemental pension"),
    DISABILITY_INSURANCE(8, "Disability fund"),
    SOCIAL_SECURITY_CUSTOM(9, "Social security Custom"),
    PROVIDENT_FUND(10, "Housing fund"),
    PROVIDENT_FUND_CUSTOM(11, "Custom housing fund");

    public static final Integer[] ARRAYS = Arrays.stream(values())
            .map(HrmInsuranceProjectTypeEnum::getType).toArray(Integer[]::new);

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

    public boolean isSocialSecurity() {
        return !isProvidentFund();
    }

    public boolean isProvidentFund() {
        return this == PROVIDENT_FUND || this == PROVIDENT_FUND_CUSTOM;
    }

    public boolean isCustom() {
        return this == SOCIAL_SECURITY_CUSTOM || this == PROVIDENT_FUND_CUSTOM;
    }

    public static HrmInsuranceProjectTypeEnum valueOf(Integer type) {
        return ArrayUtil.firstMatch(item -> item.getType().equals(type), values());
    }

    public static boolean isSocialSecurity(Integer type) {
        HrmInsuranceProjectTypeEnum typeEnum = valueOf(type);
        return typeEnum != null && typeEnum.isSocialSecurity();
    }

    public static boolean isProvidentFund(Integer type) {
        HrmInsuranceProjectTypeEnum typeEnum = valueOf(type);
        return typeEnum != null && typeEnum.isProvidentFund();
    }

}
